import java.util.ArrayList;

public class GenericHero extends Hero {
    // Generic hero with no extra logic

    public GenericHero(String name, double mana, double strength, double agility, double dexterity, double money,
                       double exp, double hp, double defense, double startExp, String heroType) {
        setName(name);
        setMana(mana);
        setStrength(strength);
        setAgility(agility);
        setDexterity(dexterity);
        setMoney(money);
        setDefense(defense);
        setAppliedArmor(null);
        setAppliedWeapon(null);
        levelUpBehavior = new GenericLevelUpBehavior(); // strategy pattern
        setLevel(1);
        setHp(100*getLevel());
        setNextLevelPoints(getLevel() * 10);
        setExp(exp);
        setHeroType(heroType);
        setArmors(new ArrayList<>());
        setWeapons(new ArrayList<>());
        setPotions(new ArrayList<>());
        setSpells(new ArrayList<>());
    }

    public void levelUp() {
        levelUpBehavior.levelUp(this);
    }

}
