package pzn.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import pzn.spring.core.configuration.DependencyInjectionConfiguration;
import pzn.spring.core.data.Bar;
import pzn.spring.core.data.Foo;
import pzn.spring.core.data.FooBar;

public class DependencyInjectionTest {

    private ApplicationContext context;

    @BeforeEach
    void setup() {
        context = new AnnotationConfigApplicationContext(DependencyInjectionConfiguration.class);
    }

    @Test
    void testWithDI() {
        Foo foo = context.getBean(Foo.class);
        Bar bar = context.getBean(Bar.class);

        FooBar fooBar = context.getBean(FooBar.class);

        Assertions.assertNotNull(foo);
        Assertions.assertNotNull(bar);

        Assertions.assertNotNull(fooBar);

        Assertions.assertSame(foo, fooBar.getFoo());
        Assertions.assertSame(bar, fooBar.getBar());
    }

    @Test
    void testNoDI() {
        Foo foo = new Foo();
        Bar bar = new Bar();

        FooBar fooBar = new FooBar(foo, bar);

        Assertions.assertSame(foo, fooBar.getFoo());
        Assertions.assertSame(bar, fooBar.getBar());
    }
}
