package com.kizio.sweat;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kizio.sweat.adapter.ProgrammeAdapter;
import com.kizio.sweat.data.DataFactory;
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
	 * Invoked when the activity is created.
	 *
	 * @param savedInstanceState A {@link Bundle} containing the saved state of the activity
	 */
	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final RecyclerView programmeList = findViewById(R.id.programme_list);
		final TrainingProgramme[] programmes = DataFactory.getTrainingProgrammes(this);
		final ProgrammeAdapter adapter = new ProgrammeAdapter(this, programmes);
		final Toolbar toolbar = findViewById(R.id.main_toolbar);

		setSupportActionBar(toolbar);

		programmeList.setLayoutManager(new LinearLayoutManager(this));
		programmeList.setAdapter(adapter);

		new ImageDownloadTask(adapter).execute(programmes);
	}
}
