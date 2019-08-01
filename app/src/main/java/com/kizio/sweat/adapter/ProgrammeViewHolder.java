package com.kizio.sweat.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kizio.sweat.data.TrainingProgramme;
import com.kizio.sweat.view.ProgrammeView;

/**
 * {@link RecyclerView.ViewHolder} used to hold a {@link ProgrammeView}.
 *
 * @author Graeme Sutherland
 * @since 01/08/2019
 */
public class ProgrammeViewHolder extends RecyclerView.ViewHolder {

	/**
	 * The {@link ProgrammeView} being held by this view holder.
	 */
	private final ProgrammeView programmeView;

	/**
	 * Constructor.
	 *
	 * @param view The {@link ProgrammeView} being held
	 */
	public ProgrammeViewHolder(@NonNull final ProgrammeView view) {
		super(view);

		this.programmeView = view;
	}

	/**
	 * Helper method to set the {@link TrainingProgramme} displayed by the view associated with this
	 * view holder.
	 *
	 * @param programme The {@link TrainingProgramme} to display
	 */
	public void setTrainingProgramme(@NonNull final TrainingProgramme programme) {
		this.programmeView.setTrainingProgramme(programme);
	}
}
