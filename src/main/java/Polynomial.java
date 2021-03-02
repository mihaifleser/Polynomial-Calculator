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
        input = input.replaceAll("\\s+","");
        Pattern pattern = Pattern.compile("[+-]?[^x]+x\\^[+-]?[^+-]+");
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
        return new ArrayList<>(content);
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

    public void simplifyPoli()
    {
        ArrayList<Monomial> result = new ArrayList<>();
        Monomial aux;
        for(int i = 0; i < content.size();i++)
        {
            aux = content.get(i);
            for(int j = i + 1; j < content.size();j++)
            {
                if(content.get(j).getDegree() == aux.getDegree())
                {
                    aux.setCoefficient(aux.getCoefficient() + content.get(j).getCoefficient());
                    content.remove(j);
                    j--;
                }
            }
            if(aux.getCoefficient() != 0)
                result.add(aux);
        }
        content = result;
    }
    public void addMonomial(Monomial m)
    {
        ArrayList<Monomial> aux = new ArrayList<>();
        boolean exists = false;
        for(Monomial localM: content)
        {
            Float aux_coeff = localM.getCoefficient();
            if(localM.getDegree().compareTo(m.getDegree()) == 0 )
            {
                aux_coeff = aux_coeff + m.getCoefficient();
                exists = true;
            }
            if(aux_coeff != 0)
                aux.add(new Monomial(aux_coeff,localM.getDegree()));
        }
        if(!exists)
            aux.add(new Monomial(m.getCoefficient(), m.getDegree()));
        content = new ArrayList<>(aux);
    }

    public String writePoly()
    {
        String result = "";
        Collections.sort(content, Monomial.monomialComparator);
        for(Monomial m: content)
        {
            result += m.writeMonomial() + " ";
        }
        return result;
    }
}
