package DataModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
    private ArrayList<Monomial> content;

    public Polynomial(Polynomial p)
    {
        this.content = new ArrayList<>();
        for (Monomial m:p.getContent())
        {
            this.content.add(new Monomial(m.getCoefficient(),m.getDegree()));
        }
    }

    public Polynomial(String input) {
        content = new ArrayList<>();
        input = input.replaceAll("\\*+","");
        input = input.replaceAll("\\s+","");


        /*
        String[] arrOfStrings = input.split("[+-]", 100);
        for(String str:arrOfStrings)
            addMonomial(new DataModel.Monomial(str));
         */

        //Pattern pattern = Pattern.compile("[+-]?[^x]+x\\^[+-]?[^+-]+");
        Pattern pattern = Pattern.compile("[+-]?[^+-]+");
        Matcher m = pattern.matcher(input);
        while (m.find()) {
            addMonomial(new Monomial(m.group()));
        }


    }
    public Polynomial(ArrayList <Monomial> content)
    {
        this.content = content;
    }
    public Polynomial()
    {
        content = new ArrayList<>();
    }

    public ArrayList<Monomial> getContent() {
        return content;
    }
    public ArrayList<Monomial> getCopyOfContent() {
        ArrayList<Monomial> result= new ArrayList<>();
        for(Monomial m:content)
        {
            result.add(new Monomial(m.getCoefficient(),m.getDegree()));
        }
        return result;
    }

    public ArrayList<Monomial> deepCopy() {
        ArrayList<Monomial> result = new ArrayList<Monomial>();
        for (Monomial m:content){
            result.add(m);
        }
        return result;
    }

    public void setContent(ArrayList<Monomial> content) {
        this.content = content;
    }

    public void addMonomial(Monomial m)
    {
        ArrayList<Monomial> aux = new ArrayList<>();
        boolean exists = false;
        for(Monomial localM: content)
        {
            Float aux_coeff = localM.getCoefficient().floatValue();
            if(localM.getDegree().intValue() == m.getDegree().intValue())
            {
                aux_coeff = aux_coeff + m.getCoefficient().floatValue();
                exists = true;
            }
            if(aux_coeff != 0)
                aux.add(new Monomial(aux_coeff,localM.getDegree()));
        }
        if(!exists && m.getCoefficient().floatValue() != 0)
            aux.add(new Monomial(m.getCoefficient(), m.getDegree()));
        content = new ArrayList<>(aux);
    }

    public String writePoly()
    {
        String result = "";
        Collections.sort(content, Monomial.monomialComparator);
        if(content.size() > 0)
        {
            for(Monomial m: content)
                result += m.writeMonomial() + " ";
        }
        else
            result = result + "0";
        return result;
    }
}
