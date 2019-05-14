/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaifrs;

import static sistemaifrs.SistemaEnsino.arquivoEnsino;
import sistemaifrs.classes.Professor;
import sistemaifrs.classes.SetorEnsino;

/**
 *
 * @author erick
 */
public class SistemaProfessor {

    static Professor encontra_Professor(String nome_professor) {
        SetorEnsino ensino = SistemaArquivos.lerEnsino(arquivoEnsino);
        if (ensino.getProfessores() != null){
            for (Professor p : ensino.getProfessores()) {
                if (p != null && p.getNome().equalsIgnoreCase(nome_professor)){
                    return p;
                }
            }
        }
        return null;
    }
    
}
