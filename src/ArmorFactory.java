public class ArmorFactory {
    public Armor getArmor(String name, int cost, int reqLevel, int dmgReduction) {
        return new Armor(name, cost, reqLevel, dmgReduction);
    }
}
