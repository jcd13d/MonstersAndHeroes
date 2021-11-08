public class AmbrosiaPotion extends Potion {
    // Class with specific logic for Ambrosia Poiton

    public AmbrosiaPotion(String name, double cost, double reqLevel, double attributeIncrease) {
        super(name, cost, reqLevel, attributeIncrease);
        setAttributeIncrease(attributeIncrease);
    }

    @Override
    public void feedPotion(Hero hero) {
        // specific ambrosia effect
        hero.increaseHealth(getAttributeIncrease());
        hero.increaseMana(getAttributeIncrease());
        hero.increaseStrength(getAttributeIncrease());
        hero.inceraseAgility(getAttributeIncrease());
        hero.increaseDexterity(getAttributeIncrease());
        hero.increaseDefense(getAttributeIncrease());
    }
}
