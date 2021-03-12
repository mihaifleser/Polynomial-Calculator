package Controller;

import DataModel.PolyOperations;
import DataModel.Polynomial;
import View.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controller {
    private GUI gui;

    public Controller(GUI gui)
    {
        this.gui = gui;
    }

    private static boolean checkInput(String input)
    {
        if (input.matches("^[0-9-+^*x ]+$")) {
            return true;
        } else {
            return false;
        }
    }

    public String addPolyomials(String first, String second)
    {
        try{
            Polynomial p1 = new Polynomial(first);
            Polynomial p2 = new Polynomial(second);
            Polynomial result = PolyOperations.addPolynomials(p1,p2);
            return result.writePoly();
        } catch (Exception e)
        {
            gui.setErrorText("Error: Could Not Parse Polynomial");
        }
        return "";
    }

    public String substractPolynomials(String first, String second)
    {
        try{
            Polynomial p1 = new Polynomial(first);
            Polynomial p2 = new Polynomial(second);
            Polynomial result = PolyOperations.substractPolynomials(p1,p2);
            return result.writePoly();
        } catch (Exception e)
        {
            gui.setErrorText("Error: Could Not Parse Polynomial");
        }
        return "";
    }
    public String multiplyPolynomials(String first, String second)
    {
        try{
            Polynomial p1 = new Polynomial(first);
            Polynomial p2 = new Polynomial(second);
            Polynomial result = PolyOperations.multiplyPolynomials(p1,p2);
            return result.writePoly();
        } catch (Exception e)
        {
            gui.setErrorText("Error: Could Not Parse Polynomial");
        }
        return "";
    }
    public String derivatePolynomial(String first)
    {
        try{
            Polynomial p1 = new Polynomial(first);
            Polynomial result = PolyOperations.derivatePolynomial(p1);
            return result.writePoly();
        } catch (Exception e)
        {
            gui.setErrorText("Error: Could Not Parse Polynomial");
        }
        return "";
    }
    public String integratePolynomial(String first)
    {
        try{
            Polynomial p1 = new Polynomial(first);
            Polynomial result = PolyOperations.integratePolynomial(p1);
            return result.writePoly();
        } catch (Exception e)
        {
            gui.setErrorText("Error: Could Not Parse Polynomial");
        }
        return "";
    }
    public String dividePolynomials(String first, String second)
    {
        String output = "";
        try{
            Polynomial p1 = new Polynomial(first);
            Polynomial p2 = new Polynomial(second);
            if(p1.getContent().size() == 0 || p2.getContent().size() == 0)
                return "Error";
            ArrayList <Polynomial> result = PolyOperations.dividePolynomials(p1,p2);
            output = "Quotient: " + result.get(0).writePoly() +"\n" + "Remainder: " + result.get(1).writePoly();
        }catch (Exception e)
        {
            gui.setErrorText("Error: Could Not Parse Polynomial");
        }

        return output;
    }

    public void run()
    {
        String errorMessage1 = "<html>Error. Please fill first and use only characters like x, +,<br/> -, *, ^ or  numbers. Example: 3 * x^2 - x + 1</html>";
        String errorMessage2 = "<html>Error. Please fill both and use only characters like x, +,<br/> -, *, ^ or  numbers. Example: 3 * x^2 - x + 1</html>";
        gui.initialise();

            gui.setActionOnAdditonButton(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(checkInput(gui.getFirstPoly()) && checkInput(gui.getSecondPoly()))
                    {
                        gui.setErrorText("");
                        gui.setResultText(addPolyomials(gui.getFirstPoly(),gui.getSecondPoly()));

                    }
                    else
                    {
                        gui.setErrorText(errorMessage2);
                    }
                }
            });

            gui.setActionOnSubstractButton(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(checkInput(gui.getFirstPoly()) && checkInput(gui.getSecondPoly()))
                    {
                        gui.setErrorText("");
                        gui.setResultText(substractPolynomials(gui.getFirstPoly(),gui.getSecondPoly()));
                    }
                    else
                    {
                        gui.setErrorText(errorMessage2);
                    }
                }
            });

            gui.setActionOnMultiplyButton(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(checkInput(gui.getFirstPoly()) && checkInput(gui.getSecondPoly()))
                    {
                        gui.setErrorText("");
                        gui.setResultText(multiplyPolynomials(gui.getFirstPoly(),gui.getSecondPoly()));
                    }
                    else
                    {
                        gui.setErrorText(errorMessage2);
                    }
                }
            });

            gui.setActionOnDivideButton(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(checkInput(gui.getFirstPoly()) && checkInput(gui.getSecondPoly()))
                    {
                        if(dividePolynomials(gui.getFirstPoly(),gui.getSecondPoly()) == "Error")
                            gui.setErrorText("Error. Division with 0.");
                        else
                        {
                            gui.setErrorText("");
                            gui.setResultText(dividePolynomials(gui.getFirstPoly(),gui.getSecondPoly()));
                        }

                    }
                    else
                    {
                        gui.setErrorText(errorMessage2);
                    }
                }
            });

            gui.setActionOnDerivateButton(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(checkInput(gui.getFirstPoly()))
                    {
                        gui.setErrorText("");
                        gui.setResultText(derivatePolynomial(gui.getFirstPoly()));
                    }
                    else
                    {
                        gui.setErrorText(errorMessage1);
                    }
                }
            });

            gui.setActionOnIntegrateButton(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(checkInput(gui.getFirstPoly()))
                    {
                        gui.setErrorText("");
                        gui.setResultText(integratePolynomial(gui.getFirstPoly()));
                    }
                    else
                    {
                        gui.setErrorText(errorMessage1);
                    }
                }
            });

    }

}


