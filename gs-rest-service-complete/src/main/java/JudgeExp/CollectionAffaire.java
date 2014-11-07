package JudgeExp;

import java.util.ArrayList;
import java.util.List;

public class CollectionAffaire {

	private List<Affaire> listeAffaire = new ArrayList<Affaire>();
	
	public CollectionAffaire() {
		
	}
	
	public void add(Affaire a) {
		listeAffaire.add(a);
	}

}
