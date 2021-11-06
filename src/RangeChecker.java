public class RangeChecker implements IntChecker {
    public static final String DEFAULT_ERROR_MESSAGE = "Number out of range!! Please try again.";
    String errorMessage;
    int minRange;
    int maxRange;

    public RangeChecker(int minRange, int maxRange) {
        this(minRange, maxRange, DEFAULT_ERROR_MESSAGE);
    }

    public RangeChecker(int minRange, int maxRange, String errorMessage) {
        this.minRange= minRange;
        this.maxRange= maxRange;
        this.errorMessage = errorMessage;
    }

    public boolean check(int input) {
        boolean result = (input >= minRange) & (input <= maxRange);
        if(!result) System.out.println(DEFAULT_ERROR_MESSAGE);
        return result;
    }

}
