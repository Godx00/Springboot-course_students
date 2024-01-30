package com.excelr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelr.entity.Courses;
import com.excelr.entity.Students;
import com.excelr.repository.StudentsRepository;

@Service
public class StudentsService {
@Autowired
StudentsRepository stuRepo;

	public Students addStudents (Students stud) {
		Students stud1 = stuRepo.save(stud);
		return stud1;
		
	}
	public Optional<Students> getStudentseById(int id){
		Optional<Students> stud1 = stuRepo.findById(id);
		return stud1;
	}
	public List<Students> getAllStudents() {
		List<Students> stud1 = stuRepo.findAll();
		return stud1;
	}
	

}
