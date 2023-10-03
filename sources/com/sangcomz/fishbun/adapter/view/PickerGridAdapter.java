package com.sangcomz.fishbun.adapter.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.snackbar.Snackbar;
import com.sangcomz.fishbun.Fishton;
import com.sangcomz.fishbun.R;
import com.sangcomz.fishbun.define.Define;
import com.sangcomz.fishbun.ui.detail.DetailActivity;
import com.sangcomz.fishbun.ui.picker.PickerActivity;
import com.sangcomz.fishbun.ui.picker.PickerController;
import com.sangcomz.fishbun.util.RadioWithTextButton;
import java.util.ArrayList;
import java.util.Collections;

public class PickerGridAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_HEADER = Integer.MIN_VALUE;
    /* access modifiers changed from: private */
    public OnPhotoActionListener actionListener;
    /* access modifiers changed from: private */
    public Fishton fishton = Fishton.getInstance();
    /* access modifiers changed from: private */
    public PickerController pickerController;
    /* access modifiers changed from: private */
    public String saveDir;

    public interface OnPhotoActionListener {
        void onDeselect();
    }

    public PickerGridAdapter(PickerController pickerController2, String saveDir2) {
        this.pickerController = pickerController2;
        this.saveDir = saveDir2;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == Integer.MIN_VALUE) {
            return new ViewHolderHeader(LayoutInflater.from(parent.getContext()).inflate(R.layout.header_item, parent, false));
        }
        return new ViewHolderImage(LayoutInflater.from(parent.getContext()).inflate(R.layout.thumb_item, parent, false));
    }

    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int imagePos;
        if (holder instanceof ViewHolderHeader) {
            final ViewHolderHeader vh = (ViewHolderHeader) holder;
            vh.header.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (PickerGridAdapter.this.pickerController.checkCameraPermission()) {
                        PickerGridAdapter.this.pickerController.takePicture((Activity) vh.header.getContext(), PickerGridAdapter.this.saveDir);
                    }
                }
            });
        }
        if (holder instanceof ViewHolderImage) {
            if (this.fishton.isCamera()) {
                imagePos = position - 1;
            } else {
                imagePos = position;
            }
            final ViewHolderImage vh2 = (ViewHolderImage) holder;
            final Uri image = this.fishton.getPickerImages()[imagePos];
            Context context = vh2.item.getContext();
            vh2.item.setTag(image);
            vh2.btnThumbCount.unselect();
            vh2.btnThumbCount.setCircleColor(this.fishton.getColorActionBar());
            vh2.btnThumbCount.setTextColor(this.fishton.getColorActionBarTitle());
            vh2.btnThumbCount.setStrokeColor(this.fishton.getColorSelectCircleStroke());
            initState(this.fishton.getSelectedImages().indexOf(image), vh2);
            if (!(image == null || vh2.imgThumbImage == null)) {
                Fishton.getInstance().getImageAdapter().loadImage(vh2.imgThumbImage, image);
            }
            vh2.btnThumbCount.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    PickerGridAdapter.this.onCheckStateChange(vh2.item, image);
                }
            });
            final Context context2 = context;
            final int i = imagePos;
            final ViewHolderImage viewHolderImage = vh2;
            final Uri uri = image;
            vh2.imgThumbImage.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (PickerGridAdapter.this.fishton.isUseDetailView()) {
                        Context context = context2;
                        if (context instanceof PickerActivity) {
                            PickerActivity activity = (PickerActivity) context;
                            Intent i = new Intent(activity, DetailActivity.class);
                            i.putExtra(Define.BUNDLE_NAME.POSITION.name(), i);
                            new Define().getClass();
                            activity.startActivityForResult(i, 130);
                            return;
                        }
                        return;
                    }
                    PickerGridAdapter.this.onCheckStateChange(viewHolderImage.item, uri);
                }
            });
        }
    }

    private void initState(int selectedIndex, ViewHolderImage vh) {
        if (selectedIndex != -1) {
            animScale(vh.imgThumbImage, true, false);
            updateRadioButton(vh.btnThumbCount, String.valueOf(selectedIndex + 1));
            return;
        }
        animScale(vh.imgThumbImage, false, false);
    }

    /* access modifiers changed from: private */
    public void onCheckStateChange(View v, Uri image) {
        ArrayList<Uri> pickedImages = this.fishton.getSelectedImages();
        boolean isContained = pickedImages.contains(image);
        if (this.fishton.getMaxCount() != pickedImages.size() || isContained) {
            ImageView imgThumbImage = (ImageView) v.findViewById(R.id.img_thumb_image);
            RadioWithTextButton btnThumbCount = (RadioWithTextButton) v.findViewById(R.id.btn_thumb_count);
            if (isContained) {
                pickedImages.remove(image);
                btnThumbCount.unselect();
                animScale(imgThumbImage, false, true);
            } else {
                animScale(imgThumbImage, true, true);
                pickedImages.add(image);
                if (this.fishton.isAutomaticClose() && this.fishton.getMaxCount() == pickedImages.size()) {
                    this.pickerController.finishActivity();
                }
                updateRadioButton(btnThumbCount, String.valueOf(pickedImages.size()));
            }
            this.pickerController.setToolbarTitle(pickedImages.size());
            return;
        }
        Snackbar.make(v, (CharSequence) this.fishton.getMessageLimitReached(), -1).show();
    }

    public void updateRadioButton(RadioWithTextButton v, String text) {
        if (this.fishton.getMaxCount() == 1) {
            v.setDrawable(ContextCompat.getDrawable(v.getContext(), R.drawable.ic_done_white_24dp));
        } else {
            v.setText(text);
        }
    }

    public void updateRadioButton(ImageView imageView, RadioWithTextButton v, String text, boolean isSelected) {
        if (isSelected) {
            animScale(imageView, isSelected, false);
            if (this.fishton.getMaxCount() == 1) {
                v.setDrawable(ContextCompat.getDrawable(v.getContext(), R.drawable.ic_done_white_24dp));
            } else {
                v.setText(text);
            }
        } else {
            v.unselect();
        }
    }

    private void animScale(View view, final boolean isSelected, final boolean isAnimation) {
        float toScale;
        int duration = 200;
        if (!isAnimation) {
            duration = 0;
        }
        if (isSelected) {
            toScale = 0.8f;
        } else {
            toScale = 1.0f;
        }
        ViewCompat.animate(view).setDuration((long) duration).withStartAction(new Runnable() {
            public void run() {
            }
        }).scaleX(toScale).scaleY(toScale).withEndAction(new Runnable() {
            public void run() {
                if (isAnimation && !isSelected) {
                    PickerGridAdapter.this.actionListener.onDeselect();
                }
            }
        }).start();
    }

    public int getItemCount() {
        int count;
        if (this.fishton.getPickerImages() == null) {
            count = 0;
        } else {
            count = this.fishton.getPickerImages().length;
        }
        if (this.fishton.isCamera()) {
            return count + 1;
        }
        if (this.fishton.getPickerImages() == null) {
            return 0;
        }
        return count;
    }

    public int getItemViewType(int position) {
        if (position != 0 || !this.fishton.isCamera()) {
            return super.getItemViewType(position);
        }
        return Integer.MIN_VALUE;
    }

    public void addImage(Uri path) {
        ArrayList<Uri> al = new ArrayList<>();
        Collections.addAll(al, this.fishton.getPickerImages());
        al.add(0, path);
        this.fishton.setPickerImages((Uri[]) al.toArray(new Uri[al.size()]));
        notifyDataSetChanged();
        this.pickerController.setAddImagePath(path);
    }

    public void setActionListener(OnPhotoActionListener actionListener2) {
        this.actionListener = actionListener2;
    }

    public class ViewHolderImage extends RecyclerView.ViewHolder {
        RadioWithTextButton btnThumbCount;
        ImageView imgThumbImage;
        View item;

        public ViewHolderImage(View view) {
            super(view);
            this.item = view;
            this.imgThumbImage = (ImageView) view.findViewById(R.id.img_thumb_image);
            this.btnThumbCount = (RadioWithTextButton) view.findViewById(R.id.btn_thumb_count);
        }
    }

    public class ViewHolderHeader extends RecyclerView.ViewHolder {
        RelativeLayout header = ((RelativeLayout) this.itemView.findViewById(R.id.rel_header_area));

        public ViewHolderHeader(View view) {
            super(view);
        }
    }
}
