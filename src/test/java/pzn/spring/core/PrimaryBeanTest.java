package pzn.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pzn.spring.core.configuration.PrimaryBeanConfiguration;
import pzn.spring.core.data.Foo;

public class PrimaryBeanTest {

    private ApplicationContext applicationContext;

    @BeforeEach
    void setup() {
        applicationContext = new AnnotationConfigApplicationContext(PrimaryBeanConfiguration.class);
    }

    @Test
    void testCreateBeanNotNull() {
        Assertions.assertNotNull(applicationContext);
    }

    @Test
    void testGetPrimary() {
        Foo primary = applicationContext.getBean(Foo.class);

        Assertions.assertNotNull(primary);
    }

    @Test
    void testCompareBean() {
        Foo primary = applicationContext.getBean(Foo.class);
        Foo foo1 = applicationContext.getBean("foo1", Foo.class);
        Foo foo2 = applicationContext.getBean("foo2", Foo.class);

        Assertions.assertNotNull(primary);
        Assertions.assertNotNull(foo1);
        Assertions.assertSame(primary, foo1);
        Assertions.assertNotSame(primary, foo2);
        Assertions.assertNotSame(foo1, foo2);
    }
}
