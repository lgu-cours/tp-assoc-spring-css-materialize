package bean;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListePays {

	public final static ArrayList<Pays> getList ()
	{
		ArrayList<Pays> list = new ArrayList<>();
		list.add(new Pays("FR","France") );
		list.add(new Pays("ES","Espagne") );
		list.add(new Pays("IT","Italie") );
		list.add(new Pays("BE","Belgique") );
		list.add(new Pays("CA","Canada") );
		
		
		return list ;
	}
}
