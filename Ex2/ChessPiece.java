public abstract class ChessPiece
{
    //    A class that represents a game board in a chess piece.
    protected Position position;

    // abstract method return an array of places that the chess tool can move to.
    public abstract Position[] moves(Position p);

    // getter for this.Position.
    public abstract Position getPosition();

    //    Checks whether the index of the row or column is valid
    protected boolean isValidIndex(int p)
    {
        return p <= 8 && p >= 1;
    }

    // Checks whether the Position object is a valid.
    protected boolean isValidP(Position p)
    {
        int row = p.getRow(), col = p.getCol();
        return row <= 8 && row >= 1 && col <= 8 && col >= 1;
    }
}
