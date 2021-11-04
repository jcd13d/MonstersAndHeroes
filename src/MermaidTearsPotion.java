public class MermaidTearsPotion extends Potion {

    public MermaidTearsPotion(String name, double cost, double reqLevel, double attributeIncrease) {
        super(name, cost, reqLevel, attributeIncrease);
        setAttributeIncrease(attributeIncrease);
    }

    public void feedPotion(Hero hero) {
        hero.increaseHealth(getAttributeIncrease());
        hero.increaseMana(getAttributeIncrease());
        hero.increaseStrength(getAttributeIncrease());
        hero.inceraseAgility(getAttributeIncrease());
    }
}
