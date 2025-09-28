package raisetech.StudentManagement.data;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {

  private String id; // 登録時は自動採番かもしれないのでチェック不要

  @NotBlank(message = "名前は必須です")
  @Size(max = 50, message = "名前は50文字以内で入力してください")
  private String name;

  @NotBlank(message = "フリガナは必須です")
  @Size(max = 50, message = "フリガナは50文字以内で入力してください")
  private String kanaName;

  @Size(max = 30, message = "ニックネームは30文字以内で入力してください")
  private String nickname;

  @NotBlank(message = "メールアドレスは必須です")
  @Email(message = "正しいメールアドレスを入力してください")
  private String email;

  @Size(max = 100, message = "地域は100文字以内で入力してください")
  private String region;

  @Min(value = 0, message = "年齢は0以上で入力してください")
  @Max(value = 120, message = "年齢は120以下で入力してください")
  private int age;

  @NotBlank(message = "性別は必須です")
  private String gender;

  @Size(max = 200, message = "備考は200文字以内で入力してください")
  private String remark;

  private boolean isDeleted;
}

