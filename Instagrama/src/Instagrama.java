
public class Instagrama {
    private  Usuario[] usuarios;

    public Instagrama() {
        this.usuarios = new Usuario[200];
    }

    public void cadastraUsuarios(String email, String nome) {
        if (this.usuarios[this.usuarios.length - 1] != null) {
            aumentaUsuarios();
        }
        for (int i = 0; i < this.usuarios.length; i++) {
            if (this.usuarios[i] == null) {
                this.usuarios[i] = new Usuario(email, nome);
                break;
            }
        }
    }

    public void cadastraFoto(String email, String url, String descricao) {
        for (int i = 0; i < this.usuarios.length; i++) {
            if (this.usuarios[i] != null && this.usuarios[i].getEmail().equals(email)) {
                this.usuarios[i].cadastraFoto(url,descricao);
            }
        }
    }

    public String listarUsarios() {
        String usuariosSaida = "";
        for (int i = 0; i < this.usuarios.length; i++) {
            if (this.usuarios[i] != null) {
                usuariosSaida += this.usuarios[i].toString() + "\n";
            }
        }

        return usuariosSaida;
    }

    public int qtdCadastrados() {
        int cont = 0;

        for (int i = 0; i < this.usuarios.length; i++ ){
            if (this.usuarios[i] != null) {
                cont ++;
            }
        }
        return cont;
    }

    private void aumentaUsuarios() {
        Usuario[] novosUsuarios = new Usuario[2 * this.usuarios.length];

        for (int i = 0; i <= this.usuarios.length; i++) {
            novosUsuarios[i] = this.usuarios[i];
        }
        this.usuarios = novosUsuarios;
    }

    public void alterarDescricao(String email, String url, String descricao) {
        for (int i = 0; i <= this.usuarios.length; i++) {
            if (this.usuarios[i].getEmail() == email) {
                this.usuarios[i].alterarDescricao(email, descricao);
            }
        }
    }

    public void curtirFoto(String email_curtir,String email_dono,int foto) {
        for (int i = 0; i<= this.usuarios.length; i++){
            if (this.usuarios[i].getEmail().equals(email_dono)) {
                this.usuarios[i].curtirFoto(email_curtir, foto);
            }
        }
    }

    public String listaFotos(String email) {
        String fotos = "";

        for (int i = 0; i < this.usuarios.length; i++) {
            if (this.usuarios[i] != null && this.usuarios[i].getEmail().equals(email)) {
                fotos += this.usuarios[i].listaFotos() + "\n";
            }
        }
        return fotos;
    }

    private int qtdFotosUsuarios(String email) {
        for (int i = 0; i <= this.usuarios.length; i++) {
            if (this.usuarios[i].getEmail().equals(email)) {
                return this.usuarios[i].qtdFotosUsuario();
            }
        }
        return 0;
    }

}

