public class LightningSpellDecorator extends SpellDecorator {
    // add lightining functionality to a spell
    double monsterDodgeReduction;

    public LightningSpellDecorator(Spell spell, String spellName, double monsterDodgeReduction) {
        super(spell);
        this.monsterDodgeReduction = monsterDodgeReduction;
        decoratedSpell.setName(spellName);
    }

    @Override
    public void use(Monster monster, double dexterity) {
        monster.inflictDamage(decoratedSpell.getDmgReduction() + (decoratedSpell.getDmgReduction()*(dexterity/1000)), true);
        monster.reduceDodge(monster.getDodgeChance() * 0.9);
    }

    public double getMonsterDodgeReduction() {
        return monsterDodgeReduction;
    }

    public void setMonsterDodgeReduction(double monsterDodgeReduction) {
        this.monsterDodgeReduction = monsterDodgeReduction;
    }
}
