package com.excelr.controller;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.entity.Courses;
import com.excelr.service.CoursesService;

@RestController
@RequestMapping("/api/course")
public class CourseController {
	@Autowired
	CoursesService corService;
	@PostMapping("/courses")
	public ResponseEntity<Courses> addCourseEntity (@RequestBody Courses course){
		Courses c1 = corService.addCourse(course);
		return new ResponseEntity<Courses>(c1,HttpStatus.OK);
	}
	@GetMapping("/courses/{id}")
	public ResponseEntity<Optional<Courses>> getCoursesById (@PathVariable int id){
		Optional<Courses> c1 = corService.getCourseById(id);
		return new ResponseEntity<Optional<Courses>>(c1,HttpStatus.OK);
	}
	@GetMapping("/courses")
	public ResponseEntity<List<Courses>> getCourses (){
		List<Courses>c1 = corService.getAllCourses();
		return new ResponseEntity<List<Courses>>(c1, HttpStatus.OK);
	}
	@DeleteMapping("/courses/{id}")
	public ResponseEntity<String> deleteCourse(@PathVariable int id){
		return new ResponseEntity<String>(corService.deleteCourse(id), HttpStatus.OK);
	}
	@PutMapping("/courses/{id}")
	public ResponseEntity<String> updateCourse (@PathVariable int id, @RequestBody Courses course){
		return new ResponseEntity<String>(corService.updateCourse(id, course), HttpStatus.OK);
	}
}
