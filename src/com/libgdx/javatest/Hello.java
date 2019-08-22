package com.libgdx.javatest;

import java.lang.reflect.Field;

public class Hello {
    private int moveX = 5; //, moveY = 2, posX = 50, posY = 80;
    private double red = 0.5, green = 0.33, blue = 0.84, deltaRed = 0.017, deltaGreen = 0.021, deltaBlue = 0.013;

    public Hello() {
        try {
            setV1("deltaRed");
            //build("deltaRedError");
        } catch (NoSuchFieldException e) {
            System.out.println("erreur de champ ");
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        setV2("deltaRed", 0.234);
        setV2("moveX", 123);

        System.out.println("deltaRed: "+deltaRed);
        System.out.println("moveX: "+moveX);

    }

    // V1 test de la classe Field et changement de valeur
    private void setV1(String attr) throws NoSuchFieldException, IllegalAccessException
    {
        Field f = this.getClass().getDeclaredField(attr);
        System.out.println("valeur rouge 0: "+f.get(this));
        f.set(this, 0.55);
        System.out.println("valeur rouge 1: "+f.get(this));
    }

    // V2 nouvelle fonction plus globale
    private void setV2(String attr, Object value) {
        try {
            Field f = this.getClass().getDeclaredField(attr);
            System.out.println("valeur "+attr+" 0: "+f.get(this));
            f.set(this, value);
            System.out.println("valeur "+attr+" 1: "+f.get(this));
        } catch (NoSuchFieldException e) {
            System.out.println("erreur de champ ***"+attr+"*** n'existe pas");
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void changeColors() {
        this.deltaRed = this.changeDelta(this.red, this.deltaRed);
        this.red += this.deltaRed;

        this.deltaGreen = this.changeDelta(this.green, this.deltaGreen);
        this.green += this.deltaGreen;

        this.deltaBlue = this.changeDelta(this.blue, this.deltaBlue);
        this.blue += this.deltaBlue;
    }

    private double changeDelta(double color, double delta) {
        if (color < 0 || color > 1) {
            delta *= -1;
        }

        return delta;
    }

}
