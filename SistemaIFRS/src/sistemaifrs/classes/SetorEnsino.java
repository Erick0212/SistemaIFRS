
package sistemaifrs.classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author erick
 */
public class SetorEnsino implements Serializable{
    
    private ArrayList <Curso> cursos;
    private ArrayList <Professor> professores;
    private String diretor;
    private String coordenador;

    
     public boolean novaDisciplina(Disciplina newDisciplina){
         for (int i = 0; i < cursos.size(); i++) {
            if( cursos.get(i).getDisciplinas() == null){
                 cursos.get(i).getDisciplinas().set(i, newDisciplina);
                return true;
            }
        }
        return false;
    }
    
    public boolean removeDisciplina(String nome){
        for (int i = 0; i < cursos.size(); i++){
            if(cursos.get(i).getDisciplinas().get(i) !=  null && cursos.get(i).getDisciplinas().get(i).getNome().equalsIgnoreCase(nome) ){
                cursos.get(i).getDisciplinas().set(i, null);
                return true;
            }
        }
        return false;
    }
    
    public boolean novoProfessor(Professor newProfessor) {
        for (int i = 0; i < professores.size(); i++) {
            if (professores.get(i) != null) {
                professores.set(i, newProfessor);
                return true;
            }
        }
        return false;
    }

    public boolean novoCurso(Curso newCurso) {
        for (int i = 0; i < cursos.size(); i++) {
            if (cursos.get(i) != null) {
                cursos.set(i, newCurso);
                return true;
            }
        }
        return false;
    }

    public boolean ApagaCurso (String nome) {
        for (int i = 0; i < cursos.size(); i++) {
            if (cursos.get(i) != null && cursos.get(i).getNome().equalsIgnoreCase(nome)){
                cursos.set(i, null);
                return true;
            }
        }
        return false;
    }

    public boolean demitirProfessor(long siape) {
        for (int i = 0; i < professores.size(); i++) {
            if (professores.get(i) != null && professores.get(i).getSiape() == siape) {
                professores.set(i, null);
                return true;
            }
        }
        return false;
    }

    public boolean salvaNotas(ArrayList<Float> notas, Curso curso, Disciplina d) {
                for (Disciplina disciplina : curso.getDisciplinas()) {
                    if (disciplina.equals(d)){
                        disciplina.setNotas(notas);
                        return true;
                    }
                }
        return false;
    }
    
    public boolean alterarNota(String nomeCurso, String nomeDisciplina, long matricula, float newNota){
        int contador = 0;
        for (Curso curso : cursos) {
            if(curso.getNome().equalsIgnoreCase(nomeCurso) ){
                for (Disciplina disciplina : curso.getDisciplinas()) {
                    if (disciplina.getNome().equalsIgnoreCase(nomeDisciplina)){
                        for (Aluno aluno : disciplina.getAlunos()) {
                            contador++;
                            if (aluno.getMatricula() == matricula){
                                disciplina.getNotas().set(contador, newNota);
                                return true;
                            }
                        }
                    }                      
                }
            }
        }
        return false;
    }
    
    public boolean matricularAluno(String nome_curso, Aluno a){
        for (Curso curso : cursos) {
            if (curso.getNome().equalsIgnoreCase(nome_curso)){
                for (Disciplina d : curso.getDisciplinas()) {
                    for (int i = 0; i < d.getAlunos().size(); i++) {
                        if (d.getAlunos().get(i) == null){
                            d.getAlunos().set(i, a);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }

    public ArrayList<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(ArrayList<Professor> professores) {
        this.professores = professores;
    }
  
    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(String coordenador) {
        this.coordenador = coordenador;
    }

    public SetorEnsino(ArrayList<Curso> cursos, ArrayList <Professor> professores, String diretor, String coordenador) {
        this.cursos = cursos;
        this.professores = professores;
        this.diretor = diretor;
        this.coordenador = coordenador;
    }

    public SetorEnsino(String diretor, String coordenador) {
        this.diretor = diretor;
        this.coordenador = coordenador;
        this.professores = new ArrayList();
        this.cursos = new ArrayList();
    }
    
    //toString

    @Override
    public String toString() {
        return "SetorEnsino{" + "cursos=" + cursos + ", professores=" + professores + ", diretor=" + diretor + ", coordenador=" + coordenador + '}';
    }
    
    // equals

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SetorEnsino other = (SetorEnsino) obj;
        if (!Objects.equals(this.diretor, other.diretor)) {
            return false;
        }
        if (!Objects.equals(this.coordenador, other.coordenador)) {
            return false;
        }
        if (!Objects.equals(this.cursos, other.cursos)) {
            return false;
        }
        if (!Objects.equals(this.professores, other.professores)) {
            return false;
        }
        return true;
    }
}
