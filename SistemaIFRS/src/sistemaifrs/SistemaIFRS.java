/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaifrs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author erick
 */
public class SistemaIFRS {

    /**
     * @param args the command line arguments
     */
     public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     
     final static int OPSAIR = 0;
     
     public static int menu() throws IOException {
        System.out.println("MENU 1: \n[1] - Aluno"
                + "\n[2] - Professor"
                + "\n[3] - Setor de Ensino"
                + "\n[0] - Sair");
        String texto = br.readLine();

        int opcao = Integer.parseInt(texto);
        return opcao;
    }
     
      public static void main(String[] args) throws IOException {
        int opcao = menu();
          
        do {
            switch (opcao) {
                case 1:
                    SistemaAluno.menu_alunos("MENU 2: \n [1] Ver Cursos [2] Ver notas",
                            ensino,
                            alunos,);
                    break;
                case 2:
                    System.out.println("Qual o seu nÃºmero de siape, professor?");
                    int siape = Integer.parseInt(br.readLine());
                    int posicao_professor = SistemaProfessor.login_professor(siape, ensino, br);

                    if (posicao_professor != -1) {
                        SistemaProfessor.menu_professor("MENU 2: \n [1] Dar Notas de uma disciplina [2] Alterar uma nota [3] Adicionar Ã�rea [4] Remover Ã�rea",
                                posicao_professor,
                                ensino,
                                br);
                    } else {
                        System.err.println("SIAPE invÃ¡lido.");
                    }
                    break;
                case 3:
                    SistemaEnsino.menu_ensino("MENU 2: \n [1] Adicionar Disciplina ao Curso [2] Cadastrar Aluno [3] Cadastrar Curso [4] Cadastrar Professor",
                            ensino,
                            alunos,
                            br);
            }
        } while (opcao != OPSAIR);
      }
    
    
}
