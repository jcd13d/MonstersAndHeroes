public class PaladinLevelUpBehavior extends GenericLevelUpBehavior {
    public void levelUp(Hero hero) {
        super.levelUp(hero);
        hero.setStrength(hero.getStrength() * PCT_INC);
        hero.setDexterity(hero.getDexterity() * PCT_INC);
    }
}
