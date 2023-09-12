import controller.WineController;
import java.io.IOException;

public class Start {
    public Start() {
    }

    public static void main(String[] args) throws IOException {
        WineController wineController = new WineController();
        wineController.start();
    }
}
