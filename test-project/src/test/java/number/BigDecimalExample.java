package number;

import java.math.BigDecimal;

import org.junit.Test;

/**
 * 17/1/13.
 */
public class BigDecimalExample {
    @Test
    public void test(){
        BigDecimal a= new BigDecimal(100);
        BigDecimal b= new BigDecimal(1.1);
        System.out.println(a.subtract(b));
    }
}
