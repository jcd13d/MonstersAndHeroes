import java.util.List;

public class StringInListChecker implements StringChecker {
    // checks if entered string exists in a list or not
    public static final String DEFAULT_ERROR_MESSAGE = "String entered not valid!";
    String errorMessage;
    List<String> validStrings;

    public StringInListChecker(List<String> validStrings) {
        this(validStrings, DEFAULT_ERROR_MESSAGE);
    }

    public StringInListChecker(List<String> validStrings, String errorMessage) {
        this.validStrings = validStrings;
        this.errorMessage = errorMessage;
    }

    // that string better be in the list!
    public boolean check(String input) {
        boolean check = validStrings.stream().anyMatch(input::equalsIgnoreCase);
        if (!check) {
            System.out.println(DEFAULT_ERROR_MESSAGE);
        }
        return check;
    }
}
