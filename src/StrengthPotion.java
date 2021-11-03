public class StrengthPotion extends Potion {

    public StrengthPotion(int attributeIncrease) {
        this.attributeIncrease = attributeIncrease;
    }

    public void feedPotion(Hero hero) {
        hero.increaseStrength(attributeIncrease);
    }
}
