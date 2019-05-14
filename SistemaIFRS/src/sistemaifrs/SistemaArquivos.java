/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaifrs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import static sistemaifrs.SistemaIFRS.br;
import sistemaifrs.classes.Aluno;
import sistemaifrs.classes.Curso;
import sistemaifrs.classes.SetorEnsino;

/**
 *
 * @author erick
 */
public class SistemaArquivos {
    
    
    public static boolean salvaAlunoDisciplina(String arquivo, Aluno aluno){
        
        try {
            File file = new File(arquivo);
            if (!file.exists()){
                file.createNewFile();
            }
            try (FileOutputStream fos = new FileOutputStream(file);
                    ObjectOutputStream oos = new ObjectOutputStream(fos)){
                oos.writeObject(aluno);
                        
                    }
                    System.out.println("Dados salvos");
        }catch (IOException e){
                System.err.println(e);
                System.out.println("Erro ao salvar os arquivos");
        }
        
        return false;
    }
        public static void salvaAluno(Aluno aluno){
     
        try {
            File f = new File("alunos.bin");
            if (!f.exists()){
                f.createNewFile();
            }
            try (FileOutputStream fos = new FileOutputStream(f);
                    ObjectOutputStream oos = new ObjectOutputStream(fos)){
                oos.writeObject(aluno);
                        
                    }
                    System.out.println("Dados salvos");
        }catch (IOException e){
                System.err.println(e);
                System.out.println("Erro ao salvar os arquivos");
        }
        
    }
    
    public static void lerAluno() throws ClassNotFoundException{
        Aluno aluno = new Aluno();
        try {
            ///FileReader ler = new FileReader("alunos.bin");
            //BufferedReader lerb = new BufferedReader(ler);
            //String linha  = lerb.readLine();
            
            File f = new File ("alunos.bin");
            if (f.exists()){
                try (FileInputStream fis = new FileInputStream(f);
                        ObjectInputStream ois = new ObjectInputStream(fis)){
                    aluno = (Aluno) ois.readObject();
                    System.out.println("Dados lidos");
                    System.out.println(aluno.toString());
                }
            }
        }catch(IOException e){
            System.out.println(e);
            System.out.println("Erro na leitura");   
        }        
    }
    
    public static void lerCursos (String arquivo) throws IOException, ClassNotFoundException{
          SetorEnsino ensino;
          try {
              File arq = new File(arquivo);
              if(arq.exists()){
                  
                  try (FileInputStream fis = new FileInputStream(arq);
                          ObjectInputStream ois = new ObjectInputStream(fis)){
                      ensino = (SetorEnsino)ois.readObject();
                      for (Curso c : ensino.getCursos()) {
                          System.out.println(c.getNome());
                      }
                          } catch (ClassNotFoundException ex){
                              System.err.println("Erro ao ler o objeto de "+arquivo);
                          }
              }
          } catch (IOException e){
              System.out.println("Erro: Arquivo não encontrado!");
          }
      }
      
    public static SetorEnsino lerEnsino(String arquivo){
        SetorEnsino ensino;
          try {
              File arq = new File(arquivo);
              if(arq.exists()){
                  
                  try (FileInputStream fis = new FileInputStream(arq);
                          ObjectInputStream ois = new ObjectInputStream(fis)){
                      ensino = (SetorEnsino)ois.readObject();
                      return ensino;
                          } catch (ClassNotFoundException ex){
                              System.err.println("Erro ao ler o objeto de "+arquivo);
                          }
              }
          } catch (IOException e){
              System.out.println("Erro: Arquivo não encontrado!");
          }
        return null;
    }
      public static boolean gravaArq (SetorEnsino ensino, String arquivo) throws IOException{    
          try{
                  File file = new File(arquivo);
                  if(! file.exists()){
                      file.createNewFile();
                  }
              try (FileOutputStream fos = new FileOutputStream(file);
                      ObjectOutputStream oos = new ObjectOutputStream(fos)){
                  oos.writeObject(ensino);
              } catch (Exception e) {
              }
                  return true;
              } catch (IOException e){
                  System.out.println(e.getMessage());
                  return false;
              }  
      }
    /* salvar em txt
      public static String lerArq (String arquivo){
          String conteudo = "";
          try {
              FileReader arq = new FileReader(arquivo);
              BufferedReader lerArq = new BufferedReader(arq);
              String linha = "";
              try{
                  linha = lerArq.readLine();
                  while(linha!=null){
                      conteudo += linha;
                      linha = lerArq.readLine();
                  }
                  arq.close();
              } catch (IOException ex) {
                  conteudo = "Erro: Não foi possível ler o arquivo!";
                }
          } catch (FileNotFoundException ex){
              conteudo = "Erro: Arquivo não encontrado!";
            }
          if (conteudo.contains("Erro"))
              return "erro";
          else{
              return conteudo;
          }
      }
      
      public static boolean gravaArq (String texto, String arquivo) throws IOException{    
          try{
                  File file = new File(arquivo);
                  if(! file.exists()){
                      file.createNewFile();
                  }
                  FileWriter arq = new FileWriter(file, true);
                  BufferedWriter bw = new BufferedWriter(arq);
                  PrintWriter gravarArq = new PrintWriter(bw);
                  gravarArq.println(texto);
                  gravarArq.close();
                  return true;
              } catch (IOException e){
                  System.out.println(e.getMessage());
                  return false;
              }  
      }*/
      
      public static void main(String[] args) throws IOException {
          String texto = "texto teste8 salvo";
          String arquivo = "teste.txt"; 
          gravaArq(texto, arquivo);
          lerArq(arquivo);
    }
}   
    
    

