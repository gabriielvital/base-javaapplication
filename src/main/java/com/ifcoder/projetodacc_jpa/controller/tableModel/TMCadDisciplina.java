package com.ifcoder.projetodacc_jpa.controller.tableModel;

import com.ifcoder.projetodacc_jpa.model.entities.Disciplina;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jose
 */
public class TMCadDisciplina extends AbstractTableModel {

    private List<Disciplina> lista;

    private final int COL_NOME = 0;   
    private final int COL_CURSO = 1;
    private final int COL_SEMESTRE = 2;

    public TMCadDisciplina(List<Disciplina> lstDisciplina) {        
        lista = lstDisciplina;        
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 3; // Três colunas: nome, curso e semestre.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {               
        Disciplina aux = (lista.isEmpty()) ? new Disciplina() : lista.get(rowIndex);

        // verifica qual valor deve ser retornado
        switch (columnIndex) {
            case -1:
                return aux;
            case COL_NOME:
                return aux.getNome();
            case COL_CURSO:
                return aux.getCurso();
            case COL_SEMESTRE:
                return aux.getSemestre();
            default: 
                break;
        }

        return aux;
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
            case COL_CURSO:
                return "Curso";
            case COL_SEMESTRE:
                return "Semestre";
            default:
                break;
        }

        return "";
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        return String.class;
    }
}

