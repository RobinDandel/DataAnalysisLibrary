public class Main {
    public static void main(String[] args) {
        Pandas pandas = new Pandas("src/main/resources/Car_ Evaluation_Database.csv");
        System.out.println(pandas.valMoy("doors"));
    }
}
