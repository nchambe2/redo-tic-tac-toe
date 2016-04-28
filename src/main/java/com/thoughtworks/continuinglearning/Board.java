package com.thoughtworks.continuinglearning;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.List;

/**
 * Created by nicollettec on 4/28/16.
 */
public class Board {

    private List<Integer> boardArray;
    private PrintStream printStream;

    public Board(List<Integer> boardArray, PrintStream printStream){

        this.boardArray = boardArray;
        this.printStream = printStream;
    }

    public void drawBoard(){
        printStream.println(
                "1|2|3\n" +
                "-----\n" +
                "4|5|6\n" +
                "-----\n" +
                "7|8|9"
        );


//        for(Integer individualCell : boardArray){
//
//            if (individualCell <= 3){
//             stringBuilder.append(individualCell + "|");
//            } else if (individualCell == 3) {
//                stringBuilder.append("\n");
//                stringBuilder.append("-------");
//            } else if (individualCell < 6) {
//                stringBuilder.append(individualCell + "|");
//            } else if (individualCell == 6) {
//                stringBuilder.append("\n");
//                stringBuilder.append("-------");
//            } else if (individualCell < 9) {
//                stringBuilder.append(individualCell + "|");
//            } else if (individualCell == 9) {
//                stringBuilder.append("\n");
//                stringBuilder.append("-------");
//            }
//        }

    }

    public void mark(BufferedReader playerMove) {

    }
}
