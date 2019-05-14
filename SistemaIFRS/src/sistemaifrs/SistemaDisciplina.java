/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaifrs;

import java.io.IOException;
import java.util.ArrayList;
import static sistemaifrs.SistemaIFRS.br;
import sistemaifrs.classes.Disciplina;
import sistemaifrs.classes.Professor;

/**
 *
 * @author erick
 */
class SistemaDisciplina {
    
    static ArrayList<Disciplina> recebe_disciplinas() throws IOException {
        ArrayList <Disciplina> disciplinas = new ArrayList();
        
        System.out.println("Digite [1] para finalizar ou [2] para cadastrar disciplina");
        int op = Integer.parseInt(br.readLine());
        
        for (int i = 0; op != 1 ; i++ ){
            String nome_professor = br.readLine();
            Professor professor = SistemaProfessor.encontra_Professor(nome_professor);
            
            if (professor == null){
                System.err.println("professor não esta cadastrado!");
                break;
            }
            disciplinas.add(cria_disciplina(professor));
            System.out.println("\nDigite [1] para finalizar ou [2] para cadastrar disciplina");
            op = Integer.parseInt(br.readLine());
        }
        return disciplinas;
    }

    private static Disciplina cria_disciplina(Professor professor) throws IOException {
        System.out.print("Qual o nome da disciplina: ");
        String nome = br.readLine();
        
        System.out.print("qual o ano/semestre da disciplina: ");
        int ano = Integer.parseInt(br.readLine());
        
        Disciplina d = new Disciplina(nome, ano, professor);
        return d;
    }
    
}
