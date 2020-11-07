package com.company;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.CountDownLatch;

public class Comprador implements Runnable{

    private CountDownLatch countDownLatch;
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");


    public Comprador(int money) {
        countDownLatch= new CountDownLatch(money);
    }

    @Override
    public void run() {
        System.out.printf("Esperando los 10€ %s\n",
                LocalTime.now().format(dateTimeFormatter));
        try {
            countDownLatch.await();
            System.out.printf("Tenemos suficiente dinero, voy a comprar %s\n",
                    LocalTime.now().format(dateTimeFormatter));
        } catch (InterruptedException e) {
            System.out.println("Se ha interrumpido al comprador.");
        }
    }

    public void getMoney(int money) {
        System.out.printf("%s ha dado %d euros %s\n", Thread.currentThread().getName(),
                money, LocalTime.now().format(dateTimeFormatter));
        for (int i = 0; i < money; i++) {
            countDownLatch.countDown();
        }
    }

}
