package JudgeExp;

public class Scelle {
	// Numéro
	private long numeroScelle;
	private long numeroPV;
	private String commentaire;

	/**
	 * Constructeur par defaut
	 */
	public Scelle() {

	}

	public Scelle(long numeroScelle){
		this.setNumeroScelle(numeroScelle);
	}
	/**
	 * Constructeur avec numeroScelle, numeroPV,commentaire
	 * 
	 * @param numeroScelle
	 * @param numeroPV
	 * @param commentaire
	 */
	public Scelle(long numeroScelle, long numeroPV, String commentaire) {
		this.setNumeroScelle(numeroScelle);
		this.setNumeroPV(numeroPV);
		this.setCommentaire(commentaire);
	}

	/*
	 * Méthodes lidées à l'ORM
	 */

	/**
	 * Sauvegarde un scelle dans une affaire
	 * 
	 * @param idAffaire
	 */
	public void save(long idAffaire) {
		// TODO Auto-generated method stub

	}

	/**
	 * Charge un Scelle
	 * 
	 * @param numeroScelle
	 * @return
	 */
	public Scelle load() {
		return null;
	}

	/*
	 * Setters and Getters
	 */

	public long getNumeroScelle() {
		return numeroScelle;
	}

	public void setNumeroScelle(long numeroScelle) {
		this.numeroScelle = numeroScelle;
	}

	public long getNumeroPV() {
		return numeroPV;
	}

	public void setNumeroPV(long numeroPV) {
		this.numeroPV = numeroPV;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

}
