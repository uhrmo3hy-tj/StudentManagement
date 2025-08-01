package raisetech.StudentManagement.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentsCourses;
import raisetech.StudentManagement.repository.StudentRepository;

@Service
public class StudentService {

  private final StudentRepository repository;

  @Autowired
  public StudentService(StudentRepository repository) {
    this.repository = repository;
  }

  public List<Student> searchStudentList() {
    return repository.search();
  }

<<< kadai15
  public List<StudentsCourses> searchStudentsCourseList() {
    return repository.searchStudentsCourses();

 kadai14
    public List<StudentsCourses> searchStudentsCourseList() {
      return repository.searchStudentsCourses();
   
    public List<Student> getThirtysStudents() {
      return repository.search()
          .stream()
          .filter(s -> s.getAge() >= 30 && s.getAge() <= 39)
          .collect(Collectors.toList());
    }

    public List<StudentsCourses> searchStudentsCourseList() {
      return repository.searchStudentsCourses();
    }

      public List<StudentsCourses> getJavaCoursesOnly() {
        return repository.searchStudentsCourses()
            .stream()
            .filter(c -> c.getCourseName().toLowerCase().contains("javako-su"))
            .collect(Collectors.toList());
    } master

  }

  public void insertStudent(Student student) {
    repository.insertStudent(student);
  }
}

