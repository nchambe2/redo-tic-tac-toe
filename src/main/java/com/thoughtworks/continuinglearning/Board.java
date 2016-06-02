package com.thoughtworks.continuinglearning;

import java.io.PrintStream;
import java.util.List;

public class Board {
    private PrintStream printStream;
    private List<String> locations;
    private Boolean allLocationsTaken;
    private Integer numOfEmptyLocations;

    public Board(PrintStream printStream, List<String> locations, Integer numOfEmptyLocations) {
        this.printStream = printStream;
        this.locations = locations;
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

   public boolean locationAvailable(Integer locationToMark) {
       boolean isLocationEmpty = !locations.get(locationToMark).equals("X") && !locations.get(locationToMark).equals("O");
       return isLocationEmpty;
   }

    public void mark(Integer locationToMark, String symbol) {
        locations.set(locationToMark - 1, symbol);
    }

    public Boolean isFull() {
        if (getNumOfEmptyLocations().equals(0)) {
           printStream.println("Game is a draw");
           return allLocationsTaken = true;
        } else {
            return allLocationsTaken;
        }
    }


    public Integer getNumOfEmptyLocations() {
       return numOfEmptyLocations;
    }

    public void setNumOfEmptyLocations(int currentNumOfLocations) {
        numOfEmptyLocations -= currentNumOfLocations;
    }


    public Boolean hasWinner() {
        return isDiagonalWin();
    }

    private Boolean isDiagonalWin() {
        if(locations.get(0).equals("X") && locations.get(4).equals("X") && locations.get(8).equals("X")) {
            return true;
        } else if(locations.get(2).equals("X") && locations.get(4).equals("X") && locations.get(6).equals("X")) {
            return true;
        } else if(locations.get(0).equals("O") && locations.get(4).equals("O") && locations.get(8).equals("O")) {
            return true;
        } else if(locations.get(2).equals("O") && locations.get(4).equals("O") && locations.get(6).equals("O")) {
            return true;
        } else {
            return false;
        }
    }

}