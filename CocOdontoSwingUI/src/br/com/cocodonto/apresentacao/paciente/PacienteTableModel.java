/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cocodonto.apresentacao.paciente;

import br.com.cocodonto.modelo.entidade.Contato;
import br.com.cocodonto.modelo.entidade.Paciente;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Bisso
 */
public class PacienteTableModel extends AbstractTableModel {

    private List<Paciente> pacientes;
    private String[] colunas;
    
    public PacienteTableModel(List<Paciente> pacientes) {
        this.pacientes = pacientes;
        colunas = new String[] {"Nome" , "RG", "CPF", "Telefone"};
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
    
    @Override
    public int getRowCount() {
        return pacientes.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (pacientes.size() == 0 ) return "";
        
        Paciente paciente = getPaciente(rowIndex);
        
        Contato contato = ( paciente.getContato() != null ) ? paciente.getContato(): new Contato();
         
        switch (columnIndex) {
            case 0: return paciente.getNome();
            case 1: return paciente.getRg();
            case 2: return paciente.getCpf();
            case 3: return contato.getTelefone();
        }
        
        return null;
        
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }
    
    public Paciente getPaciente( int row ) {
        return pacientes.get(row);
    }

}
