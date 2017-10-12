## Authors

Elizabeth Trinh - ent150130

## List of Source Files:

*  Driver.java
*  ValueIterator.java
*  State.java
*  Edge.java

## Platform

Windows

## Assumptions

Input File Contents:

*  States are denoted: s# (e.g. State 0: s0, State 1: s1, State n: sn)
*  Actions are denoted: a# (e.g. Action 0: a0, Action 1: a1, Action n: an)

## Compile and Run:

1. Open command line
2. Navigate to the folder with the java files.
3. `javac *.java` to compile files.
4.  `java Driver <#ofstates> <#ofpossibleactions> <inputfilepath> <discountfactor>` to run program.
   *  `<#ofstates>`: the number of states in the MDP
   *  `<#ofpossibleactions>`: the number of possible actions in the MDP
   *  `<inputfilepath>`: file name/path for the MDP input file
   *  `<discountfactor>`: the discount factor, or gamma

