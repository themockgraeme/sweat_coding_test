package com.kizio.sweat.task;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import androidx.annotation.NonNull;

import com.kizio.sweat.MainActivity;
import com.kizio.sweat.data.Trainer;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Downloads the trainer images from the web.
 * <p>
 * This isn't an optimal piece of code, but I'm going for simplicity here. It should call an update
 * for each downloaded bitmap, and cache images so that it doesn't do a network call more than once.
 * </p>
 * @author Graeme Sutherland
 * @since 01/08/2019
 */
public class ImageDownloadTask extends AsyncTask<Trainer, Void, Void> {

	/**
	 * Holds a {@link WeakReference} to the {@link MainActivity} class to prevent it from being
	 * leaked.
	 */
	private final WeakReference<MainActivity> activityReference;

	/**
	 * Constructor.
	 *
	 * @param activity The {@link MainActivity} to call back to
	 */
	public ImageDownloadTask(final MainActivity activity) {
		super();

		this.activityReference = new WeakReference<>(activity);
	}

	/**
	 * Runs in the background thread and downloads the {@link Trainer} portrait {@link Bitmap}
	 * images from the web.
	 *
	 * @param trainers An array of {@link Trainer} objects
	 * @return {@code null}
	 */
	@Override
	protected Void doInBackground(final Trainer... trainers) {
		for (final Trainer trainer : trainers) {
			final String url = trainer.getImageAddress();
			final Bitmap bitmap = getBitmapFromUrl(url);

			trainer.setImage(bitmap);
		}

		return null;
	}

	@Override
	protected void onPostExecute(final Void aVoid) {
		super.onPostExecute(aVoid);

		final MainActivity activity = this.activityReference.get();

		if (activity != null) {
			activity.onDownloadComplete();
		}
	}

	/**
	 * Downloads a {@code Bitmap} from the supplied URL.
	 *
	 * @param address The URL {@code String} to download the image from
	 * @return The downloaded {@code Bitmap}
	 */
	private static Bitmap getBitmapFromUrl(@NonNull final String address) {
		Bitmap bitmap = null;

		try {
			final URL url = new URL(address);
			final URLConnection connection = url.openConnection();

			connection.setDoInput(true);
			connection.connect();

			bitmap = BitmapFactory.decodeStream(connection.getInputStream());
		} catch (final MalformedURLException mue) {
			mue.printStackTrace();
		} catch (final IOException ioe) {
			ioe.printStackTrace();
		}

		return bitmap;
	}
}
