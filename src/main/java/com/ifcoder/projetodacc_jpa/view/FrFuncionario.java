/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifcoder.projetodacc_jpa.view;


import com.ifcoder.projetodacc_jpa.controller.FuncionarioController;
import com.ifcoder.projetodacc_jpa.model.entities.Funcionario;
import com.ifcoder.projetodacc_jpa.model.entities.Professor;
import java.util.List;
import javax.swing.JOptionPane;
import com.ifcoder.projetodacc_jpa.model.exceptions.ProfessorException;
import kong.unirest.*;

/**
 *
 * @author joserui
 */
public class FrFuncionario extends javax.swing.JDialog {

    FuncionarioController funcionarioController;
    Long idFuncionarioEditando;

    public FrFuncionario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        funcionarioController = new FuncionarioController();
        idFuncionarioEditando = -1L;

        initComponents();
        // this.addMaskOnFields();

        this.habilitarCampos(false);
        this.limparCampos();

        //edtListagem.setText(profController.imprimirListaProfessores());
        funcionarioController.atualizarTabela(grdAlunos);
    }

    public void habilitarCampos(boolean flag) {
        for (int i = 0; i < panFormulario.getComponents().length; i++) {
            panFormulario.getComponent(i).setEnabled(flag);
        }
    }

    public void limparCampos() {
        edtNome.setText("");
        edtIdade.setText("");
        edtSexo.setText("");
        edtEmail.setText("");
    }

    /**
     * O ideal seria entregar essa responsabiliadde para o controller para isso
     * deveriamos passar os componentes edt s
     *
     * OU senao criar um novo tipo representationModel, que será a representacao
     * do modelo na camada VIEW. Com isso criamos uma independencia da camada
     * MODEL.
     *
     * @param a
     */
    public void preencherFormulario(Funcionario a) {
        edtNome.setText(a.getNome());
        edtSexo.setText(a.getSexo()+"");
        edtIdade.setText(a.getIdade()+"");
        edtEmail.setText(a.getEmail());
        
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
        panFormulario = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        edtNome = new javax.swing.JTextField();
        lblSexo = new javax.swing.JLabel();
        edtEmail = new javax.swing.JTextField();
        lblSexo1 = new javax.swing.JLabel();
        edtSexo = new javax.swing.JTextField();
        lblNome1 = new javax.swing.JLabel();
        edtIdade = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        grdAlunos = new javax.swing.JTable();
        panButtons = new javax.swing.JPanel();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Funcionários");

        lblTitle.setFont(new java.awt.Font("Fira Sans", 1, 36)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Cadastro de Funcionário");

        lblNome.setText("Nome:");

        lblSexo.setText("E-mail:");

        lblSexo1.setText("Sexo:");

        lblNome1.setText("Idade:");

        javax.swing.GroupLayout panFormularioLayout = new javax.swing.GroupLayout(panFormulario);
        panFormulario.setLayout(panFormularioLayout);
        panFormularioLayout.setHorizontalGroup(
            panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFormularioLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panFormularioLayout.createSequentialGroup()
                        .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panFormularioLayout.createSequentialGroup()
                        .addComponent(lblSexo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNome1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSexo1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(edtSexo)
                    .addComponent(edtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        panFormularioLayout.setVerticalGroup(
            panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFormularioLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panFormularioLayout.createSequentialGroup()
                        .addGroup(panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(edtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSexo1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panFormularioLayout.createSequentialGroup()
                        .addGroup(panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNome)
                            .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNome1)
                            .addComponent(lblSexo)
                            .addComponent(edtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        grdAlunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        grdAlunos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grdAlunosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(grdAlunos);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(panFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                .addContainerGap())
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
            if (idFuncionarioEditando > 0) {
                funcionarioController.atualizarFuncionario(idFuncionarioEditando, edtNome.getText(), edtEmail.getText(), edtIdade.getText(), edtSexo.getText());
            } else {
                funcionarioController.cadastrarFuncionario(edtNome.getText(), edtEmail.getText(), edtIdade.getText(), edtSexo.getText());
            }

            //Comando bastante importante
            this.idFuncionarioEditando = -1L;
            funcionarioController.atualizarTabela(grdAlunos);
            this.habilitarCampos(false);
            this.limparCampos();
        } catch (ProfessorException e) {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.limparCampos();
        this.habilitarCampos(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        Funcionario funcionarioEditando = (Funcionario) this.getObjectSelectOnGrid();

        if (funcionarioEditando == null)
            JOptionPane.showMessageDialog(this, "Primeiro selecione um registro na tabela.");
        else {
            try {
                idFuncionarioEditando = funcionarioEditando.getId();
                funcionarioController.excluirFuncionario(idFuncionarioEditando);

                funcionarioController.atualizarTabela(grdAlunos);
                JOptionPane.showMessageDialog(this, "Exclusão feita com sucesso!");
            } catch (ProfessorException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        Funcionario funcionarioEditando = (Funcionario) this.getObjectSelectOnGrid();

        if (funcionarioEditando == null)
            JOptionPane.showMessageDialog(this, "Primeiro selecione um registro na tabela.");
        else {
            this.limparCampos();
            this.habilitarCampos(true);
            this.preencherFormulario(funcionarioEditando);
            this.idFuncionarioEditando = funcionarioEditando.getId();
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    /**
     * Retorna o objeto (classe) da linha selecionada na grid.
     *
     * Uso a estratégia do metodo getValueAt() la na TableModel, receber coluna
     * -1 e retornar o objeto ao inves de uma célula.
     *
     * @return
     */
    private Object getObjectSelectOnGrid() {
        int rowCliked = grdAlunos.getSelectedRow();
        Object obj = null;
        if (rowCliked >= 0) {
            obj = grdAlunos.getModel().getValueAt(rowCliked, -1);
        }
        return obj;
    }

    private void grdAlunosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grdAlunosMouseClicked
        if (evt.getClickCount() == 2) {
            btnEditarActionPerformed(null);
        }
    }//GEN-LAST:event_grdAlunosMouseClicked

    public void conectarAPIOnline(){
        try {
            String token = "your_auth_token";  // Substitua pelo seu token de autenticação.
            String apiUrl = "http://localhost:8080/professores/";  // Substitua pela URL da sua API.

            HttpResponse<List<Professor>> response;                   
            response = Unirest.get(apiUrl)                   
                    .header("Content-Type", "application/json")
                    .asObject(new kong.unirest.GenericType<List<Professor>>() {
                    });

            String texto = "";
            if (response.getStatus() == 200) {
                List<Professor> students = response.getBody();
                texto = "Retrieved " + students.size() + " professores.\n";
                for (Professor student : students) {
                    texto += "Name: " + student.getNome() + ", Cpf: " + student.getCpf()+ "\n";
                }
            } else {
                texto += "Error retrieving students. Status: " + response.getStatus()+ "\n";
            }
            //jTextArea1.setText(texto);
        } catch (RuntimeException e) {
            System.out.println("Error making API call.");
            e.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField edtEmail;
    private javax.swing.JTextField edtIdade;
    private javax.swing.JTextField edtNome;
    private javax.swing.JTextField edtSexo;
    private javax.swing.JTable grdAlunos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNome1;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblSexo1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel panButtons;
    private javax.swing.JPanel panFormulario;
    // End of variables declaration//GEN-END:variables
}