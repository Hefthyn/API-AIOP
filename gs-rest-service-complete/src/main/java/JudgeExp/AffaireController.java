package JudgeExp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AffaireController {

/* ---------------------------------------------------- METHODE POST ---------------------------------------------------------------*/

	/**
	 * Méthode de création d'une affaire
	 * @param nomAffaire nom de l'affaire créée
	 * @return l'affaire créée
	 */
	@RequestMapping(value = "/affaires", method = RequestMethod.POST)
	public Affaire createAffaire(
			@RequestParam(value = "nomAffaire", required = true) String nomAffaire) {
		Affaire x = new Affaire(nomAffaire);
		x.create();
		return x;
	}

	/**
	 * Méthode de création d'un frais pour une affaire
	 * @param idAffaire identifiant de l'affaire concernée
	 * @param libFrais libellé du nouveau Frais
	 * @param prixFrais prix du nouveau Frais
	 * @return le Frais créé
	 */
	@RequestMapping(value = "/affaire/{idAffaire}/frais", method = RequestMethod.POST)
	public Frais createFraisAffaire(@PathVariable("idAffaire") long idAffaire,
			@RequestParam("libFrais") String libFrais,
			@RequestParam("prixFrais") double prixFrais) {
		Frais x = new Frais(libFrais, prixFrais);
		x.save(idAffaire);
		return x;
	}

	/**
	 * Méthode de création d'un scellé pour une affaire
	 * @param idAffaire identifiant de l'affaire concernée
	 * @param numeroScelle numéro pénal du scellé
	 * @param numeroPV numéro du procés verbal
	 * @param commentaire commentaire concernant le scellé
	 * @return le scellé créé
	 */
	@RequestMapping(value = "/affaire/{idAffaire}/scelles", method = RequestMethod.POST)
	public Scelle createScelleAffaire(@PathVariable("idAffaire") long idAffaire,
			@RequestParam("numeroScelle") long numeroScelle,
			@RequestParam("numeroPV") long numeroPV,
			@RequestParam("commentaire") String commentaire) {
		Scelle newScelle = new Scelle(numeroScelle, numeroPV, commentaire);
		newScelle.save(idAffaire);
		return newScelle;
	}

	
/* ---------------------------------------------------- METHODE GET ---------------------------------------------------------------*/

	/**
	 * Méthode de récupération d'une affaire
	 * @param idAffaire identifiant de l'affaire
	 * @return l'affaire recherchée
	 */
	@RequestMapping(value = "/affaire/{idAffaire}", method = RequestMethod.GET)
	public Affaire getAffaire(@PathVariable("idAffaire") long idAffaire) {

		// il faudra le charger depuis la bdd et appeller le constructeur vide
		Affaire x = new Affaire();
		// x.load(idAffaire);

		return x;
	}

	/**
	 * Méthode de récupération de toutes les affaires
	 * @return liste des affaire
	 */
	@RequestMapping(value = "/affaires", method = RequestMethod.GET)
	public List<Affaire> getAffaires() {

		// Il faudra load toutes les affaires depuis la bdd
		// Affaire x = new Affaire();
		// return x.getAllAffaires();

		// en attendant :
		List<Affaire> x = new ArrayList<Affaire>();
		x.add(new Affaire(1));
		x.add(new Affaire(2));
		x.add(new Affaire(3));
		return x;
	}

	/**
	 * Méthode de récupération des Frais d'une affaire
	 * @param idAffaire identifiant de l'affaire
	 * @return liste des Frais de l'affaire
	 */
	@RequestMapping(value = "/affaire/{idAffaire}/frais", method = RequestMethod.GET)
	public List<Frais> getFraisAffaire(@PathVariable("idAffaire") long idAffaire) {

		// il faudra le charger depuis la bdd et appeller le constructeur vide
		Affaire x = new Affaire(idAffaire);
		// x.load(idAffaire);

		return x.getFrais();
	}

	/**
	 * Méthode de récupération de l'état d'une affaire
	 * @param idAffaire identifiant de l'affaire
	 * @return l'état d'une affaire
	 */
	@RequestMapping(value = "/affaire/{idAffaire}/etat", method = RequestMethod.GET)
	public String getEtatAffaire(@PathVariable("idAffaire") long idAffaire) {

		// il faudra le charger depuis la bdd et appeller le constructeur vide
		Affaire x = new Affaire(idAffaire);
		// x.load(idAffaire);

		return x.getEtat();
	}

	/**
	 * Méthode de récupération d'un scellé d'une affaire
	 * @param idAffaire identifiant de l'affaire
	 * @param numeroScelle numéro du scellé a récupérer
	 * @return le scellé souhaité
	 */
	@RequestMapping(value = "/affaire/{idAffaire}/scelles/{numeroScelle}", method = RequestMethod.GET)
	public Scelle getScelleAffaire(@PathVariable("idAffaire") long idAffaire,
			@PathVariable("numeroScelle") long numeroScelle) {

		// il faudra le charger depuis la bdd et appeller le constructeur vide
		Affaire x = new Affaire(idAffaire);
		// x.load(idAffaire);

		return x.getScelle(numeroScelle);
	}

	/**
	 * Méthode de récupération des scellés d'une affaire
	 * @param idAffaire identifiant de l'affaire
	 * @return liste des scellés de l'affaire
	 */
	@RequestMapping(value = "/affaire/{idAffaire}/scelles", method = RequestMethod.GET)
	public List<Scelle> getScelleAffaire(
			@PathVariable("idAffaire") long idAffaire) {

		// il faudra le charger depuis la bdd et appeller le constructeur vide
		Affaire x = new Affaire(idAffaire);
		// x.load(idAffaire);

		return x.getScelles();
	}

	/* ---------------------------------------------------- METHODE PUT ---------------------------------------------------------------*/
	
	/**
	 * Méthode de modification d'une affaire
	 * @param idAffaire identifiant de l'affaire à modifier
	 * @param nom nom de l'affaire à modifier
	 * @param dossier numéro de dossier de l'affaire à modifier
	 * @param parquet numéro de parquet de l'affaire à modifier
	 * @param dateOrdre 
	 * @param dateMax
	 * @param dateProrogation
	 * @param pageNb
	 * @param pageCoul
	 * @param hExp
	 * @param hDepl
	 * @param dateDevis
	 * @param pourcentDevis
	 * @param facture
	 * @param montantFacture
	 * @param pourcentRemise
	 * @param delais10j
	 * @param dateRemise
	 * @param instruction
	 */
	@RequestMapping(value = "/affaire/{idAffaire}", method = RequestMethod.PUT)
	public void PutAffaire(@PathVariable("idAffaire") long idAffaire,
			@RequestParam("nomAffaire") String nom,
			@RequestParam("numDossier") long dossier,
			@RequestParam("numParquet") long parquet,
			@RequestParam("dateOrdre") String dateOrdre,
			@RequestParam("dateMax") String dateMax,
			@RequestParam("dateProrogation") String dateProrogation,
			@RequestParam("nbPageNb") long pageNb,
			@RequestParam("nbPageCouleur") long pageCoul,
			@RequestParam("nbHExpertise") long hExp,
			@RequestParam("nbHDepalacement") long hDepl,
			@RequestParam("dateDevis") String dateDevis,
			@RequestParam("pourcentageDevis") double pourcentDevis,
			@RequestParam("numFacture") long facture,
			@RequestParam("montantFacture") double montantFacture,
			@RequestParam("pourcentageRemise") double pourcentRemise,
			@RequestParam("delais10j") boolean delais10j,
			@RequestParam("dateRemise") String dateRemise,
			@RequestParam("numInstruction") long instruction) {

		Affaire x = new Affaire(idAffaire);
		x.setNomAffaire(nom);
		x.setNumDossier(dossier);
		x.setNumParquet(parquet);
		x.setDateOrdre(dateOrdre);
		x.setDateMax(dateMax);
		x.setDateProrogation(dateProrogation);
		x.setNbPageNb(pageNb);
		x.setNbPageCouleur(pageCoul);
		x.setNbHExpertise(hExp);
		x.setNbHDeplacement(hDepl);
		x.setDateDevis(dateDevis);
		x.setPourcentageDevis(pourcentDevis);
		x.setNumFacture(facture);
		x.setMontantFacture(montantFacture);
		x.setPourcentageRemise(pourcentRemise);
		x.setDelais10j(delais10j);
		x.setDateRemise(dateRemise);
		x.setNumInstruction(instruction);
		x.save();
	}

	/**
	 * Méthode de modification de l'état d'une affaire
	 * @param idAffaire identifiant de l'affaire
	 * @param etat nouvel état de l'affaire
	 */
	@RequestMapping(value = "/affaire/{idAffaire}/etat", method = RequestMethod.PUT)
	public void putEtat(@PathVariable("idAffaire") long idAffaire,
			@RequestParam("etat") String etat) {

		// il faudra le charger depuis la bdd et appeller le constructeur vide
		Affaire x = new Affaire(idAffaire);
		// x.load(idAffaire);

		x.setEtat(etat);
		x.save();
	}

	/**
	 * Méthode de modification d'un frais d'une affaire
	 * @param idAffaire identifiant de l'affaire
	 * @param idFrais identifiant du frais à modifier
	 * @param libFrais nouveau libellé
	 * @param prixFrais nouveau prix
	 */
	@RequestMapping(value = "/affaire/{idAffaire}/frais/{idFrais}", method = RequestMethod.PUT)
	public void putFrais(@PathVariable("idAffaire") long idAffaire,
			@PathVariable("idFrais") long idFrais,
			@RequestParam("libFrais") String libFrais,
			@RequestParam("prixFrais") double prixFrais) {

		Frais x = new Frais(idFrais);
		x.setLibFrais(libFrais);
		x.setPrixFrais(prixFrais);
		x.save(idAffaire);
	}

	/**
	 * Méthode de modification d'un scellé d'une affaire
	 * @param idAffaire identifiant de l'affaire
	 * @param numeroScelle numéro du scellé à modifier
	 * @param numeroPV nouveau numéro du PV
	 * @param commentaire nouveau commentaire
	 */
	@RequestMapping(value = "/affaire/{idAffaire}/scelles/{numeroScelle}", method = RequestMethod.PUT)
	public void putScelle(@PathVariable("idAffaire") long idAffaire,
			@PathVariable("numeroScelle") long numeroScelle,
			@RequestParam("numeroPV") long numeroPV,
			@RequestParam("commentaire") String commentaire) {

		Scelle x = new Scelle(numeroScelle);
		x.load();
		x.setNumeroPV(numeroPV);
		x.setCommentaire(commentaire);
		x.save(idAffaire);
	}

	/* -------------------------------------------------- METHODE DELET -------------------------------------------------------------*/
	
	/**
	 * Méthode de suppression d'un frais d'une affaire
	 * @param idAffaire identifiant de l'affaire
	 * @param idFrais identifiant du frais à supprimer
	 */
	@RequestMapping(value = "/affaires/{idAffaire}/frais/{idFrais}", method = RequestMethod.DELETE)
	public void getAffaire2(@PathVariable("idAffaire") long idAffaire,
			@PathVariable("idFrais") long idFrais) {
		Frais x = new Frais(idAffaire, idFrais);
		x.delete();
	}

	/**
	 * Méthode de suppression d'un scellé d'une affaire
	 * @param idAffaire identifiant de l'affaire
	 * @param numeroScelle identifiant du scellé à supprimer
	 */
	@RequestMapping(value = "/affaires/{idAffaire}/scelles/{numeroScelle}", method = RequestMethod.DELETE)
	public void deleteScelle(@PathVariable("idAffaire") long idAffaire,
			@PathVariable("numeroScelle") long numeroScelle) {
		Affaire a = new Affaire();
		a.load(idAffaire);
		a.deleteScelle(numeroScelle);
	}

}
