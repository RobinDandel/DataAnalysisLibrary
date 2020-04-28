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

    @Test
    public void exceptionFileNotFound() {
        assertNull(new Dataframe("chien.csv").tab);//fichier .csv qui n'existe pas
    }


    @Test
    public void displayFirstLigneDataFrame() {
        Dataframe dataframe = new Dataframe("src/main/resources/Car_ Evaluation_Database.csv");
        Object[] tabFirstLigne=dataframe.displayFirstLigneDataFrame();
        assertEquals("vhigh",tabFirstLigne[1]);
        assertEquals("vhigh",tabFirstLigne[2]);
        assertEquals(2,tabFirstLigne[3]);
        assertEquals(2,tabFirstLigne[4]);
        assertEquals("small",tabFirstLigne[5]);
        assertEquals("low",tabFirstLigne[6]);
    }

    @Test
    public void displayLastLigneDataFrame() {
        Dataframe dataframe = new Dataframe("src/main/resources/Car_ Evaluation_Database.csv");
        Object[] tabFirstLigne=dataframe.displayLastLigneDataFrame();
        assertEquals("low",tabFirstLigne[1]);
        assertEquals("low",tabFirstLigne[2]);
        assertEquals(5,tabFirstLigne[3]);
        assertEquals(4,tabFirstLigne[4]);
        assertEquals("big",tabFirstLigne[5]);
        assertEquals("high",tabFirstLigne[6]);
    }

    @Test
    public void valMax() {
        Dataframe dataframe = new Dataframe("src/main/resources/Car_ Evaluation_Database.csv");
        assertEquals(5,dataframe.valMax("doors"));

        Dataframe dataframe2 = new Dataframe("src/main/resources/forestfires.csv");
        assertEquals((float)33.3,dataframe2.valMax("temp"));

        assertNull(dataframe2.valMax("month"));//Max sur un String
    }

    @Test
    public void valMin() {
        Dataframe dataframe2 = new Dataframe("src/main/resources/forestfires.csv");
        assertEquals(2,dataframe2.valMin("Y"));
        assertEquals((float)0.4,dataframe2.valMin("wind"));

        assertNull(dataframe2.valMin("day"));//Min sur un String
    }

    @Test
    public void valMoy() {
        Dataframe dataframe = new Dataframe("src/main/resources/Car_ Evaluation_Database.csv");
        assertEquals(3.334490740740741,dataframe.valMoy("persons"));

        Dataframe dataframe2 = new Dataframe("src/main/resources/forestfires.csv");
        assertEquals(9.031523890836556,dataframe2.valMoy("ISI"));

        assertNull(dataframe2.valMoy("month"));//Moy sur un String
    }

    @Test
    public void newDataframe() {
        Dataframe dataframe = new Dataframe("src/main/resources/forestfires.csv");
        List<String> labels = new ArrayList<>();
        List<Integer> indexs = new ArrayList<>();
        labels.add("X");
        labels.add("nb_arbre");//n'existe pas
        labels.add("day");
        labels.add("temp");
        indexs.add(2);
        indexs.add(4);
        Dataframe dataframe2 = dataframe.newDataframe(labels, indexs);
        Object[][] tab = dataframe2.displayAllDataframe();
        //vérification de la table des types
        assertEquals("Integer",dataframe2.types[1]);
        assertEquals("String",dataframe2.types[2]);
        assertEquals("Float",dataframe2.types[3]);
        //vérification de la table des données
        Object[][] tab2 = new Object[3][4];
        //1er colonne
        tab2[0][0]="";
        tab2[0][1]="X";
        tab2[0][2]="day";
        tab2[0][3]="temp";
        //2ème colonne
        tab2[1][0]=0;
        tab2[1][1]=7;
        tab2[1][2]="sat";
        tab2[1][3]=(float)14.6;
        //3ème colonne
        tab2[2][0]=1;
        tab2[2][1]=8;
        tab2[2][2]="sun";
        tab2[2][3]=(float)11.4;


        assertEquals(3,tab.length);
        assertEquals(4,tab[0].length);
        for (int i=0;i<tab.length;i++){
            for(int j=0;j<tab[i].length;j++){
                assertEquals(tab2[i][j],tab[i][j]);
            }
        }
    }

    @Test
    public void numColonne(){
        Dataframe dataframe = new Dataframe("src/main/resources/Car_ Evaluation_Database.csv");
        assertSame(3,dataframe.numColonne("doors"));
        assertSame(-1,dataframe.numColonne(""));
    }


}