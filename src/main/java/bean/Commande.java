package bean;

import java.util.LinkedList;

public class Commande {

	LinkedList listCommande = new LinkedList();

	public void commanderArticle(Article a )
	{
		listCommande.add(a);
		System.out.println("Article commandé : " + a.getCode() + " : " + a.getNom() );
	}

	public int getNbArticles()
	{
		return listCommande.size();
	}
	
	public LinkedList getListe()
	{
		return listCommande ;
	}
}
