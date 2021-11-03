# Notes

## The Market
* Weapons
* Armor
* Potion
* Spell
  * ice
  * fire
  * lightning 


## Heroes and Monsters
### Heroes
  * name
  * level
  * health power (HP)
  * faints at zeor hp
  * mana
  * skills
    * strength
    * desterity
    * agility
  * money
  * exp
    * levels up w exp thresh
    * level up increases skills
  * Types
    * Warriors
    * Sorcerers
    * Paladins
  * can have items described in market


### Monsters
  * name
  * HP
  * Level
  * Stats
    * damage 
    * defense
    * dodge
  * Types
    * Dragons
    * Exoskeletons
    * Spirits

## World of Play
* playing field is a grid
  * team of heroes up to 3 placed in a tile
  * can move up and down
* types of grid spaces
  * inaccessible
  * marketplaces
    * buy/sell
  * common tiles
    * any time visit common tile chance to fight mosters of highest level hero
* players able to check inventory if not in market or in battle
  * change armor and weapons consume potion
  * any time display info related to heros like level hp mana exp skill level
  * any time display the map

## Fighting
* heroes attack first 
* ends when hp of all heroes or all monsters are zero
* monster win - heros lose half money
* heroes win - earn money based on level and num monsters fought
* if hero fainted they get back half of hp doesnt gain exp or money
* heros still alive after a round of fight they regain some hp and mana
* player choses for each hero what type of move or change armor weapon
* need to show who cause how much damage to who
* first player attack first, second second monster etc



# Pseudocode
## main play file

```
playerList = playerCollection.init(filname)
playerSelection = PlayerSelect(userInputString(playerSelectPrompt, checksClass))
do {
    game.getInput(getUserInput(game.gameStateInput(), game.gameCheck))

} while(stillPlaying)
```
