package pzn.spring.core.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import pzn.spring.core.data.Bar;
import pzn.spring.core.data.Foo;
import pzn.spring.core.data.FooBar;

@Slf4j
@Configuration
public class DependsOnConfiguration {

    // The Function below, will create when it calls by accessing .getBean
    // that's why it annotated by @Lazy
    @Lazy
    @DependsOn(value = {"barFirst"})
    @Bean(value = "fooFirst")
    Foo foo1() {
        log.info("Create Foo First");
        return new Foo();
    }

    @DependsOn(value = {"barSecond"})
    @Bean(value = "fooSecond")
    Foo foo2() {
        log.info("Create Foo Second");
        return new Foo();
    }

    @Bean(value = "barFirst")
    Bar bar1() {
        log.info("Create Bar First");
        return new Bar();
    }

    @Bean(value = "barSecond")
    Bar bar2() {
        log.info("Create Bar Second");
        return new Bar();
    }

    @Bean
    FooBar fooBar(@Qualifier("fooSecond") Foo foo, @Qualifier("barSecond") Bar bar) {
        return new FooBar(foo, bar);
    }


}
