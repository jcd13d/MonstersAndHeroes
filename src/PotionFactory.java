import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class PotionFactory extends HaMFactory{
    private int numPotions;
    private ArrayList<PotionConfig> config;

    public PotionFactory() {
        setFactoryName("Potions");
        config = new ArrayList<>();
        Path currentPath = Paths.get(System.getProperty("user.dir"));
        Path potionsPath = Paths.get(currentPath.toString(), "configs", "Potions.txt");

        String[] files = {
                potionsPath.toString()
        };

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
                config.add(new PotionConfig(line[0],
                        Double.parseDouble(line[1]),
                        Double.parseDouble(line[2]),
                        Double.parseDouble(line[3])));
            }
        }

        numPotions = config.size();
    }

    public int getNumPotions() {
        return numPotions;
    }

    public Potion getPotionByIndex(int potionNumber){
        PotionConfig cfg = config.get(potionNumber);
        return getPotion(cfg.name, cfg.cost, cfg.reqLevel, cfg.attributeIncrease);
    }

    public void printPotionMenu() {
        for (int i=0; i < config.size(); i++) {
            System.out.printf("%s:   %s\n", i, config.get(i));
        }
    }

    public Potion getPotion(String name, double cost, double reqLevel, double attributeIncrease) {
        if (name.equalsIgnoreCase("healing_potion")) {
            return new HealingPotion(name, cost, reqLevel, attributeIncrease);
        } else if (name.equalsIgnoreCase("ambrosia")) {
            return new AmbrosiaPotion(name, cost, reqLevel, attributeIncrease);
        } else if (name.equalsIgnoreCase("strength_potion")) {
            return new StrengthPotion(name, cost, reqLevel, attributeIncrease);
        } else if (name.equalsIgnoreCase("magic_potion")) {
            return new MagicPotion(name, cost, reqLevel, attributeIncrease);
        } else if (name.equalsIgnoreCase("luck_elixir")) {
            return new LuckElixirPotion(name, cost, reqLevel, attributeIncrease);
        } else if (name.equalsIgnoreCase("mermaid_tears")) {
            return new MermaidTearsPotion(name, cost, reqLevel, attributeIncrease);
        } else {
            return null;
        }
    }

    private class PotionConfig {
        public String name;
        public double cost;
        public double reqLevel;
        public double attributeIncrease;

        public PotionConfig(String name, double cost, double reqLevel, double attributeIncrease) {
            this.name = name;
            this.cost = cost;
            this.reqLevel = reqLevel;
            this.attributeIncrease = attributeIncrease;
        }

        @Override
        public String toString() {
            return "name='" + name + '\'' +
                    ", cost=" + cost +
                    ", reqLevel=" + reqLevel +
                    ", attributeIncrease=" + attributeIncrease +
                    ", Special Power=" + getSpecialString(name);
        }
    }

    public String getSpecialString(String name) {
        if (name.equalsIgnoreCase("healing_potion")) {
            return "Increases health";
        } else if (name.equalsIgnoreCase("ambrosia")) {
            return "Increases all attributes";
        } else if (name.equalsIgnoreCase("strength_potion")) {
            return "Increases strength";
        } else if (name.equalsIgnoreCase("magic_potion")) {
            return "Increases mana";
        } else if (name.equalsIgnoreCase("luck_elixir")) {
            return "Increases agility";
        } else if (name.equalsIgnoreCase("mermaid_tears")) {
            return "Increases health, mana, strength, agility";
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        PotionFactory factory = new PotionFactory();
        factory.printPotionMenu();
    }

}
