# Shopping Cart

## *An application that will deduct sales tax for non essentials and import tax for all imported goods*

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

The Factory pattern was selected considering the following reasons:-
1. The application expects a few items to be exempted from sales tax. The Factory pattern helps us set rules for each item.
2. In the future, more items could be exempted from service tax. 
    - For example :- Clothes can later be consider as a exempted item for sales tax in the future  
3. The possiblity of having service tax (may be reduced rate) added for any one of the currently exempted item. 
    - For example :- Books can have a service tax of 3% added in the future
4. Imported tax rate for each item can change.
    - For example :- Books imported tax can be reduced from 5% to 3% in the future.


__Compiling and building the application:__

This is a Java Maven application, which can be complied and built using any Java 1.8 compiler. The com.shop.App class can be run as a Java application.
