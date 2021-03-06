public class PaladinHero extends GenericHero {
    // paladin hero - overrides level up behavior to be specific for paladins

    public PaladinHero(String name, double mana, double strength, double agility, double dexterity, double money,
                       double exp, double hp, double defense, double startExp, String heroType) {
        super(name, mana, strength, agility, dexterity, money, exp, hp, defense, startExp, heroType);
        levelUpBehavior = new PaladinLevelUpBehavior();
    }

}
