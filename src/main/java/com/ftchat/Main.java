package com.ftchat;

import com.ftchat.message.MessageTest;
import org.junit.experimental.ParallelComputer;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class Main {
    public static void main(String[] args) throws Exception {
        Class[] cls = {MessageTest.class, MessageTest.class, MessageTest.class, MessageTest.class, MessageTest.class,
                MessageTest.class, MessageTest.class, MessageTest.class, MessageTest.class, MessageTest.class,
                MessageTest.class, MessageTest.class, MessageTest.class, MessageTest.class, MessageTest.class,
                MessageTest.class, MessageTest.class, MessageTest.class, MessageTest.class, MessageTest.class,
                MessageTest.class, MessageTest.class, MessageTest.class, MessageTest.class, MessageTest.class,
                MessageTest.class, MessageTest.class, MessageTest.class, MessageTest.class, MessageTest.class,
                MessageTest.class, MessageTest.class, MessageTest.class, MessageTest.class, MessageTest.class,
                MessageTest.class, MessageTest.class, MessageTest.class, MessageTest.class, MessageTest.class,
                MessageTest.class, MessageTest.class, MessageTest.class, MessageTest.class, MessageTest.class,
                MessageTest.class, MessageTest.class, MessageTest.class,};

        Result result = JUnitCore.runClasses(new ParallelComputer(true, true), cls);
        System.out.println("Falhas: " + result.getFailureCount());
        System.out.println("Testes: " + result.getRunCount());
        System.out.println(result.toString());
    }
}