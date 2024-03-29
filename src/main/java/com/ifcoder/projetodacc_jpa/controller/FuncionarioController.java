/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifcoder.projetodacc_jpa.controller;

import com.ifcoder.projetodacc_jpa.controller.tableModel.TMCadFuncionario;
import com.ifcoder.projetodacc_jpa.model.dao.FuncionarioDAO;
import com.ifcoder.projetodacc_jpa.model.entities.Funcionario;
import com.ifcoder.projetodacc_jpa.model.valid.ValidateFuncionario;
import javax.swing.JTable;
import com.ifcoder.projetodacc_jpa.model.exceptions.ProfessorException;

/**
 *
 * @author jose
 */
public class FuncionarioController {

    private FuncionarioDAO repositorio;

    public FuncionarioController() {
        repositorio = new FuncionarioDAO();        
    }

    public void cadastrarFuncionario(String nome, String email, String idade, String sexo) {
        ValidateFuncionario valid = new ValidateFuncionario();
        Funcionario novoFuncionario = valid.validaCamposEntrada(nome, email, idade, sexo);
                
        if (repositorio.findByEmail(novoFuncionario.getEmail()) != null) {
            throw new ProfessorException("Error - Já existe um funcionario com este 'email'.");
        } else {
            repositorio.save(novoFuncionario);
        }
    }    
    
    public void atualizarFuncionario(Long idFuncionario, String nome, String email, String idade, String sexo) {
        ValidateFuncionario valid = new ValidateFuncionario();
        Funcionario novoFuncionario = valid.validaCamposEntrada(nome, email, idade, sexo);
        novoFuncionario.setId(idFuncionario);
        repositorio.update(novoFuncionario);
    }    

    public void atualizarTabela(JTable grd) {
        Util.jTableShow(grd, new TMCadFuncionario(repositorio.findAll()), null);
    }

    public void excluirFuncionario(Long id) {
        //Encontrar professor e exlcui                   
        
        if (id != null) {
            repositorio.delete(id);
        } else {
            throw new ProfessorException("Error - Aluno inexistente.");
        }
    }    

}
