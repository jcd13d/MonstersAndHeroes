import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class SpellFactory extends HaMFactory {
    private int numSpells;
    private ArrayList<SpellConfig> config;

    public SpellFactory() {
        setFactoryName("Spells");
        config = new ArrayList<>();

        Path currentPath = Paths.get(System.getProperty("user.dir"));
        Path firePath = Paths.get(currentPath.toString(), "configs", "FireSpells.txt");
        Path icePath = Paths.get(currentPath.toString(), "configs", "IceSpells.txt");
        Path lightPath = Paths.get(currentPath.toString(), "configs", "LightningSpells.txt");

        String[] files = {
                firePath.toString(),
                icePath.toString(),
                lightPath.toString()
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
                config.add(new SpellConfig(line[0],
                        Double.parseDouble(line[1]),
                        Double.parseDouble(line[2]),
                        Double.parseDouble(line[3]),
                        Double.parseDouble(line[4]),
                        path.getName().split("\\.")[0]));
            }
        }

        numSpells = config.size();
    }

    public int getNumSpells() {
        return numSpells;
    }

    public void setNumSpells(int numSpells) {
        this.numSpells = numSpells;
    }

    public Spell getSpell(String name, double cost, double reqLevel, double dmgReduction, double manaCost, String spellType, double monsterReduction) {
        Spell spell = new Spell(name, cost, reqLevel, dmgReduction, manaCost, spellType);
        if (spellType.equalsIgnoreCase("firespells")) {
            return new FireSpellDecorator(spell, spellType, monsterReduction);
        } else if (spellType.equalsIgnoreCase("icespells")) {
            return new IceSpellDecorator(spell, spellType, monsterReduction);
        } else if (spellType.equalsIgnoreCase("lightningspells")) {
            return new LightningSpellDecorator(spell, spellType, monsterReduction);
        } else {
            return spell;
        }
    }

    public Spell getSpellByIndex(int potionNumber){
        SpellConfig cfg = config.get(potionNumber);
        return getSpell(cfg.name, cfg.cost, cfg.reqLevel, cfg.dmgReduction, cfg.manaCost, cfg.spellType, cfg.dmgReduction);
    }

    public void pringSpellMenu() {
        for (int i=0; i < config.size(); i++) {
            System.out.printf("%s:   %s\n", i, config.get(i));
        }
    }

    private class SpellConfig {
        public String name;
        public double cost;
        public double reqLevel;
        public double dmgReduction;
        public double manaCost;
        public String spellType;

        public SpellConfig(String name, double cost, double reqLevel, double dmgReduction, double manaCost, String spellType) {
            this.name = name;
            this.cost = cost;
            this.reqLevel = reqLevel;
            this.dmgReduction = dmgReduction;
            this.manaCost = manaCost;
            this.spellType = spellType;
        }

        @Override
        public String toString() {
            return "name='" + name + '\'' +
                    ", cost=" + cost +
                    ", reqLevel=" + reqLevel +
                    ", dmgReduction=" + dmgReduction +
                    ", manaCost=" + manaCost +
                    ", spellType='" + spellType +
                    ", Special Power=" + getSpecialString(spellType);
        }
    }

    public String getSpecialString(String spellType) {
        if (spellType.equalsIgnoreCase("FireSpells")) {
            return "also reduces defensse of the enemy";
        } else if (spellType.equalsIgnoreCase("IceSpells")) {
            return "also reduces the damage of the enemy";
        } else if (spellType.equalsIgnoreCase("LightningSpells")) {
            return "also reducces the dodge chance of the enemy";
        } else {
            return "";
        }
    }

    public static void main(String[] args) {
        SpellFactory factory = new SpellFactory();
        factory.pringSpellMenu();
    }

}
