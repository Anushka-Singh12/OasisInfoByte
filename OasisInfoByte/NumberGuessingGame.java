package program3.src_program3;

//================ || NUMBER GUESSING GAME =================

import java.util.Random;
import java.util.Scanner;

class Game{
    public int number;
    public int inputNumber;
    public int noOfGuesses = 0;
    public int totalAttempt= 10;

    public int getNoOfGuesses() {
        return noOfGuesses;
    }

    public void setNoOfGuesses(int noOfGuesses) {
        this.noOfGuesses = noOfGuesses;
        int var = 3;
    }

    Game(){
        Random rand = new Random();
        this.number = rand.nextInt(100);
        System.out.println("Welcome to the number guessing game");
        System.out.println("Please write your name here");
        Scanner sc=new Scanner(System.in);
        String name= sc.next();
        
        System.out.println("You have 5 attempts to play this game so best of luck!");
        System.out.println("Enter number from 1 and 100");
    }
    void takeUserInput(){

        System.out.println("Guess the number");
        Scanner sc = new Scanner(System.in);
        inputNumber = sc.nextInt();

    }
    boolean isCorrectNumber(int round) {
    	if (noOfGuesses == totalAttempt) {
            System.out.println("GAME OVER");
            System.out.println("U REACH YOUR LIMIT ");
            System.out.println("TRY NEXT TIME ");
            return false;
        }
    	
        noOfGuesses++;
        System.out.println("round is "+ round);
        if (round == 1 && (inputNumber > 100 || inputNumber < 1)) {
            System.out.println("Error! Enter a number between 1 and 100");
        }else if(round == 2 && (inputNumber < 100 || inputNumber > 200)) {
        	System.out.println("Error ! Enter a  Number between 100 and 200");
        }
        else if (inputNumber == number) {
            if(round == 1) {
            	System.out.println("CONGRAGULATION U WIN ROUND 1 AND READY FOR ROUND 2");
                System.out.println("YOUR TOTAL ATTEMPT IS "+ noOfGuesses);
                return false;
            }
            if(round == 2) {	
            	System.out.println("CONGRAGULATION HIP HIP HURRAH");
            	System.out.println("U WIN THE GAME ");
            	return false;
            }
        }
        else if (inputNumber < number) {
            System.out.println("Too low...");
        }
        else if (inputNumber > number) {
            System.out.println("Too high...");
        }
        return true;
    }

}

public class NumberGuessingGame {

	public static void main(String[] args) {
		Game g = new Game();
        boolean b= true;
        int round = 1;
        while(b){
            g.takeUserInput();
            b = g.isCorrectNumber(round);
            if(!b && round == 1) {
            	if(g.noOfGuesses ==  g.totalAttempt) break;
            	Random rand = new Random();
                g.number = rand.nextInt(100,200);
            	g.noOfGuesses = 0;
//            	g.totalAttempt = 5;
            	b =true;
            	round++;
            }
        }

	}

}
