package com.example.learnplan.calculate;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author wangfk
 */
public class DoubleTest {
    public static void main(String[] args) {
        double zpc = 0.05;
        double wfk = 0.01;
        System.out.println(zpc + wfk);
        System.out.println(new BigDecimal(zpc).add(new BigDecimal(wfk)).setScale(2, RoundingMode.HALF_UP).doubleValue());
    }
}
