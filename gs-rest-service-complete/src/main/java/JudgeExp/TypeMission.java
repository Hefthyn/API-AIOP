package JudgeExp;

public class TypeMission {

	private long idTypeMission;
	private String libTypeMission;

	/*
	 * Constructeur
	 */
	public TypeMission() {

	}

	public TypeMission(long idTypeMission) {
		this.setIdTypeMission(idTypeMission);
	}

	public TypeMission(long idTypeMission, String libTypeMission) {
		this.setIdTypeMission(idTypeMission);
		this.setLibTypeMission(libTypeMission);
	}

	/*
	 * Methode lié à l'ORM
	 */
	public TypeMission load() {
		return null;
	}
	
	public void save(long idTypeObjet) {
		// TODO Auto-generated method stub
		
	}
	public void delete(){
		
	}

	public long getIdTypeMission() {
		return idTypeMission;
	}

	public void setIdTypeMission(long idTypeMission) {
		this.idTypeMission = idTypeMission;
	}

	public String getLibTypeMission() {
		return libTypeMission;
	}

	public void setLibTypeMission(String libTypeMission) {
		this.libTypeMission = libTypeMission;
	}

}
