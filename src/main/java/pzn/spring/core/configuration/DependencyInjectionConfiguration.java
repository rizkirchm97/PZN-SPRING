package pzn.spring.core.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import pzn.spring.core.data.Bar;
import pzn.spring.core.data.Foo;
import pzn.spring.core.data.FooBar;

@Slf4j
@Configuration
public class DependencyInjectionConfiguration {

    @Primary
    @Bean
    Foo fooFirst() {
        log.info("Create Foo First");
        return new Foo();
    }

    @Bean
    Foo fooSecond() {
        log.info("Create Foo Second");
        return new Foo();
    }

    @Bean
    Bar bar() {
        return new Bar();
    }

    @Bean
    FooBar fooBar(@Qualifier("fooSecond") Foo foo, Bar bar) {
        return new FooBar(foo, bar);
    }
}
