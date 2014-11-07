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

	/*
	 * METHODE POST
	 */

	// création d’une affaire
	@RequestMapping(value = "/affaires", method = RequestMethod.POST)
	public void createAffaire(
			@RequestParam(value = "nomAffaire", required = true) String nomAffaire) {
		Affaire x = new Affaire(nomAffaire);
		x.create();
	}

	// Création d'un frais d'une affaire
	@RequestMapping(value = "/affaire/{idAffaire}/frais", method = RequestMethod.POST)
	public void createFraisAffaire(@PathVariable("idAffaire") long idAffaire,
			@RequestParam("libFrais") String libFrais,
			@RequestParam("prixFrais") double prixFrais) {
		Frais x = new Frais(libFrais, prixFrais);
		x.save(idAffaire);
	}

	/*
	 * METHODE GESTION SCELLE
	 */
	@RequestMapping(value = "/affaire/{idAffaire}/scelles", method = RequestMethod.POST)
	public void createScelleAffaire(@PathVariable("idAffaire") long idAffaire,
			@RequestParam("numeroScelle") long numeroScelle,
			@RequestParam("numeroPV") long numeroPV,
			@RequestParam("commentaire") String commentaire) {
		Scelle newScelle = new Scelle(numeroScelle, numeroPV, commentaire);
		newScelle.save(idAffaire);
	}

	/*
	 * METHODE GET
	 */

	// Read d'une affaire
	@RequestMapping(value = "/affaire/{idAffaire}", method = RequestMethod.GET)
	public Affaire getAffaire(@PathVariable("idAffaire") long idAffaire) {

		// il faudra le charger depuis la bdd et appeller le constructeur vide
		Affaire x = new Affaire();
		// x.load(idAffaire);

		return x;
	}

	// Read des affaires
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

	// Read des frais d'une affaire
	@RequestMapping(value = "/affaire/{idAffaire}/frais", method = RequestMethod.GET)
	public List<Frais> getFraisAffaire(@PathVariable("idAffaire") long idAffaire) {

		// il faudra le charger depuis la bdd et appeller le constructeur vide
		Affaire x = new Affaire(idAffaire);
		// x.load(idAffaire);

		return x.getFrais();
	}

	// Read etat d'une affaire
	@RequestMapping(value = "/affaire/{idAffaire}/etat", method = RequestMethod.GET)
	public String getEtatAffaire(@PathVariable("idAffaire") long idAffaire) {

		// il faudra le charger depuis la bdd et appeller le constructeur vide
		Affaire x = new Affaire(idAffaire);
		// x.load(idAffaire);

		return x.getEtat();
	}

	// Read un scelle d'une affaire
	@RequestMapping(value = "/affaire/{idAffaire}/scelles/{numeroScelle}", method = RequestMethod.GET)
	public Scelle getScelleAffaire(@PathVariable("idAffaire") long idAffaire,
			@PathVariable("numeroScelle") long numeroScelle) {

		// il faudra le charger depuis la bdd et appeller le constructeur vide
		Affaire x = new Affaire(idAffaire);
		// x.load(idAffaire);

		return x.getScelle(numeroScelle);
	}

	// Read des scelle d'une affaire
	@RequestMapping(value = "/affaire/{idAffaire}/scelles", method = RequestMethod.GET)
	public List<Scelle> getScelleAffaire(
			@PathVariable("idAffaire") long idAffaire) {

		// il faudra le charger depuis la bdd et appeller le constructeur vide
		Affaire x = new Affaire(idAffaire);
		// x.load(idAffaire);

		return x.getScelles();
	}

	/*
	 * METHODE PUT
	 */
	// Modification d'une affaire
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

	// Modifie l'état d'une affaire
	@RequestMapping(value = "/affaire/{idAffaire}/etat", method = RequestMethod.PUT)
	public void putEtat(@PathVariable("idAffaire") long idAffaire,
			@RequestParam("etat") String etat) {

		// il faudra le charger depuis la bdd et appeller le constructeur vide
		Affaire x = new Affaire(idAffaire);
		// x.load(idAffaire);

		x.setEtat(etat);
		x.save();
	}

	// Modifie un frais d'une affaire
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

	// Modifie un scelle d'une affaire
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

	/*
	 * METHODE DELET
	 */
	// suppression d'un frais d'une affaire
	@RequestMapping(value = "/affaires/{id}/frais/{id2}", method = RequestMethod.DELETE)
	public void getAffaire2(@PathVariable("id") long id,
			@PathVariable("id2") long idFrais) {
		Frais x = new Frais(id, idFrais);
		x.delete();
	}

	@RequestMapping(value = "/affaires/{idAffaire}/scelles/{numeroScelle}", method = RequestMethod.DELETE)
	public void deleteScelle(@PathVariable("idAffaire") long idAffaire,
			@PathVariable("numeroScelle") long numeroScelle) {
		Affaire a = new Affaire();
		a.load(idAffaire);
		a.deleteScelle(numeroScelle);
	}

	/*
	 * test
	 * 
	 * @RequestMapping(value = "/affaires/{id}", method = RequestMethod.GET)
	 * public Affaire getAffaire2(@PathVariable("id") int id) { return new
	 * Affaire(id, "test"); }
	 */

}
