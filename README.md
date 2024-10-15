# Lawn Mower

### Description
This program simulates a lawn mower that can cut grass in a grid-based lawn layout. Users can specify multiple lawns to be mowed, each defined by its dimensions and randomly placed trees. The mower starts from a user-defined position and cuts the grass around it, taking care not to cut grass next to trees.

- **T** represents trees
- **.** represents uncut lawn
- **C** represents cut lawn

### Usage
- The program prompts the user to input the number of lawns to mow
- For each lawn, it asks for the number of rows and columns (40 is the max # for rows and columns)
- Random trees are planted, and the initial state of the lawn is displayed
- The user specifies the starting position of the mower for each lawn
- The program then displays the lawn after mowing.

### How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/mowing-java.git
2. Ensure you have Java installed on your machine.
3. Compile and run the program
   ```bash
   javac Main.java Lawn.java
   java Main

   
### Future Improvements
- Add a GUI for a more interactive experience.
- Allow for more complex mowing patterns
- Add options for different types of terrain or obstacles in the lawn
