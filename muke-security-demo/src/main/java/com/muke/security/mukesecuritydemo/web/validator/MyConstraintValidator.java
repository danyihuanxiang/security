package com.muke.security.mukesecuritydemo.web.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyConstraintValidator implements ConstraintValidator<MyConstraint,Object> {

    //这里可以注入spring的bean，来实现方法

    @Override
    public void initialize(MyConstraint myConstraint) {
      //初始化
        System.out.println("MyConstraintValidator-->初始化");
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        System.out.println(o);
        //就会报错
        return false;
    }
}
