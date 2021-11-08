public class FireSpellDecorator extends SpellDecorator{
    // decorator to add fire functionality to spell
    double monsterDefenseReduction;

    public FireSpellDecorator(Spell spell, String spellName, double monsterDefenseReduction) {
        super(spell);
        this.monsterDefenseReduction = monsterDefenseReduction;
        decoratedSpell.setName(spellName);
    }

    @Override
    public void use(Monster monster, double dexterity) {
        monster.inflictDamage(decoratedSpell.getDmgReduction() + (decoratedSpell.getDmgReduction()*(dexterity/1000)), true);
        monster.reduceDefense(monster.getDefense() * 0.9);
    }

    public double getMonsterDefenseReduction() {
        return monsterDefenseReduction;
    }

    public void setMonsterDefenseReduction(int monsterDefenseReduction) {
        this.monsterDefenseReduction = monsterDefenseReduction;
    }
}
