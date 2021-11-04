import javax.imageio.IIOException;
import java.io.IOException;
import java.util.HashMap;

public class HeroFactory extends HaMFactory {

    public HeroFactory() {
        try {
            configs.put("warriors", utils.readTxtFile("/Users/justindiemmanuele/Documents/MS/CS611/HW3_MonstersAndHeros/Legends_Monsters_and_Heroes/Warriors.txt"));
            configs.put("sorcerers", utils.readTxtFile("/Users/justindiemmanuele/Documents/MS/CS611/HW3_MonstersAndHeros/Legends_Monsters_and_Heroes/Sorcerers.txt"));
            configs.put("paladins", utils.readTxtFile("/Users/justindiemmanuele/Documents/MS/CS611/HW3_MonstersAndHeros/Legends_Monsters_and_Heroes/Paladins.txt"));
        } catch (IOException e) {
            System.out.println("unable to read file");
        }

    }

    public Hero getHero(String name, double mana, double strength, double agility, double dexterity, double money,
                   double exp, double hp, double defense, double startExp, String heroType) {

        if (heroType.equalsIgnoreCase("paladin")) {
            return new PaladinHero(name, mana, strength, agility, dexterity, money, exp, hp, defense, startExp, heroType);
        } else if (heroType.equalsIgnoreCase("sorcerer")) {
            return new SorcererHero(name, mana, strength, agility, dexterity, money, exp, hp, defense, startExp, heroType);
        } else if (heroType.equalsIgnoreCase("warrior")) {
            return new WarriorHero(name, mana, strength, agility, dexterity, money, exp, hp, defense, startExp, heroType);
        } else {
            return new GenericHero(name, mana, strength, agility, dexterity, money, exp, hp, defense, startExp, heroType);
        }

    }

}
