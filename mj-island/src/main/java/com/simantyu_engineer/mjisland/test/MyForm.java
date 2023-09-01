package com.simantyu_engineer.mjisland.test;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class MyForm {
    @NotBlank
    @Size(min = 2, max = 50, message = "名前は2文字以上50文字以下である必要があります")
    private String name;

    @NotBlank(message = "メールアドレスを入力してください")
    private String email;

}
