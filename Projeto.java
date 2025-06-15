public class Projeto {
    private Profissional orientador;
    private Equipe equipe;
    private int notaFinal;

    public Projeto(Profissional orientador, Equipe equipe) {
        this.orientador = orientador;
        this.equipe = equipe;
    }

    public void setNotaFinal(int notaFinal) {
        this.notaFinal = notaFinal;
    }

    public int getNotaFinal() {
        return notaFinal;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public Profissional getProfissional(){
        return orientador;
    }
}
