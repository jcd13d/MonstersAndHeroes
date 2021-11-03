public class AmbrosiaPotion extends Potion {

    public AmbrosiaPotion(int attributeIncrease) {
        this.attributeIncrease = attributeIncrease;
    }

    public void feedPotion(Hero hero) {
        hero.increaseHealth(attributeIncrease);
        hero.increaseMana(attributeIncrease);
        hero.increaseStrength(attributeIncrease);
        hero.inceraseAgility(attributeIncrease);
        hero.increaseDexterity(attributeIncrease);
        hero.increaseDefense(attributeIncrease);
    }
}
