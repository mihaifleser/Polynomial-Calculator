public class Monomial {

    private Integer coefficient;
    private Integer degree;

    public Monomial(Integer coefficient, Integer degree)
    {
        this.coefficient = coefficient;
        this.degree = degree;
    }
    public Monomial(String input)
    {
            String[] arrOfStrings = input.split("x\\^", 2);
            coefficient = Integer.parseInt(arrOfStrings[0]);
            degree = Integer.parseInt(arrOfStrings[1]);

    }

    public Integer getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Integer coefficient) {
        this.coefficient = coefficient;
    }

    public Integer getDegree() {
        return degree;
    }

    public void setDegree(Integer degree) {
        this.degree = degree;
    }

    public String writeMonomial()
    {
        String result = coefficient.toString() + "x^" + degree.toString();
        return result;
    }
}
