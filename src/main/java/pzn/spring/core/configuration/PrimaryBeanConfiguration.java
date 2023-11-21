package pzn.spring.core.configuration;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import pzn.spring.core.data.Foo;

@Slf4j
@Configuration
public class PrimaryBeanConfiguration {

    @Primary
    @Bean
    Foo foo1() {
        Foo foo = new Foo();
        log.info("Created Foo1");
        return foo;
    }

    @Bean
    Foo foo2() {
        Foo foo = new Foo();
        log.info("Created foo2");
        return foo;
    }


}
