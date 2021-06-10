package src;

@SuppressWarnings("unused")
public class Case {

    private int colonne;
    private int ligne;
    private Piece piece;

    /*	Constructeur vide	*/
    public Case()
    {
    	
    }
    
    
    /*	Constructeur	*/
    public Case(int ligne, int colonne,Piece p) 
    {
    	this.ligne = ligne;
    	this.colonne = colonne;
    	this.piece = p;
    }
    
    /*	Constructeur par copie	*/
    public Case(Case c)
    {
    	this.colonne = c.getColonne();
    	this.ligne = c.getLigne();
    	this.piece = c.getPiece();
    }

    /*	Retournes si case vide	*/
    public boolean caseVide() 
    {
    	return (this.piece == null);
    }

    /*	Getters	*/
    public int getLigne() 
    {
    	return this.ligne;
    }

    public int getColonne() 
    {
    	return this.colonne;
    }

    public Piece getPiece() 
    {
    	return this.piece;
    }

    public void setPiece(Piece p1) 
    {
    	this.piece = p1;
    }
    
    public String toString()
    {
    if (!(this.caseVide()))
    {	
    	return piece.toString();
    }
    
    return ".";
    }
    
    public boolean equals(Case o)
    {	
    	if (this.getPiece() == null || o.getPiece() == null)
    	{
    		return false;
    	}
		return (this.getPiece().equals(o.getPiece()));
    }
}