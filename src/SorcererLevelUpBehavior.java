public class SorcererLevelUpBehavior extends GenericLevelUpBehavior{
    // how a sorcerer levels up
    public void levelUp(Hero hero) {
        super.levelUp(hero);
        hero.setAgility(hero.getAgility() * PCT_INC);
        hero.setDexterity(hero.getDexterity() * PCT_INC);
    }
}
