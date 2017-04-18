package com.fusion.objects;

import java.util.ArrayList;

/**
 * This is one category.
 * @author Ethan Raymond
 *
 */
public class Category {
	
	private int id;
	private String name;
	private Category parent;
	private ArrayList<Category> children;
	
	/**
	 * Sets default values.
	 */
	public Category() {
		id = -1;
		name = "";
		parent = null;
		children = new ArrayList<>();
	}

	/**
	 * @return the category ID
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets a new category ID
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the category's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets a new name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return this category's parent, null if there is not parent
	 */
	public Category getParent() {
		return parent;
	}

	/**
	 * Sets the category parent.
	 */
	public void setParent(Category parent) {
		this.parent = parent;
	}

	/**
	 * @return the list of children
	 */
	public ArrayList<Category> getChildren() {
		return children;
	}
	
	/**
	 * Adds a child category.
	 */
	public void addChild(Category category) {
		category.setParent(this);
		this.children.add(category);
	}
	
	@Override
	public String toString() {
		String s = "";
		s += "[ ";
		s += "id: " + getId() + ", ";
		s += "name: " + getName() + ", ";
		s += "parent: " + (getParent() == null ? "N/A" : getParent().getName());
		s += " ]";
		return s;
	}

}
