package com.company;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Alumno implements Runnable{

    private final int money;
    private final Comprador comprador;

    public Alumno(int money, Comprador comprador) {
        this.money = money;
        this.comprador = comprador;
    }

    @Override
    public void run() {
        try {
            giveMoney();
        } catch (InterruptedException e) {
            System.out.println("Se ha interrumpido mientras daba dinero.");
            return;
        }
        comprador.getMoney(money);
    }

    private void giveMoney() throws InterruptedException {
        TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(7)+3);
    }
}
