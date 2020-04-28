import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Dataframe dataframe = new Dataframe("src/main/resources/Car_ Evaluation_Database.csv");
        //Dataframe dataframe = new Dataframe("src/main/resources/forestfires.csv");
        dataframe.displayLastLigneDataFrame();



       // dataframe.displayAllDataframe();
        //System.out.println(dataframe.valMoy("ISI"));
    }
}
