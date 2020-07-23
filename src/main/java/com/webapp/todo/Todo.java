package com.webapp.todo;

public class Todo {

	public String name, category;
	public long id;

	public Todo(String name, String category, long id) {
		super();
		this.name = name;
		this.category = category;
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Todo [name=" + name + ", category=" + category + "]";
	}

}
