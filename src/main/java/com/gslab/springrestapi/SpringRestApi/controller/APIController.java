package com.gslab.springrestapi.SpringRestApi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gslab.springrestapi.SpringRestApi.Services.CourseService;
import com.gslab.springrestapi.SpringRestApi.entites.Course;

@RestController
public class APIController {
	
	@Autowired
	private CourseService courseService;

	@GetMapping("/course")
	public List<Course> getCoures() {
		return courseService.getCourse();
	}
	
	@GetMapping("/course/{courseID}")
	public Optional<Course>  getCourse(@PathVariable String courseID) {
		return courseService.getCourse(Long.parseLong(courseID));
	}
	
	@PostMapping("/course")
	public Course addNewCourse(@RequestBody Course course) {
		return courseService.addCourse(course);
	}
	
	@PutMapping("/course/{courseID}")
	public Course update(@PathVariable String courseID, @RequestBody Course course) {
		return courseService.update(Long.parseLong(courseID), course);
	}
	
	@DeleteMapping("/course/{courseId}")
	public ResponseEntity<HttpStatus> delete(@PathVariable String courseId) {
		try {
			this.courseService.delete(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
