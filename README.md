ArtLife
=======
flugen <flugen@flugen>
v0.5 June 2012

Artificial Life simulator
-------------------------

This project is designed to simulate populations of creatures that have the potential to evolve.  Their world has several types of terrain, and the organisms are allowed various traits to help them survive.  Each creature's main goal is currently merely to survive, with almost all actions costing energy, even standing still.  The only way to regain energy is to find and consume Food. Now, creatures travel around the world and if they meet have the option to reproduce.  Their offspring will have a combination of the traits of it's parent, with a sprinkling of mutations as well, in order to allow said evolution.  

Now, our organisms are rather homogenous in physical aspects, they have three "unique" parameters: max energy, color, and transportation mode.  Max energy is self explanatory, transportation mode determines what terrain they fit best (e.g. swimming in water), and color forms a way to allow "speciation", though we are uncertain if that will ever come into play.  These parameters do not really allow for evolution however, since color and max energy do not really provide a survival benefit, while transportation mode's benefit is somewhat limited.  Thus, the organisms are allowed different behaviors.  

A behavior is a piece of Java code that an organism executes once per turn.  The constraints on the behavior consist of a limited number of inputs (primarily information about the world around the organism and its current location) and at least one output specifying which behavior should follow.  Now, the behavior does not specify what the next behavior is, merely an index into the organisms list of behaviors.  The one other thing necessary for a behavior is a method to mutate the behavior.

With this definition of a behavior, we use them as the primary genes of our organism.  During reproduction we use the crossover and mutation operators to create unique children, that will hopefully do better than their parents.  Crossover involves swapping sections of the gene list, while mutation can either occur as a change in the execution of the behavior (i.e. move forward 3 => move forward 2), or a complete change to another behavior type (i.e. move forward 3 => turn right).

While the end goal is to evolve intresting sets of behaviors, we are uncertain at this time whether our design will produce them.  Thus, the more people who create novel behaviors and run the simulation, the better.


Usage
-----

Currently, ArtLife can be run as a Java application or an applet, with ArtLifeMain as the main class.  To run the program, simply navigate to the ArtLife folder and run 

        javac ArtLife.java

and then 

        java ArtLife

Alternatively, you can package the files in a .jar file and use that.


Creating Behaviors
------------------

The possible behaviors an organism can have are listed in the Behaviors file.  See that file for syntax.  Adding a new behavior is a simple as adding another behavior to that file, as long as it has the appropriate syntax.  When the next organism is born, this file will be sourced if a behavior is mutated to another type.


TODO
----

- Add mutation to different behavior in DNA.java
- Possibly modify terrain generation.
- Probably should check other behaviors.