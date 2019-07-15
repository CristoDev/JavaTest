class Operation {
    private String controler;
    private String element;

    Operation(){
        this.setControler("default operation");
    }

    Operation(String controler) {
        this.setControler(controler);
    }

    private String getControler() {
        return controler;
    }

    void setControler(String controler) {
        this.controler = controler;
    }

    private String getElement() {
        return element;
    }

    void setElement(String element) {
        this.element = element;
    }

    void resume(){
        try {
            System.out.println("Element:" + this.getElement());
            System.out.println("Controler: " + this.getControler());
            System.out.println("---------------------------------");
        }
        catch (NullPointerException e) {
            System.out.println("Attention null pointer exception!");
        }
    }
}
