package csula.cs4660.games;

import com.google.common.collect.Lists;

import java.util.*;

/**
 * Simple game agent for playing games
 */
public class WGCFGameAgent {

    public class State{
        int id;
        boolean[] data;
    }


    public String getAction(boolean[] state) {
        // TODO: implement your BFS/A*

        List<String> possibleActions = getPossibleActions(state);
        Map<State, State> parents = new HashMap<>();
        Queue<boolean[]> frontier = new LinkedList<>();
        frontier.add(new State(0, state));

        while (!frontier.isEmpty()){
            boolean [] current = frontier.poll();

            for (String possibleAction: getPossibleActions(current)){

            }

        }

        Random random = new Random();


        return "g";
    }

    private Collection<String> getPossibleActions(boolean[] state){
        Collection<String> result = Lists.newArrayList();

        for (int i = 0; i < state.length; i++){
            if (state[i] == state[state.length - 1]){
                result.add(convertIndexToAction(i));
            }

        }
        return result;
    }

    private String convertIndexToAction(int i) {
        switch (i) {
            case 0:
                return "w";
            case 1:
                return "g";
            case 2:
                return "c";
            case 3:
                return "f";
            default:
                throw new IllegalArgumentException();
        }
    }
}
