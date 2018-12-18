package com.muke.security.mukesecuritydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@RestController
@EnableSwagger2
@ComponentScan(basePackages = {"com.muke.security.mukesecuritybrowsers"})
public class MukeSecurityDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MukeSecurityDemoApplication.class, args);
    }

    @GetMapping("/")
    public String getMapping(){
        return "helloWorld";
    }

}
