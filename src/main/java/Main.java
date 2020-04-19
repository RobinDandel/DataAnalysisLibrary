import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int somme = 0;
        for (int i=0; i < 10 ; i++) {
            somme = somme + i;
        }
        System.out.println(somme);

        List<String>name=new ArrayList<String>();
        /*name.add("toto");
        name.add("Jean");
        name.forEach(n->System.out.println(n));*/
    }
}