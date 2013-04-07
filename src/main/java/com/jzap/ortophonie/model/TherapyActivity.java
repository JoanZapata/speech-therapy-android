package com.jzap.ortophonie.model;

import java.util.List;

import org.codehaus.jackson.annotate.JsonAnySetter;

public class TherapyActivity {

	// Wrapper for activity list
	public static class TherapyActivityList {
		public List<TherapyActivity> activities;
	}

	private String id, name, image, description, category, type;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@JsonAnySetter
	public void set(String name, Object value) {
		// Nothing, allow extra fields in JSON
		// representation while unmarshalling.
	}
}
