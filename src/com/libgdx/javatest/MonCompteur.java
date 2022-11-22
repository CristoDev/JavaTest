package com.libgdx.javatest;

public class MonCompteur {
    private int valeur;

    public int getValue() {
        return valeur;
    }

    public int getNextValue() {
        return ++valeur;
    }

    public static void main(String []args){
        System.out.println("Hello, World!");
        final MonCompteur compteur = new MonCompteur();

        Thread[] threads = new Thread[20];
        Runnable thread = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    compteur.getNextValue();
                }
            }
        };

        for (int i = 0; i < 20; i++) {
            threads[i] = new Thread(thread);
            threads[i].start();
        }

        for (int i = 0; i < 20; i++) {
            try {
                threads[i].join();
            }
            catch(InterruptedException e) {
                System.out.println("erreur join");
            }
        }

        System.out.println(compteur.getValue());
    }
}