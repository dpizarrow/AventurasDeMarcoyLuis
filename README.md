# AventurasdeMarcosyLuis

## Logic of the program

- The interface ICharacter contains the most important parameters of both Players and Enemies: HP, DEF, ATK, y el LVL. The interface also contains the getters and setters for these parameters
- There is an AbstractCharacter class that represents a generic Player or Enemy.
- There is an Enemy class that implements the methods in AbstractCharacter, and each enemy is a subclass of the Enemy class
- There is an AbstractPlayer class that extends the AbstractCharacter class, which represents a generic player, and this class contains:
  - Each player's inventory of items
  - Methods that use each different type of item
  - A method that determines if a player has lost all of it's HP
- There is an interface for a generic item, and each item class implements this interface

## Assumptions made

- The "Refreshing Herb" item was not implemented, as there is insufficient information to implement the item
- For this assignment, the "Star" item assigns the players current HP to the players maximum HP. This has only been done as a temporary measure
- Each item can only be used by a player once. This means that once a player uses an item, the item is removed from the player's inventory

