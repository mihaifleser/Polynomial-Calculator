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
        Polynomial aux1 = new Polynomial(p1);
        Polynomial aux2 = new Polynomial();
        Polynomial result = new Polynomial();
        for(Monomial m:p2.getContent())
        {
            Float auxCoeff = m.getCoefficient() * (-1);
            aux2.addMonomial(new Monomial(auxCoeff,m.getDegree()));
        }
        for(Monomial m1:aux1.getContent())
        {
            result.addMonomial(m1);
        }
        for(Monomial m2:aux2.getContent())
        {
            result.addMonomial(m2);
        }
        return  result;
    }
}
