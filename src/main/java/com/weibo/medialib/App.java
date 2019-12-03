package com.weibo.medialib;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException {
        while (true){
            System.out.println(BizTest.randomInt());
            Thread.sleep(500L);
        }
    }
}
