package pl.koziol.taskhelper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TaskhelperApplication {

    public static final Logger log = LoggerFactory.getLogger(TaskhelperApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(TaskhelperApplication.class, args);
    }

}
