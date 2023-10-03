package com.sangcomz.fishbun;

import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.sangcomz.fishbun.define.Define;

public abstract class BaseActivity extends AppCompatActivity {
    protected Define define = new Define();
    protected Fishton fishton;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().requestFeature(12);
        }
        super.onCreate(savedInstanceState);
        this.fishton = Fishton.getInstance();
    }
}
