public class Bishop extends ChessPiece
{

    public Bishop(Position p) //default constructor for Bishop, Receives a position index and updates it.
    {
        this.position = p;
    }

    public Position[] moves(Position p)
    { // A method that returns an array with all possible places for the displacement of the Bishop on the board.
        Position[] A = new Position[13];
        int i = 0;
        if (isValidP(p))
        {
            for (int row = p.getRow() + 1, col = p.getCol() + 1; isValidIndex(row) && isValidIndex(col); ) //Check the movement to the right and down.
            {
                ;
                A[i] = new Position(row, col);
                row++;
                col++;
                i++;
            }
            for (int row = p.getRow() - 1, col = p.getCol() + 1; isValidIndex(row) && isValidIndex(col); ) //Check the movement to the right and up.
            {
                A[i] = new Position(row, col);
                row--;
                col++;
                i++;
            }
            for (int row = p.getRow() + 1, col = p.getCol() - 1; isValidIndex(row) && isValidIndex(col); ) // Check the movement to the left and down.
            {
                A[i] = new Position(row, col);
                row++;
                col--;
                i++;
            }
            for (int row = p.getRow() - 1, col = p.getCol() - 1; isValidIndex(row) && isValidIndex(col); ) // Check the movement to the left and up.
            {
                A[i] = new Position(row, col);
                row--;
                col--;
                i++;
            }
        }
        Position[] B = new Position[i];
        System.arraycopy(A, 0, B, 0, i); // Copies all positions to a new array.

        return B;
    }

    // getter for this.Position.

    public Position getPosition()
    {
        return this.position;
    }

    // toString method, present the name and the location of the chess piece.
    public String toString()
    {
        return "Bishop, position: " + position.toString();
    }


}
