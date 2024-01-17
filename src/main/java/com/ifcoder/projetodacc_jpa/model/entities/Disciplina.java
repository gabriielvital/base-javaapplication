
package com.ifcoder.projetodacc_jpa.model.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    private String curso;
    private String semestre;
    
    @OneToMany(mappedBy = "disciplina")
    private List<Turma> lstTurmas;
    
    
    
    public String toString() {
        String txt
                = "---------- Disciplina -----------\n";
        txt += "Nome: " + this.nome + "\n";
        txt += "Curso: " + this.curso + "\n";
        txt += "Semestre: " + this.semestre + "\n"
                + "-------------------------------------\n";
        return txt;
    }
}
