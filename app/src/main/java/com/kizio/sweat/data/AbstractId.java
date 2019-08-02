package com.kizio.sweat.data;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

/**
 * Common class holding the ID for other objects. Allows for comparison between them, to order the
 * values.
 */
public abstract class AbstractId implements Comparable<AbstractId> {

	/**
	 * Internal ID for the attribute.
	 */
	@SerializedName("id")
	private int id;

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
	 * Compares this {@link AbstractId} to another. The ordering is based on the ID value.
	 *
	 * @param other The {@link AbstractId} to compare to
	 * @return A negative if this object is less than the other, positive if greater, 0 if equal
	 */
	@Override
	public int compareTo(@NonNull final AbstractId other) {
		return this.id - other.getId();
	}
}
