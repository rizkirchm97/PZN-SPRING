package pzn.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pzn.spring.core.configuration.BeanNameConfiguration;
import pzn.spring.core.data.Foo;

public class BeanNameTest {

    private ApplicationContext context;

    @BeforeEach
    void setup() {
        context = new AnnotationConfigApplicationContext(BeanNameConfiguration.class);
    }

    @Test
    void testCreateBean() {
        Assertions.assertNotNull(context);
    }

    @Test
    void testGetBeanByNameSuccess() {
        Foo foo1 = context.getBean("fooFirst", Foo.class);
        Foo foo2 = context.getBean("fooSecond", Foo.class);

        Assertions.assertNotNull(foo1);
        Assertions.assertNotNull(foo2);
        Assertions.assertNotSame(foo1, foo2);
    }

    @Test
    void testCompareBeanSuccess() {
        Foo primary = context.getBean(Foo.class);
        Foo foo1 = context.getBean("fooFirst", Foo.class);
        Foo foo2 = context.getBean("fooSecond", Foo.class);

        Assertions.assertNotNull(primary);
        Assertions.assertNotNull(foo1);
        Assertions.assertNotNull(foo2);

        Assertions.assertSame(primary, foo1);
        Assertions.assertNotSame(primary, foo2);
        Assertions.assertNotSame(foo1, foo2);
    }

    @Test
    void testGetBeanByFuncNameError() {

        Assertions.assertThrows(NoSuchBeanDefinitionException.class, () -> {
            Foo foo1 = context.getBean("foo1", Foo.class);
        });
    }
}
