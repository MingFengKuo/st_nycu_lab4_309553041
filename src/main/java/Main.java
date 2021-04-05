import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        Game game = new Game();
        String[] choice = new String[2];

        System.out.println("=== Welcome to Rock-Paper-Scissors game ===");
        System.out.println("Enter Player 1 choice (rock, paper or scissors):");
        choice[0] = sc.next();
        try{
            game.validation(choice[0]);
        }
        catch (IllegalArgumentException e){
            System.out.println(e + ": Bad Choice!");
            System.exit(0);
        }

        System.out.println("Enter Player 2 choice (rock, paper or scissors):");
        choice[1] = sc.next();
        try{
            game.validation(choice[1]);
        }
        catch (IllegalArgumentException e){
            System.out.println(e + ": Bad Choice!");
            System.exit(0);
        }

        System.out.println(game.WinOrLose(choice));
    }
}
