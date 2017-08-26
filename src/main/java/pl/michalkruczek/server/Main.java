package pl.michalkruczek.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@Controller
//@EnableAutoConfiguration
//@ComponentScan("server")
//@EnableJpaRepositories(basePackageClasses = TaskRepository.class)
@SpringBootApplication
public class Main {


    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }


}