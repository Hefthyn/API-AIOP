package JudgeExp;

public class TypeMission {

	private long idTypeMission;
	private String libTypeMission;
	
	/*
	 * Methode lié à l'ORM
	 */
	public TypeMission load(){
		return null;
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
