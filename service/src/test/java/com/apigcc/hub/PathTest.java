package com.apigcc.hub;

import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {

    @Test
    public void test1(){
        Path path = Paths.get("E:/");
        Path resolve = path.resolve("apigcc,apigcc-hub");
        System.out.println(resolve);
    }

}
