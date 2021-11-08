public class HealingPotion extends Potion {
    // class defining special logic for healing potions

    public HealingPotion(String name, double cost, double reqLevel, double attributeIncrease) {
        super(name, cost, reqLevel, attributeIncrease);
        setAttributeIncrease(attributeIncrease);
    }

    public void feedPotion(Hero hero) {
        hero.increaseHealth(getAttributeIncrease());
    }
}
