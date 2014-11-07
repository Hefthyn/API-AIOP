package JudgeExp;

import java.util.ArrayList;
import java.util.List;

public class CollectionFrais {
	
	private List<Frais> listeFrais = new ArrayList<Frais>();
	

	public CollectionFrais() {
		
	}
	
	public List<Frais> getListeFrais() {
		return listeFrais;
	}

	public void setListeFrais(List<Frais> listeFrais) {
		this.listeFrais = listeFrais;
	}
	
	public void add(Frais f) {
		listeFrais.add(f);
	}

}
