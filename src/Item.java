public abstract class Item {
    String name;
    double cost;
    double reqLevel;

    public Item() {
        this.name = null;
        this.cost = 0;
        this.reqLevel = 0;
    }

    public Item(String name, double cost, double reqLevel) {
        this.name = name;
        this.cost = cost;
        this.reqLevel = reqLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getReqLevel() {
        return reqLevel;
    }

    public void setReqLevel(double reqLevel) {
        this.reqLevel = reqLevel;
    }

}
