import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
    private ArrayList<Monomial> content;

    public Polynomial(String input) {
        String pattern = "[+-][........]x\\^[+-][........]";

        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);

        // Now create matcher object.
        Matcher m = r.matcher(input);
        while (m.find()) {
            // Get the group matched using group() method
            System.out.print(m.group() + " ");
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
        content.add(m);
        simplifyPoli();
    }

    public String writePoly()
    {
        String result = "";
        for(Monomial m: content)
        {
            result += m.writeMonomial() + " ";
        }
        return result;
    }
}
