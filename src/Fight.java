import java.util.ArrayList;
import java.util.List;

public class Fight {
    private List<Hero> heroes;
    private List<Monster> monsters;
    private double maxLevel;
    private MonsterFactory monsterFactory;

    public Fight(List<Hero> heroes) {
        this.heroes = heroes;
        this.maxLevel = getMaxHeroLevel();
    }

    private void initMonsters() {
        for (int i = 0; i < heroes.size(); i++) {

        }

    }

    private double getMaxHeroLevel() {
        double maxLevel = 0;
        for (Hero hero : heroes) {
            if (maxLevel < hero.getLevel()) maxLevel = hero.getLevel();
        }
        return maxLevel;
    }

    public void startFight() {

    }

    public



}
