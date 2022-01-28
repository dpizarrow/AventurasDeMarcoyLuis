# AventurasdeMarcosyLuis

## Logic of the program

- The interface ICharacter contains the most important parameters of both Players and Enemies: HP, DEF, ATK, and LVL. The interface also contains the getters and setters for these parameters
- There is an AbstractCharacter class that represents a generic Player or Enemy.
- There is an Enemy class that implements the methods in AbstractCharacter, and each enemy is a subclass of the Enemy class
- There is an AbstractPlayer class that extends the AbstractCharacter class, which represents a generic player, and this class contains:
  - Each player's inventory of items
  - Methods that use each different type of item
  - A method that determines if a player has lost all of it's HP
- There is an interface for a generic item, and each item class implements this interface
- The game controller facilitates all interactions between enemies, players and items.

## Assumptions made

- When players Jump attack a Spiny enemy, the player takes 5% of it's maximum HP value as damage and the Spiny does not receive any damage
- On leveling up, the players maximum HP and FP values are raised by 15% and they receive 15% of their maximum HP, DEF, FP and ATK.
- In some cases, casts were required implement attacks between players and enemies via the controller. To remedy this, methods `isEnemy` and `isPlayer` were created to ensure that the cast is done to the correct type.

## Changes (Tarea 2)

- The Star item was removed
- Two interfaces were created to help facilitate interactions between Enemies and Players:
  - `IPlayer` represents a Player and contains methods to attack Enemies depending on the attack type (Hammer or Jump)
  - `IEnemy` represents an Enemy and contains a generic attack method to attack Players
- Each players individual inventory was removed and replaced with a shared Inventory
- The game controller was implemented:
  - This controller inherits methods from an `AbstractController` which implements the interface `IController`
  - This controller handles all interactions between:
      - Players and Enemies. Players attack Enemies via the controller
      - Enemies and Players. Enemies randomly select a Player to attack via the controller
      - Players and the Inventory. Players can use items from the inventory which modify the player's statistics depending on the item used
 - To facilitate Enemy creation, Enemy Factories were implemented using the interface `IEnemyFactory`. These factories create multiple instances of the same type of enemy

## Changes (Tarea 3)

- The main additions were the implementations of phases, which help control the flow of the game, and exceptions which are thrown depending on the context of the game. 
- The interface `IPhase` and the abstract class `AbstractPhase` contain the abstract implementations of different phase methods and exception throwing, while the concrete phases are:
  - `PlayerDecisionPhase`: This phase allows players to use items, attack enemies, or skip their turn
  - `PlayerAttackPhase`: In this phase players select an enemy to attack with either a hammer or a jump. Players can also leave this phase and return to the `PlayerDecisionPhase`, if they encounter enemies they cannot attack.
  - `UseItemPhase`: Players can use an item or return to the `PlayerDecisionPhase` if there are no items in the inventory
  - `EnemyAttackPhase`: Here enemies randomly choose and attack a player

- Exceptions which extend the base `Exception` class were implemented. These are:

  - `InvalidActionException`: Thrown when an enemy tries to attack a player that it cannot attack
  - `InvalidAttackableException`: Thrown when a player tries to attack an enemy that it cannot attack
  - `InvalidUseItemException:` Thrown when a player tries to use an item that is not available in the inventory
  - `InvalidTransitionException`: Thrown when it is not possible to transition between phases. For example, this exception would be thrown when a player tries to use an item during an enemies turn

- Other changes include fixing the attack methods in the game controller to avoid casting 
- Each phase is tied to a controller, and every time the controller attemps to go to the next turn, it checks to make sure that the correct phase transition is executed.


