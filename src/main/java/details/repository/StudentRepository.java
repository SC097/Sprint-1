package details.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import details.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
