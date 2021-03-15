package View;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GUI {

    private JTextArea p1Text = new JTextArea();
    private JTextArea p2Text = new JTextArea();
    private JLabel errorLabel = new JLabel("");
    private JTextArea p3Text = new JTextArea();
    private JButton addition=new JButton("ADD");
    private JButton substract=new JButton("SUBSTRACT");
    private JButton multiply=new JButton("MULTIPLY");
    private JButton divide=new JButton("DIVIDE");
    private JButton derivate=new JButton("DERIVATE P1");
    private JButton integrate=new JButton("INTEGRATE P1");


    public GUI()
    {

    }

    public String getFirstPoly()
    {
        return p1Text.getText();
    }
    public String getSecondPoly()
    {
        return p2Text.getText();
    }
    public void setErrorText(String string)
    {
        errorLabel.setText(string);
    }
    public void setResultText(String string)
    {
        p3Text.setText(string);
    }

    public void setActionOnAdditonButton(ActionListener actionListener)
    {
            addition.addActionListener(actionListener);
    }
    public void setActionOnSubstractButton(ActionListener actionListener)
    {
        substract.addActionListener(actionListener);
    }
    public void setActionOnMultiplyButton(ActionListener actionListener)
    {
        multiply.addActionListener(actionListener);
    }
    public void setActionOnDivideButton(ActionListener actionListener)
    {
        divide.addActionListener(actionListener);
    }
    public void setActionOnDerivateButton(ActionListener actionListener)
    {
        derivate.addActionListener(actionListener);
    }
    public void setActionOnIntegrateButton(ActionListener actionListener)
    {
        integrate.addActionListener(actionListener);
    }

    public void initialise()
    {
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

        p1Text.setFont(new Font(Font.SERIF,  Font.PLAIN, 17));
        p1Text.setBounds(p1Label.getX(), p1Label.getY() + labelHeight,labelWidth,labelHeight);
        p1Text.setText("x^3 - 2x^2 + 6 * x - 5");
        frame.add(p1Text);

        JLabel p2Label = new JLabel("Second Polynomial:");
        p2Label.setFont(new Font(Font.SERIF,  Font.ITALIC, 18));
        p2Label.setBounds(p1Label.getX(), p1Text.getY() + labelHeight,labelWidth,labelHeight);
        frame.add(p2Label);

        p2Text.setFont(new Font(Font.SERIF,  Font.PLAIN, 17));
        p2Text.setBounds(p2Label.getX(), p2Label.getY() + labelHeight,labelWidth,labelHeight);
        p2Text.setText("x^2 + 4*x + 5");
        frame.add(p2Text);

        errorLabel.setFont(new Font(Font.SERIF,  Font.PLAIN, 16));
        errorLabel.setBounds(p1Label.getX(), p2Text.getY() + labelHeight,labelWidth,labelHeight);
        errorLabel.setForeground(Color.red);
        frame.add(errorLabel);

        JLabel p3Label = new JLabel("Result:");
        p3Label.setFont(new Font(Font.SERIF,  Font.ITALIC, 18));
        p3Label.setBounds(p1Label.getX(), p2Text.getY() + 3 * labelHeight,labelWidth,labelHeight);
        frame.add(p3Label);

        p3Text.setFont(new Font(Font.SERIF,  Font.PLAIN, 17));
        p3Text.setBounds(p3Label.getX(), p3Label.getY() + labelHeight,labelWidth,2 * labelHeight);
        p3Text.setEditable(false);
        frame.add(p3Text);

        JLabel madeByLabel = new JLabel("@ Made By Fleser Mihai");
        madeByLabel.setFont(new Font(Font.SERIF,  Font.ITALIC, 14));
        madeByLabel.setBounds(p3Text.getX() + buttonWidth, p3Text.getY() + 4 * labelHeight,labelWidth,labelHeight);
        frame.add(madeByLabel);

        addition.setBounds(0,buttonHeight * 0,buttonWidth, buttonHeight);//x axis, y axis, width, height
        addition.setBackground(buttonColor);
        addition.setFont(new Font(Font.SERIF,  Font.BOLD, 13));
        addition.setForeground(Color.white);
        frame.add(addition);//adding addition in JFrame

        substract.setBounds(0,buttonHeight * 1,buttonWidth, buttonHeight);//x axis, y axis, width, height
        substract.setBackground(buttonColor);
        substract.setFont(new Font(Font.SERIF,  Font.BOLD, 13));
        substract.setForeground(Color.white);
        frame.add(substract);//adding substracton button in JFrame

        multiply.setBounds(0,buttonHeight * 2,buttonWidth, buttonHeight);//x axis, y axis, width, height
        multiply.setBackground(buttonColor);
        multiply.setFont(new Font(Font.SERIF,  Font.BOLD, 13));
        multiply.setForeground(Color.white);
        frame.add(multiply);//adding multiplication button in JFrame

        divide.setBounds(0,buttonHeight * 3,buttonWidth, buttonHeight);//x axis, y axis, width, height
        divide.setBackground(buttonColor);
        divide.setFont(new Font(Font.SERIF,  Font.BOLD, 13));
        divide.setForeground(Color.white);
        frame.add(divide);//adding button in JFrame

        derivate.setBounds(0,buttonHeight * 4,buttonWidth, buttonHeight);//x axis, y axis, width, height
        derivate.setBackground(buttonColor);
        derivate.setFont(new Font(Font.SERIF,  Font.BOLD, 13));
        derivate.setForeground(Color.white);
        frame.add(derivate);//adding button in JFrame

        integrate.setBounds(0,buttonHeight * 5,buttonWidth, buttonHeight);//x axis, y axis, width, height
        integrate.setBackground(buttonColor);
        integrate.setFont(new Font(Font.SERIF,  Font.BOLD, 12));
        integrate.setForeground(Color.white);
        frame.add(integrate);//adding button in JFrame

        frame.setSize(width,height+38);//400 width and 500 height
        frame.setLayout(null);//using no layout managers
        frame.getContentPane().setBackground(frameColor);
        frame.setVisible(true);//making the frame visible


    }
}
