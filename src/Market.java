import java.util.ArrayList;
import java.util.Arrays;

public class Market {

    Utils utils = new Utils();
    WeaponFactory weaponFactory;
    SpellFactory spellFactory;
    ArmorFactory armorFactory;
    PotionFactory potionFactory;

    public Market() {
        weaponFactory = new WeaponFactory();
        spellFactory = new SpellFactory();
        armorFactory = new ArmorFactory();
        potionFactory = new PotionFactory();
    }

    public void marketMenus(ArrayList<Hero> heroes) {
        for (Hero h : heroes) {
            marketMenu(h);
        }
    }

    public void marketMenu(Hero hero) {
        String s = "";
        s = s + String.format("Buying for hero %s \n", hero);
        s = s + "Available item categories for purchase below. Please type which you would like to view.\n";
        s = s + "Type 'next' to move to next player\n";
        s = s + weaponFactory.getFactoryName() + "\n";
        s = s + spellFactory.getFactoryName() + "\n";
        s = s + armorFactory.getFactoryName() + "\n";
        s = s + potionFactory.getFactoryName() + "\n";
        System.out.println(s);

        String input = utils.getStringInput("", new StringInListChecker(Arrays.asList(
                weaponFactory.getFactoryName(),
                spellFactory.getFactoryName(),
                armorFactory.getFactoryName(),
                potionFactory.getFactoryName(),
                "next")));

        if (input.equalsIgnoreCase(weaponFactory.getFactoryName())) {
            weaponMenu(hero);
        } else if (input.equalsIgnoreCase(spellFactory.getFactoryName())) {
            spellMenu(hero);
        } else if (input.equalsIgnoreCase(armorFactory.getFactoryName())) {
            armorMenu(hero);
        } else if (input.equalsIgnoreCase(potionFactory.getFactoryName())) {
            potionMenu(hero);
        } else {
            // nothing
        }

    }

    public void weaponMenu(Hero hero) {
        weaponFactory.printWeaponMenu();
        int input = utils.getIntInput(menuPrompt(weaponFactory.getNumWeapons()), new RangeChecker(-1, weaponFactory.getNumWeapons()));
        Weapon weapon;
        if (input < weaponFactory.getNumWeapons()) {
            weapon = weaponFactory.getWeaponByIndex(input);
            if (hero.getLevel() >= weapon.getReqLevel()) {
                if (hero.pay(weapon.getCost())) {
                    hero.addWeapon(weapon);
                    marketMenu(hero);
                } else {
                    System.out.println("Insufficient Funds!");
                    marketMenu(hero);
                }
            } else {
                System.out.println("Must be a higher level to purchase!");
                marketMenu(hero);
            }
        } else {
            // next player
        }
    }

    public void spellMenu(Hero hero) {
        spellFactory.pringSpellMenu();
        int input = utils.getIntInput(menuPrompt(spellFactory.getNumSpells()), new RangeChecker(-1, spellFactory.getNumSpells()));
        Spell spell;
        if (input < spellFactory.getNumSpells()) {
            spell = spellFactory.getSpellByIndex(input);
            if (hero.getLevel() >= spell.getReqLevel()) {
                if (hero.pay(spell.getCost())) {
                    hero.addSpell(spell);
                    marketMenu(hero);
                } else {
                    System.out.println("Insufficient Funds!");
                    marketMenu(hero);
                }
            } else {
                System.out.println("Must be a higher level to purchase!");
                marketMenu(hero);
            }
        } else {
            // next
        }
    }

    public void armorMenu(Hero hero) {
        armorFactory.printArmorMenu();
        int input = utils.getIntInput(menuPrompt(armorFactory.getNumArmors()), new RangeChecker(-1, armorFactory.getNumArmors()));
        Armor armor;
        if (input < armorFactory.getNumArmors()) {
            armor = armorFactory.getArmorByIndex(input);
            if (hero.getLevel() >= armor.getReqLevel()) {
                if (hero.pay(armor.getCost())) {
                    hero.addArmor(armor);
                    marketMenu(hero);
                } else {
                    System.out.println("Insufficient Funds!");
                    marketMenu(hero);
                }
            } else {
                System.out.println("Must be a higher level to purchase!");
                marketMenu(hero);
            }
        } else {
            // next
        }
    }

    public void potionMenu(Hero hero) {
        potionFactory.printPotionMenu();
        int input = utils.getIntInput(menuPrompt(potionFactory.getNumPotions()), new RangeChecker(-1, potionFactory.getNumPotions()));
        Potion potion;
        if (input < potionFactory.getNumPotions()) {
            potion = potionFactory.getPotionByIndex(input);
            if (hero.getLevel() >= potion.getReqLevel()) {
                if (hero.pay(potion.getCost())) {
                    hero.addPotion(potion);
                    marketMenu(hero);
                } else {
                    System.out.println("Insufficient Funds!");
                    marketMenu(hero);
                }
            } else {
                System.out.println("Must be a higher level to purchase!");
                marketMenu(hero);
            }
        } else {
            // next
        }
    }

    private String menuPrompt(int exitNum) {
        return String.format("Please choose which number item you wish to buy. To exit type '%s'", exitNum);
    }

    public static void main(String[] args) {
        Market market = new Market();
        HeroFactory hf = new HeroFactory();
        Hero h = hf.getHeroByIndex(2);
        Hero h2 = hf.getHeroByIndex(3);
        ArrayList<Hero> heroes = new ArrayList<>();
        heroes.add(h);
        heroes.add(h2);
        market.marketMenus(heroes);
    }

}
