public class Spell extends Item {
    int dmgReduction;
    int manaCost;
    String spellType;

    public Spell() {
    }

    public Spell(String name, int cost, int reqLevel, int dmgReduction, int manaCost, String spellType) {
        super(name, cost, reqLevel);
        this.dmgReduction = dmgReduction;
        this.manaCost = manaCost;
        this.spellType = spellType;
    }

    public int getDmgReduction() {
        return dmgReduction;
    }

    public void setDmgReduction(int dmgReduction) {
        this.dmgReduction = dmgReduction;
    }

    public int getManaCost() {
        return manaCost;
    }

    public void setManaCost(int manaCost) {
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
