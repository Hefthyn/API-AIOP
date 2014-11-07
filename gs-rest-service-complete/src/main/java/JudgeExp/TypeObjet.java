package JudgeExp;

import java.util.List;

public class TypeObjet {

	private long idTypeObjet;
	private String libTypeObjet;
	private List<TypeMission> typeMissions;

	/*
	 * Constructeur
	 */
	public TypeObjet(long idTypeObjet) {
		// TODO Auto-generated constructor stub
		this.setIdTypeObjet(idTypeObjet);
	}

	/*
	 * Methode
	 */
	public void deleteTypeMission(long idTypeMission) {

	}

	public TypeMission getTypeMission(long idTypeMission) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * Méthodes lidées à l'ORM
	 */
	public TypeObjet load() {
		return null;
	}

	public void delete() {

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

	public List<TypeMission> getTypeMissions() {
		return typeMissions;
	}

	public void setTypeMissions(List<TypeMission> typeMissions) {
		this.typeMissions = typeMissions;
	}

}
