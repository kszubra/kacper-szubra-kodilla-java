package tictactoe.mechanics;

import tictactoe.enumerics.CellStatus;

import java.util.*;
import java.util.stream.Collectors;

import static tictactoe.enumerics.CellStatus.CIRCLE;
import static tictactoe.enumerics.CellStatus.CROSS;
import static tictactoe.enumerics.CellStatus.EMPTY;


public class Rules {

    public static final Random RANDOM_GENERATOR = new Random();

    public static Map<String, List<CellStatus>> makeMapOfLineCoordinatesInMatrix(CellStatus[][] matrix){ //turns matrix into a map of lines

        Map<String, List<CellStatus>> mapToReturn = new HashMap<>();

        //rows
        for(int row=0; row < matrix.length; row++){

                mapToReturn.put("R"+row, Arrays.asList(matrix[row]) );
        }

        //columns
        for(int column=0; column < matrix.length; column++){
            mapToReturn.put("C"+column, new ArrayList<>());

            for(int row=0; row<matrix.length; row++){
                mapToReturn.get("C"+column).add(matrix[row][column]);
            }
        }

        //diagonals
        mapToReturn.put("D0", new ArrayList<>());
        for(int index=0; index<matrix.length; index++){

            mapToReturn.get("D0").add(matrix[index][index]);

        }

        mapToReturn.put("D2", new ArrayList<>());
        for(int index=0; index<matrix.length; index++){

            mapToReturn.get("D2").add(matrix[index][(matrix.length-1)-index]);

        }


        return mapToReturn;
    }

    public static CellStatus checkGameMatrixForWinner(CellStatus[][] gameMatrix){

        // rows

        if(gameMatrix[0][0].equals(gameMatrix[0][1]) && gameMatrix[0][0].equals(gameMatrix[0][2])) {
            return gameMatrix[0][0];
        }
        if(gameMatrix[1][0].equals(gameMatrix[1][1]) && gameMatrix[1][0].equals(gameMatrix[1][2])) {
            return gameMatrix[1][0];
        }
        if(gameMatrix[2][0].equals(gameMatrix[2][1]) && gameMatrix[2][0].equals(gameMatrix[2][2])) {
            return gameMatrix[2][0];
        }

        // columns

        if(gameMatrix[0][0].equals(gameMatrix[1][0]) && gameMatrix[0][0].equals(gameMatrix[2][0])) {
            return gameMatrix[0][0];
        }
        if(gameMatrix[0][1].equals(gameMatrix[1][1]) && gameMatrix[0][1].equals(gameMatrix[2][1])) {
            return gameMatrix[0][1];
        }
        if(gameMatrix[0][2].equals(gameMatrix[1][2]) && gameMatrix[0][2].equals(gameMatrix[2][2])) {
            return gameMatrix[0][2];
        }

        // diagonals

        if(gameMatrix[0][0].equals(gameMatrix[1][1]) && gameMatrix[0][0].equals(gameMatrix[2][2])) {
            return gameMatrix[0][0];
        }
        if(gameMatrix[0][2].equals(gameMatrix[1][1]) && gameMatrix[0][2].equals(gameMatrix[2][0])) {
            return gameMatrix[0][2];
        }

        return CellStatus.EMPTY;

    }

    public static Map<String, List<CellStatus>> giveLineInDanger(Map<String, List<CellStatus>> mapOfLines){

        return mapOfLines.entrySet().stream()
                .filter(e-> Collections.frequency(e.getValue(), CROSS) == 2)
                .filter(e-> Collections.frequency(e.getValue(), EMPTY) == 1)
                .collect(Collectors.toMap(e->e.getKey(), e->e.getValue()));

    }

    public static Map<String, List<CellStatus>> giveLineWithChance(Map<String, List<CellStatus>> mapOfLines){

        return mapOfLines.entrySet().stream()
                .filter(e-> Collections.frequency(e.getValue(), CIRCLE) == 2)
                .filter(e-> Collections.frequency(e.getValue(), EMPTY) == 1)
                .collect(Collectors.toMap(e->e.getKey(), e->e.getValue()));

    }

    public static String tellIndexOfLastEmptyInLine(Map<String, List<CellStatus>> lineToComplete){

        String rowIndex = "none";
        String columnIndex = "none";

        String key = lineToComplete.keySet().stream().findFirst().get();
        char firstLetter = key.charAt(0);

        switch(firstLetter){
            case 'R':
                rowIndex = key.substring(1);
                columnIndex = "" + lineToComplete.get(key).indexOf(EMPTY);
                break;
            case 'C':
                columnIndex = key.substring(1);
                rowIndex = "" + lineToComplete.get(key).indexOf(EMPTY);
                break;
            case 'D':
                if(key.equals("D0")){
                    columnIndex = "" + lineToComplete.get(key).indexOf(EMPTY);
                    rowIndex = "" + lineToComplete.get(key).indexOf(EMPTY);
                } else if(key.equals("D2")){
                    columnIndex = "" + (2-lineToComplete.get(key).indexOf(EMPTY));
                    rowIndex = "" + lineToComplete.get(key).indexOf(EMPTY);
                }
                break;
        }

        return "R"+rowIndex+"C"+columnIndex;

    }


    public static String tellCellToBlock(Map<String, List<CellStatus>> mapOfLines){

        Map<String, List<CellStatus>> lineInDanger = Rules.giveLineInDanger(mapOfLines);

        return tellIndexOfLastEmptyInLine(lineInDanger);
    }

    public static String tellCellToWin(Map<String, List<CellStatus>> mapOfLines){

        Map<String, List<CellStatus>> lineToWin = Rules.giveLineWithChance(mapOfLines);

        return tellIndexOfLastEmptyInLine(lineToWin);
    }


}
