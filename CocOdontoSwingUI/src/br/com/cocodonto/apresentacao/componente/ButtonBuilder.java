/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cocodonto.apresentacao.componente;

import javax.swing.JButton;

/**
 *
 * @author Bisso
 */
public class ButtonBuilder {
     
    private JButton button;

    public ButtonBuilder() {
       prototype();  
    }
    
    
    
    public ButtonBuilder prototype() {
        button = new JButton();
        button.setFocusable(false);
        button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        button.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        return this;
    }
    
    public ButtonBuilder withIcon( String uri ) {
        button.setIcon(new javax.swing.ImageIcon(getClass().getResource(uri))); // NOI18N
        return this;
    }
    
    public ButtonBuilder withCommandName( String commandName ) {
        button.setActionCommand(commandName);
        return this;
    }

    public ButtonBuilder withToolTip( String toolTip ) {
        button.setToolTipText(toolTip);
        return this;
    }
        
    public JButton build() {
        return button;
    }
    
}
