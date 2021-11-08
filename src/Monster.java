import java.util.concurrent.ThreadLocalRandom;

public class Monster extends Player implements BadGuy {
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

    public void attack(Hero hero) {
        double attackMultiplier = .5;
        double dmg = damage * attackMultiplier;
        boolean attkSuccessful = hero.inflictDamage(dmg);
        if (attkSuccessful) {
            System.out.printf("%s inflicted %s damage on %s!!\n", this.getName(), dmg, hero.getName());
        }
    }

    public boolean inflictDamage(double dmg, boolean bypassDodge) {
        double dodgeChanceMultiplier = 0.01;
        double randNum = ThreadLocalRandom.current().nextInt(0, 1000) / (double) 1000;
        if ((randNum < dodgeChance*dodgeChanceMultiplier) & !bypassDodge) {
            System.out.println("Monster dodged hero attack!");
            return false;
        } else {
            setHp(getHp() - Math.max(dmg - defense*.2, 0));
            return true;
        }
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
        if (hp >= 0) {
            this.hp = hp;
        } else {
            this.hp = 0;
        }
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

    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", hp=" + hp +
                ", level=" + level +
                ", damage=" + damage +
                ", defense=" + defense +
                ", dodgeChance=" + dodgeChance +
                '}';
    }
}
