package pzn.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pzn.spring.core.configuration.ScopeBeanConfiguration;
import pzn.spring.core.data.Foo;

public class ScopeBeanTest {

    private ApplicationContext context;

    @BeforeEach
    void setup() {
        context = new AnnotationConfigApplicationContext(ScopeBeanConfiguration.class);
    }

    @Test
    void testScopeBeanSuccess() {
        Foo foo1 = context.getBean("foo1", Foo.class);
        Foo foo2 = context.getBean("foo2", Foo.class);

        Assertions.assertNotSame(foo1, foo2);
    }

    @Test
    void testScopeBeanError() {
        Foo foo1 = context.getBean("foo1", Foo.class);
        Foo foo2 = context.getBean("foo2", Foo.class);

        Assertions.assertThrows(Throwable.class, () -> {
            Assertions.assertSame(foo1, foo2);
        });
    }
}
