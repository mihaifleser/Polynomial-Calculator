package DataModel;
import java.util.ArrayList;
import java.util.Collections;

public class PolyOperations {

    public PolyOperations()
    {

    }
    public static Polynomial addPolynomials(Polynomial p1, Polynomial p2)
    {
        Polynomial copyOfP1 = new Polynomial(p1);
        Polynomial copyOfP2 = new Polynomial(p2);
        Polynomial result = new Polynomial();
        for(Monomial m1:copyOfP1.getContent())
        {
            result.addMonomial(m1);
        }
        for(Monomial m2:copyOfP2.getContent())
        {
            result.addMonomial(m2);
        }
        return result;
    }
    public static Polynomial substractPolynomials(Polynomial p1, Polynomial p2)
    {
        Polynomial copyOfP1 = new Polynomial(p1);
        Polynomial copyOfP2 = new Polynomial(p2);
        Polynomial result = new Polynomial();
        for(Monomial m:copyOfP2.getContent())
        {
            m.setCoefficient(m.getCoefficient().floatValue() * -1);
        }
        for(Monomial m1:copyOfP1.getContent())
        {
            result.addMonomial(m1);
        }
        for(Monomial m2:copyOfP2.getContent())
        {
            result.addMonomial(m2);
        }
        return  result;
    }

    public static Polynomial multiplyPolynomials(Polynomial p1, Polynomial p2)
    {
        Polynomial copyOfP1 = new Polynomial(p1);
        Polynomial copyOfP2 = new Polynomial(p2);
        Polynomial result = new Polynomial();
        for(Monomial m1:copyOfP1.getContent())
        {
            for(Monomial m2: copyOfP2.getContent())
            {
                Monomial auxM = new Monomial(m1.getCoefficient().floatValue() * m2.getCoefficient().floatValue(), m1.getDegree().intValue() + m2.getDegree().intValue());
                result.addMonomial(auxM);
            }
        }

        return  result;
    }

    public static Polynomial derivatePolynomial(Polynomial p1)
    {
        Polynomial copyOfP1 = new Polynomial(p1);
        Polynomial result = new Polynomial();
        for(Monomial m1:copyOfP1.getContent())
        {
            Monomial auxM = new Monomial(m1.getCoefficient().floatValue() * m1.getDegree().intValue(), m1.getDegree().intValue() - 1);
            result.addMonomial(auxM);
        }

        return  result;
    }

    public static Polynomial integratePolynomial(Polynomial p1)
    {
        Polynomial copyOfP1 = new Polynomial(p1);
        Polynomial result = new Polynomial();
        for(Monomial m1:copyOfP1.getContent())
        {
            Monomial auxM = new Monomial(m1.getCoefficient().floatValue() / (m1.getDegree().floatValue() + 1), m1.getDegree().intValue() + 1);
            result.addMonomial(auxM);
        }

        return  result;
    }

    public static ArrayList<Polynomial> dividePolynomials(Polynomial p1, Polynomial p2)
    {
        Polynomial copyOfP1 = new Polynomial(p1);
        Polynomial copyOfP2 = new Polynomial(p2);
        Polynomial cat = new Polynomial();
        ArrayList<Polynomial> result = new ArrayList<>();
        Collections.sort(copyOfP1.getContent(), Monomial.monomialComparator);
        Collections.sort(copyOfP2.getContent(), Monomial.monomialComparator);
        if(copyOfP1.getContent().get(0).getDegree().intValue() < copyOfP2.getContent().get(0).getDegree().intValue())
            swap(copyOfP1,copyOfP2);
        do {
            Monomial tempMoni = new Monomial(copyOfP1.getContent().get(0).getCoefficient().floatValue() / copyOfP2.getContent().get(0).getCoefficient().floatValue(),
                    copyOfP1.getContent().get(0).getDegree().intValue() - copyOfP2.getContent().get(0).getDegree().intValue());
            cat.addMonomial(tempMoni);
            Polynomial tempPoly = new Polynomial();
            tempPoly.getContent().add(tempMoni);
            Polynomial multiply = multiplyPolynomials(copyOfP2,tempPoly);
            copyOfP1 = substractPolynomials(copyOfP1,multiply);
            tempPoly.getContent().remove(tempMoni);

        }while(copyOfP1.getContent().size() != 0 && copyOfP1.getContent().get(0).getDegree().intValue() >= copyOfP2.getContent().get(0).getDegree().intValue());
        result.add(cat);
        result.add(copyOfP1);

        return result;

    }

    private static void swap(Polynomial copyOfP1, Polynomial copyOfP2) {
        ArrayList<Monomial> arr1= copyOfP1.getContent();
        copyOfP1.setContent(copyOfP2.getContent());
        copyOfP2.setContent(arr1);

    }

}
