package pzn.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pzn.spring.core.configuration.BeanConfiguration;
import pzn.spring.core.configuration.PrimaryBeanConfiguration;
import pzn.spring.core.data.Foo;

public class BeanTest {

    private ApplicationContext applicationContext;

    @BeforeEach
    void before(){
        applicationContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
    }

    @Test
    void testCreateBean() {
        Assertions.assertNotNull(applicationContext);
    }

    @Test
    void testGetFooBeanSuccess() {
        Foo foo1 = applicationContext.getBean(Foo.class);
        Foo foo2 = applicationContext.getBean(Foo.class);

        Assertions.assertNotNull(foo1);
        Assertions.assertNotNull(foo2);
        Assertions.assertSame(foo1, foo2);

    }
}
