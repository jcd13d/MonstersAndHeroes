public class Potion extends Item {
    // general pption class
    private double attributeIncrease;

    public Potion(String name, double cost, double reqLevel, double attributeIncrease) {
        setName(name);
        setCost(cost);
        setReqLevel(reqLevel);
        setAttributeIncrease(attributeIncrease);
    }

    public void feedPotion(Hero hero) {
        // overwrite in sub class
    }

    public double getAttributeIncrease() {
        return attributeIncrease;
    }

    public void setAttributeIncrease(double attributeIncrease) {
        this.attributeIncrease = attributeIncrease;
    }

}
