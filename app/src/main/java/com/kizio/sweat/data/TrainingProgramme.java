package com.kizio.sweat.data;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * Represents a training programme downloaded from the Sweat service.
 * <p>
 * (Strictly speaking, this is actually read in from a JSON file.)
 * </p>
 *
 * @author Graeme Sutherland
 * @since 21/07/2019
 */
public class TrainingProgramme extends AbstractId {

	/**
	 * Acronym {@code String} for the programme.
	 */
	@SerializedName("acronym")
	private String acronym;

	/**
	 * The code name {@code String} for the programme.
	 */
	@SerializedName("code_name")
	private String codeName;

	/**
	 * The name {@code String} for the programme.
	 */
	@SerializedName("name")
	private String name;

	/**
	 * The name {@code String} for the image.
	 */
	@SerializedName("image_name")
	private String imageName;

	/**
	 * A {@code String} containing the URL to download an image for the programme from.
	 */
	@SerializedName("image")
	private String imageAddress;

	/**
	 * The {@link Trainer} who will be running the programme.
	 */
	@SerializedName("trainer")
	private Trainer trainer;

	/**
	 * The {@link Attribute} objects used to store the programme's characteristics.
	 */
	@SerializedName("attributes")
	private TreeSet<Attribute> attributes;

	/**
	 * The {@link Tag} objects used to store more details for the programme.
	 */
	@SerializedName("tags")
	private TreeSet<Tag> tags;

	/**
	 * Sets the acronym for the programme.
	 *
	 * @param anAcronym A {@code String} containing the acronym
	 */
	public void setAcronym(final String anAcronym) {
		this.acronym = anAcronym;
	}

	/**
	 * Gets the code name for the programme.
	 *
	 * @return A {@code String} containing the acronym
	 */
	public String getAcronym() {
		return this.acronym;
	}

	/**
	 * Sets the code name for the programme.
	 *
	 * @param aCodeName A {@code String} containing the code name
	 */
	public void setCodeName(final String aCodeName) {
		this.codeName = aCodeName;
	}

	/**
	 * Gets the code name for the programme.
	 *
	 * @return A {@code String} containing the code name
	 */
	public String getCodeName() {
		return this.codeName;
	}

	/**
	 * Sets the displayed name for the programme.
	 *
	 * @param aName A {@code String} containing the displayed name
	 */
	public void setName(final String aName) {
		this.name = aName;
	}

	/**
	 * Gets the displayed name for the programme.
	 *
	 * @return A {@code String} containing the displayed name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets the displayed name for the image.
	 *
	 * @param aName A {@code String} containing the image name
	 */
	public void setImageName(final String aName) {
		this.imageName = aName;
	}

	/**
	 * Gets the displayed name for the image.
	 *
	 * @return A {@code String} containing the image name
	 */
	public String getImageName() {
		return this.imageName;
	}

	/**
	 * Sets the URL to download the image from.
	 *
	 * @param aURL A {@code String} containing the image's download URL
	 */
	public void setImageAddress(final String aURL) {
		this.imageAddress = aURL;
	}

	/**
	 * Gets the URL to download the image from.
	 *
	 * @return A {@code String} containing the image's download URL
	 */
	public String getImageAddress() {
		return this.imageAddress;
	}

	/**
	 * Sets the {@link Trainer} who will be running the programme.
	 *
	 * @param aTrainer The {@link Trainer} who will be running the programme
	 */
	public void setTrainer(final Trainer aTrainer) {
		this.trainer = aTrainer;
	}

	/**
	 * Gets the {@link Trainer} who will be running the programme.
	 *
	 * @return The {@link Trainer} who will be running the programme
	 */
	public Trainer getTrainer() {
		return this.trainer;
	}

	/**
	 * Sets the {@link Attribute} values for the programme.
	 *
	 * @param attributesArray The {@link Attribute} array for the programme
	 */
	public void setAttributes(final Attribute[] attributesArray) {
		this.attributes = new TreeSet<>();

		this.attributes.addAll(Arrays.asList(attributesArray));
	}

	/**
	 * Gets the {@link Attribute} values for the programme.
	 *
	 * @return The {@link Attribute} array for the programme
	 */
	public Attribute[] getAttributes() {
		final Attribute[] attibuteArray = new Attribute[0];

		return this.attributes != null ? this.attributes.toArray(attibuteArray) : attibuteArray;
	}

	/**
	 * Sets the {@link Tag} values for the programme.
	 *
	 * @param tagsArray The {@link Tag} array for the programme
	 */
	public void setTags(final Tag[] tagsArray) {
		this.tags = new TreeSet<>();

		this.tags.addAll(Arrays.asList(tagsArray));
	}

	/**
	 * Gets the {@link Tag} values for the programme.
	 *
	 * @return The {@link Tag} array for the programme
	 */
	public Tag[] getTags() {
		final Tag[] tagsArray = new Tag[0];

		return this.attributes != null ? this.tags.toArray(tagsArray) : tagsArray;
	}
}
