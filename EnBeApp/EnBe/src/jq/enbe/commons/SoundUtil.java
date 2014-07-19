package jq.enbe.commons;

import java.io.IOException;

import android.media.MediaPlayer;

/**
 * The Class SoundUtil.
 */
public class SoundUtil {

	/** The mp. */
	static MediaPlayer mp;

	/**
	 * Play bgm.
	 * 
	 * @param path
	 *            the path
	 * @param looping
	 *            the looping
	 */
	static void playBGM(String path, boolean looping) {
		if (mp == null) {
			mp = new MediaPlayer();
		}
		mp.reset();
		try {
			mp.setDataSource(path);
			mp.prepare();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		mp.setLooping(looping);
		mp.start();
	}
}