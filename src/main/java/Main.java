import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Dataframe dataframe = new Dataframe("src/main/resources/Car_ Evaluation_Database.csv");
        System.out.println(dataframe.valMax("doors"));
        /*List<String> labels = new ArrayList<>();
        List<Integer> indexs = new ArrayList<>();
        labels.add("doors");
        labels.add("nb_roues");//n'existe pas
        labels.add("lug_boot");
        indexs.add(2);
        indexs.add(4);
        Dataframe dataframe2 =dataframe.newDataframe(labels,indexs);
        dataframe2.displayAllDataframe();
        */
        //dataframe.displayAllDataframe();
        //System.out.println(dataframe.valMoy("ISI"));
    }
}
