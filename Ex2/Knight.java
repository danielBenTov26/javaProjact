public class Knight extends ChessPiece
{
    public Knight(Position p)
    {
        this.position = p;
    }

    // A method that returns an array with all possible places for the displacement of the Knight on the board.

    public Position[] moves(Position p)
    {
        Position[] A = new Position[13];
        int i = 0;
        int row, col;
        if (isValidP(p))
        {
            row = (p.getRow() - 2); // Checks if valid 2 steps up.
            if (isValidIndex(row))
            {
                col = p.getCol() - 1;
                if (isValidIndex(col)) // Checks the option of 2 steps up and step left.
                {
                    A[i] = new Position(row, col);
                    i++;
                }
                col = p.getCol() + 1; // Checks the option of 2 steps up and step right.
                if (isValidIndex(col))
                {
                    A[i] = new Position(row, col);
                    i++;
                }
            }

            row = (p.getRow() + 2); // Checks if valid 2 steps down.
            if (isValidIndex(row))
            {
                col = p.getCol() - 1;   // Checks the option of 2 steps down and step left.
                if (isValidIndex(col))
                {
                    A[i] = new Position(row, col);
                    i++;
                }
                col = p.getCol() + 1;    // Checks the option of 2 steps down and step right.
                if (isValidIndex(col))
                {
                    A[i] = new Position(row, col);
                    i++;
                }
            }
            col = p.getCol() + 2;   // Checks if valid 2 steps right.
            if (isValidIndex(col))
            {
                row = p.getRow() + 1;
                if (isValidIndex(row))  // Checks the option of 2 steps right and step down.
                {
                    A[i] = new Position(row, col);
                    i++;
                }
                row = p.getRow() - 1;
                if (isValidIndex(row))   // Checks the option of 2 steps right and step up.
                {
                    A[i] = new Position(row, col);
                    i++;
                }
            }
            col = p.getCol() - 2;
            if (isValidIndex(col))  // Checks if valid 2 steps left.
            {
                row = p.getRow() + 1;
                if (isValidIndex(row))    // Checks the option of 2 steps left and step down.
                {
                    A[i] = new Position(row, col);
                    i++;
                }
                row = p.getRow() - 1;
                if (isValidIndex(row))   // Checks the option of 2 steps left and step up.
                {
                    A[i] = new Position(row, col);
                    i++;
                }

            }

        }
        Position B[] = new Position[i];
        System.arraycopy(A, 0, B, 0, i);    // Copies all positions to a new array.
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
        return "Knight, position: " + position.toString();
    }

}

