public class GenericLevelUpBehavior implements LevelUpBehavior {
    public static final double PCT_INC = 1.05;
    public void levelUp(Hero hero) {
        hero.setLevel(hero.getLevel() + 1);
        hero.setHp(100*hero.getLevel());
        hero.setMana(hero.getMana()*1.1);
        hero.setNextLevelPoints(hero.getLevel()*10);
//        hero.setCurrentLevelPoints(hero.getCurrentLevelPoints());
        // inc all skills 5% strength, dexterity, agility
        hero.setStrength(hero.getStrength() * PCT_INC);
        hero.setDexterity(hero.getDexterity() * PCT_INC);
        hero.setAgility(hero.getAgility() * PCT_INC);
        // delegate extra skill increase to children
    }
}
