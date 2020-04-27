import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DataframeTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
/*
    @Test
    public void parseurCSV() {
    }

    @Test
    public void displayAllDataframe() {
    }

    @Test
    public void displayFirstLigneDataFrame() {
    }

    @Test
    public void displayLastLigneDataFrame() {
    }
*/
    @Test
    public void valMax() {
        Dataframe dataframe = new Dataframe("src/main/resources/Car_ Evaluation_Database.csv");
        assertEquals(5,dataframe.valMax("doors"));
    }
/*
    @Test
    public void valMin() {

    }

    @Test
    public void valMoy() {
        Dataframe dataframe = new Dataframe("src/main/resources/Car_ Evaluation_Database.csv");
        assertEquals(3.334490740740741,dataframe.valMoy("persons"));
    }

    @Test
    public void newDataframe() {
        Dataframe dataframe = new Dataframe("src/main/resources/Car_ Evaluation_Database.csv");
        List<String> labels = new ArrayList<>();
        List<Integer> indexs = new ArrayList<>();
        labels.add("doors");
        labels.add("nb_roues");//n'existe pas
        labels.add("lug_boot");
        indexs.add(2);
        indexs.add(4);
        Dataframe dataframe2 =dataframe.newDataframe(labels,indexs);
        dataframe2.displayAllDataframe();
        //compare
        Object[][] tab2 = new Object[3][3];


        /////////////////pas fini//////////////////
    }
    */

}