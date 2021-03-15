
import Controller.Controller;
import View.GUI;
public class Main {
    public static void main(String args[])
    {
        Controller controller = new Controller(new GUI());
        controller.run();

    }
}
