

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Backgammon {
	private int[] board; // Positive numbers - white pieces, negative - black pieces.
	private int[] eaten; // 2 cells - 1st cell for whites eaten pieces, 2nd for blacks.
	private int[] cubesUsages; // How many more usages do we have for each cube
	private boolean whitesTurn; // Is it whites turn?
	private Random rd = new Random(); // Random generator.
	private Scanner sc = new Scanner(System.in); // For getting the users position and cube to use.
	
	Backgammon() {
		// TODO
	}
	
	Backgammon(int board_size) {
		// TODO
	}
	
	@SuppressWarnings("unused")
	public void initBoard() { // useful when playing more than 1 game.
		initBoard(24);
	}
	
	public void initBoard(int boardSize) {
		// ...
	}
	
	public String toString() {
		// Should look like:
		// [2, 0, 0, 0, 0, -5][0, -3, 0, 0, 0, 5]
		// [-2, 0, 0, 0, 0, 5][0, 3, 0, 0, 0,-5]
		// Whites eaten - 0, blacks eaten - 0
		
		// You can use Arrays functionalities here, will make your life much easier...
		// Hints: Arrays.copyOfRange, Arrays.toString
		
		// ...
		return null; // TODO CHANGE
	}
	
	public int[] getBoard() {
		// ...
		return null; // TODO CHANGE
	}
	
	public boolean getWhitesTurn() {
		// ...
		return false; // TODO CHANGE
	}
	
	public void setBoard(int[] board) {
		// Use with caution, should be used only for debugging purposes!
		this.board = board;
	}

	public boolean whiteStarts() {
		// You can give random boolean here, equivalent to randomly rolling 2 cubes and deciding from them
		// ...
		return false; // TODO CHANGE
	}
	
	public int[] roll2Cubes() {
		int[] cubes = new int[2];
		// TODO CHANGE
		return cubes;
	}
	
	public boolean gameOver() {
		// ...
		return false; // TODO CHANGE
	}
	
	public boolean move(int position, int move) {
		int direction = this.whitesTurn ? 1 : -1;
		if (legalMove(position, move)) {
			// TODO CHANGE
			return true;
		}
		return false;
	}
	
	public boolean haveLegalMoves(int[] cubes) { // Any legal moves for the player
		// ...
		return false; // TODO CHANGE
	}
	
	public boolean legalMove(int startPosition, int move) {
		// ...
		return false; // TODO CHANGE
	}
	
	public int farthestStone() {
		// ...
		return -1; // TODO CHANGE
	}
	
	public boolean farthestStoneInLastQuadrant(int farthestStone) {
		// ...
		return false; // TODO CHANGE
	}
	
	public boolean outOfBoard(int position) {
		// ...
		return false; // TODO CHANGE
	}
	
	public void nextTurn() {
		// ...
		// TODO CHANGE
	}
	
	public void runGame() {
		while (!this.gameOver()) {
			int[] cubes = this.roll2Cubes();
			this.cubesUsages[1] = this.cubesUsages[0] = (cubes[0] == cubes[1]) ? 2 : 1;
			
			// Move the board using legal moves rolled by the cubes:			
			while (this.cubesUsages[0] > 0 || this.cubesUsages[1] > 0) {
				if (!this.haveLegalMoves(cubes))
					break;
				
				System.out.print(this.whitesTurn ? "Whites turn (⇄)" : "Blacks turn (⇆)");
				System.out.println(", Rolled " + cubes[0] + " " + cubes[1]);
				System.out.print("Insert position number: ");
				int choosenPosition = this.sc.nextInt();
				System.out.print("Insert cube number (0 or 1): ");
				int cubeToUse = this.sc.nextInt();
				if (cubeToUse < 0 || cubeToUse >= cubes.length) {
					System.out.println("Please select a cube from the range of 0 to " + (cubes.length - 1));					
					continue;
				}
				if (this.cubesUsages[cubeToUse] <= 0) {
					System.out.println("Can\'t use this cube again!");					
					continue;
				}
				int choosenMove = cubes[cubeToUse];
				boolean moved = this.move(choosenPosition, choosenMove);
				if (moved) {
					this.cubesUsages[cubeToUse] -= 1;
					System.out.println(this);
				} else
					System.out.println("Illegal move!");
			}
			this.nextTurn();
		}
		System.out.println(this.whitesTurn ? "Black won!" : "White won!");
	}
	
	public static void main(String[] args) {
		Backgammon bg = new Backgammon();
		System.out.println(bg);
		bg.runGame();
	}
}
