public class Weapon extends Item {
    int damage;
    int reqHands;

    public Weapon(String name, int cost, int reqLevel, int damage, int reqHands) {
        super(name, cost, reqLevel);
        this.damage = damage;
        this.reqHands = reqHands;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getReqHands() {
        return reqHands;
    }

    public void setReqHands(int reqHands) {
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
