package study.springmvc.part2;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class SpringMvcPart2Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringMvcPart2Application.class, args);
    }
}