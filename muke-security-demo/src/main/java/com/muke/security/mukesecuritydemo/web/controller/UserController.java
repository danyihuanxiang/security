package com.muke.security.mukesecuritydemo.web.controller;


import com.fasterxml.jackson.annotation.JsonView;
import com.muke.security.mukesecuritydemo.web.dto.User;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Pageable;

import javax.validation.Valid;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.sym.error;

@RestController
@RequestMapping("/user")
public class UserController {




    @GetMapping
  @JsonView(User.UserSimpleView.class)
  /**
   * @RequestParam(name = "name",required = false,defaultValue = "tom") String userName
   *  RequestParam把请求参数进行映射,来达到别名效果
   *  name属性就是进行参数隐射
   *  required属性是来说明这个参数是不是必填的，false不必填
   *  defaultValue属性是如果请求没有这个参数，设置一个默认值
   *
   *  也可以用对象进行接收参数
   *
   * @PageableDefault(page = 3,size = 10,sort = "name,asc")
   * 分页对象，属于spring data jpa里面的
   * 有三个属性，page页码，size条数，sort排序条件
   * 如果前端没有传，这个值就是设置的多少
   *
   *  ReflectionToStringBuilder.toString(user, ToStringStyle.MULTI_LINE_STYLE)
   *  进行反射取出这个对象的值
   */

    public List query(User user,
                      @PageableDefault(page = 3,size = 10,sort = "name,asc") Pageable pageable){
    System.out.println(pageable.getPageSize());
    System.out.println(pageable.getPageNumber());
    System.out.println(pageable.getSort());
    System.out.println("*****************************************");
    System.out.println(ReflectionToStringBuilder.toString(user, ToStringStyle.MULTI_LINE_STYLE));
    List list=new ArrayList();
    list.add(new User());
    list.add(new User());
    list.add(new User());
      return list;
  }


  /**
   *@PathVariable(name = "id",required = false)
   * RESTful风格必须用这个注解进行映射
   * :\\d+ 正则匹配，让这个只能配数字所访问
   *
   *
   *  @JsonView(User.UserDetailView.class)
   *  视图:根据不同的视频选择给与不同的显示，在实体类里面定义
   *  然后在方法上面定义注解JsonView
   *  里面定义用什么视图
   */
  @GetMapping("/{id:\\d+}")
  @JsonView(User.UserDetailView.class)
  public User getInfo(@PathVariable(name = "id") int id){
    System.out.println("id-->"+id);
    User user=new User();
    user.setAge(12);
    user.setName("Tom");
    user.setPassWord("123");
      return  user;
  }


 @PostMapping
  public User create(@Valid @RequestBody User user, BindingResult errors){

      if (errors.hasErrors()){
          errors.getAllErrors().stream().forEach(
              error-> System.out.println(error.getDefaultMessage())
          );
      }
   System.out.println(user.getAge());
   System.out.println(user.getName());
   System.out.println(user.getPassWord());
   System.out.println(user.getBirthday());
   user.setId("1");
   return user;
 }


    @PutMapping("/{id:\\d+}")
    public User update(@Valid @RequestBody User user, BindingResult errors){

        if (errors.hasErrors()){
            errors.getAllErrors().stream().forEach(
                    error->
                            System.out.println(error.getDefaultMessage())
             );
        }
        System.out.println(user.getAge());
        System.out.println(user.getName());
        System.out.println(user.getPassWord());
        System.out.println(user.getBirthday());
        user.setId("1");
        return user;
    }

    @DeleteMapping("/{id:\\d+}")
    public String datele(@PathVariable int id){

        System.out.println("要删除的id为-->"+id);
        return "删除成功";
    }
}
