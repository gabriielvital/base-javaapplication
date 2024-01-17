package com.ifcoder.projetodacc_jpa.model.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import lombok.Data;

/**
 *
 * @author jose
 */
@Data
@Entity
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome = "T1";//por padrão uma turma
    private int ano;
    private String horario;

    @ManyToOne
    private Disciplina disciplina;

    @ManyToOne
    private Professor professor;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "turma_aluno",
        joinColumns = @JoinColumn(name = "turma_id"),
        inverseJoinColumns = @JoinColumn(name = "aluno_id")
    )
    private List<Aluno> lstAlunos;

    public Turma() {
        this.professor = new Professor();
        this.lstAlunos = new ArrayList<>();
    }
    
    

}
