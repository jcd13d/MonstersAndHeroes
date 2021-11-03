public class IceSpellDecorator extends SpellDecorator{
    double monsterDmgReduction;

    public IceSpellDecorator(Spell spell, String spellName, double monsterDmgReduction) {
        super(spell);
        this.monsterDmgReduction = monsterDmgReduction;
        decoratedSpell.setName(spellName);
    }

    @Override
    public void use(BadGuy monster) {
        monster.inflictDamage(decoratedSpell.getDmgReduction());
        monster.reduceDamage(getMonsterDmgReduction());
    }

    public double getMonsterDmgReduction() {
        return monsterDmgReduction;
    }

    public void setMonsterDmgReduction(double monsterDmgReduction) {
        // TODO error checking?
        this.monsterDmgReduction = monsterDmgReduction;
    }

}
