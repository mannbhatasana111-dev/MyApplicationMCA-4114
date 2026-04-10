package com.example.myapplicationmca;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.progressindicator.LinearProgressIndicator;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class UNIT3_pro37 extends AppCompatActivity {

    private WebView webView;
    private EditText etUrl;
    private MaterialButton btnGo;
    private LinearProgressIndicator progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_unit3_pro37);

        webView = findViewById(R.id.webView);
        etUrl = findViewById(R.id.et_url);
        btnGo = findViewById(R.id.btn_go);
        progressBar = findViewById(R.id.progress_bar);

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar.setVisibility(View.GONE);
                etUrl.setText(url);
            }
        });

        webView.loadUrl("https://www.google.com");

        btnGo.setOnClickListener(v -> {
            String url = etUrl.getText().toString().trim();
            if (!url.isEmpty()) {
                if (!url.startsWith("http")) {
                    url = "https://" + url;
                }
                webView.loadUrl(url);
            }
        });
    }


    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}