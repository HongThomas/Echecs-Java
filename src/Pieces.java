package src;

public abstract class Pieces implements Piece{
	
	private String couleur;
	private String nom;

	
	public Pieces()
	{}
	
	public Pieces(String couleur, String nom)
	{
		this.couleur = couleur;
		this.nom = nom;
	}
	
	public Pieces(Piece p)
	{
		this.couleur = p.getCouleur();
		this.nom = p.getNom();
	}
	
	public String getCouleur()
	{
		return this.couleur;
	}
	
	public String getNom()
	{
		return this.nom;
	}
	

	@Override
	public void setCouleur(String newCouleur)
	{
		this.couleur = newCouleur;
	}
		
	public boolean equals(Piece o)
	{
		if(o.getClass()!=this.getClass()) 
			{
			return false;
			}
		
		return (this.getCouleur() == ((Piece)o).getCouleur());
	}
	
	public abstract boolean deplacementPossible(Echiquier plateau, Case cd, Case ca);
	
	public abstract boolean cheminLibre(Echiquier plateau, Case cd, Case ca);


	
}
