/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cocodonto.apresentacao.paciente;

import br.com.cocodonto.modelo.entidade.Contato;
import br.com.cocodonto.modelo.entidade.Endereco;
import br.com.cocodonto.modelo.entidade.Paciente;
import br.com.cocodonto.modelo.service.PacienteService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Bisso
 */
public class PacienteActionListener implements ActionListener 
                                    , ListSelectionListener {

    private PacienteFrm frm;
    private PacienteService service;
    private PacienteTableModel tableModel;
    public PacienteActionListener(PacienteFrm frm) {
        this.frm = frm;
        service = new PacienteService();
        adicionaListener();
        inicializaTableModel();
    }
    
    public void inicializaTableModel() {
        List<Paciente> pacientes = service.getPacientes();
        tableModel = new PacienteTableModel(pacientes);
        frm.getTbPacientes().setModel(tableModel);
        frm.getTbPacientes()
                .getSelectionModel()
                .addListSelectionListener( this );
    }
    
    public void adicionaListener() {
        frm.getBtAlterar().addActionListener(this);
        frm.getBtIncluir().addActionListener(this);
        frm.getBtSalvar().addActionListener(this);
        frm.getBtCancelar().addActionListener(this);
        frm.getBtExcluir().addActionListener(this);
    }

    private void enableButtonsToSaveAction() {
        enableOrDisableButtonsToEdit(true);
    }

    private void disablableButtonsToSaveAction() {
        enableOrDisableButtonsToEdit(false);
    }
    
    private void enableOrDisableButtonsToEdit ( boolean enabled ) {
        frm.getBtIncluir().setEnabled(!enabled);
        frm.getBtAlterar().setEnabled(!enabled);
        frm.getBtExcluir().setEnabled(!enabled);
        frm.getBtSalvar().setEnabled(enabled);
        frm.getBtCancelar().setEnabled(enabled);

    } 
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent event) {
        
        if (event.getActionCommand().equals("Incluir")  ) {
            incluir();
        } else if ( event.getActionCommand().equals("Alterar")  ) {
        } else if ( event.getActionCommand().equals("Excluir")  ) {
        } else if ( event.getActionCommand().equals("Salvar")  ) {
            salvar();
        } else if ( event.getActionCommand().equals("Cancelar")  ) {
            
        }
        
    }

    private void incluir() {
        enableButtonsToSaveAction();
    }
    
    private void salvar () {
        
        service.salvar(formToPaciente());
        JOptionPane.showMessageDialog(frm, "Paciente Salvo" , "Salvar" , JOptionPane.INFORMATION_MESSAGE);
        disablableButtonsToSaveAction();
    }
    
    private Paciente formToPaciente() {
        
        Paciente paciente = new Paciente();
        if ( !"".equals( frm.getLblIdPaciente().getText()) ) {
            paciente.setId( Long.parseLong( frm.getLblIdPaciente().getText() )  );
        }
        
        paciente.setNome( frm.getTxtNome().getText() );
        paciente.setCpf( frm.getTxtCpf().getText() );
        paciente.setRg( frm.getTxtRg().getText() );
        
        paciente.setContato( formToContato() );
        paciente.setEndereco( formToEndereco() );
        
        return paciente;
    }
    
    private void pacienteToForm(Paciente paciente) {
        
        frm.getLblIdPaciente().setText( Long.toString ( paciente.getId() ) );
        frm.getTxtNome().setText( paciente.getNome());
        frm.getTxtRg().setText( paciente.getRg() );
        frm.getTxtCpf().setText( paciente.getCpf() );
    
    }
    
    private Contato formToContato () {
        
        Contato contato = new Contato();

        if ( !"".equals( frm.getLblIdContato().getText()) ) {
            contato.setId( Long.parseLong( frm.getLblIdContato().getText() )  );
        }

        contato.setEmail(frm.getTxtEmail().getText());
        contato.setTelefone(frm.getTxtTelefone().getText());
        contato.setCelular(frm.getTxtTelefone().getText());
        return contato;
    }
    
    private Endereco formToEndereco() {
        Endereco endereco = new Endereco();
        
        if ( !"".equals( frm.getLblidEndereco().getText()) ) {
            endereco.setId( Long.parseLong( frm.getLblidEndereco().getText() )  );
        }
        
        endereco.setEndereco( frm.getTxtEndereco().getText()  );
        endereco.setCidade( frm.getTxtCidade().getText()  );
        endereco.setCep( frm.getTxtCep().getText()  );
        endereco.setBairro( frm.getTxtBairro().getText()  );
        
        return endereco;
    }

    @Override
    public void valueChanged(ListSelectionEvent event) {
        
        Paciente paciente = tableModel.getPacientes().get(frm.getTbPacientes().getSelectedRow());
        System.out.println(paciente);
        pacienteToForm(paciente);
    }

}
