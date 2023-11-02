package com.example.torbrowserinternational

import android.app.ProgressDialog
import android.content.Intent
import android.graphics.Bitmap
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.SearchView
import androidx.core.widget.addTextChangedListener
import com.example.torbrowserinternational.databinding.ActivityMainBinding
import com.example.torbrowserinternational.utils.MyData
import com.example.torbrowserinternational.utils.MyData.str

class MainActivity : AppCompatActivity() {
        lateinit var progressDialog:ProgressDialog
        private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
            var link="google.com/search?"



        progressDialog=ProgressDialog(this)
        progressDialog.setTitle("Yuklanmoqda...")
        progressDialog.setMessage("Kutib turing...")


        binding.edtV.addTextChangedListener {
            binding.myWeb.loadUrl("https://${it.toString()}")
        }


        binding.myWeb.settings.javaScriptEnabled=true

        binding.myWeb.webViewClient=object : WebViewClient(){
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
            }


            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                progressDialog.hide()
            }

            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                return super.shouldOverrideUrlLoading(view, request)
            }
        }

    }
}