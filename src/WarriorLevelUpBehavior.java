public class WarriorLevelUpBehavior extends GenericLevelUpBehavior{
    // how warriors level up
    public void levelUp(Hero hero) {
        super.levelUp(hero);
        hero.setStrength(hero.getStrength() * PCT_INC);
        hero.setAgility(hero.getAgility() * PCT_INC);
    }
}
