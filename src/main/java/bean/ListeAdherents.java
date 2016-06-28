package bean;

import java.util.ArrayList;

public class ListeAdherents {

	public final static ArrayList<Adherent> getList ()
	{
		ArrayList<Adherent> list = new ArrayList<>();
		list.add(new Adherent("Zola","Emile", "2 rue de Plantes", "44000", "Nantes", "FR" , "emile", "OK") );
		list.add(new Adherent("Flaubert","Gustave", "23 Bd Foch", "35000", "Rennes", "FR" , "gustave", "OK" ) );
				
		return list ;
	}
}
