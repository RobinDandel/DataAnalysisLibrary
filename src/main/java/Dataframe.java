import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dataframe {
    Object[][] tab;//données (la 1ère ligne pour les labels des colonnes)
    String[] types = null;//tableau des types de chaque colonne
    Dataframe(Object[][] tab,String[] types){
        this.tab =tab;
        this.types=types;
    }
    Dataframe(String pathCsvFile){
        this.tab =parseurCSV(pathCsvFile);
    }

    Object[][] parseurCSV(String pathCsvFile){
        //src/main/resources/Car_ Evaluation_Database.csv
        String ligne="";
        String[] cases;
        Object[][] newTab = null;

        try {
            newTab = initializationDataframe(pathCsvFile);

            BufferedReader fileCSV = new BufferedReader(new FileReader(pathCsvFile));
            //ligne type
            ligne = fileCSV.readLine();
            cases = ligne.split(",");
            types = cases;
            //ligne du nom des colonnes
            ligne = fileCSV.readLine();
            cases = ligne.split(",");
            for(int k=0;k<cases.length;k++){
                newTab[0][k]=cases[k];
            }
            //lignes des données
            int i=1;
            while ((ligne = fileCSV.readLine()) != null) {
                cases = ligne.split(",");
                newTab[i][0]=Integer.parseInt(cases[0]);//index
                for (int j=1;j<cases.length;j++){
                    switch (types[j]){
                        case "String":
                            newTab[i][j]=cases[j];
                            break;
                        case "Integer":
                            newTab[i][j]=Integer.parseInt(cases[j]);
                            break;
                        case "Float":
                            newTab[i][j]=Float.parseFloat(cases[j]);
                            break;
                        default:
                            System.err.println("Le type n'est pas bon");
                    }
                }
                i++;
            }
            fileCSV.close();
        }catch (Exception e){
            System.out.println("Problème avec le fichier '.csv' : "+e);
        }
        return newTab;
    }

    Object[][] initializationDataframe(String pathCsvFile) throws IOException {
        //initialisation tableau
        int nbligne=0,nbColonne=0;
        String[] cases;
        Object[][] newTab = null;

        BufferedReader initTab = new BufferedReader(new FileReader(pathCsvFile));
        cases = initTab.readLine().split(",");
        nbColonne=cases.length;
        nbligne++;
        while(null!=initTab.readLine()) { nbligne++;}
        initTab.close();
        return new Object[nbligne-1][nbColonne];
    }



    void displayAllDataframe(){
        for (int i = 0; i< tab.length; i++){
            for (int j = 0; j< tab[i].length; j++){
                System.out.print(tab[i][j]+"\t\t");
            }
            System.out.println("");
        }
    }

    public void displayFirstLigneDataFrame(){
        for (int j = 0; j< tab[0].length; j++){
            System.out.print(tab[0][j]+"\t\t");
        }
        System.out.println("");
        for (int j = 0; j< tab[1].length; j++){
            System.out.print(tab[1][j]+"\t\t");
        }
    }

    public void displayLastLigneDataFrame(){
        for (int j = 0; j< tab[0].length; j++){
            System.out.print(tab[0][j]+"\t\t");
        }
        System.out.println("");
        for (int j = 0; j< tab[1].length; j++){
            System.out.print(tab[tab.length-1][j]+"\t\t");
        }
    }

    //valeur max de la colonne "nameColumn"
    public Object valMax(String label){
        int i = numColonne(label);
        if (i!=-1){
            switch (types[i]){
                case "String":
                    //System.err.println("La valeur Max ne peut pas être fait sur un String");
                    break;
                case "Integer":
                    int iMax=(Integer) tab[1][i];
                    for (int k = 1; k< tab.length; k++){
                        if ((Integer) tab[k][i]>iMax) {
                            iMax = (int) tab[k][i];
                        }
                    }
                    return iMax;
                case "Float":
                    float fMax=(Float) tab[1][i];
                    for (int k = 1; k< tab.length; k++){
                        if ((Float) tab[k][i]>fMax){
                            fMax=(Float) tab[k][i];
                        }

                    }
                    return fMax;
                default:
                    System.err.println("Le type n'est pas bon");
            }
        }
        return null;
    }

    //valeur min de la colonne "label"
    public Object valMin(String label){
        int i = numColonne(label);
        if (i!=-1){
            switch (types[i]){
                case "String":
                    //System.err.println("La valeur Min ne peut pas être fait sur un String");
                    break;
                case "Integer":
                    int iMin =(Integer) tab[1][i];
                    for (int k = 1; k< tab.length; k++){
                        if ((Integer) tab[k][i]<iMin) {
                            iMin = (int) tab[k][i];
                        }
                    }
                    return iMin;
                case "Float":
                    float fMin =(Float) tab[1][i];
                    for (int k = 1; k< tab.length; k++){
                        if ((Float) tab[k][i]<fMin){
                            fMin =(Float) tab[k][i];
                        }

                    }
                    return fMin;
                default:
                    System.err.println("Le type n'est pas bon");
            }
        }
        return null;
    }

    //valeur moyen de la colonne "label"
    public Object valMoy(String label){
        int i = numColonne(label);
        if (i!=-1){
            int k;
            switch (types[i]){
                case "String":
                    //System.err.println("La valeur Min ne peut pas être fait sur un String");
                    break;
                case "Integer":
                    int iMoy =(Integer) tab[1][i];
                    for (k = 1; k< tab.length; k++){
                        iMoy+=(Integer) tab[k][i];
                    }
                    return iMoy/(k-1.0);
                case "Float":
                    float fMoy =(Float) tab[1][i];
                    for (k = 1; k< tab.length; k++){
                        fMoy+=(Float) tab[k][i];
                    }
                    return fMoy/(k-1.0);
                default:
                    System.err.println("Le type n'est pas bon");
            }
        }
        return null;
    }
    //renvoit un sous ensemble des données de la Dataframe existant
    //selection du sous ensemble des données grace aux labels (colonnes) et aux indexs (lignes)
    public Dataframe newDataframe(List<String> labels,List<Integer> indexs){
        Object[][] newTab;
        String[] newTypes = new String[labels.size()+1];
        newTypes[0]="";
        List<Integer> numColonnes = new ArrayList<>();
        numColonnes.add(0);
        int num,k,numType=1;
        //on prend l'index des bonnes colonnes
        for (k=0;k<labels.size();k++) {
            num=numColonne(labels.get(k));
            if (num!=-1 && !numColonnes.contains(num)) {
                numColonnes.add(num);
                newTypes[numType]=types[num];
                numType++;
            }
        }
        newTab = new Object[indexs.size()+1][numColonnes.size()];
        newTab[0][0]="";
        //insertion des labels dans le nouveau tableau
        for (k=0;k<numColonnes.size();k++) {
            newTab[0][k]=tab[0][numColonnes.get(k)];
        }
        //insertion des données dans le nouveau tableau
        for (int i=0;i<indexs.size();i++){
            newTab[i+1][0]=i;
            for (int j=1;j<numColonnes.size();j++){
                newTab[i+1][j]=tab[indexs.get(i)+1][numColonnes.get(j)];
            }
        }

        return new Dataframe(newTab,newTypes);
    }

    //revoit le numéro de la colonne qui a pour nom "label"
    // i si trouvé
    // -1 sinon
    Integer numColonne(String label){
        int i=1;
        if(label.equals("")){return -1;}
        while(i<tab[0].length && !tab[0][i].equals(label)){
            i++;
        }
        if (i< tab[0].length) {
            return i;
        }else{
            return -1;
        }
    }



}
