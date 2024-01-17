package com.ifcoder.projetodacc_jpa.controller.tableModel;

import com.ifcoder.projetodacc_jpa.model.entities.Turma;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jose
 */
public class TMTurma extends AbstractTableModel {

    private List<Turma> lista;

    private final int COL_NOME = 0;   
    private final int COL_NOMEDISCIPLINA = 1;
    private final int COL_NOMEPROFESSOR = 2;
    private final int COL_TOTALALUNOS = 3;

    public TMTurma(List<Turma> lstTurma) {        
        lista = lstTurma;        
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 4; // Quatro colunas: nome da turma, nome da disciplina, nome do professor, total de alunos.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {               
        Turma aux = (lista.isEmpty()) ? new Turma() : lista.get(rowIndex);

        // verifica qual valor deve ser retornado
        switch (columnIndex) {
            case -1:
                return aux;
            case COL_NOME:
                return aux.getNome();
            case COL_NOMEDISCIPLINA:
                return aux.getDisciplina().getNome();
            case COL_NOMEPROFESSOR:
                return aux.getProfessor().getNome();
            case COL_TOTALALUNOS:
                return aux.getLstAlunos().size();
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
                return "Nome da Turma";
            case COL_NOMEDISCIPLINA:
                return "Disciplina";
            case COL_NOMEPROFESSOR:
                return "Professor";
            case COL_TOTALALUNOS:
                return "Total de Alunos";
            default:
                break;
        }

        return "";
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case COL_TOTALALUNOS:
                return Integer.class;
            default:
                return String.class;
        }
    }
}

