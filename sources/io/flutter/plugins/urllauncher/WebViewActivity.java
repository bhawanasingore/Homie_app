package io.flutter.plugins.urllauncher;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.HashMap;
import java.util.Map;

public class WebViewActivity extends Activity {
    public static String ACTION_CLOSE = "close action";
    private static String ENABLE_DOM_EXTRA = "enableDomStorage";
    private static String ENABLE_JS_EXTRA = "enableJavaScript";
    private static String URL_EXTRA = "url";
    private final BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (WebViewActivity.ACTION_CLOSE.equals(intent.getAction())) {
                WebViewActivity.this.finish();
            }
        }
    };
    private IntentFilter closeIntentFilter = new IntentFilter(ACTION_CLOSE);
    private final WebViewClient webViewClient = new WebViewClient() {
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (Build.VERSION.SDK_INT >= 21) {
                return super.shouldOverrideUrlLoading(view, url);
            }
            view.loadUrl(url);
            return false;
        }

        @RequiresApi(24)
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            if (Build.VERSION.SDK_INT < 21) {
                return false;
            }
            view.loadUrl(request.getUrl().toString());
            return false;
        }
    };
    /* access modifiers changed from: private */
    public WebView webview;

    private class FlutterWebChromeClient extends WebChromeClient {
        private FlutterWebChromeClient() {
        }

        public boolean onCreateWindow(WebView view, boolean isDialog, boolean isUserGesture, Message resultMsg) {
            WebViewClient webViewClient = new WebViewClient() {
                @TargetApi(21)
                public boolean shouldOverrideUrlLoading(@NonNull WebView view, @NonNull WebResourceRequest request) {
                    WebViewActivity.this.webview.loadUrl(request.getUrl().toString());
                    return true;
                }

                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    WebViewActivity.this.webview.loadUrl(url);
                    return true;
                }
            };
            WebView newWebView = new WebView(WebViewActivity.this.webview.getContext());
            newWebView.setWebViewClient(webViewClient);
            ((WebView.WebViewTransport) resultMsg.obj).setWebView(newWebView);
            resultMsg.sendToTarget();
            return true;
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WebView webView = new WebView(this);
        this.webview = webView;
        setContentView(webView);
        Intent intent = getIntent();
        String url = intent.getStringExtra(URL_EXTRA);
        boolean enableJavaScript = intent.getBooleanExtra(ENABLE_JS_EXTRA, false);
        boolean enableDomStorage = intent.getBooleanExtra(ENABLE_DOM_EXTRA, false);
        this.webview.loadUrl(url, extractHeaders(intent.getBundleExtra("com.android.browser.headers")));
        this.webview.getSettings().setJavaScriptEnabled(enableJavaScript);
        this.webview.getSettings().setDomStorageEnabled(enableDomStorage);
        this.webview.setWebViewClient(this.webViewClient);
        this.webview.getSettings().setSupportMultipleWindows(true);
        this.webview.setWebChromeClient(new FlutterWebChromeClient());
        registerReceiver(this.broadcastReceiver, this.closeIntentFilter);
    }

    private Map<String, String> extractHeaders(Bundle headersBundle) {
        Map<String, String> headersMap = new HashMap<>();
        for (String key : headersBundle.keySet()) {
            headersMap.put(key, headersBundle.getString(key));
        }
        return headersMap;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.broadcastReceiver);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode != 4 || !this.webview.canGoBack()) {
            return super.onKeyDown(keyCode, event);
        }
        this.webview.goBack();
        return true;
    }

    public static Intent createIntent(Context context, String url, boolean enableJavaScript, boolean enableDomStorage, Bundle headersBundle) {
        return new Intent(context, WebViewActivity.class).putExtra(URL_EXTRA, url).putExtra(ENABLE_JS_EXTRA, enableJavaScript).putExtra(ENABLE_DOM_EXTRA, enableDomStorage).putExtra("com.android.browser.headers", headersBundle);
    }
}
