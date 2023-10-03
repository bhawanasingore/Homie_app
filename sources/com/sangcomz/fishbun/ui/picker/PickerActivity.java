package com.sangcomz.fishbun.ui.picker;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.snackbar.Snackbar;
import com.sangcomz.fishbun.BaseActivity;
import com.sangcomz.fishbun.R;
import com.sangcomz.fishbun.adapter.view.PickerGridAdapter;
import com.sangcomz.fishbun.bean.Album;
import com.sangcomz.fishbun.define.Define;
import com.sangcomz.fishbun.permission.PermissionCheck;
import com.sangcomz.fishbun.util.RadioWithTextButton;
import com.sangcomz.fishbun.util.SingleMediaScanner;
import com.sangcomz.fishbun.util.SquareFrameLayout;
import com.sangcomz.fishbun.util.UiUtil;
import java.io.File;
import java.util.ArrayList;

public class PickerActivity extends BaseActivity {
    private static final String TAG = "PickerActivity";
    private PickerGridAdapter adapter;
    private Album album;
    private GridLayoutManager layoutManager;
    private PickerController pickerController;
    private int position;
    private RecyclerView recyclerView;

    private void initValue() {
        Intent intent = getIntent();
        this.album = (Album) intent.getParcelableExtra(Define.BUNDLE_NAME.ALBUM.name());
        this.position = intent.getIntExtra(Define.BUNDLE_NAME.POSITION.name(), -1);
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle outState) {
        try {
            this.define.getClass();
            outState.putString("instance_saved_image", this.pickerController.getSavePath());
            this.define.getClass();
            outState.putParcelableArrayList("instance_new_images", this.pickerController.getAddImagePaths());
        } catch (Exception e) {
            Log.d(TAG, e.toString());
        }
        super.onSaveInstanceState(outState);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle outState) {
        super.onRestoreInstanceState(outState);
        try {
            this.define.getClass();
            ArrayList<Uri> addImages = outState.getParcelableArrayList("instance_new_images");
            this.define.getClass();
            String savedImage = outState.getString("instance_saved_image");
            setAdapter(this.fishton.getPickerImages());
            if (addImages != null) {
                this.pickerController.setAddImagePaths(addImages);
            }
            if (savedImage != null) {
                this.pickerController.setSavePath(savedImage);
            }
        } catch (Exception e) {
            Log.d(TAG, e.toString());
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_picker);
        initController();
        initValue();
        initView();
        if (this.pickerController.checkPermission()) {
            this.pickerController.displayImage(Long.valueOf(this.album.bucketId), Boolean.valueOf(this.fishton.isExceptGif()));
        }
    }

