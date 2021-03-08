import java.util.ArrayList;

public class Controller {
    private PolyHandler ph;
    private GUI gui;

    public Controller(PolyHandler ph, GUI gui)
    {
        this.ph = ph;
        this.gui = gui;
    }

    public String addPolyomials(String first, String second)
    {
        Polynomial p1 = new Polynomial(first);
        Polynomial p2 = new Polynomial(second);
        Polynomial result = ph.addPolynomials(p1,p2);
        return result.writePoly();
    }

    public String substractPolynomials(String first, String second)
    {
        Polynomial p1 = new Polynomial(first);
        Polynomial p2 = new Polynomial(second);
        Polynomial result = ph.substractPolynomials(p1,p2);
        return result.writePoly();
    }
    public String multiplyPolynomials(String first, String second)
    {
        Polynomial p1 = new Polynomial(first);
        Polynomial p2 = new Polynomial(second);
        Polynomial result = ph.multiplyPolynomials(p1,p2);
        return result.writePoly();
    }
    public String derivatePolynomial(String first)
    {
        Polynomial p1 = new Polynomial(first);
        Polynomial result = ph.derivatePolynomial(p1);
        return result.writePoly();
    }
    public String integratePolynomial(String first)
    {
        Polynomial p1 = new Polynomial(first);
        Polynomial result = ph.integratePolynomial(p1);
        return result.writePoly();
    }
    public String dividePolynomial(String first, String second)
    {
        Polynomial p1 = new Polynomial(first);
        Polynomial p2 = new Polynomial(second);
        ArrayList <Polynomial> result = ph.dividePolynomials(p1,p2);
        String output;
        output = "Quotient: " + result.get(0).writePoly() +"\n" + "Remainder: " + result.get(1).writePoly();
        return output;
    }

}


