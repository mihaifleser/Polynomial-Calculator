// This is the main Class

public class Main {
    public static void main(String args[])
    {
        Monomial m1 = new Monomial(-3,2);
        System.out.println(m1.writeMonomial());
        Monomial m2 = new Monomial("-7x^4");
        System.out.println(m2.writeMonomial());
        Monomial m3 = new Monomial("+5x^2");
        Polynomial p = new Polynomial();
        p.addMonomial(m1);
        p.addMonomial(m2);
        p.addMonomial(m3);
        System.out.println(p.writePoly());

        Polynomial p2 = new Polynomial("-632x^-2+93x^+5");
    }
}
