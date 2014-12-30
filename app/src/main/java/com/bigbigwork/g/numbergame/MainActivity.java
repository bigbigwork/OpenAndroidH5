package com.bigbigwork.g.numbergame;

import android.graphics.Bitmap;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;


public class MainActivity extends ActionBarActivity {
    FrameLayout welcome;
    FrameLayout game;
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        welcome=(FrameLayout)findViewById(R.id.welcome);
        game=(FrameLayout)findViewById(R.id.game);
        webView=(WebView)findViewById(R.id.webView);
        new Handler().postDelayed(new Runnable(){

            public void run() {
                // TODO Auto-generated method stub

                welcome.setVisibility(View.INVISIBLE);
                game.setVisibility(View.VISIBLE);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.getSettings().setAllowFileAccess(true);// 设置允许访问文件数据
                webView.getSettings().setSupportZoom(false);
                webView.getSettings().setUserAgentString("Mozilla/5.0 (iPad; U; CPU OS 3_2 like Mac OS X;en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Version/4.0.4 Mobile/7B334bSafari/531.21.10");
                webView.loadUrl("http://www.bjnews.com.cn/m.html");
                //webView.loadUrl("file:///android_asset/index.html");
                webView.setWebViewClient(new WebViewClient(){
                    //网页加载开始时调用，显示加载提示旋转进度条
                    @Override
                    public void onPageStarted(WebView view, String url, Bitmap favicon) {
                        // TODO Auto-generated method stub
                        super.onPageStarted(view, url, favicon);
                        //progressBar.setVisibility(android.view.View.VISIBLE);
//                Toast.makeText(ElecHall.this, "onPageStarted", 2).show();
                    }

                    //网页加载完成时调用，隐藏加载提示旋转进度条
                    @Override
                    public void onPageFinished(WebView view, String url) {
                        // TODO Auto-generated method stub
                        super.onPageFinished(view, url);
                        //progressBar.setVisibility(android.view.View.GONE);
//                Toast.makeText(ElecHall.this, "onPageFinished", 2).show();
                    }
                    //网页加载失败时调用，隐藏加载提示旋转进度条
                    @Override
                    public void onReceivedError(WebView view, int errorCode,
                                                String description, String failingUrl) {
                        // TODO Auto-generated method stub
                        super.onReceivedError(view, errorCode, description, failingUrl);
                        //progressBar.setVisibility(android.view.View.GONE);
//                Toast.makeText(ElecHall.this, "onReceivedError", 2).show();
                    }


                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                        webView.loadUrl(url);
                        return super.shouldOverrideUrlLoading(view,url);
                    }
                });

                //


            }

        }, 5000);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK) {
            //mWebView.goBack();// 返回前一个页面
            //return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
