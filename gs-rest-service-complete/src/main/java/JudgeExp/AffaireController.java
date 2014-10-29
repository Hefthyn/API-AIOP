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

	/**
	 * METHODE POST
	 */
	
	// création d’une affaire
	@RequestMapping(value = "/affaires", method = RequestMethod.POST)
	public void getAffaire(@RequestParam(value="nomAffaire", required=true) String nomAffaire) {
	    Affaire x = new Affaire (nomAffaire);
	    x.create();    
	}
	
	/**
	 * METHODE GET
	 */
	
	// Read d'une affaire
	@RequestMapping(value = "/affaire/{id}", method = RequestMethod.GET)
	public Affaire getAffaire(@PathVariable("id") long id) {
	    return new Affaire(id);
	}
	
	// Read des affaires
	@RequestMapping(value = "/affaires", method = RequestMethod.GET)
	public List<Affaire> getAffaires() {
	    //Affaire x = new Affaire();
	    //return x.getAllAffaires();
		List<Affaire> x = new ArrayList<Affaire>();
		x.add(new Affaire(1));
		x.add(new Affaire(2));
		x.add(new Affaire(3));
		return x;
	}
	
	// Read des frais d'une affaire
	@RequestMapping(value = "/affaire/{id}/frais", method = RequestMethod.GET)
	public List<Frais> getFraisAffaire(@PathVariable("id") long id) {
	    Affaire x = new Affaire(id);
	    return x.getFrais();
	}
	
	/**
	 * METHODE PUT
	 */
	// Modification d'une affaire
	@RequestMapping(value = "/affaire/{id}", method = RequestMethod.GET)
	public void PutAffaire(@PathVariable("id") long id, 	@PathVariable("nomAffaire") String nom,
			@PathVariable("numDossier") long dossier, @PathVariable("numParquet") long parquet, @PathVariable("dateOrdre") String dateOrdre,
			@PathVariable("dateMax") String dateMax, @PathVariable("dateProrogation") String dateProrogation,
			@PathVariable("nbPageNb") long pageNb, @PathVariable("nbPageCouleur") long pageCoul, @PathVariable("nbHExpertise") long hExp,
			@PathVariable("nbHDepalacement") long hDepl, @PathVariable("dateDevis") String dateDevis, @PathVariable("pourcentageDevis") double pourcentDevis,
			@PathVariable("numFacture") long facture, @PathVariable("montantFacture") double montantFacture, @PathVariable("pourcentageRemise") double pourcentRemise,
			@PathVariable("delais10j") boolean delais10j, @PathVariable("dateRemise") String dateRemise, @PathVariable("numInstruction") long instruction) {
	    Affaire x = new Affaire(id);
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
	@RequestMapping(value = "/affaire/{id}/etat", method = RequestMethod.PUT)
	public void putEtat(@PathVariable("id") long id, @RequestParam("etat") String etat) {
	    Affaire x = new Affaire(id);
	    x.setEtat(etat);
	    x.save();
	}
	
	// test
	@RequestMapping(value = "/affaires/{id}", method = RequestMethod.GET)
	public Affaire getAffaire2(@PathVariable("id") int id) {
	    return new Affaire(id, "test");
	}
}

