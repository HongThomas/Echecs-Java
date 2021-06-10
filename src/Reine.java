package src;


@SuppressWarnings("unused")
public class Reine extends Pieces implements Piece {


	public Reine(String couleur, String nom)
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

	@Override
	public boolean cheminLibre(Echiquier plateau, Case cd, Case ca)  {
		
		if (ca.equals(cd)) return false;

		if ((Math.abs(ca.getColonne()-cd.getColonne()) - Math.abs(ca.getLigne()-cd.getLigne()))==0)
		{
		/* Diagonale Haute Droite*/
		if (ca.getLigne()<cd.getLigne() && ca.getColonne()>cd.getColonne()) 
		{
			
		for (int i=1;i<Math.abs(cd.getLigne()-ca.getLigne())-1;i++)
		{
			if (plateau.chercherCase(cd.getLigne() - i,i+cd.getColonne()).caseVide()==false)
			{
					return false;
			}
		}
		return true;

		}

		/* Diagonale Haut Gauche */
		if(ca.getLigne()<cd.getLigne() && ca.getColonne()<cd.getColonne())
		{


		for (int i=1;i<Math.abs(cd.getLigne()-ca.getLigne())-1;i++) 
		{
			
			if (plateau.chercherCase(cd.getLigne()-i,cd.getColonne()-i).caseVide()==false) 
			{
				return false;
			}

		}
			return true;
		}

		/* Diagonale Bas Droite */
		if(ca.getColonne() > cd.getColonne() && ca.getLigne() > cd.getLigne()){
			

		for(int i=1;i<Math.abs(cd.getLigne()-ca.getLigne())-1;i++) {

			if(plateau.chercherCase(cd.getLigne()+i,cd.getColonne()+i).caseVide()==false) return false;

	        }
		return true;
		}

		/* Diagonale Bas Gauche */
		if(ca.getColonne() < cd.getColonne() && ca.getLigne() > cd.getLigne()){
			if((Math.abs(ca.getColonne()-cd.getColonne())-(Math.abs(ca.getLigne()-cd.getLigne()))!=0)) {return false;}

		for(int i=1; i<Math.abs(cd.getLigne()-ca.getLigne())-1;i++){

			if(plateau.chercherCase(cd.getLigne()+i,cd.getColonne()-i).caseVide()==false) {return false;}

		}
		return true;
		}
		}
		else
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
		
		/* return par dÃ©faut */
		
		return false;
		}
	
	public String toString() {
		if(this.getCouleur()=="noir") {
			return "\u265B";
		}
		else {
			return "♕";
		}
	}

	@Override
	public boolean deplacementPossible(Echiquier plateau, Case cd, Case ca) {
		return cheminLibre(plateau, cd, ca) && !(ca.equals(cd)) && cd.getPiece() != null; 
	}
}
