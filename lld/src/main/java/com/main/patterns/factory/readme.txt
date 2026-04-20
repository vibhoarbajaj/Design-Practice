-- if we have multiple instantiated objects using new and we add a parameterized constructor
so we will have to change in a lot of places
-- it is a creational design pattern , used when we have to encapsulate object creation and related
creation logic at one place
-- has two types simple factory pattern (industry based)  and factory method pattern (books)

SIMPLE FACTORY PATTERN
-- kind of like authfactory if you remember
-- violates the open closed principle
-- factory class can become bloated if the creation logic is very complex hence we use this simple factory method
when the use case is very simple and the construction of the object isnt very difficult


FACTORY METHOD PATTERN
-- for each product we have a respective factory lets say 1 interface shapefactory has a method createShape
circleShape returns a circle shape , by this we are abstracting the construction logic for creation of object
-- the main factory method will have the object selection but not the creation
-- still violates the open closed principle