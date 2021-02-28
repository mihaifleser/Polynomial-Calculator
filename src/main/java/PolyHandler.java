public class PolyHandler {


    public static Polynomial addPolynomials(Polynomial p1, Polynomial p2)
    {
        Polynomial result = new Polynomial();
        for(Monomial m:p1.getContent())
        {
            result.addMonomial(m);
        }
        for(Monomial m:p2.getContent())
        {
            result.addMonomial(m);
        }
        return  result;

    }
    public static Polynomial substractPolynomials(Polynomial p1, Polynomial p2)
    {
        Polynomial result = new Polynomial();
        for(Monomial m:p1.getContent())
        {
            result.addMonomial(m);
        }
        for(Monomial m:p2.getContent())
        {
            m.setCoefficient(m.getCoefficient() * -1);
            result.addMonomial(m);
        }
        return  result;
    }
}
