public class IceSpellDecorator extends SpellDecorator{
    // add ice functionality to a spell

    double monsterDmgReduction;

    public IceSpellDecorator(Spell spell, String spellName, double monsterDmgReduction) {
        super(spell);
        this.monsterDmgReduction = monsterDmgReduction;
        decoratedSpell.setName(spellName);
    }

    @Override
    public void use(Monster monster, double dexterity) {
        monster.inflictDamage(decoratedSpell.getDmgReduction() + (decoratedSpell.getDmgReduction()*(dexterity/1000)), true);
        monster.reduceDamage(monster.getDamage() * 0.9);
    }

    public double getMonsterDmgReduction() {
        return monsterDmgReduction;
    }

    public void setMonsterDmgReduction(double monsterDmgReduction) {
        // TODO error checking?
        this.monsterDmgReduction = monsterDmgReduction;
    }

}
