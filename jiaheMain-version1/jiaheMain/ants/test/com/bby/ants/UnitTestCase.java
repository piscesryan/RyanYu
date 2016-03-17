package test.com.bby.ants;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:wl-applicationContext.xml")
public class UnitTestCase {
    private static volatile boolean initialized = false;

    public UnitTestCase() {
        initEnvironment();
    }

    private static void initEnvironment() {
        if (!initialized) {
            synchronized (UnitTestCase.class) {
                if (!initialized) {
                    initialized = true;
                }
            }
        }
    }
}
