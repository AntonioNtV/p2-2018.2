package libCrip;

public class ROT13 implements Criptografia {
    @Override
    public String criptografar(String texto) {
        String textoCritografado = "";
        String[] letras = {"A","B","C","D","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

        for (int i = 0; i < texto.length(); i++) {
            String letraTexto = texto[i];

        }
        return textoCritografado;
    }
}
