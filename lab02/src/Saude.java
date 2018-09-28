public class Saude {
    private String saudeAluno;
    private String saudeMental;
    private String saudeFisica;

    public Saude() {
        this.saudeAluno = "boa";
        this.saudeMental = "boa";
        this.saudeFisica = "boa";
    }

    public String getSaudeMental() {
        return  this.saudeMental;
    }

    public String getSaudeFisica() {
        return  this.saudeFisica;
    }

    public String getStatusGeral(){
        return this.saudeAluno;
    }

    public void defineSaudeMental(String saudeMental) {
        this.saudeMental = saudeMental;
        defineSaudeAluno(saudeMental);
    }

    public void defineSaudeFisica(String saudeFisica) {
        this.saudeFisica = saudeFisica;
        defineSaudeAluno(saudeFisica);
    }

    private void defineSaudeAluno(String saudeMentalOuFisica) {
        if (this.saudeFisica.equals("boa") && this.saudeMental.equals("boa")) {
            this.saudeAluno = "boa";
        } else if (this.saudeFisica.equals("fraca") && this.saudeMental.equals("fraca")) {
            this.saudeAluno = "fraca";
        } else {
            this.saudeAluno = "ok";
        }
    }
}
