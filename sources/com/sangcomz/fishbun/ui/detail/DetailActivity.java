package com.sangcomz.fishbun.ui.detail;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.snackbar.Snackbar;
import com.sangcomz.fishbun.BaseActivity;
import com.sangcomz.fishbun.R;
import com.sangcomz.fishbun.adapter.view.DetailViewPagerAdapter;
import com.sangcomz.fishbun.define.Define;
import com.sangcomz.fishbun.util.RadioWithTextButton;
import com.sangcomz.fishbun.util.UiUtil;

public class DetailActivity extends BaseActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {
    private static final String TAG = "DetailActivity";
    private ImageButton btnDetailBack;
    private RadioWithTextButton btnDetailCount;
    private DetailController controller;
    private int initPosition;
    private ViewPager vpDetailPager;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().requestFeature(12);
        }
        setContentView(R.layout.activity_detail_actiivy);
        initController();
        initValue();
        initView();
        initAdapter();
        initToolBar();
    }

    private void initController() {
        this.controller = new DetailController(this);
    }

    private void initView() {
        this.btnDetailCount = (RadioWithTextButton) findViewById(R.id.btn_detail_count);
        this.vpDetailPager = (ViewPager) findViewById(R.id.vp_detail_pager);
        this.btnDetailBack = (ImageButton) findViewById(R.id.btn_detail_back);
        this.btnDetailCount.unselect();
        this.btnDetailCount.setCircleColor(this.fishton.getColorActionBar());
        this.btnDetailCount.setTextColor(this.fishton.getColorActionBarTitle());
        this.btnDetailCount.setStrokeColor(this.fishton.getColorSelectCircleStroke());
        this.btnDetailCount.setOnClickListener(this);
        this.btnDetailBack.setOnClickListener(this);
        initToolBar();
    }

    private void initValue() {
        this.initPosition = getIntent().getIntExtra(Define.BUNDLE_NAME.POSITION.name(), -1);
    }

    private void initToolBar() {
        if (Build.VERSION.SDK_INT >= 21) {
            UiUtil.setStatusBarColor(this, this.fishton.getColorStatusBar());
        }
        if (this.fishton.isStatusBarLight() && Build.VERSION.SDK_INT >= 23) {
            this.vpDetailPager.setSystemUiVisibility(8192);
        }
    }

    private void initAdapter() {
        if (this.fishton.getPickerImages() == null) {
            Toast.makeText(this, R.string.msg_error, 0).show();
            finish();
            return;
        }
        onCheckStateChange(this.fishton.getPickerImages()[this.initPosition]);
        this.vpDetailPager.setAdapter(new DetailViewPagerAdapter(getLayoutInflater(), this.fishton.getPickerImages()));
        this.vpDetailPager.setCurrentItem(this.initPosition);
        this.vpDetailPager.addOnPageChangeListener(this);
    }

    public void onCheckStateChange(Uri image) {
        if (this.fishton.getSelectedImages().contains(image)) {
            updateRadioButton(this.btnDetailCount, String.valueOf(this.fishton.getSelectedImages().indexOf(image) + 1));
        } else {
            this.btnDetailCount.unselect();
        }
    }

    public void updateRadioButton(RadioWithTextButton v, String text) {
        if (this.fishton.getMaxCount() == 1) {
            v.setDrawable(ContextCompat.getDrawable(v.getContext(), R.drawable.ic_done_white_24dp));
        } else {
            v.setText(text);
        }
    }

    public void onBackPressed() {
        finishActivity();
    }

    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_detail_count) {
            Uri image = this.fishton.getPickerImages()[this.vpDetailPager.getCurrentItem()];
            if (this.fishton.getSelectedImages().contains(image)) {
                this.fishton.getSelectedImages().remove(image);
                onCheckStateChange(image);
            } else if (this.fishton.getSelectedImages().size() == this.fishton.getMaxCount()) {
                Snackbar.make(v, (CharSequence) this.fishton.getMessageLimitReached(), -1).show();
            } else {
                this.fishton.getSelectedImages().add(image);
                onCheckStateChange(image);
                if (this.fishton.isAutomaticClose() && this.fishton.getSelectedImages().size() == this.fishton.getMaxCount()) {
                    finishActivity();
                }
            }
        } else if (id == R.id.btn_detail_back) {
            finishActivity();
        }
    }

    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    public void onPageSelected(int position) {
        onCheckStateChange(this.fishton.getPickerImages()[position]);
    }

    public void onPageScrollStateChanged(int state) {
    }

    /* access modifiers changed from: package-private */
    public void finishActivity() {
        setResult(-1, new Intent());
        finish();
    }
}
