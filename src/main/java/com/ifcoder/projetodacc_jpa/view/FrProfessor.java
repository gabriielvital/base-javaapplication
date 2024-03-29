/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifcoder.projetodacc_jpa.view;

import com.ifcoder.projetodacc_jpa.controller.ProfessorController;
import com.ifcoder.projetodacc_jpa.model.entities.Professor;
import javax.swing.JOptionPane;
import com.ifcoder.projetodacc_jpa.model.exceptions.ProfessorException;

/**
 *
 * @author joserui
 */
public class FrProfessor extends javax.swing.JDialog {

    ProfessorController profController;
    Long idProfEditando;

    public FrProfessor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        profController = new ProfessorController();
        idProfEditando = -1L;

        initComponents();
        this.habilitarCampos(false);
        this.limparCampos();

        profController.atualizarTabela(grdProfessores);
    }

    public void habilitarCampos(boolean flag) {
        edtNome.setEnabled(flag);
        edtSexo.setEnabled(flag);
        edtIdade.setEnabled(flag);
        edtCPF.setEnabled(flag);
    }

    public void limparCampos() {
        edtNome.setText("");
        edtSexo.setText("");
        edtIdade.setText("");
        edtCPF.setText("");
    }

    public void preencherFormulario(Professor p) {
        edtNome.setText(p.getNome());
        edtSexo.setText(p.getSexo() + "");
        edtIdade.setText(p.getIdade() + "");
        edtCPF.setText(p.getCpf());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        grdProfessores = new javax.swing.JTable();
        panButtons = new javax.swing.JPanel();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        panFormulario = new javax.swing.JPanel();
        lblNome2 = new javax.swing.JLabel();
        edtCPF = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        edtNome = new javax.swing.JTextField();
        lblNome1 = new javax.swing.JLabel();
        edtIdade = new javax.swing.JTextField();
        lblSexo = new javax.swing.JLabel();
        edtSexo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de professores");

        lblTitle.setFont(new java.awt.Font("Fira Sans", 1, 36)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Cadastro de Professor");

        grdProfessores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        grdProfessores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grdProfessoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(grdProfessores);

        panButtons.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/novo.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });
        panButtons.add(btnNovo);

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/editar.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        panButtons.add(btnEditar);

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        panButtons.add(btnCancelar);

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/delete.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        panButtons.add(btnExcluir);

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        panButtons.add(btnSalvar);

        lblNome2.setText("CPF:");

        lblNome.setText("Nome:");

        lblNome1.setText("Idade:");

        lblSexo.setText("Sexo:");

        javax.swing.GroupLayout panFormularioLayout = new javax.swing.GroupLayout(panFormulario);
        panFormulario.setLayout(panFormularioLayout);
        panFormularioLayout.setHorizontalGroup(
            panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFormularioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panFormularioLayout.createSequentialGroup()
                        .addComponent(lblNome1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblSexo)
                        .addGap(18, 18, 18)
                        .addComponent(edtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblNome2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panFormularioLayout.createSequentialGroup()
                        .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtNome)))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        panFormularioLayout.setVerticalGroup(
            panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panFormularioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome1)
                    .addComponent(edtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSexo)
                    .addComponent(edtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNome2)
                    .addComponent(edtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panButtons, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(panFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        this.habilitarCampos(true);
        this.limparCampos();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {
            if (idProfEditando > 0) {
                profController.atualizarProfessor(idProfEditando, edtNome.getText(), edtSexo.getText(), edtIdade.getText(), edtCPF.getText());
            } else {
                profController.cadastrarProfessor(edtNome.getText(), edtSexo.getText(), edtIdade.getText(), edtCPF.getText());
            }

            idProfEditando = -1L;
            profController.atualizarTabela(grdProfessores);
            this.habilitarCampos(false);
            this.limparCampos();
        } catch (ProfessorException e) {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        idProfEditando = -1L;
        this.limparCampos();
        this.habilitarCampos(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        Professor professorExcluido = (Professor) this.getObjetoSelecionadoNaGrid();

        if (professorExcluido == null) {
            JOptionPane.showMessageDialog(this, "Primeiro selecione um registro na tabela.");
        } else {
            int response = JOptionPane.showConfirmDialog(null,
                    "Deseja excluir o Professor \n("
                    + professorExcluido.getNome() + ", "
                    + professorExcluido.getCpf() + ") ?",
                    "Confirmar exclusão",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.OK_OPTION) {
                try {
                    this.idProfEditando = professorExcluido.getId();
                    profController.excluirProfessor(idProfEditando);
                    profController.atualizarTabela(grdProfessores); // Altere o nome da grid conforme o nome da sua tabela de professores
                    JOptionPane.showMessageDialog(this, "Exclusão feita com sucesso!");
                } catch (ProfessorException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
            }
        }

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        Professor profEditando = (Professor) this.getObjetoSelecionadoNaGrid();

        if (profEditando == null) {
            JOptionPane.showMessageDialog(this, "Primeiro selecione um registro na tabela.");
        } else {
            this.limparCampos();
            this.habilitarCampos(true);
            this.preencherFormulario(profEditando);
            this.idProfEditando = profEditando.getId();
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void grdProfessoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grdProfessoresMouseClicked
        if (evt.getClickCount() == 2) {
            btnEditarActionPerformed(null);
        }
    }//GEN-LAST:event_grdProfessoresMouseClicked

    /**
     * Retorna o objeto (classe) da linha selecionada na grid.
     *
     * Uso a estratégia do metodo getValueAt() la na TableModel, receber coluna
     * -1 e retornar o objeto ao inves de uma célula.
     *
     * @return
     */
    private Object getObjetoSelecionadoNaGrid() {
        int rowCliked = grdProfessores.getSelectedRow();
        Object obj = null;
        if (rowCliked >= 0) {
            obj = grdProfessores.getModel().getValueAt(rowCliked, -1);
        }
        return obj;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField edtCPF;
    private javax.swing.JTextField edtIdade;
    private javax.swing.JTextField edtNome;
    private javax.swing.JTextField edtSexo;
    private javax.swing.JTable grdProfessores;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNome1;
    private javax.swing.JLabel lblNome2;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel panButtons;
    private javax.swing.JPanel panFormulario;
    // End of variables declaration//GEN-END:variables
}
