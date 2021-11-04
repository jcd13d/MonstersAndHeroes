public class Monster implements BadGuy {
    String name;
    String type;
    double hp;
    double level;
    double damage;
    double defense;
    double dodgeChance;

    public Monster(String name, double hp, double level, double damage, double defense, double dodgeChance, String monsterType) {
        this.name = name;
        this.hp = hp;
        this.level = level;
        this.damage = damage;
        this.defense = defense;
        this.dodgeChance = dodgeChance;
        this.type = monsterType;
    }

    public void inflictDamage(double dmg) {
        setHp(getHp() - dmg);
    }

    public void reduceDamage(double dmgReduction) {
        setDamage(getDamage() - dmgReduction);
    }

    public void reduceDefense(double defenseReduction) {
        setDefense(getDefense() - defenseReduction);
    }

    public void reduceDodge(double dodgeReduction) {
        setDodgeChance(getDodgeChance() - dodgeReduction);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        // TODO: a check to make this zero if goes below zero?
        this.hp = hp;
    }

    public double getLevel() {
        return level;
    }

    public void setLevel(double level) {
        this.level = level;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        // TODO error checking, floor to damage of zero?
        this.damage = damage;
    }

    public double getDefense() {
        return defense;
    }

    public void setDefense(double defense) {
        // TODO error checking, floor to damage of zero?
        this.defense = defense;
    }

    public double getDodgeChance() {
        return dodgeChance;
    }

    public void setDodgeChance(double dodgeChance) {
        // TODO error checking, floor to damage of zero?
        this.dodgeChance = dodgeChance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
