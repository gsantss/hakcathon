package src;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Universidade puc = new Universidade("PUC");
        Empresa empresa = new Empresa("TOTVS");

        // Criação de 2 equipes com 5 alunos cada
        for (int i = 1; i <= 2; i++) {
            Equipe equipe = new Equipe();
            for (int j = 1; j <= 5; j++) {
                equipe.adicionarMembro(new Estudante("Aluno" + i + "_" + j, puc));
            }
            Equipes.getInstancia().adicionar(equipe);
        }

        // Adiciona projeto diferente para cada equipe
        for (Equipe equipe : Equipes.getInstancia().getEquipes()) {
            Profissional orientador = new Profissional("Orientador_" + equipe.getMembros().get(0).getNome(), empresa);
            Projeto projeto = new Projeto(orientador, equipe);

            // Criação da banca com 4 jurados
            Banca banca = new Banca(projeto);
            for (int i = 1; i <= 4; i++) {
                Jurado jurado = new Jurado("Jurado" + i, empresa);
                banca.adicionarNota(jurado, 5 + (int)(Math.random() * 6)); // nota entre 5 e 10
            }

            // Criar apresentação
            Sala sala = new Sala("Sala 10" + (int)(Math.random()*10));
            Apresentacao ap = new Apresentacao(projeto, banca, sala, LocalDateTime.now());
            ap.avaliar();
            Apresentacoes.getInstancia().adicionar(ap);
        }

        // Listar projetos com nota final >= 7
        List<Projeto> aprovados = Apresentacoes.getInstancia().getApresentacoes().stream()
            .map(Apresentacao::getProjeto)
            .filter(p -> p.getNotaFinal() >= 7)
            .collect(Collectors.toList());

        System.out.println("Projetos Aprovados (nota >= 7):");
        for (Projeto p : aprovados) {
            System.out.println("Nota: " + p.getNotaFinal());
        }
    }
}
