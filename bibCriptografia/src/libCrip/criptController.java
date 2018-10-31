package libCrip;

import java.util.HashMap;
import java.util.Map;

public class criptController {
    private Map<Integer, Usuario> usarios;

    public criptController() {
        this.usarios = new HashMap<>();
    }

    public void adicionaUsuario(int id) {
        this.usarios.put(id, new Usuario(id));
    }

    public String criptografar(int id, String textoOriginal) {

        return null;
    }
}
