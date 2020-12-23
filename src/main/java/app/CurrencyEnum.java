package app;

import java.util.*;

enum Currency {
    USD,
    EUR
}

public class CurrencyEnum {

    private final String name;
    private final int ordinal;
    private final static List<CurrencyEnum> currencyEnums = new ArrayList<>();
    public final static CurrencyEnum USD = new CurrencyEnum("USD");
    public final static CurrencyEnum EUR = new CurrencyEnum("EUR");
    public final static CurrencyEnum RUB = new CurrencyEnum("RUB");

    private CurrencyEnum(String val) {
        this.name = val;
        this.ordinal = currencyEnums.size();
        currencyEnums.add(this);
    }

    public String getName() {
        return name;
    }

    public int getOrdinal() {
        return ordinal;
    }

    public static CurrencyEnum valueOf(String byName) {
        Optional<CurrencyEnum> first = currencyEnums.stream().filter(cur -> byName.equals(cur.name)).findFirst();
        return first.orElseThrow(() -> new RuntimeException("Currency not found"));
    }

    public static CurrencyEnum[] allCurrencies() {
        return currencyEnums.toArray(new CurrencyEnum[currencyEnums.size()]);
    }

    public static CurrencyEnum getByOrdinal(int i) {
        if (i >= 0 && i < currencyEnums.size()) {
            return currencyEnums.get(i);
        }
        throw new RuntimeException("Currency not found");
    }


}
