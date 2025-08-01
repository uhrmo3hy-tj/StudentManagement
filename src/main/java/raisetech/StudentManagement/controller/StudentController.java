package raisetech.StudentManagement.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
kadai15
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
 kadai14
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
master
import org.springframework.web.bind.annotation.RestController;
import raisetech.StudentManagement.controller.converter.StudentConverter;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentsCourses;
import raisetech.StudentManagement.domein.StudentDetail;
import raisetech.StudentManagement.service.StudentService;

@Controller
public class StudentController {

  private StudentService service;
  private StudentConverter converter;

  @Autowired
  public StudentController(StudentService service, StudentConverter converter) {
    this.service = service;
    this.converter = converter;
  }

  @GetMapping("/studentList")
  public String getStudentList(Model model) {
    List<Student> students = service.searchStudentList();
    List<StudentsCourses> studentsCourses = service.searchStudentsCourseList();

 kadai15
    model.addAttribute("studentList", converter.convertStudentDetails(students, studentsCourses));
    return "studentList";

    model.addAttribute( "studentList",converter.convertStudentDetails(students, studentsCourses));
    return "studentList";

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentsCourses;
import raisetech.StudentManagement.service.StudentService;

@RestController
public class StudentController {

  private StudentService service;

  @Autowired
  public StudentController(StudentService service) {
    this.service = service;
  }

  @GetMapping("/studentList")
  public List<Student> getStudentList() {
    return service.searchStudentList();
 master
  }

  @GetMapping("/studentCourseList")
  public List<StudentsCourses> getStudentsCourseList() {
    return service.searchStudentsCourseList();
 kadai15
  }

  @GetMapping("/newStudent")
  public String newStudent(Model model) {
    model.addAttribute("studentDetail", new StudentDetail());
    return "registerStudent";
  }

  @PostMapping("/registerStudent")
  public String registerStudent(@ModelAttribute StudentDetail studentDetail, BindingResult result) {
    if (result.hasErrors()) {
      return "registerStudent";
    }

    Student student = studentDetail.getStudent();

    if (student.getEmail() == null || student.getEmail().isEmpty()) {
      result.rejectValue("student.email", "error.email", "me-ruadoresuhahissudesu");
      return "registerStudent";
    }

    service.insertStudent(student);

    System.out.println(
        studentDetail.getStudent().getName() + "sanngasinnkizyukouseitositetourokusaremasita");
    return "redirect:/studentList";
  }

 kadai14

  }

  @GetMapping("/studentsIn30s")
  public List<Student> getThirtysStudents() {
    return service.getThirtysStudents();
  }

@GetMapping("/javaCourses")
public List<StudentsCourses> getJavaCoursesOnly() {
  return service.getJavaCoursesOnly();
master
 }
 master
}