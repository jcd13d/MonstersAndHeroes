public class WarriorHero extends GenericHero{

    public WarriorHero(String name, double mana, double strength, double agility, double dexterity, double money,
                       double exp, double hp, double defense, double startExp, String heroType) {
        super(name, mana, strength, agility, dexterity, money, exp, hp, defense, startExp, heroType);
        levelUpBehavior = new WarriorLevelUpBehavior();
    }

}
