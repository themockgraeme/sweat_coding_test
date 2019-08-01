package com.kizio.sweat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kizio.sweat.R;
import com.kizio.sweat.data.TrainingProgramme;

/**
 * Adapter for displaying an array of {@link TrainingProgramme} objects in a {@link RecyclerView}.
 *
 * @author Graeme Sutherland
 * @since 01/08/2019
 */
public class ProgrammeAdapter extends RecyclerView.Adapter<ProgrammeViewHolder> {

	/**
	 * The {@link Context} the adapter is being displayed in.
	 */
	private final Context context;

	/**
	 * The {@link TrainingProgramme} array being displayed in this adapter.
	 */
	private final TrainingProgramme[] programmes;

	/**
	 * Constructor.
	 *
	 * @param aContext The {@link Context} the adapter is being displayed in
	 * @param aProgrammeArray The {@link TrainingProgramme} array being displayed
	 */
	public ProgrammeAdapter(@NonNull final Context aContext,
							@NonNull final TrainingProgramme[] aProgrammeArray) {
		super();

		this.context = aContext;
		this.programmes = aProgrammeArray;
	}

	/**
	 * Created when a new {@link ProgrammeViewHolder} is required.
	 *
	 * @param parent The parent {@link ViewGroup}
	 * @param viewType The view type of the new View
	 * @return A new {@link ProgrammeViewHolder}
	 */
	@NonNull
	@Override
	public ProgrammeViewHolder onCreateViewHolder(@NonNull final ViewGroup parent,
												  final int viewType) {
		final LayoutInflater inflater = LayoutInflater.from(context);
		final View view = inflater.inflate(R.layout.view_programme, parent, false);

		return new ProgrammeViewHolder(view);
	}

	/**
	 * Binds the view in the {@link ProgrammeViewHolder} to the data at the specified position.
	 *
	 * @param holder The {@link ProgrammeViewHolder} holding the view to display
	 * @param position The position of the item within the adapter's data set
	 */
	@Override
	public void onBindViewHolder(@NonNull final ProgrammeViewHolder holder, final int position) {
		if (this.programmes != null) {
			holder.setTrainingProgramme(this.context, this.programmes[position]);
		}
	}

	/**
	 * Returns the total number of items in the data set held by the adapter.
	 *
	 * @return The total number of items in this adapter
	 */
	@Override
	public int getItemCount() {
		return this.programmes != null ? this.programmes.length : 0;
	}
}
