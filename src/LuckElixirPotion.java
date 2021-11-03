public class LuckElixirPotion extends Potion {

    public LuckElixirPotion(int attributeIncrease) {
        this.attributeIncrease = attributeIncrease;
    }

    public void feedPotion(Hero hero) {
        hero.inceraseAgility(attributeIncrease);
    }
}
