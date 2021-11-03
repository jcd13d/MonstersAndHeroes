public class PaladinHero extends GenericHero {

    public PaladinHero(String name, double mana, double strength, double agility, double dexterity, double money,
                       double exp, double hp, double defense, double startExp) {
        super(name, mana, strength, agility, dexterity, money, exp, hp, defense, startExp);
        levelUpBehavior = new PaladinLevelUpBehavior();
    }

}
