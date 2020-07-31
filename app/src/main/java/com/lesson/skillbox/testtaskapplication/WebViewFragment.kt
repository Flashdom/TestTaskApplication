package com.lesson.skillbox.testtaskapplication

import android.app.Activity.RESULT_OK
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.KeyEvent
import android.webkit.*
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_web_view.*


class WebViewFragment : BaseFragment(R.layout.fragment_web_view) {

    private val args: WebViewFragmentArgs by navArgs()
    private var uploadFile: ValueCallback<Array<Uri>>? = null

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val string = args.url
        initWebView(string)
    }


    private fun initWebView(string: String) {
        webView.loadUrl(string)
        webView.webViewClient = object : WebViewClient() {

            override fun onPageFinished(view: WebView?, url: String?) {
                CookieManager.getInstance().flush()
                super.onPageFinished(view, url)
            }

        }
        webView.settings.javaScriptEnabled = true
        checkInternetAvailability()
        webView.settings.allowFileAccess = true
        webView.settings.allowContentAccess = true
        webView.settings.setSupportZoom(true)
        webView.webChromeClient = object : WebChromeClient() {
            override fun onShowFileChooser(
                webView: WebView?,
                filePathCallback: ValueCallback<Array<Uri>>?,
                fileChooserParams: FileChooserParams
            ): Boolean {
                return try {
                    uploadFile = filePathCallback
                    startActivityForResult(
                        fileChooserParams.createIntent(),
                        REQUEST_FILE,
                        null
                    )
                    true
                } catch (e: ActivityNotFoundException) {
                    false
                }
            }

        }

        webView.setOnKeyListener { _, keyCode, _ ->
            if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
                webView.goBack()
                true
            } else
                false


        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_FILE && resultCode == RESULT_OK && data != null) {

            uploadFile?.onReceiveValue(
                WebChromeClient.FileChooserParams.parseResult(
                    resultCode,
                    data
                )
            )

            uploadFile = null

        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    companion object {
        private const val REQUEST_FILE = 1124

    }


}

