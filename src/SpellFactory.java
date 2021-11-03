public class SpellFactory {
    public Spell getSpell(String name, int cost, int reqLevel, int dmgReduction, int manaCost, String spellType, double monsterReduction) {
        Spell spell = new Spell(name, cost, reqLevel, dmgReduction, manaCost, spellType);
        if (spellType.equalsIgnoreCase("fire")) {
            return new FireSpellDecorator(spell, spellType, monsterReduction);
        } else if (spellType.equalsIgnoreCase("ice")) {
            return new IceSpellDecorator(spell, spellType, monsterReduction);
        } else if (spellType.equalsIgnoreCase("lightning")) {
            return new LightningSpellDecorator(spell, spellType, monsterReduction);
        } else {
            return spell;
        }
    }
}
