import java.util.ArrayList;

public class Usuario {
    private String email;
    private String nome;
    private Foto[] fotos;

    public Usuario(String email, String nome) {
        this.email = email;
        this.nome = nome;
        this.fotos = new Foto[200];
    }

    public void cadastraFoto(String url, String descricao) {
        if (this.fotos[this.fotos.length - 1] == null) {
            aumentaFotos();
        }

        for (int i = 0; i < this.fotos.length; i++) {
            if (this.fotos[i] == null) {
                this.fotos[i] = new Foto(url, descricao);
            }
        }
    }

    private void aumentaFotos() {
        Foto[] novasFotos = new Foto[2 * this.fotos.length];

        for (int i = 0; i < this.fotos.length; i++) {
            novasFotos[i] = this.fotos[i];
        }
        this.fotos = novasFotos;
    }

    public String getEmail() {
        return this.email;
    }
    public void alterarDescricao(String url, String descricao) {
        for (int i = 0; i < this.fotos.length; i++) {
            if (this.fotos[i].getUrl().equals(url)) {
                this.fotos[i].alterarDescricao(descricao);
            }
        }
    }

    public void curtirFoto(String email_curtir, int foto) {
        this.fotos[foto - 1].curtirFoto(email_curtir);
    }

    public int qtdFotosUsuario() {
        return this.fotos.length;
    }

    public String listaFotos() {
        String stringFotos = "";
        for (int i = 0; i < this.fotos.length; i++) {
            if (this.fotos[i] != null) {
                stringFotos += this.fotos[i].toString() + "\n";
            }
        }
        return stringFotos;
    }

    @Override
    public String toString() {
        return this.nome + " - " + this.email;
    }
}
