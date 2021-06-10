package src;

public class Fou extends Pieces implements Piece {
	
	public Fou(String couleur, String nom)
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
		// TODO Auto-generated method stub
		if (ca.equals(cd)) 
		{
			return false;
		}
		
		if ((Math.abs(ca.getColonne()-cd.getColonne())-Math.abs(ca.getLigne()-cd.getLigne()))!=0)
		{
			return false;
		}

		/* Diagonale Haute Droite*/
		if (ca.getLigne()<cd.getLigne() && ca.getColonne()>cd.getColonne()) 
		{
			
		for (int i=1;i<Math.abs(cd.getLigne()-ca.getLigne())-1;i++)
		{
			if (plateau.chercherCase(i+cd.getLigne(),i+cd.getColonne()).caseVide()==false)
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

			if(plateau.chercherCase(cd.getLigne()+i,cd.getColonne()-i).caseVide()==false) return false;

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
		return false;
		
	}
	
	public String toString() {
		if(this.getCouleur()=="noir") {
			return "♝";
		}
		else {
			return "♗";
		}
	}

	@Override
	public boolean deplacementPossible(Echiquier plateau, Case cd, Case ca) {
		return cheminLibre(plateau, cd, ca) && !(ca.equals(cd)) && cd.getPiece() != null; 
	}
}
