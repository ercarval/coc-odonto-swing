package br.com.cocodonto.apresentacao.paciente;

import br.com.cocodonto.modelo.entidade.Contato;
import br.com.cocodonto.modelo.entidade.Endereco;
import br.com.cocodonto.modelo.entidade.Paciente;
import br.com.cocodonto.modelo.service.PacienteService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Bisso
 */
public class PacienteActionListener implements ActionListener {
    
    private PacienteFrm frm;
    private PacienteService service;

    public PacienteActionListener(PacienteFrm frm) {
    
        this.frm = frm;
        service = new PacienteService();

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
    public void inserir () {
        
        service.salvar( mappingFormToPaciente() );
        
    }
    
    public void enableFormToEdit() {
        enableOrDisableToEdit(true);
    }

    public void disableFormToEdit(){
        enableOrDisableToEdit(false);
    }
    
    public void enableOrDisableToEdit ( boolean enabled ) {
    
        frm.getTxtEmail().setEnabled( enabled ) ;
        frm.getTxtTelefone().setEnabled( enabled ) ;
        frm.getTxtCelular().setEnabled( enabled ) ;          

        frm.getTxtNome().setEnabled( enabled ) ;
        frm.getTxtCpf().setEnabled( enabled ) ;
        frm.getTxtRg().setEnabled( enabled ) ;

        frm.getTxtEndereco().setEnabled( enabled ) ;
        frm.getTxtBairro().setEnabled( enabled ) ;
        frm.getTxtCidade().setEnabled( enabled ) ;
        frm.getTxtCep().setEnabled( enabled ) ;
    
    }
    
    public void enableSaveActionButtons() {
        enableOrDisableButtons(false);
    }

    public void disableSaveActionButtons() {
        enableOrDisableButtons(true);
    }
    
    public void enableOrDisableButtons( boolean enabled ) {
        frm.getBtnAlterar().setEnabled(enabled);
        frm.getBtnCriar().setEnabled(enabled);
        frm.getBtnSalvar().setEnabled(!enabled);
        frm.getBtnCancelar().setEnabled(!enabled);
    }
    
    public Paciente mappingFormToPaciente () {
        
        Paciente paciente = new Paciente();
        
        if ( "" != frm.getLblId().getText()  ) 
            paciente.setId( Integer.parseInt( frm.getLblId().getText() ) );
        
        paciente.setNome( frm.getTxtNome().getText().trim() );
        paciente.setCpf( frm.getTxtCpf().getText().trim() );
        paciente.setRg( frm.getTxtRg().getText().trim() );
        paciente.setContato(mappingFormToContato());
        paciente.setEndereco(mappingFormToEndereco());
        return paciente;
        
    }

    private Endereco mappingFormToEndereco() {
        Endereco endereco = new Endereco();
        endereco.setEndereco( frm.getTxtEndereco().getText() );
        endereco.setBairro( frm.getTxtBairro().getText() );
        endereco.setCidade( frm.getTxtCidade().getText() );
        endereco.setCep( frm.getTxtCep().getText() );
        return endereco;
    }

    private Contato mappingFormToContato() {
        Contato contato = new Contato();
        if ( ! "".equals( frm.getLblContatoId().getText() ) ) {
            contato.setId(  Integer.parseInt( frm.getLblContatoId().getText() )  );
        }
        contato.setEmail( frm.getTxtEmail().getText() );
        contato.setTelefone( frm.getTxtTelefone().getText() );
        contato.setCelular( frm.getTxtCelular().getText() );
        return contato;
    }
    
    private void mappingContatoToForm(Contato contato) {
        frm.getLblContatoId().setText( "" + contato.getId() );
        frm.getTxtEmail().setText( contato.getEmail() ) ;
        frm.getTxtTelefone().setText( contato.getTelefone() );
        frm.getTxtCelular().setText( contato.getCelular() );        
    }
    
    private void mappingEnderecoToForm( Endereco endereco ) {
        frm.getLblEnderecoId().setText( "" + endereco.getId() );
        frm.getTxtEndereco().setText( endereco.getEndereco()  );
        frm.getTxtBairro().setText( endereco.getBairro() );
        frm.getTxtCidade().setText( endereco.getCidade() );
        frm.getTxtCep().setText( endereco.getCep() );
    }
    
    private void mappingPacienteToForm(Paciente paciente) {
        frm.getLblId().setText( "" + paciente.getId() );
        frm.getTxtNome().setText( paciente.getNome() );
        frm.getTxtCpf().setText( paciente.getCpf() );
        frm.getTxtRg().setText( paciente.getRg() );
    }
    
}
