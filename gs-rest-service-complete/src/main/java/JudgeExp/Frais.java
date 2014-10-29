package JudgeExp;

public class Frais {
	
	private long idFrais;
	private String libFrais;
	private double prixFrais;
	
	public Frais () {
			
		}
	
	public Frais (long id) {
		setIdFrais(id);
		setLibFrais("frais " + id);
		setPrixFrais(id * 12.8);
	}
	
	public long getIdFrais() {
		return idFrais;
	}

	public void setIdFrais(long idFrais) {
		this.idFrais = idFrais;
	}

	public String getLibFrais() {
		return libFrais;
	}

	public void setLibFrais(String libFrais) {
		this.libFrais = libFrais;
	}

	public double getPrixFrais() {
		return prixFrais;
	}

	public void setPrixFrais(double prixFrais) {
		this.prixFrais = prixFrais;
	}

	

}
