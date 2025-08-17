package raisetech.StudentManagement.domein;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentsCourses;

@Getter
@Setter
public class StudentDetail {

  private Student student;
  private List<StudentsCourses> studentsCourses;

  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  public List<StudentsCourses> getStudentsCourses() {
    return studentsCourses;
  }

  public void setStudentsCourses(
      List<StudentsCourses> studentsCourses) {
    this.studentsCourses = studentsCourses;
  }
}



