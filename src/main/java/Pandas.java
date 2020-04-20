import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Pandas {
    Object[][] dataframe;
    String[] types = null;
    Pandas(Object[][] tab){
        this.dataframe =tab;
    }
    Pandas(String pathCsvFile){
        this.dataframe =parseurCSV(pathCsvFile);
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
        for (int i = 0; i< dataframe.length; i++){
            for (int j = 0; j< dataframe[i].length; j++){
                System.out.print(dataframe[i][j]+"\t\t");
            }
            System.out.println("");
        }
    }

    public void displayFirstLigneDataFrame(){
        for (int j = 0; j< dataframe[0].length; j++){
            System.out.print(dataframe[0][j]+"\t\t");
        }
        System.out.println("");
        for (int j = 0; j< dataframe[1].length; j++){
            System.out.print(dataframe[1][j]+"\t\t");
        }
    }

    public void displayLastLigneDataFrame(){
        for (int j = 0; j< dataframe[0].length; j++){
            System.out.print(dataframe[0][j]+"\t\t");
        }
        System.out.println("");
        for (int j = 0; j< dataframe[1].length; j++){
            System.out.print(dataframe[dataframe.length-1][j]+"\t\t");
        }
    }

    //valeur max de la colonne "nameColumn"
    public Object valMax(String nameColumn){
        int i=1;
        while(!dataframe[0][i].equals(nameColumn) && i<dataframe[0].length){i++;}

        if (i<dataframe[0].length){
            switch (types[i]){
                case "String":
                    System.err.println("La valeur Max ne peut pas être fait sur un String");
                    break;
                case "Integer":
                    int iMax=(Integer)dataframe[1][i];
                    for (int k = 1; k<dataframe.length; k++){
                        if ((Integer)dataframe[k][i]>iMax) {
                            iMax = (int) dataframe[k][i];
                        }
                    }
                    return iMax;
                case "Float":
                    float fMax=(Float) dataframe[1][i];
                    for (int k = 1; k<dataframe.length; k++){
                        System.out.print(dataframe[k][i]+"\t\t");
                        if ((Float)dataframe[k][i]>fMax){
                            fMax=(Float)dataframe[k][i];
                        }

                    }
                    return fMax;
                default:
                    System.err.println("Le type n'est pas bon");
            }
        }
        return null;
    }

    //valeur min de la colonne "nameColumn"
    public Object valMin(String nameColumn){
        int i=1;
        while(!dataframe[0][i].equals(nameColumn) && i<dataframe[0].length){i++;}

        if (i<dataframe[0].length){
            switch (types[i]){
                case "String":
                    System.err.println("La valeur Min ne peut pas être fait sur un String");
                    break;
                case "Integer":
                    int iMin =(Integer)dataframe[1][i];
                    for (int k = 1; k<dataframe.length; k++){
                        if ((Integer)dataframe[k][i]<iMin) {
                            iMin = (int) dataframe[k][i];
                        }
                    }
                    return iMin;
                case "Float":
                    float fMin =(Float) dataframe[1][i];
                    for (int k = 1; k<dataframe.length; k++){
                        System.out.print(dataframe[k][i]+"\t\t");
                        if ((Float)dataframe[k][i]<fMin){
                            fMin =(Float)dataframe[k][i];
                        }

                    }
                    return fMin;
                default:
                    System.err.println("Le type n'est pas bon");
            }
        }
        return null;
    }

    //valeur moyen de la colonne "nameColumn"
    public Object valMoy(String nameColumn){
        int i=1;
        while(!dataframe[0][i].equals(nameColumn) && i<dataframe[0].length){i++;}

        if (i<dataframe[0].length){
            int k;
            switch (types[i]){
                case "String":
                    System.err.println("La valeur Min ne peut pas être fait sur un String");
                    break;
                case "Integer":
                    int iMoy =(Integer)dataframe[1][i];
                    for (k = 1; k<dataframe.length; k++){
                        iMoy+=(Integer)dataframe[k][i];
                    }
                    return iMoy/(k-1.0);
                case "Float":
                    float fMoy =(Float)dataframe[1][i];
                    for (k = 1; k<dataframe.length; k++){
                        fMoy+=(Float)dataframe[k][i];
                    }
                    return fMoy/(k-1.0);
                default:
                    System.err.println("Le type n'est pas bon");
            }
        }
        return null;
    }

}
