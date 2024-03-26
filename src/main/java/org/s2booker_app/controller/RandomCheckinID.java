package org.s2booker_app.controller;

public class RandomCheckinID {
    public static int randomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
