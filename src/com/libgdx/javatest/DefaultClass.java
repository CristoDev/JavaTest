package com.libgdx.javatest;

class DefaultClass {
    static final int LOAD=0;
    static final int SAVE=1;

    private DefaultClass() {
        // protection factory
    }

    static Operation createElement(int type, String controler){
        if (type < 0 || type > 1) {
            throw new IllegalArgumentException("type non supporté: "+type);
        }
        else {
            switch (type){
                case 0:
                    return new Load(controler);
                case 1:
                    return new Save(controler);
                default:
                    throw new NullPointerException();
            }
        }
    }

}
