package com.ifcoder.projetodacc_jpa.controller.tableModel;

import com.ifcoder.projetodacc_jpa.model.entities.Aluno;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jose
 */
public class TMAlunoTurma extends AbstractTableModel {

    private List lista;

    private final int COL_NOME = 0;
    private final int COL_MATRICULA = 1;
    private final int COL_EXCLUIR = 2;

    public TMAlunoTurma(List lstAlunos) {
        lista = lstAlunos;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Aluno aux = new Aluno();
        if (lista.isEmpty()) {
            return aux;
        } else {
            aux = (Aluno) lista.get(rowIndex);

            //verifica qual valor deve ser retornado
            switch (columnIndex) {
                case -1:
                    return aux;
                case COL_NOME:
                    return aux.getNome();
                case COL_MATRICULA:
                    return aux.getMatricula();

                case COL_EXCLUIR:
                    return new ImageIcon(getClass().getResource("/imagens/remove_16x16.png"));
                default:
                    break;
            }
        }
        return aux;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
       return columnIndex == COL_EXCLUIR;
    }

    @Override
    public String getColumnName(int column) {

        switch (column) {
            case COL_NOME:
                return "Nome";
            case COL_MATRICULA:
                return "Matricula";
            case COL_EXCLUIR:
                return "Excluir";

            default:
                break;
        }

        return "";
    }

    @Override
    public Class getColumnClass(int columnIndex) {
//        if(columnIndex == COL_MATRICULA)
//            return Boolean.class;
        if (columnIndex == COL_EXCLUIR) {
            return ImageIcon.class; // A classe da coluna "Excluir" é ImageIcon
        }
        return String.class;
    }
    
    public List getLista(){
        return this.lista;
    }

}
