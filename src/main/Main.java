package main;

public class Main {
    public static boolean run = true;
    public static int turnNum = 0;
    public static void main(String[] args) {
        while (run){
            if (turnNum <9) {
                System.out.println("Round: "+turnNum);
                Design.writeField();
                Design.xTurn();
                turnNum++;
            }
            else{
                System.out.println("No more playing space");
                run = false;
            }
        }
    }
}
