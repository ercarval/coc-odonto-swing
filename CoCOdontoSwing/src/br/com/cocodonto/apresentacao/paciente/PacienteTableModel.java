/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cocodonto.apresentacao.paciente;

import br.com.cocodonto.modelo.entidade.Paciente;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Bisso
 */
public class PacienteTableModel extends AbstractTableModel {

    private List<Paciente> pacientes;
    private List<String> colunas;
    
    public PacienteTableModel (List<Paciente> pacientes) {
        this.pacientes = pacientes;
        colunas = Arrays.asList( "Id", "Nome","RG" , "CPF" );
    }

    @Override
    public String getColumnName(int column) {
        return colunas.get(column);
    }
    
    @Override
    public int getRowCount() {
        return pacientes.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        Paciente paciente = pacientes.get(rowIndex);
        switch(columnIndex) {
            case 0: return paciente.getId();
            case 1: return paciente.getNome();
            case 2: return paciente.getRg();
            case 3: return paciente.getCpf();
        }
        return null;
        
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }
    
    
    
}
