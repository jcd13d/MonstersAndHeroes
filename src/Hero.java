import java.util.ArrayList;
import java.util.HashMap;

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
    private HashMap<String, Weapon> weapons;
    private HashMap<String, Potion> potions;
    private HashMap<String, Armor> armors;
    private HashMap<String, Spell> spells;
    private String heroType;
    private Armor appliedArmor;
    private Weapon appliedWeapon;
    protected LevelUpBehavior levelUpBehavior;

    abstract void levelUp();

    public boolean pay(double amt) {
        return setMoney(getMoney() - amt);
    }

    public void addWeapon(Weapon weapon) {
        weapons.put(weapon.name, weapon);
    }

    public void addSpell(Spell spell) {
        spells.put(spell.getName(), spell);
    }

    public void addArmor(Armor armor) {
        armors.put(armor.getName(), armor);
    }

    public void addPotion(Potion potion) {
        potions.put(potion.getName(), potion);
    }

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

    public String getHeroType() {
        return heroType;
    }

    public void setHeroType(String heroType) {
        this.heroType = heroType;
    }

    public HashMap<String, Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(HashMap<String, Weapon> weapons) {
        this.weapons = weapons;
    }

    public HashMap<String, Potion> getPotions() {
        return potions;
    }

    public void setPotions(HashMap<String, Potion> potions) {
        this.potions = potions;
    }

    public HashMap<String, Armor> getArmors() {
        return armors;
    }

    public void setArmors(HashMap<String, Armor> armors) {
        this.armors = armors;
    }

    public HashMap<String, Spell> getSpells() {
        return spells;
    }

    public void setSpells(HashMap<String, Spell> spells) {
        this.spells = spells;
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

    public boolean setMoney(double money) {
        if (money >= 0) {
            this.money = money;
            return true;
        } else {
            return false;
        }
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

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", exp=" + exp +
                ", money=" + money +
                ", level=" + level +
                ", hp=" + hp +
                ", heroType='" + heroType + '\'' +
                '}';
    }
}
