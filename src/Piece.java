package src;

public interface Piece {

    public String getCouleur();
    
    public void setCouleur(String newCouleur);
    
    public boolean cheminLibre(Echiquier plateau, Case cd, Case ca);
    
    public String toString();

	public String getNom();

	public boolean deplacementPossible(Echiquier echiquier, Case cd, Case ca);
}
