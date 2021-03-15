package DataModel;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PolyOperationsTest {

    @org.junit.jupiter.api.Test
    void addPolynomials() {
        Polynomial p1 = new Polynomial("x^3 - 2x^2 + 6x - 6");
        Polynomial p2 = new Polynomial("x^2 - 1");

        Polynomial polyTest = PolyOperations.addPolynomials(p1, p2);
        assertEquals("+1x^3 -1x^2 +6x -7 ", polyTest.writePoly());
    }

    @org.junit.jupiter.api.Test
    void substractPolynomials() {
        Polynomial p1 = new Polynomial("x^3 - 2x^2 + 6x - 6");
        Polynomial p2 = new Polynomial("x^2 - 1");

        Polynomial polyTest = PolyOperations.substractPolynomials(p1, p2);
        assertEquals("+1x^3 -3x^2 +6x -5 ", polyTest.writePoly());
    }

    @org.junit.jupiter.api.Test
    void multiplyPolynomials() {
        Polynomial p1 = new Polynomial("x^3 - 2x^2 + 6x - 6");
        Polynomial p2 = new Polynomial("x^2 - 1");

        Polynomial polyTest = PolyOperations.multiplyPolynomials(p1, p2);
        assertEquals("+1x^5 -2x^4 +5x^3 -4x^2 -6x +6 ", polyTest.writePoly());
    }

    @org.junit.jupiter.api.Test
    void derivatePolynomial() {
        Polynomial p1 = new Polynomial("x^3 - 2x^2 + 6x - 6");
        Polynomial polyTest = PolyOperations.derivatePolynomial(p1);
        assertEquals("+3x^2 -4x +6 ", polyTest.writePoly());
    }

    @org.junit.jupiter.api.Test
    void integratePolynomial() {
        Polynomial p1 = new Polynomial("x^3 - 2x^2 + 6x - 6");
        Polynomial polyTest = PolyOperations.integratePolynomial(p1);
        assertEquals("+0.25x^4 -0.6666667x^3 +3x^2 -6x ", polyTest.writePoly());
    }

    @org.junit.jupiter.api.Test
    void dividePolynomials() {
        Polynomial p1 = new Polynomial("x^3 - 2x^2 + 6x - 5");
        Polynomial p2 = new Polynomial("x^2 - 1");

        ArrayList<Polynomial> polyTest = PolyOperations.dividePolynomials(p1, p2);
        assertEquals("+1x -2 ", polyTest.get(0).writePoly());
        assertEquals("+7x -7 ", polyTest.get(1).writePoly());
    }
}