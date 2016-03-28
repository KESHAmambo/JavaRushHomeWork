package com.javarush.test.xAttempts;

/**
 * Created by Аркадий on 10.03.2016.
 */
public class Mask {
    public static void main(String[] args) {
        int age, height, weight, combined, mask;
        age = 28; //00011100
        height = 185; //10111001
        weight = 80; //01010000
        combined = (age) | (height << 8) | (weight << 16); //00000000 01010000 10111001 00011100

        mask = 0b11111111;

        System.out.printf("Age: %d, height: %d, weight: %d",
                mask & combined,
                mask & combined >>> 8,
                mask & combined >>> 16);
    }
}
