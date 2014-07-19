package jq.enbe.phonetics;

import jq.enbe.R;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * The Class PhoneticsFragment.
 */
public class PhoneticsFragment extends Fragment {

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
	public static PhoneticsFragment newInstance(int sectionNumber) {
		PhoneticsFragment fragment = new PhoneticsFragment();
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
		View rootView = inflater.inflate(R.layout.fragment_phonetics,
				container, false);

		GridView gridView = (GridView) rootView
				.findViewById(R.id.phoneticsGridView1);
		gridView.setAdapter(new ImageAdapter(rootView.getContext()));

		return rootView;
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
				imageView.setLayoutParams(new GridView.LayoutParams(130, 110));
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
		/** The m thumb ids. */
		private Integer[] mThumbIds = { R.drawable.phonetics_01,
				R.drawable.phonetics_02, R.drawable.phonetics_03,
				R.drawable.phonetics_04, R.drawable.phonetics_05,
				R.drawable.phonetics_06, R.drawable.phonetics_07,
				R.drawable.phonetics_08, R.drawable.phonetics_09,
				R.drawable.phonetics_10, R.drawable.phonetics_11,
				R.drawable.phonetics_12, R.drawable.phonetics_13,
				R.drawable.phonetics_14, R.drawable.phonetics_blank,
				R.drawable.phonetics_blank, R.drawable.phonetics_15,
				R.drawable.phonetics_16, R.drawable.phonetics_17,
				R.drawable.phonetics_blank, R.drawable.phonetics_18,
				R.drawable.phonetics_19, R.drawable.phonetics_20,
				R.drawable.phonetics_blank, R.drawable.phonetics_21,
				R.drawable.phonetics_22, R.drawable.phonetics_23,
				R.drawable.phonetics_24, R.drawable.phonetics_25,
				R.drawable.phonetics_26, R.drawable.phonetics_27,
				R.drawable.phonetics_28, R.drawable.phonetics_29,
				R.drawable.phonetics_30, R.drawable.phonetics_31,
				R.drawable.phonetics_32, R.drawable.phonetics_33,
				R.drawable.phonetics_34, R.drawable.phonetics_35,
				R.drawable.phonetics_36, R.drawable.phonetics_37,
				R.drawable.phonetics_38, R.drawable.phonetics_39,
				R.drawable.phonetics_40, R.drawable.phonetics_41,
				R.drawable.phonetics_42, R.drawable.phonetics_43,
				R.drawable.phonetics_44 };

		// references to our sounds
		private Integer[] mSoundIds = { R.raw.phonetics_sheep,
				R.raw.phonetics_ship, R.raw.phonetics_good,
				R.raw.phonetics_shoot, R.raw.phonetics_bed,
				R.raw.phonetics_teacher, R.raw.phonetics_bird,
				R.raw.phonetics_door, R.raw.phonetics_cat, R.raw.phonetics_up,
				R.raw.phonetics_far, R.raw.phonetics_on, R.raw.phonetics_here,
				R.raw.phonetics_wait, R.raw.phonetics_blank,
				R.raw.phonetics_blank, R.raw.phonetics_tourist,
				R.raw.phonetics_boy, R.raw.phonetics_show,
				R.raw.phonetics_blank, R.raw.phonetics_hair,
				R.raw.phonetics_my, R.raw.phonetics_cow, R.raw.phonetics_blank,
				R.raw.phonetics_pea, R.raw.phonetics_boat, R.raw.phonetics_tea,
				R.raw.phonetics_dog, R.raw.phonetics_fly,
				R.raw.phonetics_video, R.raw.phonetics_think,
				R.raw.phonetics_this, R.raw.phonetics_man, R.raw.phonetics_now,
				R.raw.phonetics_sing, R.raw.phonetics_hat,
				R.raw.phonetics_cheese, R.raw.phonetics_june,
				R.raw.phonetics_car, R.raw.phonetics_go, R.raw.phonetics_see,
				R.raw.phonetics_zoo, R.raw.phonetics_shall,
				R.raw.phonetics_television, R.raw.phonetics_love,
				R.raw.phonetics_red, R.raw.phonetics_wet, R.raw.phonetics_yes };
	}
}
