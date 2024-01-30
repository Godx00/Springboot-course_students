package com.excelr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelr.entity.Courses;
import com.excelr.repository.CoursesRepository;

@Service
public class CoursesService {
	@Autowired
	CoursesRepository courseRepo;
	
	
	public Courses addCourse( Courses course) {
		Courses course1 = courseRepo.save(course);
		return course1;
	}
	public Optional<Courses> getCourseById(int id){
		Optional<Courses> course1 = courseRepo.findById(id);
		return course1;
	}
	public List<Courses> getAllCourses() {
		List<Courses> courses = courseRepo.findAll();
		return courses;
	}
	public String deleteCourse( int id) {
		if( courseRepo.existsById(id)) {
		courseRepo.deleteById(id);
		return "deleted sucessfully";
		}
		else {
			return " No id found to delete";
		}
		}
	
	public String updateCourse(int id, Courses course) {
		if (courseRepo.existsById(id)) {
			Courses course1 = courseRepo.findById(id).get();
			course1.setName(course.getName());
			course1.setProfessor(course.getProfessor());
			course1.setDescription(course.getDescription());
			return "Updated sucessfully";
		}
		else {
			return "No id found to update";
		}
		
	}
	
}
