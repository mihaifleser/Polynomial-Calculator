import javax.swing.*;
import java.awt.*;

public class GUI {
    private JFrame frame = new JFrame("Polynomial Calculator");

    public GUI()
    {

    }

    public void initialize()
    {
        /*
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(720, 600);
        JLabel label1 = new JLabel("test1");
        label1.setBounds(0,0,frame.getWidth(),frame.getHeight());
        label1.setBackground(Color.blue);
        JLabel label2 = new JLabel("test2");
        JLabel label11 = new JLabel("test11");
        JLabel label22 = new JLabel("test22");

        Box bigBox = Box.createHorizontalBox();
        Box boxLeft = Box.createVerticalBox();
        boxLeft.setSize(new Dimension(3 * frame.getWidth()/4, frame.getHeight()));
        Box boxRight = Box.createVerticalBox();
        boxRight.setSize(new Dimension(frame.getWidth()/4, frame.getHeight()));
        boxLeft.add(label1);
        boxLeft.add(label11);
        boxRight.add(label2);
        boxRight.add(label22);

        bigBox.setBounds(0,0,frame.getWidth(),frame.getHeight());
        bigBox.add(boxLeft);
        bigBox.add(boxRight);
        bigBox.setBackground(Color.blue);
        bigBox.setVisible(true);


        //frame.add(bigBox);
        frame.add(label1);
        frame.setVisible(true);
        */
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
        titleLabel.setBounds(labelWidth, 0,labelWidth,labelHeight);
        frame.add(titleLabel);

        JLabel p1Label = new JLabel("First Polynomial:");
        p1Label.setBounds(buttonWidth * 2, buttonHeight,labelWidth,labelHeight);
        frame.add(p1Label);
        JTextArea p1Text = new JTextArea();
        p1Text.setBounds(p1Label.getX(), p1Label.getY() + labelHeight,labelWidth,labelHeight);
        frame.add(p1Text);

        JLabel p2Label = new JLabel("Second Polynomial:");
        p2Label.setBounds(p1Label.getX(), p1Text.getY() + labelHeight,labelWidth,labelHeight);
        frame.add(p2Label);
        JTextArea p2Text = new JTextArea();
        p2Text.setBounds(p2Label.getX(), p2Label.getY() + labelHeight,labelWidth,labelHeight);
        frame.add(p2Text);

        JLabel p3Label = new JLabel("Result:");
        p3Label.setBounds(p1Label.getX(), p2Text.getY() + 3 * labelHeight,labelWidth,labelHeight);
        frame.add(p3Label);
        JTextArea p3Text = new JTextArea();
        p3Text.setBounds(p3Label.getX(), p3Label.getY() + labelHeight,labelWidth,labelHeight);
        p3Text.setEditable(false);
        frame.add(p3Text);


        JButton addition=new JButton("ADD");//creating instance of JButton
        addition.setBounds(0,buttonHeight * 0,buttonWidth, buttonHeight);//x axis, y axis, width, height
        addition.setBackground(buttonColor);
        addition.setForeground(Color.white);
        frame.add(addition);//adding button in JFrame

        JButton substract=new JButton("SUBSTRACT");//creating instance of JButton
        substract.setBounds(0,buttonHeight * 1,buttonWidth, buttonHeight);//x axis, y axis, width, height
        substract.setBackground(buttonColor);
        substract.setForeground(Color.white);
        frame.add(substract);//adding button in JFrame

        JButton multiply=new JButton("MULTIPLY");//creating instance of JButton
        multiply.setBounds(0,buttonHeight * 2,buttonWidth, buttonHeight);//x axis, y axis, width, height
        multiply.setBackground(buttonColor);
        multiply.setForeground(Color.white);
        frame.add(multiply);//adding button in JFrame

        JButton divide=new JButton("DIVIDE");//creating instance of JButton
        divide.setBounds(0,buttonHeight * 3,buttonWidth, buttonHeight);//x axis, y axis, width, height
        divide.setBackground(buttonColor);
        divide.setForeground(Color.white);
        frame.add(divide);//adding button in JFrame

        JButton derivate=new JButton("DERIVATE");//creating instance of JButton
        derivate.setBounds(0,buttonHeight * 4,buttonWidth, buttonHeight);//x axis, y axis, width, height
        derivate.setBackground(buttonColor);
        derivate.setForeground(Color.white);
        frame.add(derivate);//adding button in JFrame

        JButton integrate=new JButton("INTEGRATE");//creating instance of JButton
        integrate.setBounds(0,buttonHeight * 5,buttonWidth, buttonHeight);//x axis, y axis, width, height
        integrate.setBackground(buttonColor);
        integrate.setForeground(Color.white);
        frame.add(integrate);//adding button in JFrame


        frame.setSize(width,height+38);//400 width and 500 height
        frame.setLayout(null);//using no layout managers
        frame.getContentPane().setBackground(frameColor);
        frame.setVisible(true);//making the frame visible


    }
}
