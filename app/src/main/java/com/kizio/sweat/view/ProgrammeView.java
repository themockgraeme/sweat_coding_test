package com.kizio.sweat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.kizio.sweat.R;
import com.kizio.sweat.data.Tag;
import com.kizio.sweat.data.Trainer;
import com.kizio.sweat.data.TrainingProgramme;

/**
 * Custom view to display the details of a programme in a card view list.
 *
 * @author Graeme Sutherland
 * @since 01/08/2019
 */
public class ProgrammeView extends CardView {

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
	 * @param context The {@link Context} the view is being displayed in
	 */
	public ProgrammeView(@NonNull final Context context) {
		this(context, null);
	}

	/**
	 * Constructor.
	 *
	 * @param context The {@link Context} the view is being displayed in
	 * @param attrs The {@link AttributeSet} used to style the view
	 */
	public ProgrammeView(@NonNull final Context context, @Nullable final AttributeSet attrs) {
		this(context, attrs, 0);
	}

	/**
	 * Constructor.
	 *
	 * @param context The {@link Context} the view is being displayed in
	 * @param attrs The {@link AttributeSet} used to style the view
	 * @param defaultStyle The default style to apply to the view
	 */
	public ProgrammeView(@NonNull final Context context,
						 @Nullable final AttributeSet attrs,
						 int defaultStyle) {
		super(context, attrs, defaultStyle);

		final LayoutInflater inflater = LayoutInflater.from(context);
		final View view = inflater.inflate(R.layout.view_programme, this);

		this.programmeName = findViewById(R.id.programme_name);
		this.trainerName = findViewById(R.id.trainer_name);
		this.programmeRating = findViewById(R.id.programme_rating);
		this.weightLoss = findViewById(R.id.weight_loss_rating);
		this.muscle = findViewById(R.id.muscle_rating);
		this.strength = findViewById(R.id.strength_rating);
		this.flexibility = findViewById(R.id.flexibility_rating);
		this.tags = findViewById(R.id.tags);
		this.trainerPortrait = findViewById(R.id.trainer_portrait);
	}

	/**
	 * Sets the {@link TrainingProgramme} whose data is to be displayed.
	 *
	 * @param programme The {@link TrainingProgramme} to display
	 */
	public void setTrainingProgramme (@NonNull final TrainingProgramme programme) {
		final Trainer trainer = programme.getTrainer();
		final Tag[] programmeTags = programme.getTags();
		final Context context = getContext();

		this.programmeName.setText(programme.getName());
		this.trainerName.setText(getContext().getString(R.string.with_trainer, trainer.getName()));
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
