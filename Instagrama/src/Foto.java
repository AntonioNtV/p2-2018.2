public class Foto {
    private String url;
    private String descricao;
    private String[] curtidas;

    public Foto(String url, String descricao) {
        this.url = url;
        this.descricao = descricao;
    }

    public void alterarDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void curtirFoto(String email_curtido) {
        for (int i = 0; i < this.curtidas.length; i++) {
            if (this.curtidas[i] != null) {
                this.curtidas[i] = email_curtido;
            }
        }

    }
    public String getUrl() {
        return  this.getUrl();
    }

    @Override
    public String toString() {
        for (int i = 0; i < this.curtidas.length; i++) {
            if (this.curtidas[i] != null) {
                return this.url + " " + this.descricao + " " + this.curtidas[i];
            }
        }
        return this.url + " " + this.descricao;
    }
}
