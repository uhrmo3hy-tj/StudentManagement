package raisetech.StudentManagement.repository;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentsCourses;

@Mapper
public interface StudentRepository {

  @Select("SELECT * FROM students")
  List <Student> search();

  @Select("SELECT * From student_courses")
 List<StudentsCourses>searchStudentsCourses();


  @Insert("INSERT INTO students (id, name, kanaName, nickname, email, region, age, gender, created_at, is_deleted) " +
      "VALUES (#{id}, #{name}, #{kanaName}, #{nickname}, #{email}, #{region}, #{age}, #{gender}, NOW(), 0)")
  void insertStudent(Student student);
}
