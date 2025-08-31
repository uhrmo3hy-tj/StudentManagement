package raisetech.StudentManagement;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentsCourses;
import raisetech.StudentManagement.repository.StudentRepository;

@SpringBootApplication
@RestController
public class StudentmanagementApplication {

  private final Map<String, String> studentMap =
      Collections.synchronizedMap(new HashMap<>());

  public static void main(String[] args) {
    SpringApplication.run(StudentmanagementApplication.class, args);
  }

  @GetMapping("/students")
  public Map<String, String> getStudents() {
    return studentMap;
  }

  @PostMapping("/students")
  public String addStudent(@RequestParam String name, @RequestParam String age) {
    studentMap.put(name, age);
    return "Added student: " + name + " (age: " + age + ")";
  }
}