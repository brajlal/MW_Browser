package com.mywapka.mwbrowser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AppCompatImageButton imBtnHome;
    private AppCompatEditText etAddressBar;
    private AppCompatTextView tvNoOfTab;
    private WebView webView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imBtnHome = (AppCompatImageButton) findViewById(R.id.im_btn_home);
        etAddressBar = (AppCompatEditText) findViewById(R.id.et_address_bar);
        tvNoOfTab = (AppCompatTextView) findViewById(R.id.tv_no_of_tab);

        webView = (WebView) findViewById(R.id.web_view);
        webView.setWebViewClient(new WebViewClient());

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        etAddressBar.setOnEditorActionListener((v, actionId, event) -> {

            openWebPage();
            return true;
        });
        imBtnHome.setOnClickListener(v -> browserHomePage());


    }

    public void browserHomePage() {
        webView.loadUrl("https://www.yahoo.com");
    }

    public void openWebPage() {
        String address = etAddressBar.getText().toString();
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.google.com");

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }


    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.om_new_tab:
                Toast.makeText(MainActivity.this, "new Tab Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.om_new_incognito_tab:
                Toast.makeText(MainActivity.this, "Incasdlj", Toast.LENGTH_SHORT).show();
                break;
            case R.id.om_history:
                Toast.makeText(MainActivity.this, "History Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.om_downloads:
                Toast.makeText(MainActivity.this, "Downloads", Toast.LENGTH_SHORT).show();
                break;
            case R.id.om_bookmarks:
                Toast.makeText(MainActivity.this, "Bookmarks", Toast.LENGTH_SHORT).show();
                break;
            case R.id.om_share:
                Intent intent_share = new Intent(Intent.ACTION_SEND);
                intent_share.putExtra(Intent.EXTRA_TEXT, Constant.APP_LINK + BuildConfig.APPLICATION_ID);
                intent_share.setType("text/plain");
                startActivity(intent_share);
                break;
            case R.id.om_settings:
                Toast.makeText(MainActivity.this, "Settings", Toast.LENGTH_SHORT).show();
                break;
            case R.id.om_help_feedback:
                Toast.makeText(MainActivity.this, "Help", Toast.LENGTH_SHORT).show();
                break;
            case R.id.om_exit:
                System.exit(0);
                break;
        }
        return true;
    }
}