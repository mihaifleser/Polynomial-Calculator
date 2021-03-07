// This is the main Class
//   3*x^2 - x + 1
//    x - 2
//     x^3 - 2x^2 + 6 * x - 5
//    x^3 + 4*x + 5


public class Main {
    public static void main(String args[])
    {
        GUI gui = new GUI();
        PolyHandler ph = new PolyHandler();
        Polynomial p1 = new Polynomial("3x^1 + 2x^2 - 7x^4");
        System.out.println("P1: " + p1.writePoly());
        Polynomial p2 = new Polynomial("2*x -4x^4 + 9x^5 - 3x + 5x^2 +5x^2 + 24");
        System.out.println("P2: " + p2.writePoly());

        Polynomial result1;
        result1 = ph.addPolynomials(p1,p2);
        System.out.println(result1.writePoly());
        System.out.println("///////////////");
        System.out.println("P1: " + p1.writePoly());
        System.out.println("P2: " + p2.writePoly());
        System.out.println("///////////////");


        Polynomial result2;
        result2 = ph.substractPolynomials(p1,p2);
        System.out.println(result2.writePoly());

        System.out.println("///////////////");
        System.out.println("P1: " + p1.writePoly());
        System.out.println("P2: " + p2.writePoly());
        System.out.println("///////////////");

        Polynomial result3;
        result3 = ph.multiplyPolynomials(p1,p2);
        System.out.println(result3.writePoly());

        System.out.println("///////////////");
        System.out.println("P1: " + p1.writePoly());
        System.out.println("P2: " + p2.writePoly());
        System.out.println("///////////////");

        gui.run();

    }
}
