public class StrengthPotion extends Potion {

    public StrengthPotion(String name, double cost, double reqLevel, double attributeIncrease) {
        super(name, cost, reqLevel, attributeIncrease);
        setAttributeIncrease(attributeIncrease);
    }

    public void feedPotion(Hero hero) {
        hero.increaseStrength(getAttributeIncrease());
    }
}
