package pzn.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pzn.spring.core.configuration.PznConfiguration;

public class ApplicationContextTest {

    @Test
    void testApplicationContext() {

        ApplicationContext context = new AnnotationConfigApplicationContext(PznConfiguration.class);

        Assertions.assertNotNull(context);

    }
}
