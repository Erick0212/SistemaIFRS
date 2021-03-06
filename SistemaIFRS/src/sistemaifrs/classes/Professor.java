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
public class Professor implements Serializable{
    
    private String nome;
    private ArrayList<String> areas;
    private long siape;

    void alterarNome(String newNome){
        this.nome = newNome;
    }
    
    boolean novaArea(String newArea){
        for (int i = 0; i < areas.size(); i++) {
            if (areas.get(i) == null){
                areas.set(i, newArea);
                return true;
            }
        }
        return false;
    }
    
    boolean removeArea(String area){
        for (int i = 0; i < areas.size(); i++) {
            if(areas.get(i).equalsIgnoreCase(area)){
                areas.set(i, null);
                return true;
            }
            
        }
        return false;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<String> getAreas() {
        return areas;
    }

    public void setAreas(ArrayList<String> areas) {
        this.areas = areas;
    }

    public long getSiape() {
        return siape;
    }

    public void setSiape(long siape) {
        this.siape = siape;
    }

    public Professor(String nome,long siape, ArrayList<String> areas) {
        this.nome = nome;
        this.areas = areas;
        this.siape = siape;
    }

    public Professor(String nome, long siape) {
        this.nome = nome;
        this.siape = siape;
    }
    
    // toString

    @Override
    public String toString() {
        return "Professor{" + "nome=" + nome + ", areas=" + areas + ", siape=" + siape + '}';
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
        final Professor other = (Professor) obj;
        if (this.siape != other.siape) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.areas, other.areas)) {
            return false;
        }
        return true;
    }

    
    
    
    
    
}
