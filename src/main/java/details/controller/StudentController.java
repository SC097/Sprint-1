package details.controller;

import java.util.List;

import javax.validation.Valid;

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

import details.Dto.StudentDto;
import details.entity.Student;
import details.exception.StudnetNotfoundException;
import details.service.StudentService;





@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	//enter Details and save
		@PostMapping("/addstudent")
		public ResponseEntity<Student> adEmployee(@RequestBody @Valid StudentDto studentDto) {
			try
			{
				Student stu=studentService.addstudent(studentDto);
				if(stu!=null)
				{
					return new ResponseEntity<Student>(stu,HttpStatus.CREATED);
				}
			}
			catch(Exception e)
			{
				throw new StudnetNotfoundException("Student data is not inserted!!! Please enter vaild Student details...");
			}
			return new ResponseEntity<Student>(HttpStatus.BAD_REQUEST);
		}
	
		@GetMapping("/find/{id}")
		public ResponseEntity<Student> fStudent(@PathVariable("id") int id){
			try
			{
				Student stu=studentService.findStudent(id);
				if(stu!=null)
				{
					return new ResponseEntity<Student>(stu,HttpStatus.FOUND);
				}
			}
			catch(Exception e)
			{
				throw new StudnetNotfoundException("Student data is not inserted!!! ");
			}
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
	
		@PutMapping("/update/{id}")
		public ResponseEntity<String> upStudent(@PathVariable("id") int id, @RequestBody @Valid StudentDto studentDto){
			try
			{
				String stu=studentService.updateStudent(studentDto, id);
				if(stu!=null)
					return new ResponseEntity<String>(stu,HttpStatus.ACCEPTED);
			}
			catch(Exception e)
			{
				throw new StudnetNotfoundException("Unable to update Student details");
			}
			return new ResponseEntity<String>(HttpStatus.NOT_MODIFIED);
		}
		
		//delete details by id
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<String> delStudent(@PathVariable("id") int id){
			try
			{
				String stu=studentService.deleteStudent(id);
				if(stu!=null)
					return new ResponseEntity<String>(stu,HttpStatus.ACCEPTED);
			}
			catch (Exception e) {
				throw new StudnetNotfoundException("Failed to delete Student details");
			}
			return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);
		}
	
		//get all the employees details
		@GetMapping("/getall")
		public ResponseEntity<List<Student>> getAllEmployee(){
			try
			{
				List<Student> stu=studentService.getAllStudent();
				if(stu!=null)
					return new ResponseEntity<List<Student>>(stu,HttpStatus.FOUND);
			}
			catch (Exception e) {
				throw new StudnetNotfoundException("Failed to get all the Student details");
			}
			return new ResponseEntity<List<Student>>(HttpStatus.NOT_FOUND);
		}
	

}
