package pzn.spring.core.configuration;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import pzn.spring.core.data.Foo;

@Slf4j
@Configuration
public class BeanNameConfiguration {

    @Primary
    @Bean(value = "fooFirst")
    Foo foo1() {
        Foo foo = new Foo();
        log.info("Created Foo1");
        return foo;
    }

    @Bean(value = "fooSecond")
    Foo foo2() {
        Foo foo = new Foo();
        log.info("Created Foo2");
        return foo;
    }
}
