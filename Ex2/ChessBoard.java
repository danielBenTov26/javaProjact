public class ChessBoard
{
    private ChessPiece[] pieces;

    public ChessBoard()
    {
        pieces = new ChessPiece[10];
    }

    public String toString()
    { String toString = "";
        for (int i = 0 ; i < pieces.length ; i++ )
        { if (pieces[i] == null)
                break;
            toString += pieces[i].toString() + "\n";}
        return toString;
    }
// this method add chess piece to pieces array.
    public void addPiece(ChessPiece p)
    {
        for (int i = 0; i < pieces.length; i++)
        {
            if (pieces[i] == null)
            {
                pieces[i] = p;
                return;
            }
        }
    }
// this method get 2 index of chess piece in pieces array and return if the chess piece in index - p1, threats on  chess piece in index - p2.
    public boolean threats(int p1, int p2)
    {
        if (this.pieces[p1] == null || this.pieces[p2] == null || p1 > 9 || p1 < 0 || p2 > 9 || p2 < 0)
            return false;
        Position[] p = pieces[p1].moves(pieces[p1].getPosition());
        for (int i = 0; i < p.length; i++)
        {
            if (p[i].getRow() == pieces[p2].getPosition().getRow() && p[i].getCol() == pieces[p2].getPosition().getCol() )
            {
                return true;
            }
            }

            return false;

    }
//    this method return Who is threats who in pieces array.
    public String whoThreatsWho()
    {
        String whoThreatsWho = "";
        for (int i = 0 ;i < pieces.length - 1 ; i ++)
            for (int j = i + 1 ; j < pieces.length ; j++)
            {
                if (threats(i,j))
                    whoThreatsWho += pieces[i].toString() + " threats " + pieces[j].toString() + "\n";
            }
        return whoThreatsWho;
    }
}
