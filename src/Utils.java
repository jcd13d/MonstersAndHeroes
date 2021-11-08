import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Utils {
    // general I/O for M a H

    Scanner scanner = new Scanner(System.in);

    // get config file as a list of arrays of each line
    public ArrayList<String[]> readTxtFile(String filename) throws IOException {
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

}
