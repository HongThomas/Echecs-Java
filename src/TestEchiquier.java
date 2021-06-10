package src;



public class TestEchiquier {

	public static void main(String[] args) {
		
		Echiquier ech = new Echiquier("c");
		
		ech.chercherCase(3,5).setPiece(new Fou("blanc","fou"));
		System.out.println(ech.toString());
		ech.deplacerPiece(ech.chercherCase(3, 5), ech.chercherCase(7, 1));
		
	}

}
