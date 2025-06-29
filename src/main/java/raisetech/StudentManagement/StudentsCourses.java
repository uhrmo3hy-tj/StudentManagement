package raisetech.StudentManagement;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentsCourses {

  private String id;
  private String studentid;
  private String coursename;
  private LocalDateTime startdate;
  private LocalDateTime enddate;
}
