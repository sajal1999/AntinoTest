package com.example.android.antinotest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_news.*

class NewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        val ss:String = intent.getStringExtra("url").toString()
        webView.webViewClient = WebViewClient()


        webView.loadUrl(ss)


        webView.settings.javaScriptEnabled = true


        webView.settings.setSupportZoom(true)
    }

    override fun onBackPressed() {

        if (webView.canGoBack())
            webView.goBack()

        else
            super.onBackPressed()
    }
    }
