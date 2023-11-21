package pzn.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DatabaseTest {

    @Test
    void testDatabaseAsSingleton() {
        Database database1 = Database.getInstance();
        var database2 = Database.getInstance();

        Assertions.assertNotNull(database1);
        Assertions.assertNotNull(database2);
        Assertions.assertEquals(database1, database2);

        // The Code below became error, because their objects should same object
//        Assertions.assertNotEquals(database1, database2);
    }
}
