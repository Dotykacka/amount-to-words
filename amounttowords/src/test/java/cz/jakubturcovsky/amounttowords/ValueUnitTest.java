package cz.jakubturcovsky.amounttowords;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
public class ValueUnitTest {

    @Test
    public void value() {
        assertEquals(ValueConverter.POLISH_INTEGER.asWords(Integer.MAX_VALUE),
                "dwa miliardy sto czterdzieści siedem milionów czterysta osiemdziesiąt trzy tysiące sześćset czterdzieści siedem");
    }
}