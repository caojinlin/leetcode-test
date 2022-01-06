package com.leetcode.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Test
    public void testIsAssignableFrom() {
        List<String> test = new ArrayList<>();
        System.out.println(List.class.isAssignableFrom(test.getClass()));
    }


}
