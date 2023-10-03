package com.sangcomz.fishbun.ui.album;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.snackbar.Snackbar;
import com.sangcomz.fishbun.BaseActivity;
import com.sangcomz.fishbun.R;
import com.sangcomz.fishbun.adapter.view.AlbumListAdapter;
import com.sangcomz.fishbun.bean.Album;
import com.sangcomz.fishbun.define.Define;
import com.sangcomz.fishbun.permission.PermissionCheck;
import com.sangcomz.fishbun.util.SingleMediaScanner;
import com.sangcomz.fishbun.util.UiUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

public class AlbumActivity extends BaseActivity {
    private AlbumListAdapter adapter;
    /* access modifiers changed from: private */
    public AlbumController albumController;
    private ArrayList<Album> albumList = new ArrayList<>();
    private TextView progressAlbumText;
    private RecyclerView recyclerAlbumList;
    private RelativeLayout relAlbumEmpty;

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle outState) {
        if (this.adapter != null) {
            this.define.getClass();
            outState.putParcelableArrayList("instance_album_list", (ArrayList) this.adapter.getAlbumList());
        }
        super.onSaveInstanceState(outState);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle outState) {
        super.onRestoreInstanceState(outState);
        this.define.getClass();
        List<Album> albumList2 = outState.getParcelableArrayList("instance_album_list");
        this.define.getClass();
        List<Uri> thumbList = outState.getParcelableArrayList("instance_album_thumb_list");
        if (albumList2 != null && thumbList != null && this.fishton.getSelectedImages() != null) {
            AlbumListAdapter albumListAdapter = new AlbumListAdapter();
            this.adapter = albumListAdapter;
            albumListAdapter.setAlbumList(albumList2);
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_album);
        initView();
        initController();
        if (this.albumController.checkPermission()) {
            this.albumController.getAlbumList(this.fishton.getTitleAlbumAllView(), Boolean.valueOf(this.fishton.isExceptGif()));
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        RecyclerView recyclerView = this.recyclerAlbumList;
        if (recyclerView != null && recyclerView.getLayoutManager() != null) {
            if (UiUtil.isLandscape(this)) {
                ((GridLayoutManager) this.recyclerAlbumList.getLayoutManager()).setSpanCount(this.fishton.getAlbumLandscapeSpanCount());
            } else {
                ((GridLayoutManager) this.recyclerAlbumList.getLayoutManager()).setSpanCount(this.fishton.getAlbumPortraitSpanCount());
            }
        }
    }

    private void initView() {
        ((LinearLayout) findViewById(R.id.lin_album_camera)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (AlbumActivity.this.albumController.checkCameraPermission()) {
                    AlbumController access$000 = AlbumActivity.this.albumController;
                    AlbumActivity albumActivity = AlbumActivity.this;
                    access$000.takePicture(albumActivity, albumActivity.albumController.getPathDir());
                }
            }
        });
        initToolBar();
    }

    private void initRecyclerView() {
        GridLayoutManager layoutManager;
        this.recyclerAlbumList = (RecyclerView) findViewById(R.id.recycler_album_list);
        if (UiUtil.isLandscape(this)) {
            layoutManager = new GridLayoutManager(this, this.fishton.getAlbumLandscapeSpanCount());
        } else {
            layoutManager = new GridLayoutManager(this, this.fishton.getAlbumPortraitSpanCount());
        }
        RecyclerView recyclerView = this.recyclerAlbumList;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(layoutManager);
        }
    }

    private void initToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_album_bar);
        this.relAlbumEmpty = (RelativeLayout) findViewById(R.id.rel_album_empty);
        TextView textView = (TextView) findViewById(R.id.txt_album_msg);
        this.progressAlbumText = textView;
        textView.setText(R.string.msg_loading_image);
        setSupportActionBar(toolbar);
        toolbar.setBackgroundColor(this.fishton.getColorActionBar());
        toolbar.setTitleTextColor(this.fishton.getColorActionBarTitle());
        if (Build.VERSION.SDK_INT >= 21) {
            UiUtil.setStatusBarColor(this, this.fishton.getColorStatusBar());
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle((CharSequence) this.fishton.getTitleActionBar());
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            if (this.fishton.getDrawableHomeAsUpIndicator() != null) {
                getSupportActionBar().setHomeAsUpIndicator(this.fishton.getDrawableHomeAsUpIndicator());
            }
        }
        if (this.fishton.isStatusBarLight() && Build.VERSION.SDK_INT >= 23) {
            toolbar.setSystemUiVisibility(8192);
        }
    }

    private void initController() {
        this.albumController = new AlbumController(this);
    }

    private void setAlbumListAdapter() {
        if (this.adapter == null) {
            this.adapter = new AlbumListAdapter();
        }
        this.adapter.setAlbumList(this.albumList);
        this.recyclerAlbumList.setAdapter(this.adapter);
        this.adapter.notifyDataSetChanged();
        changeToolbarTitle();
    }

    /* access modifiers changed from: protected */
    public void setAlbumList(ArrayList<Album> albumList2) {
        this.albumList = albumList2;
        if (albumList2.size() > 0) {
            this.relAlbumEmpty.setVisibility(8);
            initRecyclerView();
            setAlbumListAdapter();
            return;
        }
        this.relAlbumEmpty.setVisibility(0);
        this.progressAlbumText.setText(R.string.msg_no_image);
    }

    private void refreshList(int position, ArrayList<Uri> imagePath) {
        if (imagePath.size() <= 0) {
            return;
        }
        if (position == 0) {
            this.albumController.getAlbumList(this.fishton.getTitleAlbumAllView(), Boolean.valueOf(this.fishton.isExceptGif()));
            return;
        }
        this.albumList.get(0).counter += imagePath.size();
        this.albumList.get(position).counter += imagePath.size();
        this.albumList.get(0).thumbnailPath = imagePath.get(imagePath.size() - 1).toString();
        this.albumList.get(position).thumbnailPath = imagePath.get(imagePath.size() - 1).toString();
        this.adapter.notifyItemChanged(0);
        this.adapter.notifyItemChanged(position);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        if (!this.fishton.isButton()) {
            return true;
        }
        getMenuInflater().inflate(R.menu.menu_photo_album, menu);
        MenuItem menuDoneItem = menu.findItem(R.id.action_done);
        menu.findItem(R.id.action_all_done).setVisible(false);
        if (this.fishton.getDrawableDoneButton() != null) {
            menuDoneItem.setIcon(this.fishton.getDrawableDoneButton());
            return true;
        } else if (this.fishton.getStrDoneMenu() == null) {
            return true;
        } else {
            if (this.fishton.getColorTextMenu() != Integer.MAX_VALUE) {
                SpannableString spanString = new SpannableString(this.fishton.getStrDoneMenu());
                spanString.setSpan(new ForegroundColorSpan(this.fishton.getColorTextMenu()), 0, spanString.length(), 0);
                menuDoneItem.setTitle(spanString);
            } else {
                menuDoneItem.setTitle(this.fishton.getStrDoneMenu());
            }
            menuDoneItem.setIcon((Drawable) null);
            return true;
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == 16908332) {
            finish();
        } else if (id == R.id.action_done && this.adapter != null) {
            if (this.fishton.getSelectedImages().size() < this.fishton.getMinCount()) {
                Snackbar.make((View) this.recyclerAlbumList, (CharSequence) this.fishton.getMessageNothingSelected(), -1).show();
            } else {
                finishActivity();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    public void changeToolbarTitle() {
        if (this.adapter != null) {
            int total = this.fishton.getSelectedImages().size();
            if (getSupportActionBar() == null) {
                return;
            }
            if (this.fishton.getMaxCount() == 1 || !this.fishton.isShowCount()) {
                getSupportActionBar().setTitle((CharSequence) this.fishton.getTitleActionBar());
                return;
            }
            ActionBar supportActionBar = getSupportActionBar();
            supportActionBar.setTitle((CharSequence) this.fishton.getTitleActionBar() + " (" + total + "/" + this.fishton.getMaxCount() + ")");
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        this.define.getClass();
        if (requestCode != 129) {
            this.define.getClass();
            if (requestCode == 128) {
                if (resultCode == -1) {
                    new SingleMediaScanner(this, new File(this.albumController.getSavePath()), new Function0<Unit>() {
                        public Unit invoke() {
                            AlbumActivity.this.albumController.getAlbumList(AlbumActivity.this.fishton.getTitleAlbumAllView(), Boolean.valueOf(AlbumActivity.this.fishton.isExceptGif()));
                            return Unit.INSTANCE;
                        }
                    });
                } else {
                    new File(this.albumController.getSavePath()).delete();
                }
                changeToolbarTitle();
            }
        } else if (resultCode == -1) {
            finishActivity();
        } else {
            this.define.getClass();
            if (resultCode == 29) {
                this.define.getClass();
                ArrayList<Uri> addPath = data.getParcelableArrayListExtra("intent_add_path");
                this.define.getClass();
                refreshList(data.getIntExtra("intent_position", -1), addPath);
                changeToolbarTitle();
            }
        }
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode != 28) {
            if (requestCode != 29 || grantResults.length <= 0) {
                return;
            }
            if (grantResults[0] == 0) {
                AlbumController albumController2 = this.albumController;
                albumController2.takePicture(this, albumController2.getPathDir());
                return;
            }
            new PermissionCheck(this).showPermissionDialog();
        } else if (grantResults.length <= 0) {
        } else {
            if (grantResults[0] == 0) {
                this.albumController.getAlbumList(this.fishton.getTitleAlbumAllView(), Boolean.valueOf(this.fishton.isExceptGif()));
                return;
            }
            new PermissionCheck(this).showPermissionDialog();
            finish();
        }
    }

    private void finishActivity() {
        Intent i = new Intent();
        i.putParcelableArrayListExtra(Define.INTENT_PATH, this.fishton.getSelectedImages());
        setResult(-1, i);
        finish();
    }
}
