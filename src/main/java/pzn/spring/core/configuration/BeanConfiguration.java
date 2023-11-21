package pzn.spring.core.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pzn.spring.core.data.Foo;

@Slf4j
@Configuration
public class BeanConfiguration {

    @Bean
    public Foo foo(){
        Foo foo = new Foo();
        log.info("Created foo...");
        return foo;
    }
}


