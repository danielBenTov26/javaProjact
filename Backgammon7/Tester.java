

import java.util.Arrays;

class Tester {
	private Backgammon bg;
	String initialBoard = "[2, 0, 0, 0, 0, -5][0, -3, 0, 0, 0, 5]\n"
						+ "[-2, 0, 0, 0, 0, 5][0, 3, 0, 0, 0, -5]"
						+ "\nWhites eaten - 0, blacks eaten - 0";
	
	public void newBoard(){
		this.bg = new Backgammon();
	}
	
	interface Testing {boolean test();}
	
	public boolean testToString() {
		return this.bg.toString().equals(initialBoard);
	}
	
	
	public boolean testGetBoard() {
		int[] board = new int[]{2, 0, 0, 0, 0, -5, 0, -3, 0, 0, 0, 5,
								-5, 0, 0, 0, 3, 0, 5, 0, 0, 0, 0, -2};
		return Arrays.equals(bg.getBoard(), board);
	}
	
	public boolean testGetBoardNotEmpty() {
		int[] board = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
								0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		return !Arrays.equals(bg.getBoard(), board);
	}
	
	public boolean testOutOfBoard() {
		return bg.outOfBoard(-1) && bg.outOfBoard(-11) && bg.outOfBoard(24) && bg.outOfBoard(28);
	}
	
	public boolean testNotOutOfBoard() {
		return !bg.outOfBoard(0) && !bg.outOfBoard(5) && !bg.outOfBoard(16) && !bg.outOfBoard(23);
	}
	
	public boolean testTurnChanging() {
		boolean currentTurn = bg.getWhitesTurn();
		bg.nextTurn();
		boolean nextTurn = bg.getWhitesTurn();
		bg.nextTurn();
		return (currentTurn != nextTurn) && (currentTurn == bg.getWhitesTurn());
	}
	
	public boolean testFarthestStone() {
		int[] board = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
								0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0};
		bg.setBoard(board);
		if (!bg.getWhitesTurn())
			bg.nextTurn();
		int farthestStone = bg.farthestStone();
		return (farthestStone == 18) && bg.farthestStoneInLastQuadrant(farthestStone); 
	}
	
	Testing[] tests = {
			new Testing() {public boolean test() { return testToString(); } },
			new Testing() {public boolean test() { return testGetBoard(); } },
			new Testing() {public boolean test() { return testGetBoardNotEmpty(); } },
			new Testing() {public boolean test() { return testOutOfBoard(); } },
			new Testing() {public boolean test() { return testNotOutOfBoard(); } },
			new Testing() {public boolean test() { return testTurnChanging(); } },
			new Testing() {public boolean test() { return testFarthestStone(); } },
	};
	
	public static void main(String[] args) {
		Tester tester = new Tester();
		int failedTests = 0;
		
		System.out.println("Starting testing procedure");
		for (int i = 0; i < tester.tests.length; ++i) {
			tester.newBoard();
			if (!tester.tests[i].test()) {
				System.err.println("Test " + (i + 1) + " failed!");
				failedTests++;
			}
		}
		System.out.println("Finished running all tests!\n" + 
		(tester.tests.length - failedTests) + " out of " + 
				tester.tests.length + " tests passed.");
	}
}
