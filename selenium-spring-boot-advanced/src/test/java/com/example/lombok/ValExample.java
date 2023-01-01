package com.example.lombok;

import lombok.val;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;

public class ValExample {

    public static final Logger logger = LoggerFactory.getLogger(ValExample.class);

    public static void main(String[] args) {
        val s = "Ji";
        logger.info(new ValExample().example());
        new ValExample().example2();
    }

    public String example() {
//        final ArrayList<String> example = new ArrayList<String>();
        val example = new ArrayList<String>();
        example.add("Hello, World!");
        val foo = example.get(0);
        return foo.toLowerCase();
    }

    public void example2() {
//        final HashMap<Integer, String> map = new HashMap<Integer, String>();
        val map = new HashMap<Integer, String>();
        map.put(0, "zero");
        map.put(5, "five");
        for (val entry : map.entrySet()) { //  for (final Map.Entry<Integer, String> entry : map.entrySet())
            System.out.printf("%d: %s\n", entry.getKey(), entry.getValue());
        }
    }

}
