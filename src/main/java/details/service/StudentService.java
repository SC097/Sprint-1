package details.service;

import java.util.List;

import javax.validation.Valid;

import details.Dto.StudentDto;
import details.entity.Student;

public interface StudentService {

	Student addstudent(StudentDto studentDto);
    
	Student findStudent(int id);
	 
	String updateStudent(StudentDto studentDto ,int id);
	 
	 String deleteStudent(int id);
	 
	 List<Student>getAllStudent();

}
