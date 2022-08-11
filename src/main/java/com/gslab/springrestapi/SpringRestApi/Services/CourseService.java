package com.gslab.springrestapi.SpringRestApi.Services;

import java.util.List;
import java.util.Optional;

import com.gslab.springrestapi.SpringRestApi.entites.Course;

public interface CourseService {
	public List<Course> getCourse();
	public Optional<Course> getCourse(long courseId);
	public Course addCourse(Course course);
	public Course update(long courseId, Course course);
	public void delete(long courseId);
}
