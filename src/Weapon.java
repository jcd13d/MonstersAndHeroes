public class Weapon extends Item {
    // weapon class
    double damage;
    double reqHands;

    public Weapon(String name, double cost, double reqLevel, double damage, double reqHands) {
        super(name, cost, reqLevel);
        this.damage = damage;
        this.reqHands = reqHands;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public double getReqHands() {
        return reqHands;
    }

    public void setReqHands(double reqHands) {
        this.reqHands = reqHands;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", reqLevel=" + reqLevel +
                ", damage=" + damage +
                ", reqHands=" + reqHands +
                '}';
    }
}
