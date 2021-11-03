public class GenericHero extends Hero {
    public GenericHero(String name, double mana, double strength, double agility, double dexterity, double money,
                       double exp, double hp, double defense, double startExp) {
        setName(name);
        setMana(mana);
        setStrength(strength);
        setAgility(agility);
        setDexterity(dexterity);
        setMoney(money);
        setExp(exp);
        setHp(hp);
        setDefense(defense);
        setAppliedArmor(null);
        setAppliedWeapon(null);
        levelUpBehavior = new GenericLevelUpBehavior();
        setLevel(1);
        setCurrentLevelPoints(startExp);
        setNextLevelPoints(startExp * 10);
    }

    public void levelUp() {
        levelUpBehavior.levelUp(this);
    }

}
