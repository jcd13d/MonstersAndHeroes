import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class Utils {
    Scanner scanner = new Scanner(System.in);

    public ArrayList<String[]> readTxtFile(String filename) throws IOException {
        // TODO remember to use get directory and join them
        ArrayList<String[]> data = new ArrayList<>();
        File file = new File(filename);

        BufferedReader br = new BufferedReader(new FileReader(file));
        String str;

        while ((str = br.readLine()) != null) {
            String[] s = str.split("\\s+");
            data.add(s);
        }

//        for (String[] line : data) {
//            System.out.println(Arrays.toString(line));
//        }

        return data;
    }

    public static void main(String[] args) throws IOException {
        Utils utils = new Utils();
        utils.readTxtFile("/Users/justindiemmanuele/Documents/MS/CS611/HW3_MonstersAndHeros/Legends_Monsters_and_Heroes/Armory.txt");
        utils.readTxtFile("/Users/justindiemmanuele/Documents/MS/CS611/HW3_MonstersAndHeros/Legends_Monsters_and_Heroes/Dragons.txt");
        utils.readTxtFile("/Users/justindiemmanuele/Documents/MS/CS611/HW3_MonstersAndHeros/Legends_Monsters_and_Heroes/Weaponry.txt");
    }

}
