package pzn.spring.core.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pzn.spring.core.data.Bar;
import pzn.spring.core.data.Foo;
import pzn.spring.core.data.FooBar;

@Configuration
public class DependencyInjectionConfiguration {

    @Bean
    Foo foo() {
        return new Foo();
    }

    @Bean
    Bar bar() {
        return new Bar();
    }

    @Bean
    FooBar fooBar(Foo foo, Bar bar) {
        return new FooBar(foo, bar);
    }
}
