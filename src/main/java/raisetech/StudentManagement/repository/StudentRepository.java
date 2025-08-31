package raisetech.StudentManagement.repository;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentsCourses;

@Mapper
public interface StudentRepository {

  @Select("SELECT * FROM students")
  List<Student> search();

  @Select("SELECT * FROM students WHERE id = #{id}")
  Student searchStudent(String id);

  @Select("SELECT * FROM student_courses")
  List<StudentsCourses> searchStudentsCoursesList();

  @Select("SELECT * FROM student_courses WHERE student_id = #{studentId}")
  List<StudentsCourses> searchStudentsCourses(String studentId);

  @Insert(
      "INSERT INTO students (id, name, kanaName, nickname, email, region, age, gender, created_at, remark, is_deleted) "
          + "VALUES (#{id}, #{name}, #{kanaName}, #{nickname}, #{email}, #{region}, #{age}, #{gender}, NOW(), #{remark}, false)")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void registerStudent(Student student);

  @Insert("INSERT INTO student_courses(student_id, course_name, start_date, end_date) " +
      "VALUES (#{studentId}, #{courseName}, #{startDate}, #{endDate})")
  void insertStudentCourses(StudentsCourses studentsCourses);
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void registerStudentsCourses(StudentsCourses studentsCourses);


  @Update("UPDATE students SET name = #{name}, kanaName = #{kanaName}, nickname = #{nickname}, "
     + "email = #{email}, region = #{region}, age = #{age}, gender = #{gender}, remark = #{remark}, is_deleted = #{isDeleted} WHERE id = #{id}")
  void updateStudent(Student student);

  @Update("UPDATE student_courses SET course_name = #{courseName} WHERE id = #{id}")
  void updateStudentCourses(StudentsCourses studentsCourse);
 }