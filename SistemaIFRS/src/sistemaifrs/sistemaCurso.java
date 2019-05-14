/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaifrs;

import java.io.IOException;
import java.util.ArrayList;
import static sistemaifrs.SistemaEnsino.ARQUIVO_ENSINO;
import static sistemaifrs.SistemaEnsino.ENSINO;
import static sistemaifrs.SistemaIFRS.br;
import sistemaifrs.classes.Aluno;
import sistemaifrs.classes.Curso;
import sistemaifrs.classes.Disciplina;
import sistemaifrs.classes.SetorEnsino;

/**
 *
 * @author erick
 */
class sistemaCurso {

    public static void mostrar_cursos() throws IOException, ClassNotFoundException{
    
    SistemaArquivos.lerCursos(ARQUIVO_ENSINO);
}

    public static Curso add_curso() throws IOException, ClassNotFoundException{
        SetorEnsino ensino = SistemaArquivos.lerEnsino(ARQUIVO_ENSINO);
        Curso c;

        c = cria_curso();
        if (ENSINO.novoCurso(c)){
            System.out.println("Curso" + c.getNome());
        }else{
            System.out.println("O limite de cursos foi alcançado");
        }
        return c;

    }

    public static Curso cria_curso() throws IOException{

        System.out.print("Nome: ");
        String nome = br.readLine();

        System.out.print("PPC: ");
        String ppc = br.readLine();

        Curso a = new Curso(nome, ppc);
        ArrayList <Disciplina> disciplinas = SistemaDisciplina.recebe_disciplinas();

        a.setDisciplinas(disciplinas);
        return a;
    }

    public static Curso encontra_curso(String nome){
        if (ENSINO.getCursos() != null){
            for (Curso c : ENSINO.getCursos()){
                if (c != null && c.getNome().equalsIgnoreCase(nome)){
                    return c;
                }
            }
        }
        return null;

    }

    public static void ver_cursos(){
        ArrayList<Curso> cursos = ENSINO.getCursos();

        if (cursos != null){
            for (Curso c : cursos){
                if(c != null){
                     System.out.println("Curso " + c.getNome());
                        System.out.println("PPC: " + c.getPpc());
                        System.out.println("Disciplinas: ");
                        if (c.getDisciplinas() != null) {
                            for (Disciplina d : c.getDisciplinas()) {
                                if (d != null) {
                                    System.out.println(d.getNome());
                                }
                            }
                        }
                }
            }
        }
    }

    public static void ver_notas(String curso,long matricula){
        boolean aluno_nao_encontrado = true;

        for (Curso c : ENSINO.getCursos()) {
            if (c.getNome().equalsIgnoreCase(curso)){
                for (Disciplina d : c.getDisciplinas()) {
                    int i  = 0;
                    for (Aluno a : d.getAlunos()) {
                        i ++;
                        if (a.getMatricula() == matricula){
                            float nota = d.getNotas().get(i);
                            aluno_nao_encontrado = false;
                            System.out.println("A nota do aluno" + a.getNome() + "é de "+ nota+ "na disciplina" + d.getNome());
                        }
                    }
                }
            }
        }
        if (aluno_nao_encontrado){
            System.err.println("Aluno não matriculado no sistema!");
        }
    }
   }
