package com.thoughtworks.continuinglearning;

import java.io.PrintStream;
import java.util.List;

public class Board {
    private PrintStream printStream;
    private Prompter prompter;
    private List<String> locations;
    private Boolean allLocationsTaken;
    private Integer numOfEmptyLocations;

    public Board(PrintStream printStream, Prompter prompter, List<String> locations, Boolean allLocationsTaken, Integer numOfEmptyLocations) {
        this.printStream = printStream;
        this.prompter = prompter;
        this.locations = locations;
        this.allLocationsTaken = allLocationsTaken;
        this.numOfEmptyLocations = numOfEmptyLocations;
    }

    public void draw() {
        printStream.println(
                locations.get(0) + "|" + locations.get(1) + "|" + locations.get(2) + "\n" +
                "-----" + "\n" +
                locations.get(3) + "|" + locations.get(4) + "|" + locations.get(5) + "\n" +
                "-----" + "\n" +
                locations.get(6) + "|" + locations.get(7) + "|" + locations.get(8) + "\n"
        );
    }

    public Boolean isFull() {
        if (getNumOfEmptyLocations().equals(0)) {
           printStream.println("Game is a draw");
           return allLocationsTaken = true;
        } else {
            return allLocationsTaken;
        }
    }

    public void mark(String symbol) {
        String cellToMark = prompter.prompt();
        Boolean locationAvailability = checkLocation(cellToMark);

        if(locationAvailability) {
            locations.set(Integer.parseInt(cellToMark) - 1, symbol);
        } else {
            printStream.println("Location already taken");
        }
    }

    private Boolean checkLocation(String cell) {
        if(locations.contains(cell)) {
            setNumOfEmptyLocations(1);
            return true;
        } else {
            return false;
        }
   }

    public Integer getNumOfEmptyLocations() {
       return numOfEmptyLocations;
    }

    public void setNumOfEmptyLocations(int currentNumOfLocations) {
        numOfEmptyLocations -= currentNumOfLocations;
    }


}