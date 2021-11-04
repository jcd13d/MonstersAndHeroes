public class AmbrosiaPotion extends Potion {

    public AmbrosiaPotion(String name, double cost, double reqLevel, double attributeIncrease) {
        super(name, cost, reqLevel, attributeIncrease);
        setAttributeIncrease(attributeIncrease);
    }

    @Override
    public void feedPotion(Hero hero) {
        hero.increaseHealth(getAttributeIncrease());
        hero.increaseMana(getAttributeIncrease());
        hero.increaseStrength(getAttributeIncrease());
        hero.inceraseAgility(getAttributeIncrease());
        hero.increaseDexterity(getAttributeIncrease());
        hero.increaseDefense(getAttributeIncrease());
    }
}
