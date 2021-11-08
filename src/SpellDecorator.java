public abstract class SpellDecorator extends Spell {
    // general abstract spell decorator class
    protected Spell decoratedSpell;

    public SpellDecorator(Spell spell) {
        decoratedSpell = spell;
    }

    public void use(Monster monster, double dexterity) {
        monster.inflictDamage(decoratedSpell.getDmgReduction(), true);
    }
}
