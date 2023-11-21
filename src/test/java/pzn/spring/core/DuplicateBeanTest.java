package pzn.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pzn.spring.core.configuration.DuplicateConfiguration;
import pzn.spring.core.data.Foo;

public class DuplicateBeanTest {

    private ApplicationContext applicationContext;

    @BeforeEach
    void before() {
        applicationContext = new AnnotationConfigApplicationContext(DuplicateConfiguration.class);
    }

    @Test
    void testCreateBeanNotNullSuccess() {
        Assertions.assertNotNull(applicationContext);
    }

    @Test
    void testGetDuplicateBeanError() {
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class, () -> {
            Foo foo1 = applicationContext.getBean(Foo.class);
        });
    }

    @Test
    void testGetDuplicateBeanSuccess() {
        Foo foo1 = applicationContext.getBean("foo1", Foo.class);
        Foo foo2 = applicationContext.getBean("foo2", Foo.class);

        Assertions.assertNotSame(foo1, foo2);
    }
}
