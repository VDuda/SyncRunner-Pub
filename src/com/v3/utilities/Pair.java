package com.v3.utilities;

public class Pair<U, V> {

	/**
	 * The first element of this <code>Pair</code>
	 */
	private U first;
	
	/**
	 * The second element of this <code>Pair</code>
	 */
	private V second;
	
	/**
	 * Constructs a new <code>Pair</code> with the given values.
	 * 
	 * @param first  the first element
	 * @param second the second element
	 */
	public Pair(U first, V second) {
	
	    this.setFirst(first);
	    this.setSecond(second);
	}

	/**
	 * @return the first - {@link U}
	 */
	public U getFirst() {
		return first;
	}

	/**
	 * @param first the {@link U} to set
	 */
	public void setFirst(U first) {
		this.first = first;
	}

	/**
	 * @return the second - {@link V}
	 */
	public V getSecond() {
		return second;
	}

	/**
	 * @param second the {@link V} to set
	 */
	public void setSecond(V second) {
		this.second = second;
	}
}
