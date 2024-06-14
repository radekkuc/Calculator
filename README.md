# Calculator
Simple calculator application developed in Java. It adheres to the principles outlined in https://programowanie.orzechowski.it/dodk.html

Implementation of a calculator based on the following rules:
a) operator - operator: a new operator overrides the old one - this does not change the value of the arguments;

b) operator - digit: a new digit will be inserted as a component of the value of the second argument of the operator;

c) operator - equal sign: we calculate the value of the expression as:

[value of the first argument] operator [value of the first argument]

d) we clear all operator values - restoring the calculator's initial state;

e) we set the first argument and save the operator;

f) we continue to retrieve values for the same argument - the next digits of the same number;

g) if an operator was saved, we perform the operation and save the result;

h) the current result becomes the first argument, and we save the operator.

i) we clear previous settings, start the calculation from the beginning, the digit starts retrieving components of the first argument number.

j) we repeat the last operation if there was one, if not, then no change.
