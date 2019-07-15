public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Hello h=new Hello();

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
        System.out.println("Utilisation de ENUM");

        DefaultEnum.LOAD.createOperation("Chargement ENUM").resume();
        DefaultEnum.SAVE.createOperation("Sauvegarde ENUM").resume();

    }
}
