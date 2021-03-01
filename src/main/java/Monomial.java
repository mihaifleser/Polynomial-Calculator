import java.util.Comparator;

public class Monomial {

    private Float coefficient;
    private Float degree;

    public Monomial(Float coefficient, Float degree)
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
            Float degree1 = m1.getDegree();
            Float degree2 = m2.getDegree();

            //ascending order
            return degree1.compareTo(degree2);

            //descending order
            //return StudentName2.compareTo(StudentName1);
        }};


    public Float getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Float coefficient) {
        this.coefficient = coefficient;
    }

    public Float getDegree() {
        return degree;
    }

    public void setDegree(Float degree) {
        this.degree = degree;
    }

    public String writeMonomial()
    {
        String result = coefficient + "x^" + degree;
        return result;
    }
}
