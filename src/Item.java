public abstract class Item {
    String name;
    int cost;
    int reqLevel;

    public Item() {
        this.name = null;
        this.cost = 0;
        this.reqLevel = 0;
    }

    public Item(String name, int cost, int reqLevel) {
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

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getReqLevel() {
        return reqLevel;
    }

    public void setReqLevel(int reqLevel) {
        this.reqLevel = reqLevel;
    }

}
