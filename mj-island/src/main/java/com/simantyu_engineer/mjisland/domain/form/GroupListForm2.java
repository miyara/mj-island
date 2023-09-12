package com.simantyu_engineer.mjisland.domain.form;

import jakarta.validation.constraints.Pattern;
import lombok.Data;

/**
 * SCR013用form
 */
@Data
public class GroupListForm2 {
    @Pattern(regexp = "^[a-zA-Z0-9]{1,10}$", message = "10文字以内の半角英数字のみで必ず入力してください")
    private String groupId;
    
    @Pattern(regexp = "^.{1,20}$", message = "20文字以内で必ず入力してください")
    private String group_name;
    
    @Pattern(regexp = "^.{0,100}$", message = "100文字以内で入力してください")
    private String comment;

}