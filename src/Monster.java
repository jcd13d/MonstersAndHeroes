public class Monster implements BadGuy {
    String name;
    String type;
    int hp;
    int level;
    int damage;
    int defense;
    int dodgeChance;

    public Monster(String name, int hp, int level, int damage, int defense, int dodgeChance) {
        this.name = name;
        this.hp = hp;
        this.level = level;
        this.damage = damage;
        this.defense = defense;
        this.dodgeChance = dodgeChance;
    }

    public void inflictDamage(int dmg) {
        setHp(getHp() - dmg);
    }

    public void reduceDamage(int dmgReduction) {
        setDamage(getDamage() - dmgReduction);
    }

    public void reduceDefense(int defenseReduction) {
        setDefense(getDefense() - defenseReduction);
    }

    public void reduceDodge(int dodgeReduction) {
        setDodgeChance(getDodgeChance() - dodgeReduction);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        // TODO: a check to make this zero if goes below zero?
        this.hp = hp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        // TODO error checking, floor to damage of zero?
        this.damage = damage;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        // TODO error checking, floor to damage of zero?
        this.defense = defense;
    }

    public int getDodgeChance() {
        return dodgeChance;
    }

    public void setDodgeChance(int dodgeChance) {
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
