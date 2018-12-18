package com.muke.security.mukesecuritydemo.web.controller;


import com.fasterxml.jackson.annotation.JsonView;
import com.muke.security.mukesecuritydemo.web.dto.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


     /*   @Autowired
        private ProviderSignInUtils providerSignInUtils;

        @PostMapping("/regist")
        public void regist(User user, HttpServletRequest request) {

            //不管是注册用户还是绑定用户，都会拿到一个用户唯一标识。
            String userId = user.getUsername();
            providerSignInUtils.doPostSignUp(userId, new ServletWebRequest(request));
        }

        @GetMapping("/me")
        public Object getCurrentUser(@AuthenticationPrincipal UserDetails user) {
            return user;
        }
*/
        @PostMapping
        @ApiOperation(value = "创建用户")
        public User create(@Valid @RequestBody User user) {

            System.out.println(user.getId());
            System.out.println(user.getUsername());
            System.out.println(user.getPassword());
            System.out.println(user.getBirthday());

            user.setId("1");
            return user;
        }

        @PutMapping("/{id:\\d+}")
        public User update(@Valid @RequestBody User user, BindingResult errors) {

            System.out.println(user.getId());
            System.out.println(user.getUsername());
            System.out.println(user.getPassword());
            System.out.println(user.getBirthday());

            user.setId("1");
            return user;
        }

        @DeleteMapping("/{id:\\d+}")
        public void delete(@PathVariable String id) {
            System.out.println(id);
        }



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
    @GetMapping
    @JsonView(User.UserSimpleView.class)
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

        @GetMapping("/{id:\\d+}")
        @JsonView(User.UserDetailView.class)
        public User getInfo(@ApiParam("用户id") @PathVariable String id) {
//		throw new RuntimeException("user not exist");
            System.out.println("进入getInfo服务");
            User user = new User();
            user.setUsername("tom");
            return user;
        }

    }
