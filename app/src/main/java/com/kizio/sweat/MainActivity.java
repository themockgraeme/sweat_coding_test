package com.kizio.sweat;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kizio.sweat.adapter.ProgrammeAdapter;
import com.kizio.sweat.data.DataFactory;
import com.kizio.sweat.data.Trainer;
import com.kizio.sweat.data.TrainingProgramme;
import com.kizio.sweat.task.ImageDownloadTask;

/**
 * The main application activity.
 *
 * @author Graeme Sutherland
 * @since 01/08/2019
 */
public class MainActivity extends AppCompatActivity {

	/**
	 * The {@link RecyclerView} used to display the programme cards.
	 */
	private RecyclerView programmeList;

	/**
	 * Invoked when the activity is created.
	 *
	 * @param savedInstanceState A {@link Bundle} containing the saved state of the activity
	 */
	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		this.programmeList = findViewById(R.id.programme_list);

		final TrainingProgramme[] programmes = DataFactory.getTrainingProgrammes(this);
		final ProgrammeAdapter adapter = new ProgrammeAdapter(this, programmes);

		this.programmeList.setLayoutManager(new LinearLayoutManager(this));
		this.programmeList.setAdapter(adapter);

		for (final TrainingProgramme programme : programmes) {
			final Trainer trainer = programme.getTrainer();

			new ImageDownloadTask(this).execute(trainer);
		}
	}

	/**
	 * Callback method to notify the app that the bitmaps have downloaded.
	 */
	public void onDownloadComplete() {
		final RecyclerView.Adapter<?> adapter = this.programmeList.getAdapter();

		if (adapter != null) {
			adapter.notifyDataSetChanged();
		}

		Toast.makeText(this, "Downloaded", Toast.LENGTH_SHORT).show();
	}
}
