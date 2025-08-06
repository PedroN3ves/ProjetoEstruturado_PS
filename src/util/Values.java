package util;

import java.util.HashMap;
import java.util.Map;

public class Values
{
    public static final Map<String, Double> PRICES = new HashMap<>();

    static
    {
        PRICES.put("single", 150.00);
        PRICES.put("couple", 250.00);
        PRICES.put("premium", 350.00);
    }
}