    public void onBackPressed() {
        transImageFinish(this.position);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        this.define.getClass();
        if (requestCode != 128) {
            this.define.getClass();
            if (requestCode == 130 && resultCode == -1) {
                if (this.fishton.isAutomaticClose() && this.fishton.getSelectedImages().size() == this.fishton.getMaxCount()) {
                    finishActivity();
                }
                refreshThumb();
            }
        } else if (resultCode == -1) {
            File savedFile = new File(this.pickerController.getSavePath());
            new SingleMediaScanner(this, savedFile);
            this.adapter.addImage(Uri.fromFile(savedFile));
        } else {
            new File(this.pickerController.getSavePath()).delete();
        }
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode != 28) {
            if (requestCode != 29 || grantResults.length <= 0) {
                return;
            }
            if (grantResults[0] == 0) {
                PickerController pickerController2 = this.pickerController;
                pickerController2.takePicture(this, pickerController2.getPathDir(Long.valueOf(this.album.bucketId)));
                return;
            }
            new PermissionCheck(this).showPermissionDialog();
        } else if (grantResults.length <= 0) {
        } else {
            if (grantResults[0] == 0) {
                this.pickerController.displayImage(Long.valueOf(this.album.bucketId), Boolean.valueOf(this.fishton.isExceptGif()));
                return;
            }
            new PermissionCheck(this).showPermissionDialog();
            finish();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_photo_album, menu);
        MenuItem menuDoneItem = menu.findItem(R.id.action_done);
        MenuItem menuAllDoneItem = menu.findItem(R.id.action_all_done);
        if (this.fishton.getDrawableDoneButton() != null) {
            menuDoneItem.setIcon(this.fishton.getDrawableDoneButton());
        } else if (this.fishton.getStrDoneMenu() != null) {
            if (this.fishton.getColorTextMenu() != Integer.MAX_VALUE) {
                SpannableString spanString = new SpannableString(this.fishton.getStrDoneMenu());
                spanString.setSpan(new ForegroundColorSpan(this.fishton.getColorTextMenu()), 0, spanString.length(), 0);
                menuDoneItem.setTitle(spanString);
            } else {
                menuDoneItem.setTitle(this.fishton.getStrDoneMenu());
            }
            menuDoneItem.setIcon((Drawable) null);
        }
        if (this.fishton.isUseAllDoneButton()) {
            menuAllDoneItem.setVisible(true);
            if (this.fishton.getDrawableAllDoneButton() != null) {
                menuAllDoneItem.setIcon(this.fishton.getDrawableAllDoneButton());
            } else if (this.fishton.getStrAllDoneMenu() != null) {
                if (this.fishton.getColorTextMenu() != Integer.MAX_VALUE) {
                    SpannableString spanString2 = new SpannableString(this.fishton.getStrAllDoneMenu());
                    spanString2.setSpan(new ForegroundColorSpan(this.fishton.getColorTextMenu()), 0, spanString2.length(), 0);
                    menuAllDoneItem.setTitle(spanString2);
                } else {
                    menuAllDoneItem.setTitle(this.fishton.getStrAllDoneMenu());
                }
                menuAllDoneItem.setIcon((Drawable) null);
            }
        } else {
            menuAllDoneItem.setVisible(false);
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id != R.id.action_done) {
            if (id == R.id.action_all_done) {
                for (Uri pickerImage : this.fishton.getPickerImages()) {
                    if (this.fishton.getSelectedImages().size() == this.fishton.getMaxCount()) {
                        break;
                    }
                    if (!this.fishton.getSelectedImages().contains(pickerImage)) {
                        this.fishton.getSelectedImages().add(pickerImage);
                    }
                }
                finishActivity();
            } else if (id == 16908332) {
                transImageFinish(this.position);
            }
            return super.onOptionsItemSelected(item);
        } else if (this.fishton.getSelectedImages().size() < this.fishton.getMinCount()) {
            Snackbar.make((View) this.recyclerView, (CharSequence) this.fishton.getMessageNothingSelected(), -1).show();
            return true;
        } else {
            finishActivity();
            return true;
        }
    }

    public void showToolbarTitle(int total) {
        if (getSupportActionBar() == null) {
            return;
        }
        if (this.fishton.getMaxCount() == 1 || !this.fishton.isShowCount()) {
            getSupportActionBar().setTitle((CharSequence) this.album.bucketName);
            return;
        }
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setTitle((CharSequence) this.album.bucketName + " (" + total + "/" + this.fishton.getMaxCount() + ")");
    }

    private void initController() {
        this.pickerController = new PickerController(this);
    }

    private void initView() {
        this.recyclerView = (RecyclerView) findViewById(R.id.recycler_picker_list);
        GridLayoutManager gridLayoutManager = new GridLayoutManager((Context) this, this.fishton.getPhotoSpanCount(), 1, false);
        this.layoutManager = gridLayoutManager;
        this.recyclerView.setLayoutManager(gridLayoutManager);
        initToolBar();
    }

    private void initToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_picker_bar);
        setSupportActionBar(toolbar);
        toolbar.setBackgroundColor(this.fishton.getColorActionBar());
        toolbar.setTitleTextColor(this.fishton.getColorActionBarTitle());
        if (Build.VERSION.SDK_INT >= 21) {
            UiUtil.setStatusBarColor(this, this.fishton.getColorStatusBar());
        }
        ActionBar bar = getSupportActionBar();
        if (bar != null) {
            bar.setDisplayHomeAsUpEnabled(true);
            if (this.fishton.getDrawableHomeAsUpIndicator() != null) {
                getSupportActionBar().setHomeAsUpIndicator(this.fishton.getDrawableHomeAsUpIndicator());
            }
        }
        if (this.fishton.isStatusBarLight() && Build.VERSION.SDK_INT >= 23) {
            toolbar.setSystemUiVisibility(8192);
        }
        showToolbarTitle(0);
    }

    public void setAdapter(Uri[] result) {
        this.fishton.setPickerImages(result);
        if (this.adapter == null) {
            PickerController pickerController2 = this.pickerController;
            PickerGridAdapter pickerGridAdapter = new PickerGridAdapter(pickerController2, pickerController2.getPathDir(Long.valueOf(this.album.bucketId)));
            this.adapter = pickerGridAdapter;
            pickerGridAdapter.setActionListener(new PickerGridAdapter.OnPhotoActionListener() {
                public void onDeselect() {
                    PickerActivity.this.refreshThumb();
                }
            });
        }
        this.recyclerView.setAdapter(this.adapter);
        showToolbarTitle(this.fishton.getSelectedImages().size());
    }

    /* access modifiers changed from: private */
    public void refreshThumb() {
        int firstVisible = this.layoutManager.findFirstVisibleItemPosition();
        int lastVisible = this.layoutManager.findLastVisibleItemPosition();
        for (int i = firstVisible; i <= lastVisible; i++) {
            View view = this.layoutManager.findViewByPosition(i);
            if (view instanceof SquareFrameLayout) {
                SquareFrameLayout item = (SquareFrameLayout) view;
                RadioWithTextButton btnThumbCount = (RadioWithTextButton) item.findViewById(R.id.btn_thumb_count);
                ImageView imgThumbImage = (ImageView) item.findViewById(R.id.img_thumb_image);
                Uri image = (Uri) item.getTag();
                if (image != null) {
                    int index = this.fishton.getSelectedImages().indexOf(image);
                    if (index != -1) {
                        this.adapter.updateRadioButton(imgThumbImage, btnThumbCount, String.valueOf(index + 1), true);
                    } else {
                        this.adapter.updateRadioButton(imgThumbImage, btnThumbCount, "", false);
                        showToolbarTitle(this.fishton.getSelectedImages().size());
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void transImageFinish(int position2) {
        Define define = new Define();
        Intent i = new Intent();
        define.getClass();
        i.putParcelableArrayListExtra("intent_add_path", this.pickerController.getAddImagePaths());
        define.getClass();
        i.putExtra("intent_position", position2);
        define.getClass();
        setResult(29, i);
        finish();
    }

    public void finishActivity() {
        Intent i = new Intent();
        setResult(-1, i);
        if (this.fishton.isStartInAllView()) {
            i.putParcelableArrayListExtra(Define.INTENT_PATH, this.fishton.getSelectedImages());
        }
        finish();
    }
}
