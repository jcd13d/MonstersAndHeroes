public class MonsterFactory {

    public Monster getMonster(String name, int hp, int level, int damage, int defense, int dodgeChance,
                              String monsterType) {
        return new Monster(name, hp, level, damage, defense, dodgeChance, monsterType);
    }

}
