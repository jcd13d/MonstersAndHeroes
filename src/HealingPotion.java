public class HealingPotion extends Potion {

    public HealingPotion(String name, double cost, double reqLevel, double attributeIncrease) {
        super(name, cost, reqLevel, attributeIncrease);
        setAttributeIncrease(attributeIncrease);
    }

    public void feedPotion(Hero hero) {
        hero.increaseHealth(getAttributeIncrease());
    }
}
