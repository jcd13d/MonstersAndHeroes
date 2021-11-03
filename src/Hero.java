public abstract class Hero {
    private String name;
    private double mana;
    private double strength;
    private double agility;
    private double dexterity;
    private double money;
    private double exp;
    private double level;
    private double nextLevelPoints;
    private double currentLevelPoints;
    private double hp;
    private double defense;
    private Armor appliedArmor;
    private Weapon appliedWeapon;
    protected LevelUpBehavior levelUpBehavior;

    abstract void levelUp();

    public void applyArmor(Armor armor) {
        setAppliedArmor(armor);
    }

    public void removeArmor() {
        setAppliedArmor(null);
    }

    public void increaseHealth(double amt) {
        setHp(getHp() + amt);
    }

    public void increaseStrength(double amt) {
        setStrength(getStrength() + amt);
    }

    public void increaseMana(double amt) {
        setMana(getMana() + amt);
    }

    public void inceraseAgility(double amt) {
        setAgility(getAgility() + amt);
    }

    public void increaseDexterity(double amt) {
        setDexterity(getDexterity() + amt);
    }

    public void increaseDefense(double amt) {
        // Todo should this be a monster attribute or related to armor?
        setDefense(getDefense() + amt);
    }

    public double getNextLevelPoints() {
        return nextLevelPoints;
    }

    public void setNextLevelPoints(double nextLevelPoints) {
        this.nextLevelPoints = nextLevelPoints;
    }

    public double getCurrentLevelPoints() {
        return currentLevelPoints;
    }

    public void setCurrentLevelPoints(double currentLevelPoints) {
        this.currentLevelPoints = currentLevelPoints;
    }

    public double getLevel() {
        return level;
    }

    public void setLevel(double level) {
        this.level = level;
    }

    public Armor getAppliedArmor() {
        return appliedArmor;
    }

    public void setAppliedArmor(Armor appliedArmor) {
        this.appliedArmor = appliedArmor;
    }

    public Weapon getAppliedWeapon() {
        return appliedWeapon;
    }

    public void setAppliedWeapon(Weapon appliedWeapon) {
        this.appliedWeapon = appliedWeapon;
    }

    public double getDefense() {
        return defense;
    }

    public void setDefense(double defense) {
        this.defense = defense;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMana() {
        return mana;
    }

    public void setMana(double mana) {
        this.mana = mana;
    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public double getAgility() {
        return agility;
    }

    public void setAgility(double agility) {
        this.agility = agility;
    }

    public double getDexterity() {
        return dexterity;
    }

    public void setDexterity(double dexterity) {
        this.dexterity = dexterity;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getExp() {
        return exp;
    }

    public void setExp(double exp) {
        this.exp = exp;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }
}
