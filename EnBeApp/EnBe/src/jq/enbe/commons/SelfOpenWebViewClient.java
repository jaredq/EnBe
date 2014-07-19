package jq.enbe.commons;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * The Class SelfOpenWebViewClient.
 */
public class SelfOpenWebViewClient extends WebViewClient {

	@Override
	public boolean shouldOverrideUrlLoading(WebView view, String url) {
		view.loadUrl(url);
		return true;
	}
}
