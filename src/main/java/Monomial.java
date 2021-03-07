import java.util.Comparator;

public class Monomial {

    private Number coefficient;
    private Number degree;

    public Monomial(Number coefficient, Number degree)
    {
        this.coefficient = coefficient;
        this.degree = degree;
    }
    public Monomial(String input)
    {
            String[] arrOfStrings = input.split("x\\^", 2);
            coefficient = Float.parseFloat(arrOfStrings[0]);
            degree = Float.parseFloat(arrOfStrings[1]);

    }


    public static Comparator<Monomial> monomialComparator = new Comparator<Monomial>() {

        public int compare(Monomial m1, Monomial m2) {
            Number degree1 = m1.getDegree();
            Number degree2 = m2.getDegree();

            //ascending order
            if(degree1.floatValue() < degree2.floatValue())
                return -1;
            else
                return 1;

            //descending order
            //return StudentName2.compareTo(StudentName1);
        }};


    public Number getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Number coefficient) {
        this.coefficient = coefficient;
    }

    public Number getDegree() {
        return degree;
    }

    public void setDegree(Number degree) {
        this.degree = degree;
    }

    public String writeMonomial()
    {
        String result = coefficient + "x^" + degree;
        return result;
    }
}
