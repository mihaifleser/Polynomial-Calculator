import java.sql.SQLOutput;
import java.util.ArrayList;

public class PolyHandler {

    public PolyHandler()
    {

    }
    public Polynomial addPolynomials(Polynomial p1, Polynomial p2)
    {
        Polynomial aux1 = new Polynomial(p1);
        Polynomial aux2 = new Polynomial(p2);
        Polynomial result = new Polynomial();
        for(Monomial m1:aux1.getContent())
        {
            result.addMonomial(m1);
        }
        for(Monomial m2:aux2.getContent())
        {
            result.addMonomial(m2);
        }



        return result;
    }
    public Polynomial substractPolynomials(Polynomial p1, Polynomial p2)
    {
        Polynomial result = new Polynomial();
        for(Monomial m:p1.getContent())
        {
            result.addMonomial(m);
        }
        for(Monomial m:p2.getContent())
        {
            Monomial aux = new Monomial(m.getCoefficient(), m.getDegree());
            aux.setCoefficient(aux.getCoefficient() * -1);
            System.out.println("+++++ " + aux.writeMonomial());
            result.addMonomial(aux);
        }
        return  result;
    }
}
