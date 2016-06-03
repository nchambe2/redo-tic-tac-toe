package com.thoughtworks.continuinglearning;

import java.io.PrintStream;
import java.util.List;

public class Board {
    private PrintStream printStream;
    private List<String> locations;

    public Board(PrintStream printStream, List<String> locations) {
        this.printStream = printStream;
        this.locations = locations;
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
       boolean isLocationEmpty = !locations.get(locationToMark - 1).equals("X") && !locations.get(locationToMark).equals("O");

       return isLocationEmpty;
   }

    public void mark(Integer locationToMark, String symbol) {
        locations.set(locationToMark - 1, symbol);
    }

    //value | isX    | isO    | isX && isY
    //1     | true   | true   | true
    //2     | true   | true   | true
    //3     | true   | true   | true
    //4     | true   | true   | true
    //5     | true   | true   | true
    //6     | true   | true   | true
    //7     | true   | true   | true
    //8     | true   | true   | true
    //9     | true   | true   | true
    //X     | true   | false  | false


    public Boolean isThereAnEmptySpace() {
        for(String location :locations) {
            if(isLocationEmpty(location)) {
                return true;
            }
        }

        return false;
    }

    private boolean isLocationEmpty(String location) {
        return !location.equals("X") && !location.equals("O");
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