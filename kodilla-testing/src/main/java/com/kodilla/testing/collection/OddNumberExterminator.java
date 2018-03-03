package com.kodilla.testing.collection;

import java.util.ArrayList;

public class OddNumberExterminator {

    public ArrayList exterminate(ArrayList<Integer> input) {
        ArrayList<Integer> output = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i) % 2 == 0 && input.get(i) != 0) {
                output.add(i);
            }
        }
        return output;
    }
}