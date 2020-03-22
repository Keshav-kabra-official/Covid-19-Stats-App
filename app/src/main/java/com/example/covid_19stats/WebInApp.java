package com.example.covid_19stats;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebInApp extends AppCompatActivity {

    WebView wb;
    ProgressDialog mProgressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_in_app);

        wb = findViewById(R.id.web_id);

        wb.getSettings().setJavaScriptEnabled(true);
        wb.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                mProgressDialog = new ProgressDialog(WebInApp.this);
                mProgressDialog.setTitle("COVID-19 Stats");
                mProgressDialog.setMessage("Loading...");
                mProgressDialog.setIndeterminate(false);
                try{
                    mProgressDialog.show();
                }catch (WindowManager.BadTokenException e) {
                    System.out.println("");
                }
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                mProgressDialog.dismiss();
                wb.loadUrl("javascript:(function() { " +
                        "document.getElementsByTagName('header'); " +
                        "})()");
            }
        });
        wb.loadUrl("https://covidout.in/");
    }

}
