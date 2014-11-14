Adam Sachs
ajs2255

This program simulates a few playing card manipulations for the game of Hearts:

-NewDeck produces a deck of 52 cards and prints a string version of it onto stdout.

-Shuffle reads a string version of a deck of cards from stdin, recreates the deck, shuffles the deck, and writes the string version of the now shuffled deck to stdout.

-Deal reads a string version of a deck of cards from stdin, recreates the deck, and writes 4 separate 13-card decks (hands) in their string versions to stdout. Deal should also assign a position (North, East, South, and West) to each hand.

-Leader reads 4 hands from stdin (North, East, South, and West) and writes which hand contains the 2 of clubs to stdout.

-Show reads 4 hands from stdin and prints them to stdout.

A more detailed description below:

My program seems to be working correctly. If the user inputs the commands that  given on the assignment page after compiling, the program should print an easy to read summary of which hands have which cards. Also, the name of the current hand that contains the 2 of clubs will be output if the user calls the "Leader" program.

My program is designed in the way that the Professor outlined in class. I have 5 classes that call a main method. The main methods are minimal--they parse, call the more detailed methods that exist in the CardGroup.java class, and then output a string. The main methods in Leader.java and Show.java do a bit more work, as their input is the string representation of 4 separate card groups. Their main methods split the string representation into 4 different card groups, and then proceed to have each card group (i.e. each hand) call the respective more detailed method that exists in the CardGroup.java class.

The CardGroup.java class describes the object CardGroup, which contains an array of Cards (which are described by the Card.java class). Most of the work is done within the CardGroup.java class, as most of the manipulations for this assignment are performed upon CardGroups. Both the CardGroup.java and Card.java classes have toString() and parse() methods, so that Cards and CardGroups can be turned into string representations that will be passed through IO, as well as created (i.e. parsed) by string representations. These methods use characters such as ":" ";" "::" and the "split()" and "indexOf()" methods to accomplish their goals.