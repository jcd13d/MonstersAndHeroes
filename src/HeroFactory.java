public class HeroFactory {

    public Hero getHero(String name, double mana, double strength, double agility, double dexterity, double money,
                   double exp, double hp, double defense, double startExp, String heroType) {

        if (heroType.equalsIgnoreCase("paladin")) {
            return new PaladinHero(name, mana, strength, agility, dexterity, money, exp, hp, defense, startExp, heroType);
        } else if (heroType.equalsIgnoreCase("sorcerer")) {
            return new SorcererHero(name, mana, strength, agility, dexterity, money, exp, hp, defense, startExp, heroType);
        } else if (heroType.equalsIgnoreCase("warrior")) {
            return new WarriorHero(name, mana, strength, agility, dexterity, money, exp, hp, defense, startExp, heroType);
        } else {
            return new GenericHero(name, mana, strength, agility, dexterity, money, exp, hp, defense, startExp, heroType);
        }

    }

}
