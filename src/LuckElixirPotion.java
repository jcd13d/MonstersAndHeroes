public class LuckElixirPotion extends Potion {
    // LE specific logic

    public LuckElixirPotion(String name, double cost, double reqLevel, double attributeIncrease) {
        super(name, cost, reqLevel, attributeIncrease);
        setAttributeIncrease(attributeIncrease);
    }

    public void feedPotion(Hero hero) {
        hero.inceraseAgility(getAttributeIncrease());
    }
}
