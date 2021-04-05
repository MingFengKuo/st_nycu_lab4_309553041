public class Game {

    public String WinOrLose(String [] result){

        switch (result[0]){
            case "rock":
                switch (result[1]){
                    case "rock" : return "Draw!";
                    case "paper" : return "Player 2 win!";
                    case "scissors" : return "Player 1 win!";
                }
            case "paper":
                switch (result[1]){
                    case "rock" : return "Player 1 win!";
                    case "paper" : return "Draw!";
                    case "scissors" : return "Player 2 win!";
                }
            case "scissors":
                switch (result[1]){
                    case "rock" : return "Player 2 win!";
                    case "paper" : return "Player 1 win!";
                    case "scissors" : return "Draw!";
                }
        }

        return "Error!";
    }

    public void validation(String choice){
        if(!choice.equals("rock") && !choice.equals("paper") && !choice.equals("scissors")){
            throw new IllegalArgumentException();
        }
    }
}