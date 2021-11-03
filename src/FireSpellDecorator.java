public class FireSpellDecorator extends SpellDecorator{
    int monsterDefenseReduction;

    public FireSpellDecorator(Spell spell, String spellName, int monsterDefenseReduction) {
        super(spell);
        this.monsterDefenseReduction = monsterDefenseReduction;
        decoratedSpell.setName(spellName);
    }

    @Override
    public void use(BadGuy monster) {
        monster.inflictDamage(decoratedSpell.getDmgReduction());
        monster.reduceDefense(getMonsterDefenseReduction());
    }

    public int getMonsterDefenseReduction() {
        return monsterDefenseReduction;
    }

    public void setMonsterDefenseReduction(int monsterDefenseReduction) {
        this.monsterDefenseReduction = monsterDefenseReduction;
    }
}
