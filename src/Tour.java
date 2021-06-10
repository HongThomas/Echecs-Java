package src;


public class Tour extends Pieces implements Piece {
	
	public Tour(String couleur, String nom)
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
			return "\u265c";
		}
		else {
			return "\u2656";
		}
	}

	@Override
	public boolean cheminLibre(Echiquier plateau, Case cd, Case ca) 
	{
		/* DÃ©placement de haut en bas
		 * 
		 */
		if (ca.getLigne() == cd.getLigne())
		{
			
			int j = Math.abs(cd.getColonne() - ca.getColonne());
			if (j == 1)
			{
				 return (!(ca.equals(cd)));									
			}
			
			if (ca.getColonne() < cd.getColonne())
			{
				
				for (int i = 0; i < j; i ++)
				{
					if (plateau.chercherCase(cd.getLigne(), cd.getColonne() - (i + 1)).getPiece() != null)
					{
						return false;
					}
				}
			}
			
			if (ca.getColonne() > cd.getColonne())
			{
				
				for (int i = 0; i < j; i ++)
				{
					if (plateau.chercherCase(cd.getLigne(), cd.getColonne() + (i + 1)).getPiece() != null)
					{
						return false;
					}
				}
			}
		}
		
		/* DÃ©placement de droite Ã  gauche et inversement
		 * 
		 */
		if (ca.getColonne() == cd.getColonne())
		{
			int j = Math.abs(ca.getLigne() - cd.getLigne());
			
			if (j == 1)
			{
				 return (!(ca.equals(cd)));									
			}
			
			if (ca.getLigne() < cd.getLigne())
			{
				
				for (int i = 0; i < j; i ++)
				{
					if (plateau.chercherCase(cd.getLigne()  - (i + 1), cd.getColonne()).getPiece() != null)
					{
						return false;
					}
				}
			}
		
			
			if (ca.getLigne() > cd.getLigne())
			{
				for (int i = 0; i < j; i ++)
				{
					if (plateau.chercherCase(cd.getLigne()  + (i + 1), cd.getColonne()).getPiece() != null)
					{
						return false;
					}
				}
			}
		}
		return true;
	}
	
	@Override
	public boolean deplacementPossible(Echiquier plateau, Case cd, Case ca) {
		return cheminLibre(plateau, cd, ca) && !(ca.equals(cd)) && cd.getPiece() != null; 
	}




}
