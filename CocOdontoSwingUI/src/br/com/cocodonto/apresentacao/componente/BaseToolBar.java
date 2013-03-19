/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cocodonto.apresentacao.componente;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JToolBar;

/**
 *
 * @author Bisso
 */
public class BaseToolBar extends JToolBar {

    private Map<String,JButton> buttons;
    private JButton btnAlterar;
    private JButton btnCancelar;
    private JButton btnCriar;
    private JButton btnSalvar;
    
    
    public BaseToolBar(String name, int orientation) {
        super(name, orientation);
        initilize();
    }

    public BaseToolBar(String name) {
        super(name);
        initilize();
    }

    public BaseToolBar(int orientation) {
        super(orientation);
        initilize();
    }

    public BaseToolBar() {
        super();
        initilize();
    }
    
    
    private void initilize() {
        
        buttons = new HashMap<String, JButton>();
        
        btnCriar = new JButton();
        btnAlterar = new JButton();
        btnCancelar = new JButton();
        btnSalvar = new JButton();
        
        registerButtons(btnCriar, btnCancelar, btnCriar, btnSalvar);
        
        setFloatable(false);

        btnCriar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cocodonto/apresentacao/images/add1-24.png"))); // NOI18N
        btnCriar.setToolTipText("inserir");
        btnCriar.setActionCommand("inserir");
        btnCriar.setFocusable(false);
        btnCriar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCriar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        
        add(btnCriar);
    
        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cocodonto/apresentacao/images/edit24.png"))); // NOI18N
        btnAlterar.setToolTipText("alterar");
        btnAlterar.setActionCommand("alterar");
        btnAlterar.setFocusable(false);
        btnAlterar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAlterar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        
        add(btnAlterar);

        JSeparator separator = new Separator();
        separator.setMaximumSize(new java.awt.Dimension(36, 32767));
        separator.setRequestFocusEnabled(false);
        add(separator);        
        
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cocodonto/apresentacao/images/success24.png"))); // NOI18N
        btnSalvar.setToolTipText("salvar");
        btnSalvar.setActionCommand("salvar");
        btnSalvar.setEnabled(false);
        btnSalvar.setFocusable(false);
        btnSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalvar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        add(btnSalvar);

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cocodonto/apresentacao/images/close24.png"))); // NOI18N
        btnCancelar.setToolTipText("cancelar");
        btnCancelar.setActionCommand("cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.setFocusable(false);
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        add(btnCancelar);
        
        
    }
    
    private void registerButtons (JButton... buttons) {
        
        for (JButton button : buttons) {
            this.buttons.put(button.getActionCommand(), button);
        }
    }

    private void registerActionListener(ActionListener listener) {
        for (JButton button : buttons.values()) {
            button.addActionListener(listener);
        }
    }

    public JButton getBtnAlterar() {
        return btnAlterar;
    }

    public void setBtnAlterar(JButton btnAlterar) {
        this.btnAlterar = btnAlterar;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(JButton btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

    public JButton getBtnCriar() {
        return btnCriar;
    }

    public void setBtnCriar(JButton btnCriar) {
        this.btnCriar = btnCriar;
    }

    public JButton getBtnSalvar() {
        return btnSalvar;
    }

    public void setBtnSalvar(JButton btnSalvar) {
        this.btnSalvar = btnSalvar;
    }

    public Map<String, JButton> getButtons() {
        return buttons;
    }

    public void setButtons(Map<String, JButton> buttons) {
        this.buttons = buttons;
    }
    
    public void saveAndCancelEnabled(boolean enabled) {
        btnSalvar.setEnabled(enabled);
        btnCancelar.setEnabled(enabled);
    }

    
    

    
}
