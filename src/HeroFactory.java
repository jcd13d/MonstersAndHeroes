import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HeroFactory extends HaMFactory {
    // factory to produce heroes

    private ArrayList<HeroConfig> config;
    private int numHeroes;

    public HeroFactory() {
        config = new ArrayList<>();

        // OS agnostic config read
        Path currentPath = Paths.get(System.getProperty("user.dir"));
        Path warriorPath = Paths.get(currentPath.toString(), "configs", "Warriors.txt");
        Path sorcererPath = Paths.get(currentPath.toString(), "configs", "Sorcerers.txt");
        Path paladinPath = Paths.get(currentPath.toString(), "configs", "Paladins.txt");

        String[] files = {
                warriorPath.toString(),
                sorcererPath.toString(),
                paladinPath.toString()
        };

        // read from config and load config objects that aid object creation
        ArrayList<String[]> fileContents = new ArrayList<>();
        String[] line;
        File path;
        for (String file : files) {
            path = new File(file);
            try {
                fileContents = utils.readTxtFile(file);
            } catch (IOException e) {
                System.out.println("unable to read file");
            }

            for (int i=1; i < fileContents.size(); i++) {
                line = fileContents.get(i);
                config.add(new HeroConfig(line[0],
                        Double.parseDouble(line[1]),
                        Double.parseDouble(line[2]),
                        Double.parseDouble(line[3]),
                        Double.parseDouble(line[4]),
                        Double.parseDouble(line[5]),
                        Double.parseDouble(line[6]),
                        path.getName().split("\\.")[0]));
            }
        }

        numHeroes = config.size();

    }

    public void printPlayerMenu() {
        for (int i=0; i < config.size(); i++) {
            System.out.printf("%s:   %s\n", i, config.get(i));
        }
    }

    public Hero getHero(String name, double mana, double strength, double agility, double dexterity, double money,
                   double exp, double hp, double defense, double startExp, String heroType) {

        if (heroType.equalsIgnoreCase("paladins")) {
            return new PaladinHero(name, mana, strength, agility, dexterity, money, exp, hp, defense, startExp, heroType);
        } else if (heroType.equalsIgnoreCase("sorcerers")) {
            return new SorcererHero(name, mana, strength, agility, dexterity, money, exp, hp, defense, startExp, heroType);
        } else if (heroType.equalsIgnoreCase("warriors")) {
            return new WarriorHero(name, mana, strength, agility, dexterity, money, exp, hp, defense, startExp, heroType);
        } else {
            return new GenericHero(name, mana, strength, agility, dexterity, money, exp, hp, defense, startExp, heroType);
        }

    }

    public Hero getHeroByIndex(int heroNumber) {
        HeroConfig cfg = config.get(heroNumber);
        return getHero(cfg.name, cfg.mana, cfg.strength, cfg.agility, cfg.dexterity, cfg.money, cfg.exp,
                100, 100, cfg.exp, cfg.category);
    }

    public int getNumHeroes() {
        return numHeroes;
    }

    // class to aid in reading in configs and then init heroes
    private class HeroConfig {
        public String name;
        public double mana;
        public double strength;
        public double agility;
        public double dexterity;
        public double money;
        public double exp;
        public String category;

        public HeroConfig(String name, double mana, double strength, double agility, double dexterity, double money,
                          double exp, String category) {
            this.name = name;
            this.mana = mana;
            this.strength = strength;
            this.agility = agility;
            this.dexterity = dexterity;
            this.money = money;
            this.exp = exp;
            this.category = category;
        }

        @Override
        public String toString() {
            return "name='" + name + '\'' +
                    ", mana=" + mana +
                    ", strength=" + strength +
                    ", agility=" + agility +
                    ", dexterity=" + dexterity +
                    ", money=" + money +
                    ", exp=" + exp +
                    ", category='" + category + '\'';
        }
    }

}
