//import java.io.Serializable;
//import java.util.Objects;
//
//public class runGame implements Serializable {
//    Integer p1Points;
//    Integer p2Points;
//    String p1Plays;
//    String p2Plays;
//    Boolean have2Players;
//    Integer p1Guess;
//    Integer p2Guess;
//    Boolean p1Status;
//    Boolean p2Status;
//
//    public void getPlayStatuss() {
//        // player 1 has same guess as the player 2 play
//        if(Objects.equals(p1Guess, p2Plays)){
//            p1Status = true;
//        }
//        // player 2 has same guess as the player 1 play
//        else if(Objects.equals(p2Guess, p1Plays)){
//            p2Status = true;
//        }
//        // player 2 does not have the same guess as the player 1 play
//        else if(p2Guess!=p1Plays){
//            p2Status = false;
//        }
//        // player 1 does not have the same guess as the player 2 play
//        else if(p1Guess!=p2Plays){
//            p1Guess = false;
//        }
//    }
//
//    Public void GetPlayPoints(){
//        // If both player guessed it corectly they will 0 points
//        if(Objects.equals(p1Status, p2Status)){
//            p1Points = 0;
//            p2Points = 0;
//        }
//        // if player 1 guessed it correctly
//        else if(p1Status == true){
//            // and player 2 guess wrong they will have 2 points
//            if(p2Status == false){
//                p1Points = 2;
//            }
//            // if player 2 guess it wrong they will have 0 points
//            else if(p2Status == true){
//                p1Points = 0;
//            }
//        }
//        // if player 2 guessed it correctly
//        else if(p2Status == true){
//            // player 1 guess wrong they will get 2 points
//            if(p1Status == false){
//                p1Points = 2;
//            }
//            // if player 1 guess right they will get 0 points
//            else if(p1Status == true){
//                p1Points = 0;
//            }
//        }
//    }
//
//    getPlayStatuss();
//    GetPlayPoints();
//
//}
