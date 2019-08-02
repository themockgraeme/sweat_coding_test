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
import com.kizio.sweat.data.Attribute;
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
	 * Used to convert the {@code float} value into an {@code int}.
	 */
	private static final int RATING_MULTIPLIER = 10;

	/**
	 * {@link TextView} containing the programme name.
	 */
	private final TextView programmeName;

	/**
	 * {@link TextView} containing the trainer's name.
	 */
	private final TextView trainerName;

	/**
	 * {@link RatingBar} displaying the programme's rating. This is passed as Intensity in the JSON.
	 */
	private final RatingBar programmeRating;

	// These variables were all named before I realised that the titles were pulled out of the JSON,
	// and I've left them in place rather than refactor to something more meaningful.

	/**
	 * {@link TextView} giving the title for the first rating bar.
	 */
	private final TextView weightLossTitle;

	/**
	 * {@link TextView} giving the title for the second rating bar.
	 */
	private final TextView muscleTitle;

	/**
	 * {@link TextView} giving the title for the third rating bar.
	 */
	private final TextView strengthTitle;

	/**
	 * {@link TextView} giving the title for the fourth rating bar.
	 */
	private final TextView flexibililtyTitle;

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
		this.weightLossTitle = view.findViewById(R.id.weight_loss);
		this.muscleTitle = view.findViewById(R.id.muscle);
		this.strengthTitle = view.findViewById(R.id.strength);
		this.flexibililtyTitle = view.findViewById(R.id.flexibility);
		this.weightLoss = view.findViewById(R.id.weight_loss_rating);
		this.muscle = view.findViewById(R.id.muscle_rating);
		this.strength = view.findViewById(R.id.strength_rating);
		this.flexibility = view.findViewById(R.id.flexibility_rating);
		this.tags = view.findViewById(R.id.tags);
		this.trainerPortrait = view.findViewById(R.id.trainer_portrait);
	}

	/**
	 * Helper method to set the {@link TrainingProgramme} displayed by the view associated with this
	 * holder.
	 *
	 * @param context The {@link Context} the list is being displayed in
	 * @param programme The {@link TrainingProgramme} to display
	 */
	void setTrainingProgramme(@NonNull final Context context,
							  @NonNull final TrainingProgramme programme) {
		setTrainer(context, programme.getTrainer());
		setTags(context, programme.getTags());
		setRatings(programme.getAttributes());
		this.programmeName.setText(programme.getName());


	}

	/**
	 * Helper method to set the {@link Trainer} details displayed by the view associated with this
	 * holder.
	 *
	 * @param context The {@link Context} the list is being displayed in
	 * @param trainer The {@link Trainer} to display
	 */
	private void setTrainer(@NonNull final Context context, @NonNull final Trainer trainer) {
		this.trainerName.setText(context.getString(R.string.with_trainer, trainer.getName()));
		this.trainerPortrait.setImageBitmap(trainer.getImage());
	}

	/**
	 * Helper method to set the {@link Tag} details displayed by the view associated with this
	 * holder.
	 *
	 * @param context The {@link Context} the list is being displayed in
	 * @param programmeTags The {@link Tag} array to display
	 */
	private void setTags(@NonNull final Context context, @NonNull final Tag[] programmeTags) {
		this.tags.removeAllViews();

		for (final Tag tag : programmeTags) {
			final String caption = tag.getName();
			final Chip chip = new Chip (context);

			chip.setText(caption);
			chip.setCheckable(false);
			chip.setClickable(false);

			this.tags.addView(chip);
		}
	}

	/**
	 * Helper method to set the attribute bars for the programme.
	 * <p>
	 * The attributes are sorted by their ID value. I don't know if that's correct, but I don't have
	 * a specification to go on.
	 * </p>
	 *
	 * @param attributes The {@link Attribute} array of ratings to display
	 */
	private void setRatings(@NonNull final Attribute[] attributes) {

		// This could be done in a for loop. There's an assumption (from the JSON file) that there
		// are always five elements in the array, and I'm not checking as it's constant. I'd do it
		// differently in production code.
		//this.programmeRating.setMax((int) Math.rint(attributes[0].getTotal()));
		this.programmeRating.setRating(attributes[0].getValue());

		setRating(attributes[1], this.weightLossTitle, this.weightLoss);
		setRating(attributes[2], this.muscleTitle, this.muscle);
		setRating(attributes[3], this.strengthTitle, this.strength);
		setRating(attributes[4], this.flexibililtyTitle, this.flexibility);
	}

	private void setRating(final Attribute attribute, final TextView title, final ProgressBar rating) {
		title.setText(attribute.getName());

		rating.setMax((int) Math.rint(attribute.getTotal() * RATING_MULTIPLIER));
		rating.setProgress((int) Math.rint(attribute.getValue() * RATING_MULTIPLIER));
	}
}
