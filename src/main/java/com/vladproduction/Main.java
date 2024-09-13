package com.vladproduction;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

public class Main {
    static final List<String> PHRASES = List.of(
            "Every setback is a setup for a comeback.",
            "Success is not final, failure is not fatal: It is the courage to continue that counts.",
            "Your only limit is you. Be brave and fearless.",
            "Challenges are what make life interesting; overcoming them is what makes life meaningful.",
            "It does not matter how slowly you go as long as you do not stop.",
            "The moment you’re ready to quit is usually the moment right before the miracle happens.",
            "Keep going. Each step may get harder, but don’t stop. The view is beautiful at the top.",
            "Never give up!"
    );

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {


        while (true){
            printRandomPhrase();
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }

    static void printRandomPhrase() {
        String phrase = PHRASES.get(RANDOM.nextInt(PHRASES.size()));
        LocalTime time = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = time.format(formatter);
        System.out.println(formattedTime + " : " + phrase);
    }
}


