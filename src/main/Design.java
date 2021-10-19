package main;

import java.util.Scanner;

public class Design {


    private static String[] field = {
            "0","1","2","3","4","5","6","7","8"
    };
    private static int[][] combinations ={
            {0,1,2},
            {3,4,5},
            {6,7,8},
            {0,4,8},
            {2,4,6},
            {0,3,6},
            {1,4,7},
            {2,5,8}
    };
    public static void writeField(){
        for(int i = 0; i< Design.field.length; i++){
            if(i == 0){
                if (!field[0].equals("0")){
                    System.out.print(field[0]+"|");
                }
                else{
                    System.out.print("0|");
                }
            }
            else if ((i+1)%3 == 0){
                System.out.println(Design.field[i]);
            }
            else{
                System.out.print(Design.field[i]+"|");
            }
        }
    }
    public static void xTurn(){
        System.out.println("X turn");
        Scanner sc = new Scanner(System.in);
        int writeCords = sc.nextInt();
        field[writeCords] = "X" ;
        writeField();
        checkWin();
        if(Main.run){
            oTurn();
        }
    }

    public static void oTurn(){
        System.out.println("O turn");
        Scanner sc = new Scanner(System.in);
        int writeCords = sc.nextInt();
        field[writeCords] = "O" ;
        writeField();
        System.out.println("O turn");
        System.out.println();
        checkWin();

    }

    public static void checkWin(){
        for (int[] trip: combinations){
            for (int i = 0; i<trip.length; i=i+3){
                if (field[trip[i]].equals(field[trip[i + 1]]) && field[trip[i + 2]].equals(field[trip[i + 1]]) && field[trip[i]].equals(field[trip[i + 2]])){
                    end();
                    Main.run = false;
                    break;
                }
            }
        }
    }
    public static void end(){
        System.out.println("Vyhrál hráč X po "+(Main.turnNum+1)+" kolech.");
    }
}
