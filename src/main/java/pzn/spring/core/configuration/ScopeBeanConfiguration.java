package pzn.spring.core.configuration;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import pzn.spring.core.data.Foo;

@Slf4j
@Configuration
public class ScopeBeanConfiguration {

    @Bean
    @Scope(value = "prototype")
    Foo foo1() {
        log.info("Create Foo1");
        return new Foo();
    }

    @Bean
    @Scope(value = "prototype")
    Foo foo2() {
        log.info("Create Foo2");
        return new Foo();
    }
}
