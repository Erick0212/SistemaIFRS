/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaifrs;

import java.io.IOException;
import java.util.ArrayList;
import static sistemaifrs.SistemaIFRS.br;
import sistemaifrs.classes.Curso;
import sistemaifrs.classes.Disciplina;
import sistemaifrs.classes.SetorEnsino;

/**
 *
 * @author erick
 */
public class SistemaEnsino {
    public static final String ARQUIVO_ENSINO = "ensinos.bin";
    public static final SetorEnsino ENSINO = SistemaArquivos.lerEnsino(ARQUIVO_ENSINO);
    
    public static boolean novo_ensino() throws IOException{
        System.out.print("Nome do diretor: ");
        String diretor = br.readLine();
        System.out.print("Nome do coordenador: ");
        String coordenador = br.readLine();
        
        SetorEnsino ensino = new SetorEnsino(diretor, coordenador);
        
        try {
            SistemaArquivos.gravaArq(ensino, ARQUIVO_ENSINO);
            return true;
        } catch (Exception e) {
            System.err.println("Erro ao salvar o novo ensino! ");
        }
        
        return false;
    }
    
    public static void menu_ensino() throws IOException{
        int opcao = menu_opcoes();
        switch (opcao){
            case 1:
                \\ continuar
        }
    }
    
    public static int menu_opcoes() throws IOException{
                System.out.println("Menu Setor de Ensino"
                + "\n[1] - Adicionar disciplina ao curso"
                + "\n[2] - Cadastrar aluno"
                + "\n[3] - Cadastrar curso"
                + "\n[4] - Cadastrar professor"
                + "\n[0] - Sair");
        
        int opcao = Integer.parseInt(br.readLine());
        return opcao;

}
