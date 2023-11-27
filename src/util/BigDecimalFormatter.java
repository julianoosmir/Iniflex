package util;

import java.math.BigDecimal;
import java.text.DecimalFormat;


public class BigDecimalFormatter {

    public static String toFormat(BigDecimal volor){
        DecimalFormat df = new DecimalFormat("#,###.00");
        return df.format(volor);
    }
}
