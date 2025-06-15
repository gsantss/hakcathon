package src;
import java.util.HashMap;
import java.util.Map;

public class Banca implements Avaliavel {
    private Projeto projetoAvaliado;
    private Map<Jurado, Integer> jurados = new HashMap<>();

    public Banca(Projeto projetoAvaliado) {
        this.projetoAvaliado = projetoAvaliado;
    }

    public void adicionarNota(Jurado jurado, int nota) {
        jurados.put(jurado, nota);
    }

    public void calcularNotaFinal() {
        int soma = 0;
        for (int nota : jurados.values()) {
            soma += nota;
        }
        int media = soma / jurados.size();
        projetoAvaliado.setNotaFinal(media);
    }
}
