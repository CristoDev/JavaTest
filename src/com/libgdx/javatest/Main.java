package com.libgdx.javatest;

public class Main {


    public void testMonCompteur() {
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

    public void testDefaultClass() {
        System.out.println("Hello World!");

        System.out.println("***********************");
        System.out.println("Utilisation des classes par defaut");

        try {
            DefaultClass.createElement(DefaultClass.LOAD, "chargement").resume();
            DefaultClass.createElement(DefaultClass.SAVE, "sauvegarde").resume();
        }
        catch (NullPointerException e) {
            System.out.println("Null pointer exception depuis Main");
        }

        System.out.println("***********************");
        System.out.println("Utilisation de ENUM ==> gere le NullPointerException");

        DefaultEnum.LOAD.createOperation("Chargement ENUM").resume();
        DefaultEnum.SAVE.createOperation("Sauvegarde ENUM").resume();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.testMonCompteur();

    }
}
