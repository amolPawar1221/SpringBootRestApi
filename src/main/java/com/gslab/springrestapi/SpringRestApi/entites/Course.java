package com.gslab.springrestapi.SpringRestApi.entites;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


//import org.hibernate.annotations.DynamicUpdate;

@Entity
public class Course {
	
	@Id 
	@GeneratedValue()
	private Long courseId;
	private String title;
	private String description;
	
	public Long getCourseId() {
		return courseId;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Course(long i, String title, String description) {
		super();
		this.courseId = i;
		this.title = title;
		this.description = description;
	}
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Course [couresId=" + courseId + ", title=" + title + ", description=" + description + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(courseId, description, title);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return courseId == other.courseId && Objects.equals(description, other.description)
				&& Objects.equals(title, other.title);
	}
	

}
