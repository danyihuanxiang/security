package com.muke.security.mukesecuritydemo.web.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.muke.security.mukesecuritydemo.web.validator.MyConstraint;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Past;
import java.util.Date;

@Data
public class User {
    public interface  UserSimpleView {};
    public interface  UserDetailView extends  UserSimpleView{};

     private String id;
    @JsonView(UserSimpleView.class)
    @MyConstraint(message = "这是一个测试")
    private String username;
    @JsonView(UserDetailView.class)

    @NotBlank(message = "密码不能为空")
    private String password;
    private int age;
    @Past(message = "时间必须是过去的时间")
    private Date birthday;




}
