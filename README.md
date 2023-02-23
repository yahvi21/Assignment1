Yahvi Bhatnagar - ASSIGNMENT 1
20684595

This project will read data from a file of tags called tags.csv, and sort them from the lowest to highest count they occured in the csv file. It will also allow users to search for induvidual tags by their count or name. 

TagList : The array list does not store the same tag name twice. If the tag name is already available it increments the count of the tag. If not present then adds a new tag with count 1. Hence this way it uses less memory to store the tags in the array list, and further improves the search time.

Algorithms used: 
- Search used - Linear search to find the highest and lowest count easily. 

- Sort used - Insertion sort is used since it uses less memory allocation and works efficiently with my code.

Used:
-NumerFormatException so if the user enters anything other than a number, a message is displayed for user to input the data again. 

-My total run time of the code to give the sorted output of movie tags is less than 2 minutes.

-I have made total 3 files - MovieTags.java, TagList.java, Tag.java
