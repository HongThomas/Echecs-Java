package src;
import java.util.*;


public class Echiquier {
	
    private ArrayList<Case> board = new ArrayList<>();
    
    /*	retourne la case avec sa ligne et colonne correspondante */
    
    public Echiquier(String mode)
    {
    if (mode.contentEquals("classique"))
    {
    	this.init();
    }
    
    if (mode.contentEquals("echec"))
    {
    	this.initEchec();
    }	
    
    if (mode.contentEquals("fou"))
    {
    	this.initFou();
    }
    
    if (mode.contentEquals("cavalier"))
    {
    	this.initCavalier();
    }
    
    if (mode.contentEquals("reine"))
    {
    	this.initReine();
    }
    
    }
    
    public Echiquier(ArrayList<Case> c)
    {
    	this.board = c;
    }
    public Echiquier(Echiquier ech) {
    	this.board=ech.getBoard();
    }
    
    
    public Case chercherCase(int ligne, int colonne)
    {
    	ListIterator<Case> i = this.board.listIterator();
    		while (i.hasNext()) {
    			Case c = i.next();
    			if (c.getLigne() == ligne && c.getColonne() == colonne)
    				return c;
    			}
		return null; 
    }
    
    
    
    /*	retourne la case de la piece 
     *	avec son nom et sa couleur 
     */
    public Case chercherRoi(String nomPiece, String couleur)
    {
    	ListIterator<Case> i = this.board.listIterator();
    	while (i.hasNext()) {
    		Case c = i.next();
    		if (c.getPiece() != null)
    		{
    			if (c.getPiece().getNom() == nomPiece && c.getPiece().getCouleur() == couleur)
        			return c;
        			}
    		}
    		
    	return null; 
    }
    
    public ArrayList<Case> chercherPieces(String couleur)
    {
    	ArrayList<Case> pieces = new ArrayList<>();
    	ListIterator<Case> i = this.board.listIterator();
    	while (i.hasNext()) {
    		Case c = i.next();
    		if (!(c.caseVide())) 
    		{
    			if (c.getPiece().getCouleur() == couleur)
    			{
    				pieces.add(c);
    			}
    		}
    			
    			}
    	return pieces;
    }
    
    public boolean mat(String couleur)
    {
    	Case caseRoi = this.chercherRoi("roi", couleur);
    	ArrayList<Case> pieces = this.chercherPieces(couleur);
    	
    	for (int i = 0 ; i < pieces.size(); i ++)
    	{
    		if (pieces.get(i).getPiece() != null) 
    		{
    			if (pieces.get(i).getPiece().deplacementPossible(this, this.chercherCase(pieces.get(i).getLigne(), pieces.get(i).getColonne()), caseRoi))
        		{
        			return true;
        		}
    		}
    		
    	}
    	return false;
    }
    
    
    public ArrayList<Case >getBoard()
    {
    	return this.board;
    }
    
    
    public void deplacerPiece(Case casePiece, Case ca)
    {

    	if (casePiece.getPiece().deplacementPossible(this, casePiece, ca)) 
    	{
    		ca.setPiece(casePiece.getPiece());
    		casePiece.setPiece(null);
    	}
    }
    
    public boolean deplacementValide(Case casePiece, Case ca)
    {
    	return (casePiece.getPiece().deplacementPossible(this, casePiece, ca));
    }
    
    public void initVide()
    {
        int j = 0;
    	int l = 1;
        while (j < 8)
        {
        	int i = 0;
        	int c = 1;
        	while (i < 8)
        	{
        		this.board.add(new Case(l, c, null));
        		i ++;
        		c ++;
        	}
        	l ++;
        	j ++;
        }
    }
    
