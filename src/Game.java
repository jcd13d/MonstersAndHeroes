public abstract class Game {
    // class for all games

    private String name;
    protected Utils utils;

    abstract void playGame();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

