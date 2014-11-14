Adam Sachs
ajs2255
Assignment 4 -- Sorting

There are 2 programs here: MakeNames,  which writes a list of 1000 people, each with a randomly selected first name and last name from two database files, but each with a unique, four-digit identification code; and Sort, which implements both quick sort and heap sort to sort the names alphabetically by last name (first name if last names are identical; only by id if full names are identical). Sort can also print the statistics of the sort, describing the number of person comparisons and person swaps. 

I provide sample first name and last name database files with some silly last names that I came up with.


My MakeNames.java program can be run as follows with my name database files:
'java names/MakeNames firstNames.txt lastNames.txt'

It takes the first names database file as the first argument, and the last names database file as the second argument. It prints out a list of 1000 randomly generated names, which were provided in the database files.

The Sort.java program can be run as follows (just an example):
java names/Sort -h -stats <personDatabase

It takes a list of names as its standard input, and either '-q' (for quicksort) or '-h' (for 'heapsort) as its first argument and '-stats' as the second argument, if the user wants to get the stats of the sort rather than the a sorted list of names.

A more detailed description below:

The sort program takes in a list of names (and pids), and creates arrays of "Person" objects based on these inputted strings. The first names, last names and pids of an individual Person should be separated by a space, and one Person should be separated from the next by a new line. The sort program takes the input in line-by-line, parsing each line to create a Person and adding that Person to the array. The array of Persons is then converted into an array of the "Array.java" class that I created, which creates an array that is able to be sorted. The Array object sorts its array of com parables using the sort algorithms that the professor used in class. I improved the quick sort pivot value selection by implementing the 'median of three' algorithm, which takes the median of the first, last, and middle elements of the array being passed to it. This ensures that we won't get worst case performance on a sorted list (which happens when choosing the first element of the array as the pivot index), and also improves the likelihood that we choose a pivot index that is closer to the middle of values (which improves sorting efficiency).

I count comparisons by incrementing the comparison counter every time a person is compared to another person (i.e. my 'compare' method in the 'Array.java' class is called). I count swaps by incrementing the swap counter every time a person pointer is assigned a person or reassigned to a different person, e.g. "this.values[top] = v;", where v is a person, increases the swap counter, as does: "this.values[i] = this.values[j];".
