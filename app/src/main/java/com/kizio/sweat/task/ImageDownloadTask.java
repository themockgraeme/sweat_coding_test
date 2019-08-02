package com.kizio.sweat.task;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import androidx.annotation.NonNull;

import com.kizio.sweat.data.Trainer;
import com.kizio.sweat.data.TrainingProgramme;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Downloads the trainer images from the web.
 *
 * @author Graeme Sutherland
 * @since 01/08/2019
 */
public class ImageDownloadTask extends AsyncTask<TrainingProgramme, Void, List<ImageDownloadTask.Result>> {

	/**
	 * Holds the result of a download from the web.
	 */
	static class Result {
		/**
		 * The URL {@code String} that was used to download the image from the web.
		 */
		private final String url;

		/**
		 * The downloaded {@link Bitmap}.
		 */
		private final Bitmap image;

		/**
		 * Constructor.
		 *
		 * @param aUrl The URL {@code String} that was used to download the image
		 * @param anImage The downloaded {@link Bitmap}
		 */
		Result(final String aUrl, final Bitmap anImage) {
			super();

			this.url = aUrl;
			this.image = anImage;
		}

		/**
		 * Gets the URL {@code String}.
		 *
		 * @return The URL {@code String}
		 */
		String getUrl() {
			return this.url;
		}

		/**
		 * Gets the downloaded {@link Bitmap}.
		 * @return The downloaded {@link Bitmap}
		 */
		Bitmap getImage() {
			return this.image;
		}
	}

	/**
	 * Holds a {@link WeakReference} to the {@link ImageDownloadListener} class to prevent it from
	 * being leaked.
	 */
	private final WeakReference<ImageDownloadListener> listenerReference;

	/**
	 * Constructor.
	 *
	 * @param listener The {@link ImageDownloadListener} to call back to
	 */
	public ImageDownloadTask(final ImageDownloadListener listener) {
		super();

		this.listenerReference = new WeakReference<>(listener);
	}

	/**
	 * Runs in the background thread and downloads the {@link Trainer} portrait {@link Bitmap}
	 * images from the web.
	 *
	 * @param programmes An array of {@link TrainingProgramme} objects
	 * @return A {@link List} of bitmap and URL pairs
	 */
	@Override
	protected List<ImageDownloadTask.Result> doInBackground(final TrainingProgramme... programmes) {
		final List<ImageDownloadTask.Result> results = new ArrayList<>();
		final Set<String> downloadedUrls = new HashSet<>();

		for (final TrainingProgramme programme : programmes) {
			final Trainer trainer = programme.getTrainer();
			final String url = trainer.getImageAddress();

			if (!downloadedUrls.contains(url)) {
				final Bitmap bitmap = getBitmapFromUrl(url);

				downloadedUrls.add(url);
				results.add(new ImageDownloadTask.Result(url, bitmap));
			}
		}

		return results;
	}

	/**
	 * Handles the results when the download process has completed.
	 *
	 * @param results The URL / image pair for each download
	 */
	@Override
	protected void onPostExecute(final List<ImageDownloadTask.Result> results) {
		final ImageDownloadListener listener = this.listenerReference.get();

		if (listener != null) {
			for (final ImageDownloadTask.Result result : results) {
				listener.onImageDownloaded(result.getUrl(), result.getImage());
			}
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
