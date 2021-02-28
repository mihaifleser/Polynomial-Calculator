// This is the main Class

public class Main {
    public static void main(String args[])
    {
        Monomial m1 = new Monomial(-3,2);
        System.out.println(m1.writeMonomial());
        Monomial m2 = new Monomial("-7x^4");
        System.out.println(m2.writeMonomial());
        Monomial m3 = new Monomial("5x^2");
        System.out.println(m3.writeMonomial());
        Polynomial p = new Polynomial();
        p.addMonomial(m1);
        p.addMonomial(m2);
        p.addMonomial(m3);
        System.out.println(p.writePoly());

        Polynomial p2 = new Polynomial("-21x^13 + 9321x^-5 + 32x^0 + 14 x^13");
        System.out.println(p2.writePoly());
    }
}
