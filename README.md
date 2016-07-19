# Java-SortingRenameFiles

This is a java program I created for my own use. It reads all the files of a given directory, renames them and saves them back in the same directory.
I like photography and ocassionaly I take some photos with my camera. When I save the pictures on my PC, I usualy organse them in folder without changing their names (I leave them with that *-blabla123.jpg-* name). So, by using this program I can:

1. give the path of a directory

2. be informed about all the files that it contains (*and their type extensions*)

3. give the *prefix* I want to add at the new names 

and the program tries to rename them and returns a message of success or failure. 

##Special Notices

1. When the console asks for the path, the user **MUST** be sure that the last character of the path is \ or /. If this last special character is missed, the renamed files will be saved at the higher directory.
2. For the alphabetical sorting of the files I used the code I found at http://haidermushtaq.com/the-problem-with-alphabetically-sorting-files-if-their-name-contains-a-number/ by Haider Mushtaq
that implements the algorithm that can be found at http://www.davekoelle.com/alphanum.html by David Koelle. 
This solves the problem of the ASCII-order sorting, that is the normal sorting in Java. So, the result is something like this:
Previous Java sorting | New "correct" sorting
-----------------|----------------------
          z1.jpg |  z1.jpg
         z10.jpg |  z2.jpg
         z11.jpg |  z3.jpg
          z2.jpg |  z10.jpg
          z3.jpg |  z11.jpg

3. I have also created the method **getFileExtension** that saves the type extension of each file (jpg, bmp, png, txt ...).

For a more detailed information on the code , you can see the two java files.

## Motivation

As I wrote before, I developped this program for my own use. It's nothing more than an "afternoon project". 

## Installation

Just copy the code from the two given java files.
