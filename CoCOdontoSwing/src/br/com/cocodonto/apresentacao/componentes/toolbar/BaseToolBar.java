/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cocodonto.apresentacao.componentes.toolbar;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

/**
 *
 * @author Bisso
 */
public class BaseToolBar extends JToolBar {

    private Map<String, JButton> buttons;
    private ActionListener listener;
    
    public BaseToolBar() {
        super();
        buttons = new HashMap<String, JButton>();
    }

    public BaseToolBar(ActionListener listener) {
        this();
        this.listener = listener;
        loadDefaultButtons();
    }

    public Map<String, JButton> getButtons() {
        return buttons;
    }
    
    public BaseToolBar addButton (String text, String iconPath) {
    
        JButton button = buildButton(text, iconPath);
        
        buttons.put(text.toLowerCase() , button);
        
        add(button);
        
        return this;
    }
    
    
    protected void loadDefaultButtons() {
        this.addButton("Incluir", "/br/com/cocodonto/apresentacao/images/add1-24.png")
            .addButton("Alterar",  "/br/com/cocodonto/apresentacao/images/edit24.png")                
            .addButton("Excluir",  "/br/com/cocodonto/apresentacao/images/delete24.png")
            .addButton("Salvar",  "/br/com/cocodonto/apresentacao/images/success24.png")
            .addButton("Cancelar",  "/br/com/cocodonto/apresentacao/images/close24.png");
    } 
    
    protected JButton buildButton(String text, String iconPath){
        JButton button = new JButton();
        button.setActionCommand(text);
        button.setIcon( new ImageIcon( getClass().getResource(iconPath)  ) );
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.setVerticalTextPosition(SwingConstants.BOTTOM);
        button.addActionListener(listener);
        return button;
    }
    
}
