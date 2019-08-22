package com.libgdx.javatest;

public class Save extends Operation {

    Save(String controler) {
        this.setControler(controler);
        this.setElement("SAVE");
    }

    public Save() {
        this.setElement("SAVE");
    }

}