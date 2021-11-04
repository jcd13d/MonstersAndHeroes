public class PotionFactory {
    public Potion getPotion(String name, double cost, double reqLevel, double attributeIncrease) {
        if (name.equalsIgnoreCase("healing")) {
            return new HealingPotion(name, cost, reqLevel, attributeIncrease);
        } else if (name.equalsIgnoreCase("ambrosia")) {
            return new AmbrosiaPotion(name, cost, reqLevel, attributeIncrease);
        } else if (name.equalsIgnoreCase("strength")) {
            return new StrengthPotion(name, cost, reqLevel, attributeIncrease);
        } else if (name.equalsIgnoreCase("magic")) {
            return new MagicPotion(name, cost, reqLevel, attributeIncrease);
        } else if (name.equalsIgnoreCase("luck elixir")) {
            return new LuckElixirPotion(name, cost, reqLevel, attributeIncrease);
        } else if (name.equalsIgnoreCase("mermaid tears")) {
            return new MermaidTearsPotion(name, cost, reqLevel, attributeIncrease);
        } else {
            return null;
        }
    }
}
