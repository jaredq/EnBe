package jq.enbe.grammar;

import jq.enbe.R;
import jq.enbe.commons.SelfOpenWebViewClient;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class GrammarFragment extends Fragment {

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
	public static GrammarFragment newInstance(int sectionNumber) {
		GrammarFragment fragment = new GrammarFragment();
		Bundle args = new Bundle();
		args.putInt(ARG_SECTION_NUMBER, sectionNumber);
		fragment.setArguments(args);
		return fragment;
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
		View rootView = inflater.inflate(R.layout.fragment_grammar, container,
				false);
		WebView webView = (WebView) rootView.findViewById(R.id.grammarWebView1);
		webView.setWebViewClient(new SelfOpenWebViewClient());
		webView.loadUrl("https://sites.google.com/site/enbegrammar/home");

		return rootView;
	}
}
