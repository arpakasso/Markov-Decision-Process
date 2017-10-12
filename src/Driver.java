/* CS 4375 Assignment 3: Markov Decision Processes
 * Author: Elizabeth Trinh
 *
 * Command line arguments (4): #states, #possible actions, input file path, and discount factor
 *
 * Function: The program will output to stdout the J value and optimal policy for each state of the given MDP.
 *
 * The program reads the input file with a helper method, readData,
 *      which stores values in an array of State objects corresponding to the MDP.
 * Each State stores its name, reward, and an ArrayList of transitions.
 * Creates a ValueIterator object to calculate J values and optimal policy.
 */

import java.io.*;
import java.util.*;

public class Driver {
    public static void main(String[] args) throws FileNotFoundException {
        // checks for the correct amount of commandline arguments
        if (args.length == 4) {
            // read in training data
            Scanner trainIn = new Scanner(new File(args[2]));

            // parse input file
            State[] stateInfo = readData(trainIn, Integer.parseInt(args[0]));

            // create value iterator and calculate best policy
            ValueIterator vi = new ValueIterator(Integer.parseInt(args[0]));
            vi.iterate(stateInfo, Integer.parseInt(args[1]), Double.parseDouble(args[3]));
        }
        else {
            System.err.printf("Incorrect number of arguments. Only %d argument(s). " +
                    "\nRequires four arguments: #states, #possible actions, input file path, and discount factor.", args.length);
        }
    }

    /**
     * Parses input data.
     * @param in Scanner for input file
     * @param len number of states in the input file
     * @return State array containng all the states and their associated transitions
     * @throws FileNotFoundException if input file is not found
     */
    public static State[] readData(Scanner in, int len)  throws FileNotFoundException {
        State[] rtn = new State[len];

        int pos = 0;
        String line;
        do {
            // ignore lines with only whitespace characters + trims strings
            do {
                line = in.nextLine().trim();
            } while (line.isEmpty());

            // split line on spaces
            String[] splits = line.split(" ");
            // first two values are state values
            State curr = new State(splits[0], Double.parseDouble(splits[1]));
            // split along open parenthesis
            splits = line.split("\\(");
            // starting from 2nd position, each represents a transition
            for (int i = 1; i < splits.length; i++) {
                // split on space, close parenthesis, or close parenthesis and space
                String[] trans = splits[i].split(" |\\) |\\)");
                // the first three elements are transition/edge values
                curr.add(trans[0], trans[1], Double.parseDouble(trans[2]));
            }
            // add the completed state to the array
            rtn[pos] = curr;

            pos++;
        } while (in.hasNextLine() && pos < len);
        in.close();

        return rtn;
    }
}