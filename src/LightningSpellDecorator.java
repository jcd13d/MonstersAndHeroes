public class LightningSpellDecorator extends SpellDecorator {
    int monsterDodgeReduction;

    public LightningSpellDecorator(Spell spell, String spellName, int monsterDodgeReduction) {
        super(spell);
        this.monsterDodgeReduction = monsterDodgeReduction;
        decoratedSpell.setName(spellName);
    }

    @Override
    public void use(BadGuy monster) {
        monster.inflictDamage(decoratedSpell.getDmgReduction());
        monster.reduceDodge(getMonsterDodgeReduction());
    }

    public int getMonsterDodgeReduction() {
        return monsterDodgeReduction;
    }

    public void setMonsterDodgeReduction(int monsterDodgeReduction) {
        // TODO error checking?
        this.monsterDodgeReduction = monsterDodgeReduction;
    }
}
