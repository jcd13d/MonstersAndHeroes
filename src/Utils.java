import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class Utils {
    Scanner scanner = new Scanner(System.in);

    public void readTxtFile(String filename) throws IOException {
        // TODO remember to use get directory and join them
        File file = new File(filename);

        BufferedReader br = new BufferedReader(new FileReader(file));
        String str;

        while ((str = br.readLine()) != null) {
            System.out.println(str);
            String[] s = str.split("\\s+");
            System.out.println(Arrays.toString(s));
        }

    }

    public static void main(String[] args) throws IOException {
        Utils utils = new Utils();
        utils.readTxtFile("/Users/justindiemmanuele/Documents/MS/CS611/HW3_MonstersAndHeros/Legends_Monsters_and_Heroes/Armory.txt");
    }

}
