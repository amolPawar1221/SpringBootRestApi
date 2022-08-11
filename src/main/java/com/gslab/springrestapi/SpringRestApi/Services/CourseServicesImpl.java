package com.gslab.springrestapi.SpringRestApi.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gslab.springrestapi.SpringRestApi.Dao.CourseDao;
import com.gslab.springrestapi.SpringRestApi.entites.Course;

@Service
public class CourseServicesImpl implements CourseService {

//	private ArrayList<Course> courses;
	
	@Autowired
	private CourseDao courseDao;
	
	public CourseServicesImpl() {
		
//		courses = new ArrayList<Course>();
//		courses.add(new Course(123, "ios developer", "you will learn ios developement"));
//		courses.add(new Course(124, "java coures", "learn java"));
	}

	@Override
	public List<Course> getCourse() {
		
		return courseDao.findAll();
		//return courses;
	}

	@Override
	public Optional<Course> getCourse(long courseId) {
		return courseDao.findById(courseId);
		
//		Course cour = null;
//		
//	   for(Course course: courses) {
//			if(course.getCourseId() == courseId) {
//				cour = course;
//				break;
//			}
//		}
//		
//		return cour;
	}

	@Override
	public Course addCourse(Course course) {
		courseDao.save(course);
		return course;
//		courses.add(course);
//		return course;
	}
	
	@Override
	public Course update(long courseId, Course course) {
		return courseDao.findById(courseId).map(course1 -> {
			course1.setTitle(course.getTitle());
			course1.setDescription(course.getDescription());
	        return courseDao.save(course1);
	      })
	      .orElseGet(() -> {
	        return courseDao.save(course);
	      });

//		courses.forEach( e -> {
//			if(e.getCourseId() == course.getCourseId()) {
//				e.setTitle(course.getTitle());
//				e.setDescription(course.getDescription());
//			}
//		});
//		return course;
	}
	
	@Override
	public void delete(long courseId) {
		courseDao.deleteById(courseId);
		//courses = (ArrayList<Course>) this.courses.stream().filter(e -> e.getCourseId()!= courseId).collect(Collectors.toList());
	}

}
