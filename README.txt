{\rtf1\ansi\ansicpg1252\cocoartf1404\cocoasubrtf130
{\fonttbl\f0\fswiss\fcharset0 Helvetica;\f1\fnil\fcharset0 LucidaGrande;}
{\colortbl;\red255\green255\blue255;}
\margl1440\margr1440\vieww10800\viewh8400\viewkind0
\pard\tx720\tx1440\tx2160\tx2880\tx3600\tx4320\tx5040\tx5760\tx6480\tx7200\tx7920\tx8640\pardirnatural\partightenfactor0

\f0\fs24 \cf0 Capstone 2016\
Alex Arnold\
AP Computer Science 2\
\

\b Overview:\

\b0 This project generates a useable Etch-a-Sketch controlled by the arrow keys on a keyboard with a variety of functions such as increasing/decreasing the thickness of the line and changing the color of the line. \
\

\b Concepts Used:
\b0 \
I implemented a variety of concepts that we have learned throughout the year, such as:\
 - GUI\
 - ArrayLists\
 - Event Listeners\
 - Multiple Classes\
Many of the ideas I used in my program I had seen or previously used in our old labs, which served as the basis for my implementation of the same concept. I found the our examples of the DrawingEditor Lab and the practice Triangle lab to be the most helpful in designing my class layout and determining what I needed to include in my classes. \
\

\b Additional Research:\

\b0 JSlider\
 - Initially I was using a JSlider object as my method of changing the line thickness. However, I ran into issues with focus within my JFrame and ease of implementation later on and decided to approach the issue by using something more familiar and practical; buttons. 
\i (not in final program)
\i0 \
\
KeyListener\
 - I needed a way to control the direction of the line in the Etch-a-Sketch and naturally turned to using the keyboard as my method of doing so. In order to accomplish this, I needed to use a KeyListener (similar to ClickListener). I was able to find some examples online as well as from code from a previous year\'92s student which was very detailed and helpful in successfully implementing the KeyListener into my program.\
\

\b Instructions:
\b0 \
 - Run the main method in the Board class to launch the program\
 - Control the line using the arrow keys\
 - Change the width of the line using the 
\f1 \uc0\u8593 
\f0  and 
\f1 \uc0\u8595 
\f0  buttons 
\i (current width indicating by lefthand label)\

\i0  - Change the color of your drawing using the \'91Pick Color\'92 button\
 - Clear your drawing using the \'91Clear\'92 button\
 - Have fun drawing!\
}