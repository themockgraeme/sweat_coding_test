package com.kizio.sweat.data;

import com.google.gson.annotations.SerializedName;

/**
 * Holds a tag for a training programme.
 *
 * @author Graeme Sutherland
 * @since 21/07/2019
 */
public class Tag {

	/**
	 * Internal ID for the trainer.
	 */
	@SerializedName("id")
	private int id;

	/**
	 * The display name or value {@code String} for the tag.
	 */
	@SerializedName("name")
	private String name;

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
	 * Sets the displayed name for the tag.
	 *
	 * @param aName A {@code String} containing the displayed name
	 */
	public void setName(final String aName) {
		this.name = aName;
	}

	/**
	 * Gets the displayed name for the tag.
	 *
	 * @return A {@code String} containing the displayed name
	 */
	public String getName() {
		return this.name;
	}
}
