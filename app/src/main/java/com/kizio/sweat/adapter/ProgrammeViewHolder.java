package com.kizio.sweat.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.kizio.sweat.R;
import com.kizio.sweat.data.Tag;
import com.kizio.sweat.data.Trainer;
import com.kizio.sweat.data.TrainingProgramme;

/**
 * {@link RecyclerView.ViewHolder} used to hold a {@link View} to display details about a training
 * programme.
 *
 * @author Graeme Sutherland
 * @since 01/08/2019
 */
class ProgrammeViewHolder extends RecyclerView.ViewHolder {

	/**
	 * {@link TextView} containing the programme name.
	 */
	private final TextView programmeName;

	/**
	 * {@link TextView} containing the trainer's name.
	 */
	private final TextView trainerName;

	/**
	 * {@link RatingBar} displaying the programme's rating.
	 */
	private final RatingBar programmeRating;

	/**
	 * {@link ProgressBar} displaying how effective the programme is for weight loss.
	 */
	private final ProgressBar weightLoss;

	/**
	 * {@link ProgressBar} displaying how effective the programme is for building muscle.
	 */
	private final ProgressBar muscle;

	/**
	 * {@link ProgressBar} displaying how effective the programme is for gaining strength.
	 */
	private final ProgressBar strength;

	/**
	 * {@link ProgressBar} displaying how effective the programme is for improving flexibility.
	 */
	private final ProgressBar flexibility;

	/**
	 * {@link ChipGroup} for holding tags about the programme.
	 */
	private final ChipGroup tags;

	/**
	 * {@link ImageView} holding a portrait of the trainer.
	 */
	private final ImageView trainerPortrait;
	
	/**
	 * Constructor.
	 *
	 * @param view The {@link View} being held
	 */
	ProgrammeViewHolder(@NonNull final View view) {
		super(view);

		this.programmeName = view.findViewById(R.id.programme_name);
		this.trainerName = view.findViewById(R.id.trainer_name);
		this.programmeRating = view.findViewById(R.id.programme_rating);
		this.weightLoss = view.findViewById(R.id.weight_loss_rating);
		this.muscle = view.findViewById(R.id.muscle_rating);
		this.strength = view.findViewById(R.id.strength_rating);
		this.flexibility = view.findViewById(R.id.flexibility_rating);
		this.tags = view.findViewById(R.id.tags);
		this.trainerPortrait = view.findViewById(R.id.trainer_portrait);
	}

	/**
	 * Helper method to set the {@link TrainingProgramme} displayed by the view associated with this
	 * view holder.
	 *
	 * @param programme The {@link TrainingProgramme} to display
	 */
	void setTrainingProgramme(@NonNull final Context context,
							  @NonNull final TrainingProgramme programme) {
		final Trainer trainer = programme.getTrainer();
		final Tag[] programmeTags = programme.getTags();

		this.programmeName.setText(programme.getName());
		this.trainerName.setText(context.getString(R.string.with_trainer, trainer.getName()));
		this.trainerPortrait.setImageBitmap(trainer.getImage());

		this.tags.removeAllViews();

		for (final Tag tag : programmeTags) {
			final String caption = tag.getName();
			final Chip chip = new Chip(context);

			chip.setText(caption);

			this.tags.addView(chip);
		}
	}
}
