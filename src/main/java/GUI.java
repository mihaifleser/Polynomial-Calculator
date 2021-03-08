import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private JFrame frame = new JFrame("Polynomial Calculator");
    private Controller controller;
    public GUI()
    {
        controller = new Controller(new PolyHandler(),this);
    }

    private static boolean checkInput(String input)
    {
        if (input.matches("^[0-9-+^*x ]+$")) {
            return true;
        } else {
            return false;
        }
    }

    public void run()
    {
        String errorMessage1 = "<html>Error. Please fill first and use only characters like x, +,<br/> -, *, ^ or  numbers. Example: 3 * x^2 - x + 1</html>";
        String errorMessage2 = "<html>Error. Please fill both and use only characters like x, +,<br/> -, *, ^ or  numbers. Example: 3 * x^2 - x + 1</html>";

        Color buttonColor = Color.decode("#1A535C");
        Color frameColor = Color.decode("#4ECDC4");
        int width = 720; int height = 600;
        int buttonWidth = width / 6;
        int buttonHeight = height / 6;
        int labelWidth = width / 2;
        int labelHeight = height / 15;
        JFrame frame=new JFrame("Polynomial Calculator");//creating instance of JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel titleLabel = new JLabel("Polynomial Calculator");
        titleLabel.setFont(new Font(Font.SERIF,  Font.BOLD, 22));
        titleLabel.setBounds(buttonWidth * 2, 0,labelWidth,labelHeight);
        frame.add(titleLabel);

        JLabel p1Label = new JLabel("First Polynomial:");
        p1Label.setFont(new Font(Font.SERIF,  Font.ITALIC, 18));
        p1Label.setBounds(buttonWidth * 2, buttonHeight,labelWidth,labelHeight);
        frame.add(p1Label);
        JTextArea p1Text = new JTextArea();
        p1Text.setFont(new Font(Font.SERIF,  Font.PLAIN, 17));
        p1Text.setBounds(p1Label.getX(), p1Label.getY() + labelHeight,labelWidth,labelHeight);
        frame.add(p1Text);

        JLabel p2Label = new JLabel("Second Polynomial:");
        p2Label.setFont(new Font(Font.SERIF,  Font.ITALIC, 18));
        p2Label.setBounds(p1Label.getX(), p1Text.getY() + labelHeight,labelWidth,labelHeight);
        frame.add(p2Label);
        JTextArea p2Text = new JTextArea();
        p2Text.setFont(new Font(Font.SERIF,  Font.PLAIN, 17));
        p2Text.setBounds(p2Label.getX(), p2Label.getY() + labelHeight,labelWidth,labelHeight);
        frame.add(p2Text);

        JLabel errorLabel = new JLabel("");
        errorLabel.setFont(new Font(Font.SERIF,  Font.PLAIN, 16));
        errorLabel.setBounds(p1Label.getX(), p2Text.getY() + labelHeight,labelWidth,labelHeight);
        errorLabel.setForeground(Color.red);
        frame.add(errorLabel);

        JLabel p3Label = new JLabel("Result:");
        p3Label.setFont(new Font(Font.SERIF,  Font.ITALIC, 18));
        p3Label.setBounds(p1Label.getX(), p2Text.getY() + 3 * labelHeight,labelWidth,labelHeight);
        frame.add(p3Label);
        JTextArea p3Text = new JTextArea();
        p3Text.setFont(new Font(Font.SERIF,  Font.PLAIN, 17));
        p3Text.setBounds(p3Label.getX(), p3Label.getY() + labelHeight,labelWidth,2 * labelHeight);
        p3Text.setEditable(false);
        frame.add(p3Text);

        JLabel madeByLabel = new JLabel("@ Made By Fleser Mihai");
        madeByLabel.setFont(new Font(Font.SERIF,  Font.ITALIC, 14));
        madeByLabel.setBounds(p3Text.getX() + buttonWidth, p3Text.getY() + 4 * labelHeight,labelWidth,labelHeight);
        frame.add(madeByLabel);


        JButton addition=new JButton("ADD");//creating instance of JButton
        addition.setBounds(0,buttonHeight * 0,buttonWidth, buttonHeight);//x axis, y axis, width, height
        addition.setBackground(buttonColor);
        addition.setFont(new Font(Font.SERIF,  Font.BOLD, 13));
        addition.setForeground(Color.white);
        addition.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(checkInput(p1Text.getText()) && checkInput(p2Text.getText()))
                {
                    p3Text.setText(controller.addPolyomials(p1Text.getText(),p2Text.getText()));
                    errorLabel.setText("");
                }
                else
                {
                    errorLabel.setText(errorMessage2);
                }

            }
        });
        frame.add(addition);//adding addition in JFrame

        JButton substract=new JButton("SUBSTRACT");//creating instance of JButton
        substract.setBounds(0,buttonHeight * 1,buttonWidth, buttonHeight);//x axis, y axis, width, height
        substract.setBackground(buttonColor);
        substract.setFont(new Font(Font.SERIF,  Font.BOLD, 13));
        substract.setForeground(Color.white);
        substract.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if(checkInput(p1Text.getText()) && checkInput(p2Text.getText()))
                {
                    p3Text.setText(controller.substractPolynomials(p1Text.getText(),p2Text.getText()));
                    errorLabel.setText("");
                }
                else
                {
                    errorLabel.setText(errorMessage2);
                }
            }
        });
        frame.add(substract);//adding substracton button in JFrame

        JButton multiply=new JButton("MULTIPLY");//creating instance of JButton
        multiply.setBounds(0,buttonHeight * 2,buttonWidth, buttonHeight);//x axis, y axis, width, height
        multiply.setBackground(buttonColor);
        multiply.setFont(new Font(Font.SERIF,  Font.BOLD, 13));
        multiply.setForeground(Color.white);
        multiply.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if(checkInput(p1Text.getText()) && checkInput(p2Text.getText()))
                {
                    p3Text.setText(controller.multiplyPolynomials(p1Text.getText(),p2Text.getText()));
                    errorLabel.setText("");
                }
                else
                {
                    errorLabel.setText(errorMessage2);
                }
            }
        });
        frame.add(multiply);//adding multiplication button in JFrame

        JButton divide=new JButton("DIVIDE");//creating instance of JButton
        divide.setBounds(0,buttonHeight * 3,buttonWidth, buttonHeight);//x axis, y axis, width, height
        divide.setBackground(buttonColor);
        divide.setFont(new Font(Font.SERIF,  Font.BOLD, 13));
        divide.setForeground(Color.white);
        divide.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if(checkInput(p1Text.getText()) && checkInput(p2Text.getText()))
                {
                    p3Text.setText(controller.dividePolynomial(p1Text.getText(),p2Text.getText()));
                    errorLabel.setText("");
                }
                else
                {
                    errorLabel.setText(errorMessage2);
                }
            }
        });
        frame.add(divide);//adding button in JFrame

        JButton derivate=new JButton("DERIVATE P1");//creating instance of JButton
        derivate.setBounds(0,buttonHeight * 4,buttonWidth, buttonHeight);//x axis, y axis, width, height
        derivate.setBackground(buttonColor);
        derivate.setFont(new Font(Font.SERIF,  Font.BOLD, 13));
        derivate.setForeground(Color.white);
        derivate.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if(checkInput(p1Text.getText()))
                {
                    p3Text.setText(controller.derivatePolynomial(p1Text.getText()));
                    errorLabel.setText("");
                }
                else
                {
                    errorLabel.setText(errorMessage1);
                }
            }
        });
        frame.add(derivate);//adding button in JFrame

        JButton integrate=new JButton("INTEGRATE P1");//creating instance of JButton
        integrate.setBounds(0,buttonHeight * 5,buttonWidth, buttonHeight);//x axis, y axis, width, height
        integrate.setBackground(buttonColor);
        integrate.setFont(new Font(Font.SERIF,  Font.BOLD, 12));
        integrate.setForeground(Color.white);
        integrate.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if(checkInput(p1Text.getText()))
                {
                    p3Text.setText(controller.integratePolynomial(p1Text.getText()));
                    errorLabel.setText("");
                }
                else
                {
                    errorLabel.setText(errorMessage1);
                }
            }
        });
        frame.add(integrate);//adding button in JFrame



        frame.setSize(width,height+38);//400 width and 500 height
        frame.setLayout(null);//using no layout managers
        frame.getContentPane().setBackground(frameColor);
        frame.setVisible(true);//making the frame visible


    }
}
