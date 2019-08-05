package cn.gaohank.idea.j2ee.es;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
@SpringBootApplication
public class Application {
    @PostConstruct
    private void init() {
        log.info("starting scheduler");
    }

    @PreDestroy
    private void destroy() {
        log.info("shutdown scheduler");
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
