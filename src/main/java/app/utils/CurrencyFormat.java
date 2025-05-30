package app.utils;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyFormat {

    public static String formatInt(int price) {
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale.Builder().setLanguage("id").setRegion("ID").build());
        return currencyFormatter.format(price);
        
    }
}
