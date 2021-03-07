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
        Polynomial aux2 = new Polynomial(p2);
        Polynomial result = new Polynomial();
        for(Monomial m:aux2.getContent())
        {
            m.setCoefficient(m.getCoefficient().floatValue() * -1);
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

    public Polynomial multiplyPolynomials(Polynomial p1, Polynomial p2)
    {
        Polynomial aux1 = new Polynomial(p1);
        Polynomial aux2 = new Polynomial(p2);
        Polynomial result = new Polynomial();
        for(Monomial m1:aux1.getContent())
        {
            for(Monomial m2: aux2.getContent())
            {
                Monomial auxM = new Monomial(m1.getCoefficient().floatValue() * m2.getCoefficient().floatValue(), m1.getDegree().intValue() + m2.getDegree().intValue());
                result.addMonomial(auxM);
            }
        }

        return  result;
    }

    public Polynomial derivatePolynomial(Polynomial p1)
    {
        Polynomial aux1 = new Polynomial(p1);
        Polynomial result = new Polynomial();
        for(Monomial m1:aux1.getContent())
        {
            Monomial auxM = new Monomial(m1.getCoefficient().floatValue() * m1.getDegree().intValue(), m1.getDegree().intValue() - 1);
            result.addMonomial(auxM);
        }

        return  result;
    }

    public Polynomial integratePolynomial(Polynomial p1)
    {
        Polynomial aux1 = new Polynomial(p1);
        Polynomial result = new Polynomial();
        for(Monomial m1:aux1.getContent())
        {
            Monomial auxM = new Monomial(m1.getCoefficient().floatValue() / (m1.getDegree().floatValue() + 1), m1.getDegree().intValue() + 1);
            result.addMonomial(auxM);
        }

        return  result;
    }



    public Polynomial test(Polynomial p1)
    {
        Polynomial aux1 = new Polynomial(p1);
        for(Monomial m1:aux1.getContent())
        {
            m1.setCoefficient(2.0f);
        }
        return aux1;
    }
}
