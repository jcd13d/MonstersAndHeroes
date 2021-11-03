public class Spell extends Item {
    int dmgReduction;
    int manaCost;

    public Spell() {
    }

    public Spell(String name, int cost, int reqLevel, int dmgReduction, int manaCost) {
        super(name, cost, reqLevel);
        this.dmgReduction = dmgReduction;
        this.manaCost = manaCost;
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

    public void use(BadGuy monster) {
        monster.inflictDamage(getDmgReduction());
    }

}
