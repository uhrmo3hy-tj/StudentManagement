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

/**
 * 受講生テーブルと受講生コース情報テーブルと紐づくRepositoryです。
 */

@Mapper
public interface StudentRepository {

  /**
   * 受講生の全件検索を行います。
   *
   * @return　受講生一覧（全件）
   */
  @Select("SELECT * FROM students")
  List<Student> search();

  /**
   * 受講生の全件検索を行います。
   *
   * @param id　受講生ID
   * @return　受講生
   */
  @Select("SELECT * FROM students WHERE id = #{id}")
  Student searchStudent(String id);

  /**
   * 受講生のコース情報の全件検索を行います。
   * @return　受講生のコース情報（全件）
   */
  @Select("SELECT * FROM student_courses")
  List<StudentsCourses> searchStudentsCoursesList();

  /**
   * 受講生IDに紐づく受講生コース情報を検索します。
   *
   * @param studentId　受講生ID
   * @return　受講生IDに紐づく受講生コース情報
   */

  @Select("SELECT * FROM student_courses WHERE student_id = #{studentId}")
  List<StudentsCourses> searchStudentsCourses(String studentId);

  @Insert(
      "INSERT INTO students (name, kanaName, nickname, email, region, age, gender, created_at, remark, is_deleted) "
          + "VALUES(#{name}, #{kanaName}, #{nickname}, #{email}, #{region}, #{age}, #{gender}, NOW(), #{remark}, false)")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void registerStudent(Student student);

  @Insert("INSERT INTO student_courses(student_id, course_name, start_date, end_date) " +
      "VALUES (#{studentId}, #{courseName}, #{startDate}, #{endDate})")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void registerStudentsCourses(StudentsCourses studentsCourses);


  @Update("UPDATE students SET name = #{name}, kanaName = #{kanaName}, nickname = #{nickname}, "
     + "email = #{email}, region = #{region}, age = #{age}, gender = #{gender}, remark = #{remark}, is_deleted = #{isDeleted} WHERE id = #{id}")
  void updateStudent(Student student);

  @Update("UPDATE student_courses SET course_name = #{courseName} WHERE id = #{id}")
  void updateStudentCourses(StudentsCourses studentsCourse);
 }