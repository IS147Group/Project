package com.company;

class Player extends Person {
	 private char playerPiece;

	 public Player(String name, char playerPiece){
		 super.setName(name);
		 this.playerPiece = playerPiece;
	 }
	 public String getName() {
			return super.getName();
		}
	 public void setPlayerPiece(char playerPiece) {
	  this.playerPiece = playerPiece;
	 }
	 public char getPlayerPiece() {
	  return this.playerPiece;
	 }
}