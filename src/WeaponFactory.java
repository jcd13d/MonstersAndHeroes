public class WeaponFactory {
    public Weapon getWeapon(String name, int cost, int reqLevel, int damage, int reqHands) {
        return new Weapon(name, cost, reqLevel, damage, reqHands);
    }
}
