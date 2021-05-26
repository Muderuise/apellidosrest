package comun;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import comun.personaclientejson.ListaIds;
import comun.personaclientejson.PersonaClienteJson;

import org.springframework.beans.factory.annotation.Autowired;
/*
 * instalar plugin spring tools en eclipse
 */
@RestController
public class ApellidosController {	
	@Autowired
	private PersonaClienteJson servicioPersonaJson;
	
	//https://localhost:8080/mezcla-apellidos?ids="{ids:[1,2]}"
	@PostMapping("/mezcla-apellidos")
	public String mezclaApellidos(
			@RequestBody (required = true) ListaIds ids) {
		String apellido1 = "Error";
		String apellido2  = "sin parametros";
		if(ids!=null && ids.getIds()!=null && ids.getIds().size()==2) {
			int id1 = ids.getIds().get(0);
			int id2 = ids.getIds().get(1);
			apellido1 = servicioPersonaJson.dameApellidoPersonaConId(id1);
			apellido2 = servicioPersonaJson.dameApellidoPersonaConId(id2);
		}		
		return apellido1+" "+apellido2;
	}
}
