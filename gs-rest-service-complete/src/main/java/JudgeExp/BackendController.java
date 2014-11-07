package JudgeExp;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BackendController {

	/*
	 * METHODE POST
	 */
	// Création d'un typeMission d'un typeObjet
	@RequestMapping(value = "/typeObjet/{idTypeObjet}/typeMissions", method = RequestMethod.POST)
	public void createFraisAffaire(
			@PathVariable("idTypeObjet") long idTypeObjet,
			@RequestParam("idTypeMission") long idTypeMission,
			@RequestParam("libTypeMission") String libTypeMission) {
		TypeMission t = new TypeMission(idTypeMission, libTypeMission);
		t.save(idTypeObjet);
	}

	/*
	 * METHODE GET
	 */
	// Read des affaires
	@RequestMapping(value = "/typeObjets", method = RequestMethod.GET)
	public List<TypeObjet> getTypeObjets() {
		// Il faudra load toutes les typeObjets depuis la bdd
		List<TypeObjet> x = this.loadTypeObjets();
		return x;
	}

	// Read des typesMissions d'un typeobjet
	@RequestMapping(value = "/typeObjet/{idTypeObjet}/typeMissions", method = RequestMethod.GET)
	public List<TypeMission> getTypeMssions(
			@PathVariable("idTypeObjet") long idTypeObjet) {

		// Il faudra load toutes les typeMissions d'un typeObjet depuis la bdd
		TypeObjet t = new TypeObjet(idTypeObjet);
		t.load();
		return t.getTypeMissions();
	}

	// Read un typesMissions d'un typeobjet
	@RequestMapping(value = "/typeObjet/{idTypeObjet}/typeMission/{idTypeMission}", method = RequestMethod.GET)
	public TypeMission getTypeMssion(
			@PathVariable("idTypeObjet") long idTypeObjet,
			@PathVariable("idTypeMission") long idTypeMission) {

		// Il faudra load un typeMissions d'un typeObjet depuis la bdd
		TypeObjet t = new TypeObjet(idTypeObjet);
		t.load();
		return t.getTypeMission(idTypeMission);
	}

	/*
	 * Methode PUT
	 */
	// modification un typeMission d'un typeObjet
	@RequestMapping(value = "/typeObjet/{idTypeObjet}/typeMission/{idTypeMission}", method = RequestMethod.PUT)
	public void putScelle(@PathVariable("idTypeObjet") long idTypeObjet,
			@PathVariable("idTypeMission") long idTypeMission,
			@RequestParam("libTypeMission") String libTypeMission) {

		TypeObjet to = new TypeObjet(idTypeObjet);
		to.load();
		TypeMission tm=to.getTypeMission(idTypeMission);
		tm.setLibTypeMission(libTypeMission);
		tm.save(idTypeObjet);
	}

	/*
	 * Methode DELET
	 */

	// suppression un typeMission d'un typeObjet
	@RequestMapping(value = "/typeObjet/{idTypeObjet}/typeMission/{idTypeMission}", method = RequestMethod.DELETE)
	public void deleteTypeMission(
			@PathVariable("idTypeObjet") long idTypeObjet,
			@PathVariable("idTypeMission") long idTypeMission) {
		TypeObjet to = new TypeObjet(idTypeObjet);
		to.load();
		to.deleteTypeMission(idTypeMission);
	}

	/*
	 * Methode lié à l'ORM
	 */
	public List<TypeObjet> loadTypeObjets() {
		return null;
	}
}
