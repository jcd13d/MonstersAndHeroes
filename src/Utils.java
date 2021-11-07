import java.lang.reflect.Array;
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

        String[] s;
        int ct = 0;
        while ((str = br.readLine()) != null) {
            if (str.length() > 0) {
                if (ct == 0) {
                    s = str.split("/");
                } else {
                    s = str.split("\\s+");
                }
                if (s.length > 0) {
                    data.add(s);
                }
                ct++;
            }
        }

//        for (String[] line : data) {
//            System.out.println(Arrays.toString(line));
//        }

        return data;
    }

    public String getStringInput() {
        String input;
        input = scanner.nextLine();
        return input;
    }

    public String getStringInput(String prompt) {
        System.out.println(prompt);
        return getStringInput();
    }

    public String getStringInput(String prompt, StringChecker checker) {
        String input;
        do {
            input = getStringInput(prompt);
        } while (!checker.check(input));
        return input;
    }

    // integer input
    public int getIntInput() {
        String input;
        input = scanner.nextLine();
        boolean check = intCheck(input);       // did they pass an int?

        while(!check) {                         // if not int, ask again
            System.out.println("Not an Integer!");
            input = scanner.nextLine();
            check = intCheck(input);
        }

        return Integer.parseInt(input);          // parse to int
    }

    // get int with prompt
    public int getIntInput(String prompt) {
        System.out.println(prompt);
        return getIntInput();
    }

    public int getIntInput(String prompt, IntChecker checker) {
        int input;

        do {
            input = getIntInput(prompt);
        } while (!checker.check(input));

        return input;
    }

    // check that a string is an integer
    public boolean intCheck(String input) {
        boolean check = true;
        for (int i = 0; i < input.length(); i++) {
            check = check && Character.isDigit(input.charAt(i));
        }

        if (input.length() == 0) {
            check = false;
        }

        return check;
    }

    public static void main(String[] args) throws IOException {
        Utils utils = new Utils();
        utils.readTxtFile("/Users/justindiemmanuele/Documents/MS/CS611/HW3_MonstersAndHeros/Legends_Monsters_and_Heroes/Armory.txt");
        utils.readTxtFile("/Users/justindiemmanuele/Documents/MS/CS611/HW3_MonstersAndHeros/Legends_Monsters_and_Heroes/Dragons.txt");
        utils.readTxtFile("/Users/justindiemmanuele/Documents/MS/CS611/HW3_MonstersAndHeros/Legends_Monsters_and_Heroes/Weaponry.txt");
        utils.readTxtFile("/Users/justindiemmanuele/Documents/MS/CS611/HW3_MonstersAndHeros/Legends_Monsters_and_Heroes/Warriors.txt");
    }

}
