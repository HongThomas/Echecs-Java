package src;

public class Roi extends Pieces implements Piece {
	
	private boolean mate;
	

	public Roi(String couleur, String nom)
	{
		super(couleur, nom);
	}
	
	public void setMate(boolean mate)
	{
		this.mate = mate;
	}
	public String getCouleur() {
		return super.getCouleur();
	}
	
	public String getNom()
	{
		return super.getNom();
	}


	@Override
	public void setCouleur(String newCouleur) {
		super.setCouleur(newCouleur);
		
	}

	
	public String toString()
	{
		if(this.getCouleur()=="noir") {
			return "\u265a";
		}
		else {
			return "♔";
		}
	}

	@Override
	public boolean cheminLibre(Echiquier plateau, Case cd, Case ca) {
		/*Droite et gauche
		 * 
		 */
		if (ca.getLigne() == cd.getLigne() && (cd.getColonne() - 1 == ca.getColonne()) || (cd.getColonne() + 1 == ca.getColonne()))
		{
			return ca.caseVide();	
		}
		/*Haut et bas
		 * 
		 */
		if ((ca.getColonne() == cd.getColonne()) && (cd.getLigne() - 1 == ca.getLigne()) || (cd.getLigne() + 1 == ca.getLigne()))
		{
			return ca.caseVide();
		}
		
		/* Diagonales
		 * 
		 */
		
		if ((ca.getColonne() == cd.getColonne() - 1 || ca.getColonne() == cd.getColonne() + 1) && ((cd.getLigne() + 1 == ca.getLigne()) || (cd.getLigne() - 1 == ca.getLigne())))
		{
			return ca.caseVide();
		}
		
		return false;	
	}

	@Override
	public boolean deplacementPossible(Echiquier plateau, Case cd, Case ca) {
		return cheminLibre(plateau, cd, ca) && !(ca.equals(cd)) && cd.getPiece() != null; 
	}
	
}
