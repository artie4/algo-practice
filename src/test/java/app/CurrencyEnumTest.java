package app;

import interview.stuff.CurrencyEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class CurrencyEnumTest {

    CurrencyEnum currencyEnum;

    @Test
    void valueOf_test() {
        CurrencyEnum[] currencyEnums = CurrencyEnum.allCurrencies();

        // test
        for(CurrencyEnum ce: currencyEnums) {
            Assertions.assertEquals(ce, CurrencyEnum.valueOf(ce.getName()));
        }
    }

    @Test
    void valueOfNotExist_test() {
        String val = "RRU";

        // test
        Assertions.assertThrows(RuntimeException.class, () -> CurrencyEnum.valueOf(val));
    }

    @Test
    void allCurrencies_test() {
        CurrencyEnum[] expected = { CurrencyEnum.USD, CurrencyEnum.EUR, CurrencyEnum.RUB };
        List<CurrencyEnum> expectedList = Arrays.asList(expected);
        Assertions.assertEquals(expectedList, Arrays.asList(CurrencyEnum.allCurrencies()));
    }
}
