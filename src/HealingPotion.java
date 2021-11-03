public class HealingPotion extends Potion {

    public HealingPotion(int attributeIncrease) {
        this.attributeIncrease = attributeIncrease;
    }

    public void feedPotion(Hero hero) {
        hero.increaseHealth(attributeIncrease);
    }
}
