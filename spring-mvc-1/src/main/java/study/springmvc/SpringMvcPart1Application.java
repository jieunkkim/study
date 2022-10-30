package study.springmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class SpringMvcPart1Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcPart1Application.class, args);
    }
}