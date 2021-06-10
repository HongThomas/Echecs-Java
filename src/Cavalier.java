package src;

public class Cavalier extends Pieces implements Piece {
	
	
	public Cavalier(String couleur, String nom)
	{
		super(couleur, nom);
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
	
	public String toString() {
		if(this.getCouleur()=="noir") {
			return "♞";
		}
		else {
			return "♘";
		}
	}

	@Override
	public boolean cheminLibre(Echiquier plateau, Case cd, Case ca) 
	{
		/* vers le bas
		 * 
		 */
		if (ca.getLigne() == cd.getLigne() - 2 && (ca.getColonne() == cd.getColonne() - 1 || ca.getColonne() == cd.getColonne() + 1))
		{
			return plateau.chercherCase(ca.getLigne(), ca.getColonne()).caseVide();
		}
		
		/* vers le haut
		 * 
		 */
		
		if (ca.getLigne() == cd.getLigne() + 2 && (ca.getColonne() == cd.getColonne() - 1 || ca.getColonne() == cd.getColonne() + 1 ))
		{
			return plateau.chercherCase(ca.getLigne(), ca.getColonne()).caseVide();
		}
		
		/* vers la gauche
		 * 
		 */
		
		if (ca.getColonne() == cd.getColonne() - 2 && (ca.getLigne() == cd.getLigne() - 1 || ca.getLigne() == cd.getLigne() + 1))
		{
			return plateau.chercherCase(ca.getLigne(), ca.getColonne()).caseVide();
		}
		
		/* vers la droite
		 * 
		 */
		
		if (ca.getColonne() == cd.getColonne() + 2 && (ca.getLigne() == cd.getLigne() - 1 || ca.getLigne() == cd.getLigne() + 1))
		{
			return plateau.chercherCase(ca.getLigne(), ca.getColonne()).caseVide();
		}
		
		return false;
	}

	@Override
	public boolean deplacementPossible(Echiquier plateau, Case cd, Case ca) {
		return cheminLibre(plateau, cd, ca) && !(ca.equals(cd)) && cd.getPiece() != null; 
	}

}
