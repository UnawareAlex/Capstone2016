Capstone 2016
Alex Arnold
AP Computer Science 2

OVERVIEW:
This project generates a useable Etch-a-Sketch controlled by the arrow keys on a keyboard with a 
variety of functions such as increasing/decreasing the thickness of the line and changing the color of the line. 

CONCEPTS USED:
I implemented a variety of concepts that we have learned throughout the year, such as:
 - GUI
 - ArrayLists
 - Event Listeners
 - Multiple Classes 
 - Inheritance
Many of the ideas I used in my program I had seen or previously used in our old labs, 
which served as the basis for my implementation of the same concept. I found the our examples of the 
DrawingEditor Lab and the practice Triangle lab to be the most helpful in designing my class layout and 
determining what I needed to include in my classes. 

ADDITIONAL RESEARCH:
 - JSlider -
Initially I was using a JSlider object as my method of changing the line thickness. 
However, I ran into issues with focus within my JFrame and ease of implementation later on and 
decided to approach the issue by using something more familiar and practical; buttons. (not in final program)

 - KeyListener - 
I needed a way to control the direction of the line in the Etch-a-Sketch and naturally turned to using the 
keyboard as my method of doing so. In order to accomplish this, I needed to use a KeyListener (similar to ClickListener). 
I was able to find some examples online as well as from code from a previous year’s student which was very 
detailed and helpful in successfully implementing the KeyListener into my program.

 - Focus - 
I ran into multiple problems when I started adding buttons to my program. When I would click on a button, my keyboard inputs
would no longer register on the screen (the line would not draw). After some research, I learned about focus. In short,
when I clicked on the button the focus would be set to the button and the keyboard would no longer affect the line. 
In order to get around this I had to manually set the focus of each individual button to false so that the keyboard input
would work no matter what or how many times a button was pressed

INSTRUCTIONS:
 - Run the main method in the Board class to launch the program
 - Control the line using the arrow keys
 - Change the width of the line using the ↑ and ↓ buttons (current width indicating by lefthand label)
 - Change the color of your drawing using the ‘Pick Color’ button
 - Clear your drawing using the ‘Clear’ button
 - Have fun drawing!
