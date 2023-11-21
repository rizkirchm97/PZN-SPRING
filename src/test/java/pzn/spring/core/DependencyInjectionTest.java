package pzn.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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
        Foo fooSecond = context.getBean("fooSecond", Foo.class);
        Bar bar = context.getBean(Bar.class);

        FooBar fooBar = context.getBean(FooBar.class);

        Assertions.assertNotNull(foo);
        Assertions.assertNotNull(bar);

        Assertions.assertNotNull(fooBar);

        // A line below became error, because the left foo is Primary foo or foo first
        // but the right foo is foo second
        // Assertions.assertSame(foo, fooBar.getFoo());

        Assertions.assertSame(bar, fooBar.getBar());
        Assertions.assertSame(fooSecond, fooBar.getFoo());
        Assertions.assertNotSame(foo, fooBar.getFoo());
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
