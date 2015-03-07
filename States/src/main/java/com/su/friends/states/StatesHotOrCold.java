package com.su.friends.states;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.gen.code.MyEnumSimpleType;


public class StatesHotOrCold {

	public static void main(String[] args) throws JAXBException {
		boolean win = false;
		int numGuess = 0;
		int guess;
		String guessString = "";
		int randState = randInt(1,51);
		//System.out.println("Rand is: " + randState);
		int distance =-1;
		//create an empty adjacency matrix
		StatesGraph graph;
		
		try{
			 graph = createGraph();
			 Scanner keyboard = new Scanner(System.in);
			
				System.out.println("Enter a state name. ex. Arizona");
				guessString = keyboard.nextLine();
				guess = getGuessInt(guessString);
				while(guess == 0 ){
					System.out.println("That is not a valid state, enter a state name. ex. Arizona");
					guessString = keyboard.nextLine();
					guess = getGuessInt(guessString);
				}		
				numGuess++;
			while (win == false){
				if (guess == randState)
				{
					win = true;
				}else{
					distance = getDistance(guess, randState, graph);
					howCloseisGuess(distance);
					
					System.out.println("Enter a state name. ex. Arizona");
					guessString = keyboard.nextLine();
					guess = getGuessInt(guessString);
					while(guess == 0 ){
						System.out.println("That is not a valid state, enter a state name. ex. Arizona");
						guessString = keyboard.nextLine();
						guess = getGuessInt(guessString);
					}		
					numGuess++;
				}
			}
			if(win){
				win(numGuess);
			}
				keyboard.close();
		}catch(IOException e){
			e.printStackTrace();
		}	
	}

	private static StatesGraph createGraph() throws FileNotFoundException,
			IOException, JAXBException {
		String data;
		int num_verticies;
		String[] edges;
		StatesGraph graph;
		BufferedReader in = new BufferedReader(new FileReader(new File("//Users//Matt//Documents//workspace//JAXB Code//States//src//main//resources//statesAdjacencyList.txt")));
		 data = in.readLine();
		 num_verticies = Integer.parseInt(data);
		 data = in.readLine();

		 graph = new StatesGraph(num_verticies);
		 data = in.readLine();
		 
		 while(data != null){
			 edges = data.split(" ");
			int v = Integer.parseInt(edges[0].trim());
			int e = Integer.parseInt(edges[1].trim());
			 graph.setEdge(v,e);
			 data = in.readLine();
		 }
		 System.out.println("All Items Added");
		 in.close();
		return graph;
	}

	private static void howCloseisGuess(int distance) {
		switch(distance){
		case 1:
			System.out.println("You are HOT! " + distance);
			break;
		case 2:
			System.out.println("You are warm " + distance);
			break;
		case 3:
			System.out.println("You are cold " + distance);
			break;
		default:
			System.out.println("You are Freezing! " + distance);
			break;
		}
	}

	private static void win(int numGuess) {
		System.out.println("You Win!!!!!!!");
		System.out.println("It took you "+numGuess+" Guesses");
		highScore(numGuess);
	}
	
	//returns the minimum number of connections between 2 states 
	public static int getDistance(int guess, int actual, StatesGraph graph){
		List<Integer> lvl1, lvl2, lvl3;
		lvl1= graph.getEdge(guess);
		//Check 1st level depth
		if(lvl1.contains(actual)){		
			return 1;
		}else {
			//check second level depth
			for(int i = 0; i < lvl1.size(); i++){
				lvl2 = graph.getEdge(lvl1.get(i));
				if(lvl2.contains(actual)){
					return 2;
				}
			}
			//Check 3rd level depth
			for(int i = 0; i < lvl1.size(); i++){
				lvl2 = graph.getEdge(lvl1.get(i));
				for(int x = 0; x < lvl2.size(); x++){
					lvl3 = graph.getEdge(lvl2.get(x));
					if(lvl3.contains(actual)){
						return 3;
					}
				}
			}
		}
			return 4;
	}
	
	//Generates a random integer for the random states
	public static int randInt(int min, int max) {
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}
	
	//Displays the high score list and updates it if the user is in the top 10
	public static void highScore(int score){
		
		if( score <11){
			Scanner keyboard = new Scanner(System.in);
			System.out.println("Congratulations! You got a high score!");
			System.out.println("Enter your Name!");
			Score s = new Score(keyboard.nextLine(), score);
			
			
			try{
				String line = "";
				PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("scoreList.temp")));
				BufferedReader in = new BufferedReader(new FileReader(new File("//Users//Matt//Documents//workspace//JAXB Code//States//src//main//resources//scoreList.txt")));
				int lineNum = 1;
				String temp = "";
				while((line = in.readLine()) != null && lineNum <11){
					//replace the line with the new high score
					 if (lineNum == s.getScore()) {
						 temp = line;
						 line = s.getName();
						 writer.println(line);
						 lineNum++;
						 //push the rest of the names down one
						 while((line = in.readLine()) != null && lineNum <11){
						   writer.println(temp);
						   temp=line;
						 }
					 }else{
					 writer.println(line);
					   lineNum++;
					 }
				}
					writer.close();
					in.close();
					// ... and finally ...
					File realName = new File("scoreList.txt");
					realName.delete(); // remove the old file
					// Rename temp file
					new File("scoreList.temp").renameTo(realName); // Rename temp file
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		
		try{
		 BufferedReader in = new BufferedReader(new FileReader(new File("//Users//Matt//Documents//workspace//JAXB Code//States//src//main//resources//scoreList.txt")));
		 System.out.println("The High Scores are: ");
		 for(int i = 1; i < 11; i++){
			 String data = in.readLine();
			 System.out.println("#" +i+" " + data);
		 }
		 in.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	//Converts users string guess into an integer for checking
	public static int getGuessInt(String state){
		try {
			MyEnumSimpleType enumer =  MyEnumSimpleType.fromValue(state);
			int i = enumer.ordinal();
			return i + 1;
			}catch(IllegalArgumentException ie){
				
				ie.printStackTrace();
			}
		return 0;
	}
}
