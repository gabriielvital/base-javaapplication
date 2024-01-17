package com.ifcoder.projetodacc_jpa.controller.tableModel;

import com.ifcoder.projetodacc_jpa.model.entities.Professor;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jose
 */
public class TMCadProfessor extends AbstractTableModel {

    private List<Professor> lista;
    
    private final int COL_NOME = 0;
    private final int COL_SEXO = 1;
    private final int COL_IDADE = 2;
    private final int COL_CPF = 3;

    public TMCadProfessor(List<Professor> lstProfessor) {        
        this.lista = lstProfessor;        
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {               
        Professor aux = (lista.isEmpty()) ? new Professor() : lista.get(rowIndex);

        //verifica qual valor deve ser retornado
        switch (columnIndex) {
            case -1:
                    return aux;
            case COL_NOME:
                return aux.getNome();
            case COL_SEXO:
                return aux.getSexo();
            case COL_IDADE:
                return aux.getIdade();
            case COL_CPF:
                return aux.getCpf();
            default:
                return null;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case COL_NOME:
                return "Nome";
            case COL_SEXO:
                return "Sexo";
            case COL_IDADE:
                return "Idade";
            case COL_CPF:
                return "CPF";
            default:
                return "";
        }
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case COL_IDADE:
                return Integer.class;
            case COL_NOME:
            case COL_CPF:
                return String.class;
            case COL_SEXO:
                return Character.class;
            default:
                return String.class;
        }
    }
}
