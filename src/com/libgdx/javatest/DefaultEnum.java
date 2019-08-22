package com.libgdx.javatest;

import java.util.function.Function;

public enum DefaultEnum {
    LOAD(Load::new),
    SAVE(Save::new);

    // BiFunction prend 1 parametre (ici String) pour créer 1 resultat (ici Operation)
    private Function<String, Operation> supplier;
    // BiFunction prend 2 parametres (ici String et String) pour créer 1 resultat (ici Operation)
    // pour notre cas, Operation, Load et Save n'ont pas de constructeur avec 2 paramètres
    //private BiFunction<String, String, Operation> supplier;

    DefaultEnum(Function<String, Operation> supplier)
    {
        this.supplier=supplier;
    }

    public Operation createOperation(String controler) {
        return supplier.apply(controler);
    }
}
