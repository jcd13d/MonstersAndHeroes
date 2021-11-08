import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class MonsterFactory extends HaMFactory {

    private ArrayList<MonsterConfig> config;
    private int numMonsters;

    public MonsterFactory() {
        config = new ArrayList<>();

        String[] files = {
                "/Users/justindiemmanuele/Documents/MS/CS611/HW3_MonstersAndHeros/Legends_Monsters_and_Heroes/Dragons.txt",
                "/Users/justindiemmanuele/Documents/MS/CS611/HW3_MonstersAndHeros/Legends_Monsters_and_Heroes/Spirits.txt",
                "/Users/justindiemmanuele/Documents/MS/CS611/HW3_MonstersAndHeros/Legends_Monsters_and_Heroes/Exoskeletons.txt"
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
                config.add(new MonsterConfig(line[0],
                        Double.parseDouble(line[1]),
                        Double.parseDouble(line[2]),
                        Double.parseDouble(line[3]),
                        Double.parseDouble(line[4]),
                        path.getName().split("\\.")[0]));
            }
        }

        numMonsters = config.size();

    }

    public Monster getRandMonsterLevelCap(int levelCap) {
        Monster monster;
        do {
            int randNum = ThreadLocalRandom.current().nextInt(0, numMonsters - 1);
            monster = getMonsterByIndex(randNum);
        } while(monster.getLevel() > levelCap);

        return monster;
    }

    public Monster getMonster(String name, double hp, double level, double damage, double defense, double dodgeChance,
                              String monsterType) {
        return new Monster(name, hp, level, damage, defense, dodgeChance, monsterType);
    }

    public Monster getMonsterByIndex(int monsterNumber) {
        MonsterConfig cfg = config.get(monsterNumber);
        // TODO figure out HP!
        return getMonster(cfg.name, 100*cfg.level, cfg.level, cfg.damage, cfg.damage, cfg.dodgeChance, cfg.monsterType);
    }

    private class MonsterConfig {
        public String name;
        public double level;
        public double damage;
        public double defense;
        public double dodgeChance;
        public String monsterType;

        public MonsterConfig(String name, double level, double damage, double defense, double dodgeChance,
                             String monsterType) {
            this.name = name;
            this.level = level;
            this.damage = damage;
            this.defense = defense;
            this.dodgeChance = dodgeChance;
            this.monsterType = monsterType;
        }

        @Override
        public String toString() {
            return "MonsterConfig{" +
                    "name='" + name + '\'' +
                    ", level=" + level +
                    ", damage=" + damage +
                    ", defense=" + defense +
                    ", dodgeChance=" + dodgeChance +
                    '}';
        }
    }

}
