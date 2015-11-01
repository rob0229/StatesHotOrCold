/*
 * This class is used to generate the random state and compare a user inputed guess
 * 
 * 
 * */
package com.su.friends.states;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.xml.bind.JAXBException;

import com.gen.code.MyEnumSimpleType;

public class StatesHotOrCold {
	public String filename = "statesAdjacencyList.txt";
	//create an empty adjacency matrix
	StatesGraph graph;
	//The computer generated random state
	int randState = randInt(1,51);
	//Number of guesses so far
	int numGuess = 0;
	//Win tracker
	boolean win = false;
	//Variable to track the distance
	int distance =-1;
	
	public void init() throws JAXBException {
		
		try{
			 graph = new StatesHotOrCold().createGraph();
		}catch(IOException e){
			e.printStackTrace();
		}		
//				while(guess == 0 ){
//					//set the browser message to this...
//					result = "That is not a valid state, enter a state name. ex. Arizona";
//					//guessString = keyboard.nextLine();
//					//TODO: set guess string to value from browser
//					guess = getGuessInt(guessString);
//				}		
//				numGuess++;
//			while (win == false){
//				if (guess == randState)
//				{
//					win = true;
//				}else{
//					distance = getDistance(guess, randState, graph);
//					howCloseisGuess(distance);
//					
//					message ="Enter a state name. ex. Arizona";
//				//	guessString = keyboard.nextLine();
//					guess = getGuessInt(guessString);
//					while(guess == 0 ){
//						result = "That is not a valid state, enter a state name. ex. Arizona";
//					//	guessString = keyboard.nextLine();
//						guess = getGuessInt(guessString);
//					}		
//					numGuess++;
//				}
//			}
//			if(win){
//				result = "You Win!!!!!!! It took you "+numGuess+" Guesses";
//			}
//				//keyboard.close();
//		}catch(IOException e){
//			e.printStackTrace();
//		}	
	}

	private StatesGraph createGraph() throws FileNotFoundException,IOException, JAXBException {
		String data;
		int num_verticies;
		String[] edges;
		StatesGraph graph;
		BufferedReader in  = new BufferedReader(new FileReader(getClass().getClassLoader().getResource(filename).getFile()));
		
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
		 in.close();
		return graph;
	}

	//returns the minimum number of connections between 2 states 
	public int getDistance(String g){
		int guess = getGuessInt(g);
		if(guess == 0){
			//error
			return -1;
		}
		
		List<Integer> lvl1, lvl2, lvl3;
		lvl1= graph.getEdge(guess);
		//Check 1st level depth
		if(lvl1.contains(randState)){		
			return 1;
		}else {
			//check second level depth
			for(int i = 0; i < lvl1.size(); i++){
				lvl2 = graph.getEdge(lvl1.get(i));
				if(lvl2.contains(randState)){
					return 2;
				}
			}
			//Check 3rd level depth
			for(int i = 0; i < lvl1.size(); i++){
				lvl2 = graph.getEdge(lvl1.get(i));
				for(int x = 0; x < lvl2.size(); x++){
					lvl3 = graph.getEdge(lvl2.get(x));
					if(lvl3.contains(randState)){
						return 3;
					}
				}
			}
		}
			return 4;
	}
	
	
	//Generates a random integer for the random states
	public int randInt(int min, int max) {
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}
	
	//Converts users string guess into an integer for checking
	public int getGuessInt(String state){
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
	
	//Displays the high score list and updates it if the user is in the top 10
//	public static void highScore(int score){
//		
//		if( score <11){
//			Scanner keyboard = new Scanner(System.in);
//			System.out.println("Congratulations! You got a high score!");
//			System.out.println("Enter your Name!");
//			Score s = new Score(keyboard.nextLine(), score);
//			
//			
//			try{
//				String line = "";
//				PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("scoreList.temp")));
//				BufferedReader in = new BufferedReader(new FileReader(new File("//Users//Matt//git//StatesHotOrCold//States//src//main//resources//scoreList.txt")));
//				int lineNum = 1;
//				String temp = "";
//				while((line = in.readLine()) != null && lineNum <11){
//					//replace the line with the new high score
//					 if (lineNum == s.getScore()) {
//						 temp = line;
//						 line = s.getName();
//						 writer.println(line);
//						 lineNum++;
//						 //push the rest of the names down one
//						 while((line = in.readLine()) != null && lineNum <11){
//						   writer.println(temp);
//						   temp=line;
//						 }
//					 }else{
//					 writer.println(line);
//					   lineNum++;
//					 }
//				}
//					writer.close();
//					in.close();
//					// ... and finally ...
//					File realName = new File("scoreList.txt");
//					realName.delete(); // remove the old file
//					// Rename temp file
//					new File("scoreList.temp").renameTo(realName); // Rename temp file
//			}catch(IOException e){
//				e.printStackTrace();
//			}
//		}
//		
//		try{
//		 BufferedReader in = new BufferedReader(new FileReader(new File("//Users//Matt//git//StatesHotOrCold//States//src//main//resources//scoreList.txt")));
//		 System.out.println("The High Scores are: ");
//		 for(int i = 1; i < 11; i++){
//			 String data = in.readLine();
//			 System.out.println("#" +i+" " + data);
//		 }
//		 in.close();
//		}catch(IOException e){
//			e.printStackTrace();
//		}
//	}
//	

