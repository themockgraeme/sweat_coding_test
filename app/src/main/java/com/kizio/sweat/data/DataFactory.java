package com.kizio.sweat.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kizio.sweat_test.R;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Provides a methods for reading app data.
 *
 * @author Graeme Sutherland
 * @since 21/07/2019
 */
public enum DataFactory {;

	/**
	 * Reads a {@link TrainingProgramme} from the raw resources.
	 *
	 * @param context The {@code Context} used to access the app's {@code Resources}.
	 * @return The {@link TrainingProgramme} array to use in the app
	 */
	public static com.kizio.sweat_test.data.TrainingProgramme[] getTrainingProgrammes(@NonNull final Context context) {
		final InputStream is = context.getResources().openRawResource(R.raw.trainer_programs);
		final InputStreamReader isr = new InputStreamReader(is);
		final GsonBuilder builder = new GsonBuilder();
		final Gson gson = builder.create();
		final TrainingProgramme[] programmes = gson.fromJson(isr, TrainingProgramme[].class);

		try {
			isr.close();
		} catch (final IOException ioe) {
			ioe.printStackTrace();
		}

		return programmes;
	}

	/**
	 * Downloads a {@code Bitmap} from the supplied URL.
	 *
	 * @param address The URL {@code String} to download the image from
	 * @return The downloaded {@code Bitmap}
	 */
	public static Bitmap getBitmapFromUrl(@NonNull final String address) {
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
