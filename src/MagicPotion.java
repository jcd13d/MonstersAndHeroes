public class MagicPotion extends Potion {

    public MagicPotion(int attributeIncrease) {
        this.attributeIncrease = attributeIncrease;
    }

    public void feedPotion(Hero hero) {
        hero.increaseMana(attributeIncrease);
    }
}
