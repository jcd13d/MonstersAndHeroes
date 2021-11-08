import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fight {
    private List<Hero> heroes;
    private List<Monster> monsters;
    private List<Monster> origMonsters;
    private int maxLevel;
    private MonsterFactory monsterFactory;
    private Utils utils;
    private int aliveHeroes;

    public Fight(List<Hero> heroes) {
        monsters = new ArrayList<>();
        utils = new Utils();
        this.heroes = heroes;
        this.maxLevel = getMaxHeroLevel();
        monsterFactory = new MonsterFactory();
        initMonsters();
    }

    private void initMonsters() {
        for (int i = 0; i < heroes.size(); i++) {
            monsters.add(monsterFactory.getRandMonsterLevelCap(maxLevel));
        }
        origMonsters = monsters;
    }

    private int getMaxHeroLevel() {
        int maxLevel = 0;
        for (Hero hero : heroes) {
            if (maxLevel < hero.getLevel()) maxLevel = (int) hero.getLevel();
        }
        return maxLevel;
    }

    private boolean endFightCondition() {

        return heroesWin() | monstersWin();
    }

    private boolean monstersWin() {
        double totHp = 0;
        for (Hero hero : heroes) {
            totHp = totHp + hero.getHp();
        }
        return (totHp == 0);
    }

    private boolean heroesWin() {
        double totHp = 0;
        for (Monster monster : monsters) {
            totHp = totHp + monster.getHp();
        }
        return (totHp == 0);
    }

    public void fight() {
        // TODO IMPLEMENT DODGE Hero and monster
        int currMonsterNum = 0;
        while(!endFightCondition()) {
            for (Hero hero : heroes) {
                if (hero.getHp() > 0) {
                    do {
                        currMonsterNum = (currMonsterNum + 1) % monsters.size();
                    } while (monsters.get(currMonsterNum).getHp() == 0);
                    faceOff(hero, monsters.get(currMonsterNum));
                }
            }
            // end of round heroes gain some hp and mana
            for (Hero hero : heroes) {
                if (hero.getHp() > 0) {
                    // gain mana and hp
                    hero.setMana(hero.getMana()*1.1);
                    hero.setHp(hero.getHp()*1.1);
                }
            }
        }

        // end fight level setting
        if (heroesWin()) {
            for (int i = 0; i < heroes.size(); i++) {
                Hero hero = heroes.get(i);
                if (hero.getHp() > 0) {
                    hero.payHero(100*monsters.get(i).getLevel());
                    hero.setExp(hero.getExp() + 2);
                }
                heroes.get(i).setHp(hero.getLevel() * 100); // todo is this right?
            }
        } else {
            for (Hero hero : heroes) {
                hero.setHp(hero.getLevel() * 100 / 2);
            }
        }


    }

    private void faceOff(Hero hero, Monster monster) {
        // menu with options

        String input;
        do {
            input = utils.getStringInput(faceOffPrompt(hero, monster),
                    new StringInListChecker(Arrays.asList("attack", "spell", "potion", "equip")));
        } while(!validHeroChoice(input, hero));

        if (input.equalsIgnoreCase("attack")) {
            // attack
            heroAttack(hero, monster);
        } else if (input.equalsIgnoreCase("spell")) {
            // spell
            heroSpellCast(hero, monster);
        } else if (input.equalsIgnoreCase("potion")) {
            // potion
            heroDrinkPotion(hero);
        } else {
            // equip
            hero.equipMenu();
        }

        if (monster.getHp() > 0) {
            // monster attack if monster is still alive
            monsterAttack(hero, monster);

            if (hero.getHp() == 0) {
                System.out.printf("%s has fainted!!\n", hero.getName());
            }

        } else {
            System.out.printf("%s is dead!\n", monster.getName());
        }

    }

    private boolean validHeroChoice(String choice, Hero hero) {
        if (choice.equalsIgnoreCase("attack")) {
            return true;
        } else if (choice.equalsIgnoreCase("equip")) {
            return true;
        } else if (choice.equalsIgnoreCase("spell")) {
            boolean hasSpells = hero.getSpells().size() > 0;
            if (!hasSpells) System.out.println("No spells to cast!");
            return hasSpells;
        } else {
            boolean hasPotions = hero.getPotions().size() >0;
            if (!hasPotions) System.out.println("No potions to cast!");
            return hasPotions;
        }
    }

    private void heroDrinkPotion(Hero hero) {
        hero.drinkPotion(selectPotion(hero));
    }

    private void heroSpellCast(Hero hero, Monster monster) {
        hero.castSpell(selectSpell(hero), monster);
    }

    private int selectPotion(Hero hero) {
        System.out.println("Please select potion to drink from the menu:");
        List<Potion> heroPotions = hero.getPotions();
        for (int i = 0; i < heroPotions.size(); i++) {
            System.out.printf("%s:    %s\n", i, heroPotions.get(i));
        }
        return utils.getIntInput("", new RangeChecker(0, heroPotions.size() - 1));
    }

    private int selectSpell(Hero hero) {
        System.out.println("Please select spell to cast from the menu:");
        List<Spell> heroSpells = hero.getSpells();
        for (int i = 0; i < heroSpells.size(); i++) {
            System.out.printf("%s:    %s\n", i, heroSpells.get(i));
        }
        return utils.getIntInput("", new RangeChecker(0, heroSpells.size() - 1));
    }

    private void heroAttack(Hero hero, Monster monster) {
        hero.attack(monster);
    }

    private void monsterAttack(Hero hero, Monster monster) {
        monster.attack(hero);

    }

    private String faceOffPrompt(Hero hero, Monster monster) {
        return String.format("Fight! %s is against %s!!\n Hero and Monster status printed below: \n%s\n%s" +
                "\n Please choose course of action: attack, spell, potion, equip",
                hero.getName(), monster.getName(), hero, monster);
    }

}
