// This is the main Class

public class Main {
    public static void main(String args[])
    {
        Monomial m1 = new Monomial(-3,2);
        System.out.println(m1.writeMonomial());
        Monomial m2 = new Monomial("-7x^-9");
        System.out.println(m2.writeMonomial());

    }
}