    public void init()
    {
    this.initVide();    
    this.chercherCase(1, 1).setPiece(new Tour("blanc", "tour"));
    this.chercherCase(1, 2).setPiece(new Cavalier("blanc", "cavalier"));
    this.chercherCase(1, 3).setPiece(new Fou("blanc", "fou"));
    this.chercherCase(1, 4).setPiece(new Reine("blanc", "reine"));
    this.chercherCase(1, 5).setPiece(new Roi("blanc", "roi"));
    this.chercherCase(1, 6).setPiece(new Fou("blanc", "fou"));
    this.chercherCase(1, 7).setPiece(new Cavalier("blanc", "cavalier"));
    this.chercherCase(1, 8).setPiece(new Tour("blanc", "tour"));
    
    this.chercherCase(2, 1).setPiece(new Pion("blanc", "pion"));
    this.chercherCase(2, 2).setPiece(new Pion("blanc", "pion"));
    this.chercherCase(2, 3).setPiece(new Pion("blanc", "pion"));
    this.chercherCase(2, 4).setPiece(new Pion("blanc", "pion"));
    this.chercherCase(2, 5).setPiece(new Pion("blanc", "pion"));
    this.chercherCase(2, 6).setPiece(new Pion("blanc", "pion"));
    this.chercherCase(2, 7).setPiece(new Pion("blanc", "pion"));
    this.chercherCase(2, 8).setPiece(new Pion("blanc", "pion"));
    
    this.chercherCase(8, 1).setPiece(new Tour("noir", "tour"));
    this.chercherCase(8, 2).setPiece(new Cavalier("noir", "cavalier"));
    this.chercherCase(8, 3).setPiece(new Fou("noir", "fou"));
    this.chercherCase(8, 5).setPiece(new Roi("noir", "roi"));
    this.chercherCase(8, 4).setPiece(new Reine("noir", "reine"));
    this.chercherCase(8, 6).setPiece(new Fou("noir", "fou"));
    this.chercherCase(8, 7).setPiece(new Cavalier("noir", "cavalier"));
    this.chercherCase(8, 8).setPiece(new Tour("noir", "tour"));
    
    this.chercherCase(7, 1).setPiece(new Pion("noir", "pion"));
    this.chercherCase(7, 2).setPiece(new Pion("noir", "pion"));
    this.chercherCase(7, 3).setPiece(new Pion("noir", "pion"));
    this.chercherCase(7, 4).setPiece(new Pion("noir", "pion"));
    this.chercherCase(7, 5).setPiece(new Pion("noir", "pion"));
    this.chercherCase(7, 6).setPiece(new Pion("noir", "pion"));
    this.chercherCase(7, 7).setPiece(new Pion("noir", "pion"));
    this.chercherCase(7, 8).setPiece(new Pion("noir", "pion"));
    }
    
    public void initEchec()
    {
    	this.initVide();    
    	    
    	    this.chercherCase(4, 4).setPiece(new Tour("noir", "tour"));
    	    this.chercherCase(4, 5).setPiece(new Roi("blanc", "roi"));
    }
    
    public void initFou()
    {
    	this.initVide();    
 	    
 	    this.chercherCase(4, 4).setPiece(new Fou("blanc", "fou"));
    }
    
    public void initCavalier()
    {
    	this.initVide();
    	this.chercherCase(4, 4).setPiece(new Cavalier("blanc", "cavalier"));
    }
    
    public void initReine()
    {
    	this.initVide();
    	this.chercherCase(4, 4).setPiece(new Reine("blanc", "reine"));
    }

    
    
    public String toString() {
    
    	String s = "\"q\" pour quitter. \n";
    	s += "    A	   B	  C	   D	   E	   F	   G	  H\n"
    			+ "▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬\n";
    	int j = 1;
		for (int i = 0; i < this.board.size(); i ++)
		{
			s += "|  " + this.board.get(i) + "	";
			if ((i + 1)%8 == 0 && i != 0)
			{
				s += "|	|" + Integer.toString(j) + "\n";
				s += "▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬\n";
				j ++;
			}
		}
		s +="    A	   B	  C	   D	   E	   F	   G	  H\n";
		
		return s;
    }

}
