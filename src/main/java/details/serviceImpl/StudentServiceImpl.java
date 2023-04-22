package details.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import details.Dto.StudentDto;
import details.entity.Student;
import details.repository.StudentRepository;
import details.service.StudentService;


@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student addstudent(StudentDto studentDto) {
		// TODO Auto-generated method stub
       Student student = Student.builder().name(studentDto.getName()).email(studentDto.getEmail()).college(studentDto.getCollege()).build();
		return studentRepository.save(student);
		
		
		
	}

	@Override
	public Student findStudent(int id) {
		// TODO Auto-generated method stub
		return studentRepository.findById(id).get();
	}

	@Override
	public String updateStudent(StudentDto studentDto, int id) {
		// TODO Auto-generated method stub
		Student student=studentRepository.findById(id).get();
		student.setName(studentDto.getName());
		student.setCollege(studentDto.getCollege());
		student.setEmail(studentDto.getEmail());
		studentRepository.save(student);
		return "Student updated successfully...";
	}

	@Override
	public String deleteStudent(int id) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(id);
		return "The Student with id "+id+" has been deleted successfully";
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return studentRepository.findAll() ;
	}

}
