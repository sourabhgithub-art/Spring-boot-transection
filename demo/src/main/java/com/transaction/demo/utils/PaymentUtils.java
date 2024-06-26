package com.transaction.demo.utils;

import com.transaction.demo.exception.InsufficientBalance;

import java.util.HashMap;
import java.util.Map;

public class PaymentUtils {

    private static Map<String,Double> paymentMap = new HashMap<>();

   static  {
        paymentMap.put("ac1",12000.0);
        paymentMap.put("ac2",11000.0);
        paymentMap.put("ac3",13000.0);
        paymentMap.put("ac4",15000.0);
        paymentMap.put("ac5",9000.0);
        paymentMap.put("ac6",22000.0);
        paymentMap.put("ac7",1000.0);
    }

    public static boolean validateCredentials(String accNo, double paidAmount){
        if(paidAmount > paymentMap.get(accNo)){
            throw new InsufficientBalance("InSufficient Balance");
        }else{
            return true;
        }
    }

}
