import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class WeaponFactory extends HeroFactory {
    private int numWeapons;
    private ArrayList<WeaponConfig> config;

    public WeaponFactory() {
        config = new ArrayList<>();
        String[] files = {"/Users/justindiemmanuele/Documents/MS/CS611/HW3_MonstersAndHeros/Legends_Monsters_and_Heroes/Weaponry.txt"};

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
                config.add(new WeaponConfig(line[0],
                        Double.parseDouble(line[1]),
                        Double.parseDouble(line[2]),
                        Double.parseDouble(line[3]),
                        Integer.parseInt(line[4])));
            }
        }

        numWeapons = config.size();
    }

    public Weapon getWeaponByIndex(int weaponNumber) {
        WeaponConfig cfg = config.get(weaponNumber);
        return getWeapon(cfg.name, cfg.cost, cfg.reqLevel, cfg.damage, cfg.reqHands);
    }

    public void printWeaponMenu() {
        for (int i=0; i < config.size(); i++) {
            System.out.printf("%s:   %s\n", i, config.get(i));
        }
    }

    public Weapon getWeapon(String name, double cost, double reqLevel, double damage, double reqHands) {
        return new Weapon(name, cost, reqLevel, damage, reqHands);
    }

    private class WeaponConfig {
        public String name;
        public double cost;
        public double reqLevel;
        public double damage;
        public int reqHands;

        public WeaponConfig(String name, double cost, double reqLevel, double damage, int reqHands) {
            this.name = name;
            this.cost = cost;
            this.reqLevel = reqLevel;
            this.damage = damage;
            this.reqHands = reqHands;
        }

        @Override
        public String toString() {
            return "name='" + name + '\'' +
                    ", cost=" + cost +
                    ", reqLevel=" + reqLevel +
                    ", damage=" + damage +
                    ", reqHands=" + reqHands;
        }
    }


    public static void main(String[] args) {
        WeaponFactory factory = new WeaponFactory();
        factory.printWeaponMenu();
    }

}
