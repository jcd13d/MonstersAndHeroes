public class Spell extends Item {
    double dmgReduction;
    double manaCost;
    String spellType;

    public Spell() {
    }

    public Spell(String name, double cost, double reqLevel, double dmgReduction, double manaCost, String spellType) {
        super(name, cost, reqLevel);
        this.dmgReduction = dmgReduction;
        this.manaCost = manaCost;
        this.spellType = spellType;
    }

    public double getDmgReduction() {
        return dmgReduction;
    }

    public void setDmgReduction(double dmgReduction) {
        this.dmgReduction = dmgReduction;
    }

    public double getManaCost() {
        return manaCost;
    }

    public void setManaCost(double manaCost) {
        this.manaCost = manaCost;
    }

    public String getSpellType() {
        return spellType;
    }

    public void setSpellType(String spellType) {
        this.spellType = spellType;
    }

    public void use(BadGuy monster) {
        monster.inflictDamage(getDmgReduction());
    }

}
