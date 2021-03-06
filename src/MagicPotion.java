public class MagicPotion extends Potion {
    //MP specific logic

    public MagicPotion(String name, double cost, double reqLevel, double attributeIncrease) {
        super(name, cost, reqLevel, attributeIncrease);
        setAttributeIncrease(attributeIncrease);
    }

    public void feedPotion(Hero hero) {
        hero.increaseMana(getAttributeIncrease());
    }
}
