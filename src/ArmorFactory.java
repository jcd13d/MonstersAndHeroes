import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ArmorFactory extends HaMFactory {
    private int numArmors;
    private ArrayList<ArmorConfig> config;

    public ArmorFactory() {
        setFactoryName("Armor");
        config = new ArrayList<>();

        Path currentPath = Paths.get(System.getProperty("user.dir"));
        Path weaponPath = Paths.get(currentPath.toString(), "configs", "Armory.txt");
//        String[] files = {"/Users/justindiemmanuele/Documents/MS/CS611/HW3_MonstersAndHeros/Legends_Monsters_and_Heroes/Armory.txt"};
        String[] files = {weaponPath.toString()};

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
                config.add(new ArmorConfig(line[0],
                        Double.parseDouble(line[1]),
                        Double.parseDouble(line[2]),
                        Double.parseDouble(line[3])));
            }
        }

        numArmors = config.size();
    }

    public int getNumArmors() {
        return numArmors;
    }

    public void setNumArmors(int numArmors) {
        this.numArmors = numArmors;
    }

    public Armor getArmor(String name, double cost, double reqLevel, double dmgReduction) {
        return new Armor(name, cost, reqLevel, dmgReduction);
    }

    public Armor getArmorByIndex(int armorNumber) {
        ArmorConfig cfg = config.get(armorNumber);
        return getArmor(cfg.name, cfg.cost, cfg.reqLevel, cfg.dmgReduction);
    }

    public void printArmorMenu() {
        for (int i=0; i < config.size(); i++) {
            System.out.printf("%s:   %s\n", i, config.get(i));
        }
    }

    private class ArmorConfig {
        String name;
        double cost;
        double reqLevel;
        double dmgReduction;

        public ArmorConfig(String name, double cost, double reqLevel, double dmgReduction) {
            this.name = name;
            this.cost = cost;
            this.reqLevel = reqLevel;
            this.dmgReduction = dmgReduction;
        }

        @Override
        public String toString() {
            return "name='" + name + '\'' +
                    ", cost=" + cost +
                    ", reqLevel=" + reqLevel +
                    ", dmgReduction=" + dmgReduction;
        }
    }

    public static void main(String[] args) {
        WeaponFactory factory = new WeaponFactory();
        factory.printWeaponMenu();
    }
}
