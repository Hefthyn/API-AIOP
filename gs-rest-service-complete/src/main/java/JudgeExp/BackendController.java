package JudgeExp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

public class BackendController {

	/*
	 * METHODE GET
	 */
	// Read des affaires
	@RequestMapping(value = "/typeObjets", method = RequestMethod.GET)
	public List<TypeObjet> getTypeObjets() {

		// Il faudra load toutes les affaires depuis la bdd
		List<TypeObjet> x = this.loadTypeObjets();
		return x;
	}
	// Read des typesMissions d'un type objet
	@RequestMapping(value = "/typeObjets/{idTypeObjet}/typeMissions", method = RequestMethod.GET)
	public List<TypeObjet> getTypeMssions() {

		// Il faudra load toutes les affaires depuis la bdd
		List<TypeObjet> x = this.loadTypeObjets();
		return x;
	}
	
	/*
	 * Methode lié à l'ORM
	 */
	public List<TypeObjet> loadTypeObjets() {
		return null;
	}
}
