import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;

import static com.sun.tools.javac.jvm.ByteCodes.swap;

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

    public ArrayList<Polynomial> dividePolynomials(Polynomial p1, Polynomial p2)
    {
        Polynomial aux1 = new Polynomial(p1);
        Polynomial aux2 = new Polynomial(p2);
        Polynomial cat = new Polynomial();
        ArrayList<Polynomial> result = new ArrayList<>();
        Collections.sort(aux1.getContent(), Monomial.monomialComparator);
        Collections.sort(aux2.getContent(), Monomial.monomialComparator);
        if(aux1.getContent().get(0).getDegree().intValue() < aux2.getContent().get(0).getDegree().intValue())
            swap(aux1,aux2);
        do {
            Monomial tempMoni = new Monomial(aux1.getContent().get(0).getCoefficient().floatValue() / aux2.getContent().get(0).getCoefficient().floatValue(),
                    aux1.getContent().get(0).getDegree().intValue() - aux2.getContent().get(0).getDegree().intValue());
            cat.addMonomial(tempMoni);
            Polynomial tempPoly = new Polynomial();
            tempPoly.getContent().add(tempMoni);
            Polynomial multiply = multiplyPolynomials(aux2,tempPoly);
            aux1 = substractPolynomials(aux1,multiply);
            tempPoly.getContent().remove(tempMoni);

        }while(aux1.getContent().get(0).getDegree().intValue() >= aux2.getContent().get(0).getDegree().intValue());
        result.add(cat);
        result.add(aux1);

        return result;

    }

    private void swap(Polynomial aux1, Polynomial aux2) {
        ArrayList<Monomial> arr1= aux1.getContent();
        aux1.setContent(aux2.getContent());
        aux2.setContent(arr1);

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
