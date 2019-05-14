/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaifrs.classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author erick
 */
public class Disciplina implements Serializable {
    
    private String nome;
    private int ano;
    private Professor professor;
    private ArrayList <Aluno> alunos;
    private ArrayList <Float> notas;
    
    public boolean novoAluno(Aluno newAluno){
        for (int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i) == null){
                alunos.set(i, newAluno);
                return true;
            }
        }
        return false;
    }
    
    public boolean removeAluno(long matricula){
        for (int i = 0; i < alunos.size(); i++) {
            if(alunos.get(i) != null && alunos.get(i).getMatricula() == matricula){
                alunos.set(i, null);
                return true;
            }
        }
        return false;
    }
    
    public boolean registrarNota(float nota, long matricula){
        for (int i = 0; i < notas.size(); i++) {
            if(alunos.get(i).getMatricula() == matricula){
                notas.set(i, nota);
                return true;
            }
        }
        return false;
    }
    
    public boolean alterarNota(long matricula, float newNota ){
        return registrarNota(newNota, matricula);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }

    public ArrayList<Float> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<Float> notas) {
        this.notas = notas;
    }

    

    public Disciplina(String nome, int ano, Professor professor, ArrayList<Aluno> alunos, ArrayList<Float> notas) {
        this.nome = nome;
        this.ano = ano;
        this.professor = professor;
        this.alunos = alunos;
        this.notas = notas;
    }

    public Disciplina(String nome, int ano, Professor professor, ArrayList<Aluno> alunos) {
        this.nome = nome;
        this.ano = ano;
        this.professor = professor;
        this.alunos = alunos;
    }

    public Disciplina(String nome, int ano, Professor professor) {
        this.nome = nome;
        this.ano = ano;
        this.professor = professor;
    }


    
    
    // toString
    
    @Override
    public String toString() {
        return "Disciplina{" + "nome=" + nome + ", ano=" + ano + ", professor=" + professor + ", alunos=" + alunos + ", notas=" + notas + '}';
    }
        
    //equals


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
        final Disciplina other = (Disciplina) obj;
        if (this.ano != other.ano) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.professor, other.professor)) {
            return false;
        }
        if (!Objects.equals(this.alunos, other.alunos)) {
            return false;
        }
        if (!Objects.equals(this.notas, other.notas)) {
            return false;
        }
        return true;
    }
    
    
        
}
