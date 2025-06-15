import java.util.ArrayList;
import java.util.List;

public class Equipe {
    private List<Estudante> membros = new ArrayList<>();

    public void adicionarMembro(Estudante e) {
        membros.add(e);
    }

    public List<Estudante> getMembros() {
        return membros;
    }
}
