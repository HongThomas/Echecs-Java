package src;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import src.*;
public class Jeu {

    private Echiquier echiquier;
    private String turn;
    private boolean stop = true;
    private Scanner sc = new Scanner(System.in);
    
    public Jeu() {
    	this.init();
    	this.setTurn("blanc");
    	this.affichage();
    	this.entrerCoup();
    	
    	while (this.stop)
    	{
    		if (this.stop)
    		{
    		this.setTurn("noir");
    		this.affichage();
    		this.entrerCoup();
    		}
    		if (this.stop)
    		{
    		this.setTurn("blanc");
    		this.affichage();
    		this.entrerCoup();
    		}
    	}
    	

    	
    }
    
    public Jeu(Echiquier ech, String turn) {
    	this.echiquier=ech;
    	this.turn = turn;
    	}
    
    public void setTurn(String turn) {
    	this.turn = turn;
    }
    
    
    public void setEchiquier(Echiquier ech) {
    	this.echiquier=ech;
    }
    
    public Echiquier getEchiquier() {
    	return this.echiquier;
    }
    
    public String getTurn() {
    	return this.turn;
    }
    
    public void init()
    {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Choisissez votre mode de jeu : classique, echec, charger.\n");
    	String mode = sc.nextLine();
    	
    	if (mode.contentEquals("charger")) {
    		System.out.println("Entrez le nom du fichier pour charger la partie (.txt)");
    		String nomFichier = sc.nextLine();
    		Echiquier ch_ech = this.restore(nomFichier);
    		this.echiquier= new Echiquier(ch_ech);
    	}
    	if (mode.contentEquals("classique")) {
    		System.out.println("Vous avez choisi le mode classique.");
    		this.echiquier = new Echiquier(mode);
        	this.turn = "blanc";
    	}
    	
    	if (mode.contentEquals("echec")) {
    		System.out.println("Vous avez choissi le mode échec.");
    		this.echiquier = new Echiquier(mode);
        	this.turn = "blanc";
    	}
    	
    	
  
    }
    
    public void affichage()
    {
    	System.out.println(this.echiquier.toString());
    	System.out.println("Tour: " + this.turn);
    }
    
    public void entrerCoup()
    {
    	
    	System.out.println("Votre coup (cd,ca): ");
    	String coup = sc.nextLine();
    	if (coup.contentEquals("q"))
    	{
    		this.stop = false;
    		System.out.println("Voulez vous sauvegarder ? [oui/non]");
			Scanner input = new Scanner(System.in);
			String resp = input.next();
			
			if(resp.contentEquals("oui")) {
				System.out.println("Entrez le nom du fichier");
				String nom = input.next();
				this.save(nom);
			}
			
    		System.out.println("Partie terminée.");
    		input.close();
    		
    	}
    	else
    	{
    	
    		
    	String cd = String.valueOf(coup.charAt(0)) + String.valueOf(coup.charAt(1));
    	String ca = String.valueOf(coup.charAt(3)) + String.valueOf(coup.charAt(4));
    	
    	int cdLigne = this.conversion(cd)[1];
    	int cdColonne = this.conversion(cd)[0];
    	int caLigne = this.conversion(ca)[1];
    	int caColonne = this.conversion(ca)[0];
    	
    	/*
    	 * Tant que le mouvement n'est pas valide ou que le roi est en échec, 
    	 * demander un nouveau coup
    	 */
    	while (this.echiquier.chercherCase(cdLigne, cdColonne).getPiece().getCouleur() != this.turn || // || (!(this.echiquier.mat("blanc")) && this.turn == "blanc") || (!(this.echiquier.mat("noir")) && this.turn == "noir") || 
    			(this.echiquier.deplacementValide(this.echiquier.chercherCase(cdLigne, cdColonne), this.echiquier.chercherCase(caLigne, caColonne))== false))
    	{

    		if (this.echiquier.chercherCase(cdLigne, cdColonne).getPiece().getCouleur() != this.turn)
    		{
    		System.out.println("Vous ne pouvez pas jouer les pèces ennemies !");
    		}
    		
//    		if (!(this.echiquier.mat("blanc") && this.turn == "blanc" || !(this.echiquier.mat("noir") && this.turn == "blanc") ) )
//    		{
//    		System.out.println("Vous êtes en échec ! Sortez de l'échec au roi.");
//    		}
    		
    		if ((this.echiquier.deplacementValide(this.echiquier.chercherCase(cdLigne, cdColonne), this.echiquier.chercherCase(caLigne, caColonne)))== false)
    		{
    			System.out.println("Coup illégal !");
    		}
    		System.out.println("Votre coup (cd,ca): ");
    		coup = sc.nextLine();
    		cd = String.valueOf(coup.charAt(0)) + String.valueOf(coup.charAt(1));
        	ca = String.valueOf(coup.charAt(3)) + String.valueOf(coup.charAt(4));
        	
        	cdLigne = this.conversion(cd)[1];
        	cdColonne = this.conversion(cd)[0];
        	caLigne = this.conversion(ca)[1];
        	caColonne = this.conversion(ca)[0];
    	}
    	this.echiquier.deplacerPiece(this.echiquier.chercherCase(cdLigne, cdColonne), this.echiquier.chercherCase(caLigne, caColonne));  
    	}
    }
    
