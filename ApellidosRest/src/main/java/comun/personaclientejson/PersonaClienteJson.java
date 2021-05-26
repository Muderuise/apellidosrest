package comun.personaclientejson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PersonaClienteJson {
	@Value("${HOST_PERSONA_JSON}")
	private String direccionServidorPersonaJson;
	@Value("${PORT_PERSONA_JSON}")
	private String puertoServidorPersonaJson;
	@Value("${METHOD_PERSONA_JSON}")
	private String metodoServidorPersonaJson;
		
	public String dameApellidoPersonaConId(int id){
		//https://personaJson:80/damePersonaConId?ids="{ids:[1,2]}"
		String uri = "https://"+direccionServidorPersonaJson+":"+puertoServidorPersonaJson+"/"+metodoServidorPersonaJson;//+"?id="+id;
		RestTemplate restTemplate = new RestTemplate();
		Id id1 = new Id();id1.setId(id);
		Persona persona = restTemplate.postForObject(uri, id1, Persona.class);
		return persona.getApellido();
	}
	
}
