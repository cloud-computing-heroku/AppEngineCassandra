package com.example.hello.controller;

import java.math.BigDecimal;

public class Test {
    public static void main(String[] args) {
        String str = "45000000.35";
        float a = 10000000;
        double db1 = Double.parseDouble(str);
        double db2 = Double.parseDouble(str);

        BigDecimal big = new BigDecimal(str);
        BigDecimal b1 = new BigDecimal("15000000");
        big.subtract(b1);

        System.out.println(db1 + " && " + db2 + " && " + a + " && " + big + " && " + big.subtract(b1));

    }
}
