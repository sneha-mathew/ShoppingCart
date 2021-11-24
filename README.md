#Shopping Cart

## *An application that will deduct service tax for non essentials and import tax for all imported goods*

__Assumptions:__

Food, Book and Medicine are considered as essentials, whereas other items are considered as non essentials. An item is a Book, Food or Medicine if it is mentioned as such in the item name. Similarly, the item is Imported if it is mentioned as such in the item name. 


The input is accepted in the following format:- 


*"{Quantity} {Type of Item} - {Item Name} at {Price}"*

For Example, the input can be as follows:-
- 1 Medicine BXF009 at 90
- 1 BXF0034 Imported Medicine at 180


__Future scope:__

As a part of future scope, the application should accept any food, book or medicine item without expecting a keyword (food, book or medicine) to be mentioned in the item name. 


__Development style:__

The TDD model is used to develop the application, which is built on the Factory pattern.


__Compiling and building the application:__

This is a Java Maven application, which can be complied and built using any Java 1.8 compiler. The com.shop.App class can be run as a Java application.
