package com.excelr.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.entity.Students;
import com.excelr.service.StudentsService;

@RestController
@RequestMapping("/api/v1/")
public class StudentsController {
	@Autowired
	StudentsService studService;
	@PostMapping("/student")
	public ResponseEntity<Students> addNewStudent (@RequestBody Students stud){
		Students stud1 = studService.addStudents(stud);
		return new ResponseEntity<Students>(stud1, HttpStatus.OK);
	}
	@GetMapping("/student/{id}")
	public ResponseEntity<Optional<Students>> getStudent (@PathVariable int id){
		Optional<Students> stud1 = studService.getStudentseById(id);
		return new ResponseEntity<Optional<Students>>(stud1, HttpStatus.OK);
	}
	@GetMapping("/getstudents")
	public ResponseEntity<List<Students>> getAllStudents (){
		List<Students> getStudents = studService.getAllStudents();
		return new ResponseEntity<List<Students>>(getStudents, HttpStatus.OK);
	}
	
	
}
