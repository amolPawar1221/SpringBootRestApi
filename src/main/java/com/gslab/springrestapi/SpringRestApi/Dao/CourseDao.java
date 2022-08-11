package com.gslab.springrestapi.SpringRestApi.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

import com.gslab.springrestapi.SpringRestApi.entites.Course;

//@Repository
public interface CourseDao extends JpaRepository<Course, Long> {

}
