package jq.enbe.daily;

import jq.enbe.R;
import jq.enbe.commons.SelfOpenWebViewClient;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;

/**
 * The Class DailyFragment.
 */
public class DailyFragment extends Fragment {
	/**
	 * The fragment argument representing the section number for this fragment.
	 */
	private static final String ARG_SECTION_NUMBER = "section_number";

	/**
	 * Returns a new instance of this fragment for the given section number.
	 * 
	 * @param sectionNumber
	 *            the section number
	 * @return the placeholder fragment
	 */
	public static DailyFragment newInstance(int sectionNumber) {
		DailyFragment fragment = new DailyFragment();
		Bundle args = new Bundle();
		args.putInt(ARG_SECTION_NUMBER, sectionNumber);
		fragment.setArguments(args);
		return fragment;
	}

	/**
	 * Daily fragment.
	 */
	public DailyFragment() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater,
	 * android.view.ViewGroup, android.os.Bundle)
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		final View rootView = inflater.inflate(R.layout.fragment_daily,
				container, false);

		loadDailyWebPage(rootView);

		final Button button = (Button) rootView.findViewById(R.id.dailyButton1);
		button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				loadDailyWebPage(rootView);
			}
		});

		return rootView;
	}

	/**
	 * Load daily web page.
	 * 
	 * @param rootView
	 *            the root view
	 */
	private void loadDailyWebPage(View rootView) {
		final WebView webView = (WebView) rootView
				.findViewById(R.id.dailyWebView1);
		String loadingText = "<html><body style=\"text-align:center;padding-top:20px;\">loading...</body></html>";
		webView.loadData(loadingText, "text/html", null);

		webView.setWebViewClient(new SelfOpenWebViewClient());
		webView.loadUrl("https://sites.google.com/site/enbedaily/home");
	}
}
