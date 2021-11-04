public class Potion extends Item {
    private double attributeIncrease;

    public Potion(String name, double cost, double reqLevel, double attributeIncrease) {
        setName(name);
        setCost(cost);
        setReqLevel(reqLevel);
        setAttributeIncrease(attributeIncrease);
    }

    public void feedPotion(Hero hero) {
        // overwrite
    }

    public double getAttributeIncrease() {
        return attributeIncrease;
    }

    public void setAttributeIncrease(double attributeIncrease) {
        this.attributeIncrease = attributeIncrease;
    }

}
