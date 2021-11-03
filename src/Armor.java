public class Armor extends Item {

    int dmgReduction;

    public Armor(String name, int cost, int reqLevel, int dmgReduction) {
        super(name, cost, reqLevel);
        this.dmgReduction = dmgReduction;
    }

    public int getDmgReduction() {
        return dmgReduction;
    }

    public void setDmgReduction(int dmgReduction) {
        this.dmgReduction = dmgReduction;
    }

    @Override
    public String toString() {
        return "Armor{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", reqLevel=" + reqLevel +
                ", dmgReduction=" + dmgReduction +
                '}';
    }

}
