package pl.infoshare.junit5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class SpringMvcExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcExampleApplication.class, args);
    }
}
