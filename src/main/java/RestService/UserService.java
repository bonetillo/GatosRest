package RestService;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

import jakarta.ws.rs.core.MediaType;
import java.util.HashMap;

import java.util.Map;

@Path("/gato")
public class UserService {

    static Map<String, Integer> gatosVotos = new HashMap<>();

    @GET
    @Path("/voto/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public Integer voto(@PathParam("nombre") String nombre) {
        int valorActual;
        if (!gatosVotos.containsKey(nombre)) {
            gatosVotos.put(nombre, 1);
            return 1;
        } else {
            valorActual = gatosVotos.get(nombre)+1;
            gatosVotos.put(nombre, valorActual);
            return valorActual ;

        }
    }

    @GET
    @Path("/getVotos")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Integer> getVotos() {        return gatosVotos;

    }

}
