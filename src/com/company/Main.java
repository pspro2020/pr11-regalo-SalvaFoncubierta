package com.company;

import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        final int MONEY = 10;
        Comprador comprador = new Comprador(MONEY);
        new Thread(comprador).start();

        for (int i = 0; i < 5; i++) {
            new Thread(new Alumno(ThreadLocalRandom.current().nextInt(3)+2, comprador), "Alumno " + i).start();
        }


    }
}
