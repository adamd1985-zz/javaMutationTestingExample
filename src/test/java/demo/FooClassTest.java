package demo;

import demo.FooClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * For mutation demostration.
 * Created by adamd on 6/19/2018.
 */
public class FooClassTest {

    private FooClass fooClass;

    @Before
    public void beforeEach() {
        this.fooClass = new FooClass();
    }

    @Test
    public void shouldSucceed_WhenGoodCodeGiven() {
        int goodCode = 1;

        String result = this.fooClass.doBusinessLogic(goodCode);

        // Assert.assertNotNull(result);
        // Assert.assertEquals(result, "SUCCESS");
    }

    @Test
    public void shouldFail_WhenWrongCodeGiven() {
        int goodCode = -1;

        String result = this.fooClass.doBusinessLogic(goodCode);

        // Assert.assertNotNull(result);
        // Assert.assertEquals(result, "FAILURE");
    }
}
