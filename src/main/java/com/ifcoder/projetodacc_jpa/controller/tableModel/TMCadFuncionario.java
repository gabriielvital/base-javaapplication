package com.ifcoder.projetodacc_jpa.controller.tableModel;

import com.ifcoder.projetodacc_jpa.model.entities.Funcionario;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jose
 */
public class TMCadFuncionario extends AbstractTableModel {

    private List lista;
    
    private final int COL_NOME = 0;   
    private final int COL_EMAIL = 1;    

    public TMCadFuncionario(List lstFuncionario) {        
        lista = lstFuncionario;        
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {               
        Funcionario aux = new Funcionario();
        if (lista.isEmpty()) {
            return aux;
        } else {
            aux = (Funcionario) lista.get(rowIndex);

            //verifica qual valor deve ser retornado
            switch (columnIndex) {
                case -1:
                    return aux;
                case COL_NOME:
                    return aux.getNome();
                case COL_EMAIL:
                    return aux.getEmail();
                 
               
                default: 
                    break;
            }
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
                return "Name";
            case COL_EMAIL:
                return "E-mail";
                        
            default:
                break;
        }

        return "";
    }

    @Override
    public Class getColumnClass(int columnIndex) {
//        if(columnIndex == COL_MATRICULA)
//            return Boolean.class;
        
        return String.class;
    }

}
