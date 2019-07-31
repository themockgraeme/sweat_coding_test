package com.kizio.sweat.data;

import com.google.gson.annotations.SerializedName;

/**
 * Holds the attributes for a trainer.
 *
 * @author Graeme Sutherland
 * @since 21/07/2019
 */
public class Trainer {

	/**
	 * Internal ID for the trainer.
	 */
	@SerializedName("id")
	private int id;

	/**
	 * The code name {@code String} for the trainer.
	 */
	@SerializedName("code_name")
	private String codeName;

	/**
	 * The display name {@code String} for the trainer.
	 */
	@SerializedName("name")
	private String name;

	/**
	 * A {@code String} containing the URL to download an image of the trainer from.
	 */
	@SerializedName("image_url")
	private String imageAddress;

	/**
	 * Sets the ID value.
	 *
	 * @param anId An {@code int} ID code
	 */
	public void setId(final int anId) {
		this.id = anId;
	}

	/**
	 * Gets the ID value.
	 *
	 * @return An {@code int} ID code
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Sets the code name for the trainer.
	 *
	 * @param aCodeName A {@code String} containing the code name
	 */
	public void setCodeName(final String aCodeName) {
		this.codeName = aCodeName;
	}

	/**
	 * Gets the code name for the trainer.
	 *
	 * @return A {@code String} containing the code name
	 */
	public String getCodeName() {
		return this.codeName;
	}

	/**
	 * Sets the displayed name for the trainer.
	 *
	 * @param aName A {@code String} containing the displayed name
	 */
	public void setName(final String aName) {
		this.name = aName;
	}

	/**
	 * Gets the displayed name for the trainer.
	 *
	 * @return A {@code String} containing the displayed name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets the URL to download an image from.
	 *
	 * @param anAddress A {@code String} containing a URL for the image
	 */
	public void setImageAddress(final String anAddress) {
		this.imageAddress = anAddress;
	}

	/**
	 * Gets the URL to download an image from.
	 *
	 * @return A {@code String} containing a URL for the image
	 */
	public String getImageAddress() {
		return this.imageAddress;
	}
}
