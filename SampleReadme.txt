# CS611-Legends

Name
-------------------------------------------------------------------------------------------------
Justin DiEmmanuele
U64306920

Files
-------------------------------------------------------------------------------------------------
<.java file> - <1 line comment about the file 
AmbrosiaPotion.Java - Ambrosia subclass of potion with unique to Ambrosia logic
Armor.Java - General class for armor
ArmorFactory.Java - Factory to produce armor
BadGuy.Java - Interface defining methods bad guys should have
BoardCell.Java - The cell the board is made up of
BoardFactory.Java - Factory that produces boards
Fight.Java - Class to handle all fighting
FireSpellDecorator.Java - Decorator that adds Fire spell logic
Game.Java - general game abstract class
GameBoard.Java - holds game board state and logic
GenericHero.Java - generic hero class with shared hero attributes and methods
GenericLevelUpBehavior.Java - generic level up (default before enhanced by special hero types)
HaMFactory.Java - abstract factory all factories inherit from
HaMGame.Java - heroes and monsters game class, contains game logic
HealingPotion.Java - class for healing potions
Hero.Java - class holding general hero attribues and logic
HeroFactory.Java - factory that produces heroes requested
IceSpellDecorator.Java - decorator that adds ice spell functionality to spells
IntChecker.Java - interface to define what methods int checkers need - passed to I/O methods to ensure valid inputs are made
Item.Java - general item class for things shared by all items
LevelUpBehavior.Java - interface to define what a LevelUpBehavior class implements - these define special level up algos
LightingSpellDecorator.Java - decorator that adds lightning functionality to a spell
LuckElixirPotion.Java - class for LE potion
MagicPotion.Java - class for magic potion
Main.Java - main class - runs game
Market.Java - handles logic and state associated with marketplace
MermaidTearsPotion.Java - mermaid tears potion
Monster.Java - monster class holding state and methods for monsters
MonsterFactory.Java - factory to produce monsters
PaladinHero.Java - paladin hero with logic specific to paladins
PaladinLevelUpBehavior.Java - algorithm describing how paladins level up
Player.Java - general abstract player class
Potion.Java - general potion class
PotionFactory.Java - factory to produce specific kinds of potions
RangeChecker.Java - implements IntChecker - algorithm to check that input is in a range of ints
SorcererHero.Java - logic specific to sorcerers
SorcererLevelUpBehavior.Java - algorithm describing how sorcerers level up
Spell.Java - general spell class
SpellDecorator.Java - abstract class that specifies things needed for spell decorators
SpellFactory.Java - factory that produces spells
StrengthPotion.Java - strength potion specific logic
StringChecker.Java - interface for algorithms that check an entered string conforms to some specification
StringInListChecker.Java - algorithm that checks that input is in a list of accepted inputs
Utils.Java - class to handle I/O and prompting the user
WarriorHero.Java - warrior specific logic
WarriorLevelUpBehavior.Java - describes how warriors level up
Weapon.Java - general weapon class
WeaponFactory.Java - factory that produces weapons



Notes:
-------------------------------------------------------------------------------------------------
1. Files to be parsed should be stored in ConfigFiles, for parser class to read class
2. Bonus Done
3. Things instructions to note


How to run:
-------------------------------------------------------------------------------------------------
1. Navigate to the directory after downloading the project
2. Run the following instructions on command line:
	javac *.java
	java Main.java
