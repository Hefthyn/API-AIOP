package JudgeExp;

public class TypeObjet {

	private long idTypeObjet;
	private String libTypeObjet;
	
	/*
	 * Méthodes lidées à l'ORM 
	 */
	public TypeObjet load(long idTypeObjet){
		return null;
	}
	
	public long getIdTypeObjet() {
		return idTypeObjet;
	}
	public void setIdTypeObjet(long idTypeObjet) {
		this.idTypeObjet = idTypeObjet;
	}
	public String getLibTypeObjet() {
		return libTypeObjet;
	}
	public void setLibTypeObjet(String libTypeObjet) {
		this.libTypeObjet = libTypeObjet;
	}
}
