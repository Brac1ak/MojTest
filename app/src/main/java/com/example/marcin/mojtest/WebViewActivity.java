package com.example.marcin.mojtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_view_activity);

        WebView webView = (WebView) findViewById(R.id.web_view_web_view_activity);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://github.com/Brac1ak/MojTest");

    }
}
