public class FireSpellDecorator extends SpellDecorator{
    double monsterDefenseReduction;

    public FireSpellDecorator(Spell spell, String spellName, double monsterDefenseReduction) {
        super(spell);
        this.monsterDefenseReduction = monsterDefenseReduction;
        decoratedSpell.setName(spellName);
    }

    @Override
    public void use(BadGuy monster) {
        monster.inflictDamage(decoratedSpell.getDmgReduction());
        monster.reduceDefense(getMonsterDefenseReduction());
    }

    public double getMonsterDefenseReduction() {
        return monsterDefenseReduction;
    }

    public void setMonsterDefenseReduction(int monsterDefenseReduction) {
        this.monsterDefenseReduction = monsterDefenseReduction;
    }
}
