public class Armor extends Item {

    double dmgReduction;

    public Armor(String name, double cost, double reqLevel, double dmgReduction) {
        super(name, cost, reqLevel);
        this.dmgReduction = dmgReduction;
    }

    public double getDmgReduction() {
        return dmgReduction;
    }

    public void setDmgReduction(double dmgReduction) {
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
