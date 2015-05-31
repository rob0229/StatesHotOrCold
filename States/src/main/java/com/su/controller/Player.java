package com.su.controller;

import javax.validation.constraints.Pattern;

public class Player {
	@Pattern(regexp="[^0-9]*")
	private String playerName;
	
	private String playerChoice;
	
	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPlayerChoice() {
		return playerChoice;
	}

	public void setPlayerChoice(String playerChoice) {
		this.playerChoice = playerChoice;
	}

	
	
}
