package com.adib.accounts.utils;


import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

public class AccountNumberGenerator {

    private static final AtomicLong SEQUENCE = new AtomicLong(0);

    public static String generateAccountNumber() {
        return "ACC-" + String.format("%08d",SEQUENCE.incrementAndGet());
    }
}
    /*
        write a static method to generate account number
     */

