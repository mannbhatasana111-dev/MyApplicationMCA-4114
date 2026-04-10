package com.example.myapplicationmca;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class UNIT3_pro33 extends AppCompatActivity {

    EditText etUrl;
    MaterialButton btnGo;
    WebView myWebView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit3_pro33);

        etUrl = findViewById(R.id.et_url);
        btnGo = findViewById(R.id.btn_go);
        myWebView = findViewById(R.id.webView);

        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        myWebView.setWebViewClient(new WebViewClient());

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = etUrl.getText().toString().trim();

                if (!url.isEmpty()) {

                    if (!url.startsWith("http://") && !url.startsWith("https://")) {
                        url = "https://" + url;
                    }
                    myWebView.loadUrl(url);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (myWebView.canGoBack()) {
            myWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}