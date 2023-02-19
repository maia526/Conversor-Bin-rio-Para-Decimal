import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Conversor conversor = new Conversor();
        Menu menu = new Menu(conversor);
        menu.rodaMenu();
    }
}