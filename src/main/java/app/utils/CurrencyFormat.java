package app.utils;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class CurrencyFormat {

    public static String formatInt(int price) {
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale.Builder().setLanguage("id").setRegion("ID").build());
        return currencyFormatter.format(price);
        
    }
    
    public static int formatStr(String priceString) throws ParseException {
        NumberFormat format = NumberFormat.getCurrencyInstance(new Locale.Builder().setLanguage("id").setRegion("ID").build());

        int value = format.parse(priceString).intValue();
        return value;
    }
}
