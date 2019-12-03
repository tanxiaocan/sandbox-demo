package com.weibo.medialib;

import java.util.Random;

public class BizTest {

    public static int randomInt() {
        Random random = new Random();
        int value = random.nextInt(1000);
        return value;
    }
}
