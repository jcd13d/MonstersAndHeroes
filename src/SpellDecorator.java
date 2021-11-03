public abstract class SpellDecorator extends Spell {
    protected Spell decoratedSpell;

    public SpellDecorator(Spell spell) {
        decoratedSpell = spell;
    }

    public void use(BadGuy monster) {
        monster.inflictDamage(decoratedSpell.getDmgReduction());
    }
}
