package raisetech.StudentManagement;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StudentmanagementApplication {

  @Autowired
  private StudentRepository repository;


  public static void main(String[] args) {
    SpringApplication.run(StudentmanagementApplication.class, args);
  }

  @GetMapping("/studentList")
  public List <Student> getStudentList(){
    return repository.search();
  }

  @GetMapping("/studentCoursesList")
  public List<StudentsCourses>getStudentsCourseList(){
    return repository.searchStudentsCourses();
}
}