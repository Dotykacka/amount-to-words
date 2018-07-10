package cz.jakubturcovsky.amounttowords;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
public class MoneyUnitTest {

    @Test
    public void money() {
        assertEquals(MoneyConverter.POLISH_BANKING_MONEY_VALUE.asWords(new BigDecimal("1234.56")),
                "jeden tysiąc dwieście trzydzieści cztery PLN 56/100");
    }
}
