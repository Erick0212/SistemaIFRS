/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaifrs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import static sistemaifrs.SistemaIFRS.br;

/**
 *
 * @author erick
 */
public class SistemaAluno {

   
    
    public static void menu_aluno() throws IOException{
        
        System.out.println("Qual seu ensino: ");
        
        final String ensino = br.readLine();
        
        System.out.println("Informe o número de matricula: ");
        final long matricula = (long) Integer.parseInt(br.readLine());

        System.out.println("Selecione uma opção:"
                + "\n[1] Ver cursos"
                 + "\n[2] Ver notas");  
        int opcao = Integer.parseInt(br.readLine());
        
        switch (opcao){
            case 1:
                sistemaCurso.ver_cursos();
                break;
            case 2:
                              
                sistemaCurso.ver_notas(ensino,curso,matricula);
                
                
                
                
        }
        
        
        
        
        
        
    }
    
}
