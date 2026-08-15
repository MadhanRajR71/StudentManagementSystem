package com.student;
import org.apache.commons.lang3.StringUtils;
public class MavenDemo {
    public static void main(String[] args) {

        String name = "";

        if (StringUtils.isBlank(name)) {
            System.out.println("String is empty!");
        }
    }
}