    public int[] conversion(String coupEntree)
    {
    	int[] tabCase = new int[2];
    	
    	int j = 1;
    	for (int i = 97; i < 105; i ++)
    	{
    		if (coupEntree.charAt(0) == ((char) i))
        	{
        		tabCase[0] = j;
        	}
    		j ++;
    	}
    	
    	tabCase[1] = (int) coupEntree.charAt(1) - 48;
    	return tabCase;
    }
    
    
    
    public void save(String nomFichier) {
        try {
            System.out.println("Sauvegarde fichier : "+nomFichier+".txt");
            BufferedWriter bw = Files.newBufferedWriter(Paths.get(nomFichier));
            bw.write(this.getTurn()+"\n");
            for(int x=8;x>0;x--) {
            	for(int y=1;y<8;y++) {
            		String result= this.getEchiquier().chercherCase(x,y).toString()+" ";
            		bw.write(result);
            	}
            	bw.write("\n");
            }
            bw.close();
        } catch(IOException e){
            System.err.println(e);
        }
    }
    public Echiquier restore(String nomFichier) {
    	try {
    		BufferedReader br = Files.newBufferedReader(Paths.get(nomFichier));
    		String[] ligne;
    		int i=1;
    		int j=1;
    		int z=0;
    		ArrayList<Case> board = new ArrayList<Case>();
    		String tour = br.readLine();
    		
    		ligne = br.readLine().split(" ");
    		while(ligne!=null) {
    			for(int o=0;j<(ligne.length);j++) {
    			if(ligne[z]=="♟") {
    				Case a = new Case(i,j,new Pion("noir", "pion"));
    				board.add(a);
    			}
    			if(ligne[z]=="♙") {
    				Case b = new Case(i,j,new Pion("blanc", "pion"));
    				board.add(b);
    			}
    			if(ligne[z]=="♜") {
    				Case c = new Case(i,j,new Tour("noir","tour"));
    				board.add(c);
    			}
    			if(ligne[z]=="♖") {
    				Case d = new Case(i,j,new Tour("blanc","tour"));
    				board.add(d);
    			}
    			if(ligne[z]=="♞") {
    				Case e = new Case(i,j,new Cavalier("noir","cavalier"));
    				board.add(e);
    			}
    			if(ligne[z]=="♘") {
    				Case f = new Case(i,j,new Cavalier("blanc","cavalier"));
    				board.add(f);
    			}
    			if(ligne[z]=="♝") {
    				Case g = new Case(i,j,new Fou("noir","fou"));
    				board.add(g);
    			}
    			if(ligne[z]=="♗") {
    				Case h = new Case(i,j,new Fou("blanc","fou"));
    				board.add(h);
    			}
    			if(ligne[z]=="♛") {
    				Case k = new Case(i,j,new Reine("noir","reine"));
    				board.add(k);
    			}
    			if(ligne[z]=="♕") {
    				Case l = new Case(i,j,new Reine("blanc","reine"));
    				board.add(l);
    			}
    			if(ligne[z]=="♚") {
    				Case m = new Case(i,j,new Roi("noir","roi"));
    				board.add(m);
    			}
    			if(ligne[z]=="♔") {
    				Case n = new Case(i,j,new Roi("blanc","roi"));
    				board.add(n);
    			}
    			else {
    				Case v = new Case(i,j,null);
    				board.add(v);
    			}
    			ligne = br.readLine().split(" ");
    			j++;
    		}
    			i++;
    			z++;
    		}
    		Echiquier ech = new Echiquier(board);
    		br.close();
    		return ech;
    		
    	}catch(IOException e) {
    		System.err.println(e);
    	}
		return null;
    }
    
}
