package jq.enbe.alphabets;

import jq.enbe.R;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class AlphabetsFragment extends Fragment {

	/**
	 * The fragment argument representing the section number for this fragment.
	 */
	private static final String ARG_SECTION_NUMBER = "section_number";

	/**
	 * The m media player
	 */
	private MediaPlayer mMediaPlayer = null;

	/**
	 * Returns a new instance of this fragment for the given section number.
	 * 
	 * @param sectionNumber
	 *            the section number
	 * @return the placeholder fragment
	 */
	public static AlphabetsFragment newInstance(int sectionNumber) {
		AlphabetsFragment fragment = new AlphabetsFragment();
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
		View rootView = inflater.inflate(R.layout.fragment_alphabets,
				container, false);
		ListView listView = (ListView) rootView
				.findViewById(R.id.alphabetsListView1);
		listView.setAdapter(new ImageAdapter(rootView.getContext()));
		return rootView;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		if (mMediaPlayer != null) {
			mMediaPlayer.release();
		}
	}

	/**
	 * The Class ImageAdapter.
	 */
	public class ImageAdapter extends BaseAdapter {

		/** The m context. */
		private Context mContext;

		/**
		 * Instantiates a new image adapter.
		 * 
		 * @param c
		 *            the c
		 */
		public ImageAdapter(Context c) {
			mContext = c;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see android.widget.Adapter#getCount()
		 */
		public int getCount() {
			return mThumbIds.length;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see android.widget.Adapter#getItem(int)
		 */
		public Object getItem(int position) {
			return null;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see android.widget.Adapter#getItemId(int)
		 */
		public long getItemId(int position) {
			return 0;
		}

		// create a new ImageView for each item referenced by the Adapter
		/*
		 * (non-Javadoc)
		 * 
		 * @see android.widget.Adapter#getView(int, android.view.View,
		 * android.view.ViewGroup)
		 */
		public View getView(final int position, View convertView,
				ViewGroup parent) {
			ImageView imageView;
			if (convertView == null) {
				// if it's not recycled, initialize some attributes
				imageView = new ImageView(mContext);
				imageView.setLayoutParams(new ListView.LayoutParams(450, 400));
				imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
				imageView.setPadding(8, 8, 8, 8);
			} else {
				imageView = (ImageView) convertView;
			}

			imageView.setImageResource(mThumbIds[position]);
			imageView.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// prefer to sync
					if (mMediaPlayer != null) {
						mMediaPlayer.release();
						mMediaPlayer = null;
					}

					MediaPlayer mediaPlayer = MediaPlayer.create(mContext,
							mSoundIds[position]);
					mediaPlayer.start();

					mMediaPlayer = mediaPlayer;
				}
			});
			return imageView;
		}

		// references to our images
		private Integer[] mThumbIds = { R.drawable.alphabets_a,
				R.drawable.alphabets_b, R.drawable.alphabets_c,
				R.drawable.alphabets_d, R.drawable.alphabets_e,
				R.drawable.alphabets_f, R.drawable.alphabets_g,
				R.drawable.alphabets_h, R.drawable.alphabets_i,
				R.drawable.alphabets_j, R.drawable.alphabets_k,
				R.drawable.alphabets_l, R.drawable.alphabets_m,
				R.drawable.alphabets_n, R.drawable.alphabets_o,
				R.drawable.alphabets_p, R.drawable.alphabets_q,
				R.drawable.alphabets_r, R.drawable.alphabets_s,
				R.drawable.alphabets_t, R.drawable.alphabets_u,
				R.drawable.alphabets_v, R.drawable.alphabets_w,
				R.drawable.alphabets_x, R.drawable.alphabets_y,
				R.drawable.alphabets_z };

		// references to our sounds
		private Integer[] mSoundIds = { R.raw.alphabets_a, R.raw.alphabets_b,
				R.raw.alphabets_c, R.raw.alphabets_d, R.raw.alphabets_e,
				R.raw.alphabets_f, R.raw.alphabets_g, R.raw.alphabets_h,
				R.raw.alphabets_i, R.raw.alphabets_j, R.raw.alphabets_k,
				R.raw.alphabets_l, R.raw.alphabets_m, R.raw.alphabets_n,
				R.raw.alphabets_o, R.raw.alphabets_p, R.raw.alphabets_q,
				R.raw.alphabets_r, R.raw.alphabets_s, R.raw.alphabets_t,
				R.raw.alphabets_u, R.raw.alphabets_v, R.raw.alphabets_w,
				R.raw.alphabets_x, R.raw.alphabets_y, R.raw.alphabets_z };
	}

}
