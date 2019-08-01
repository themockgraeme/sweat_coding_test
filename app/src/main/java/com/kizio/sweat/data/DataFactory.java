package com.kizio.sweat.data;

import android.content.Context;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kizio.sweat.R;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Provides methods for reading app data.
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
	public static TrainingProgramme[] getTrainingProgrammes(@NonNull final Context context) {
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
}
