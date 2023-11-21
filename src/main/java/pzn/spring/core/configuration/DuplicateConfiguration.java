package pzn.spring.core.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pzn.spring.core.data.Foo;

@Slf4j
@Configuration
public class DuplicateConfiguration {

    @Bean
    Foo foo1() {
        Foo foo = new Foo();
        log.info("Created Foo1");
        return foo;
    }

    @Bean
    Foo foo2() {
        Foo foo = new Foo();
        log.info("Created Foo2");
        return foo;
    }
}
