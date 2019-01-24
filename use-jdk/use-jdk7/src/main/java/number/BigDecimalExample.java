package number;

import java.math.BigDecimal;

/**
 * 17/1/13.
 */
public class BigDecimalExample {
    public void test(){
        BigDecimal a= new BigDecimal(100);
        BigDecimal b= new BigDecimal(1.1);
        System.out.println(a.subtract(b));
    }

    public void scientificNotation(){
        double a = 12950887.72;
        System.out.println(a);
        Double b = a;
        System.out.println(b.toString());
        BigDecimal c = new BigDecimal(1.295088772E7);
        System.out.println(c);
    }
}
