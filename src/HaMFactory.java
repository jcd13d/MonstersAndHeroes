import java.util.ArrayList;
import java.util.HashMap;

public abstract class HaMFactory {
    // abstract factory for M and H

    private String factoryName;

    protected Utils utils = new Utils();

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }
}