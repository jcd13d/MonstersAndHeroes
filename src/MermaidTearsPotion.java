public class MermaidTearsPotion extends Potion {

    public MermaidTearsPotion(int attributeIncrease) {
        this.attributeIncrease = attributeIncrease;
    }

    public void feedPotion(Hero hero) {
        hero.increaseHealth(attributeIncrease);
        hero.increaseMana(attributeIncrease);
        hero.increaseStrength(attributeIncrease);
        hero.inceraseAgility(attributeIncrease);
    }
}
