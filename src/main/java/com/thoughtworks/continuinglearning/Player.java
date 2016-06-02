package com.thoughtworks.continuinglearning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Player {
    private Board board;
    private String symbol;
    private String playerNumber;
    private PrintStream printstream;
    private BufferedReader bufferedReader;

    public Player(Board board, String symbol, String playerNumber, PrintStream printstream, BufferedReader bufferedReader) {
        this.board = board;
        this.symbol = symbol;
        this.playerNumber = playerNumber;
        this.printstream = printstream;
        this.bufferedReader = bufferedReader;
    }

    public void makeMove() {
      printstream.println(playerMakeAMoveMessage());
      Integer locationToMark = Integer.parseInt(getUserInput());

      if(board.locationAvailable(locationToMark)) {
          board.mark(locationToMark, symbol);
      } else {
          printstream.println(locationAlreadyTakenMessage());
      }
    }

    public void hasWon() {
        if(board.hasWinner()) {
            printstream.println("Player " + playerNumber + " Wins!");
        }
    }

    private String playerMakeAMoveMessage() {
        return "Player " + playerNumber + " please enter a number from 1 through 9.";
    }

    private String locationAlreadyTakenMessage() {
         return "Location already taken";
    }

    private String getUserInput() {
        try {
            return bufferedReader.readLine();
        } catch(IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
