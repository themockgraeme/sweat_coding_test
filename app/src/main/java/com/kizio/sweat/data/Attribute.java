package com.kizio.sweat.data;

import com.google.gson.annotations.SerializedName;

/**
 * Holds the attributes for a training programme. These are stored as a name {@code String} and pair
 * of {@code float} values.
 *
 * @author Graeme Sutherland
 * @since 21/07/2019
 */
public class Attribute extends AbstractId {

	/**
	 * A code name {@code String} for the attribute.
	 */
	@SerializedName("code_name")
	private String codeName;

	/**
	 * The human readable {@code String} giving the name for the attribute.
	 */
	@SerializedName("name")
	private String name;

	/**
	 * A {@code float} value giving the rating of the attribute. These correspond to things like the
	 * intensity or flexibility required.
	 */
	@SerializedName("value")
	private float value;

	/**
	 * A {@code float} value giving the maximum rating of the attribute.
	 */
	@SerializedName("total")
	private float total;

	/**
	 * Sets the code name for the attribute.
	 *
	 * @param aCodeName A {@code String} containing the code name
	 */
	public void setCodeName(final String aCodeName) {
		this.codeName = aCodeName;
	}

	/**
	 * Gets the code name for the attribute.
	 *
	 * @return A {@code String} containing the code name
	 */
	public String getCodeName() {
		return this.codeName;
	}

	/**
	 * Sets the displayed name for the attribute.
	 *
	 * @param aName A {@code String} containing the displayed name
	 */
	public void setName(final String aName) {
		this.name = aName;
	}

	/**
	 * Gets the displayed name for the attribute.
	 *
	 * @return A {@code String} containing the displayed name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets the rating value for the attribute.
	 *
	 * @param aValue A {@code float} rating
	 */
	public void setValue(final float aValue) {
		this.value = aValue;
	}

	/**
	 * Gets the rating value for the attribute.
	 *
	 * @return  A {@code float} rating
	 */
	public float getValue() {
		return this.value;
	}

	/**
	 * Sets the maximum value for the attribute.
	 *
	 * @param aTotal A {@code float} maximum rating
	 */
	public void setTotal(final float aTotal) {
		this.total = aTotal;
	}

	/**
	 * Gets the maximum value for the attribute.
	 *
	 * @return  A {@code float} maximum rating
	 */
	public float getTotal() {
		return this.total;
	}
}
