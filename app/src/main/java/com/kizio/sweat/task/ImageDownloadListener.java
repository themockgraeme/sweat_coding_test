package com.kizio.sweat.task;

import android.graphics.Bitmap;

/**
 * Handles the result of an image downloading.
 *
 * @author Graeme Sutherland
 * @since 02/08/2019
 */
public interface ImageDownloadListener {

	/**
	 * Invoked when a {@link Bitmap} is downloaded.
	 *
	 * @param url The URL {@code String} for the downloaded image
	 * @param image The downloaded {@link Bitmap}
	 */
	void onImageDownloaded(String url, Bitmap image);
}
