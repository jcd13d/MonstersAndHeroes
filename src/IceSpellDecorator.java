public class IceSpellDecorator extends SpellDecorator{
    int monsterDmgReduction;

    public IceSpellDecorator(Spell spell, String spellName, int monsterDmgReduction) {
        super(spell);
        this.monsterDmgReduction = monsterDmgReduction;
        decoratedSpell.setName(spellName);
    }

    @Override
    public void use(BadGuy monster) {
        monster.inflictDamage(decoratedSpell.getDmgReduction());
        monster.reduceDamage(getMonsterDmgReduction());
    }

    public int getMonsterDmgReduction() {
        return monsterDmgReduction;
    }

    public void setMonsterDmgReduction(int monsterDmgReduction) {
        // TODO error checking?
        this.monsterDmgReduction = monsterDmgReduction;
    }

}
