public class LightningSpellDecorator extends SpellDecorator {
    double monsterDodgeReduction;

    public LightningSpellDecorator(Spell spell, String spellName, double monsterDodgeReduction) {
        super(spell);
        this.monsterDodgeReduction = monsterDodgeReduction;
        decoratedSpell.setName(spellName);
    }

    @Override
    public void use(BadGuy monster) {
        monster.inflictDamage(decoratedSpell.getDmgReduction());
        monster.reduceDodge(getMonsterDodgeReduction());
    }

    public double getMonsterDodgeReduction() {
        return monsterDodgeReduction;
    }

    public void setMonsterDodgeReduction(double monsterDodgeReduction) {
        // TODO error checking?
        this.monsterDodgeReduction = monsterDodgeReduction;
    }
}
