import java.util.ArrayList;
import java.util.HashMap;

public abstract class HaMFactory {
    private String factoryName;

    protected Utils utils = new Utils();
//    protected HashMap<String, ArrayList<String[]>> configs = new HashMap<>();


    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }
}