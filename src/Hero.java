import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Hero extends Player{
    private Utils utils = new Utils();
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
    private ArrayList<Weapon> weapons;
    private ArrayList<Potion> potions;
    private ArrayList<Armor> armors;
    private ArrayList<Spell> spells;
    private String heroType;
    private Armor appliedArmor;
    private Weapon appliedWeapon;
    protected LevelUpBehavior levelUpBehavior;

    abstract void levelUp();

    public void castSpell(int spellNumber, Monster monster) {
        spells.get(spellNumber).use(monster, dexterity);
    }

    public void drinkPotion(int potionNumber) {
        potions.get(potionNumber).feedPotion(this);
    }

    public void attack(Monster monster) {
        double attackMultiplier = 0.1;
        double damage = (appliedWeapon == null) ? strength*attackMultiplier : (strength + appliedWeapon.getDamage())*attackMultiplier;
        boolean attkSuccessful = monster.inflictDamage(damage, false);
        if (attkSuccessful) {
            System.out.printf("%s inflicted %s damage on %s!!\n", this.getName(), damage, monster.getName());
        }
    }

    public boolean inflictDamage(double dmg) {
        double armorMultiplier = 1;
        double dodgeMultilier = 0.001;
        double randNum = ThreadLocalRandom.current().nextInt(0, 1000) / (double) 1000;
        if (appliedArmor != null) {
            dmg = Math.max(dmg - appliedArmor.getDmgReduction()*armorMultiplier, 0);
        }
        if (randNum < (agility * 0.0005)) {
            System.out.println("Hero dodged monster attack!");
            return false;
        } else {
            setHp(getHp() - dmg);
            return true;
        }
    }

    public boolean pay(double amt) {
        return setMoney(getMoney() - amt);
    }

    public boolean payHero(double amt) {
        return setMoney(getMoney() + amt);
    }

    public void addWeapon(Weapon weapon) {
        weapons.add(weapon);
    }

    public void addSpell(Spell spell) {
        spells.add(spell);
    }

    public void addArmor(Armor armor) {
        armors.add(armor);
    }

    public void addPotion(Potion potion) {
        potions.add(potion);
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

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(ArrayList<Weapon> weapons) {
        this.weapons = weapons;
    }

    public ArrayList<Potion> getPotions() {
        return potions;
    }

    public void setPotions(ArrayList<Potion> potions) {
        this.potions = potions;
    }

    public ArrayList<Armor> getArmors() {
        return armors;
    }

    public void setArmors(ArrayList<Armor> armors) {
        this.armors = armors;
    }

    public ArrayList<Spell> getSpells() {
        return spells;
    }

    public void setSpells(ArrayList<Spell> spells) {
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
        if (this.exp > getNextLevelPoints()) {
            levelUp();
        }
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        if (hp >= 0){
            this.hp = hp;
        } else {
            this.hp = 0;
        }
    }

    public void infoMenu() {
        System.out.println("Hero Stats:");
        System.out.println(this);
        String input = utils.getStringInput(infoMenuPrompt(), new StringInListChecker(Arrays.asList("exit", "equip")));
        if (input.equalsIgnoreCase("equip")) {
            equipMenu();
        } else {
            // exit
        }
    }

    public void equipMenu() {
        // hero print, shows equipped
        System.out.println("Hero equipped shown below:");
        System.out.println(this);
        // choose type of thing to equip
        System.out.println("Choose type of item to equip: \nweapons\narmor\ntype 'none' to exit\n");
        String input = utils.getStringInput("", new StringInListChecker(Arrays.asList("weapons", "armor", "none")));
        if (input.equalsIgnoreCase("armor")) {
            armorEquipMenu();
        } else if (input.equalsIgnoreCase("weapons")){
            weaponEquipMenu();
        } else {
            // nothing
        }
    }

    public void armorEquipMenu() {
        System.out.println("Please select armor to equip from the list below:");
        for (int i = 0; i < armors.size(); i++) {
            System.out.printf("%s:     %s\n", i, armors.get(i));
        }
        System.out.printf("%s:     exit\n", armors.size());
        int input = utils.getIntInput("", new RangeChecker(0, armors.size()));
        if (input < armors.size()) {
            setAppliedArmor(armors.get(input));
        }
        equipMenu();
    }

    public void weaponEquipMenu() {
        System.out.println("Please select weapon to equip from the list below:");
        for (int i = 0; i < weapons.size(); i++) {
            System.out.printf("%s:     %s\n", i, weapons.get(i));
        }
        System.out.printf("%s:     exit\n", weapons.size());
        int input = utils.getIntInput("", new RangeChecker(0, weapons.size()));
        if (input < weapons.size()) {
            setAppliedWeapon(weapons.get(input));
        }
        equipMenu();
    }

    private String infoMenuPrompt() {
        return "type 'equip' to manage items equipped or 'exit' to move to next hero";
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", exp=" + exp +
                ", money=" + money +
                ", level=" + level +
                ", hp=" + hp +
                ", mana=" + mana +
                ", dexterity=" + dexterity +
                ", agility=" + agility +
                ", strength=" + strength +
                ", equipped armor=" + appliedArmor +
                ", equipped weapon=" + appliedWeapon +
                ", heroType='" + heroType + '\'' +
                '}';
    }
}
