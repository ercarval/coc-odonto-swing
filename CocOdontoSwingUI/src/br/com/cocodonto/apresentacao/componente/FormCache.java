/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cocodonto.apresentacao.componente;

import java.awt.Window;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Bisso
 */
public class FormCache {

    private Map<String, Window> cache;
    private FormCache instance;
    
    private FormCache () {
        cache = new HashMap<String, Window>();
    }
            
    public synchronized FormCache getInstance() {
        if (instance == null)
            instance = new FormCache();        
        return instance;
    }
            
    public void showForm(String name) {
        if (!cache.containsKey(name)) return;    
        cache.get(name).setVisible(true); 
    }
    
    public void hideForm(String name) {
        if (!cache.containsKey(name)) return;    
        cache.get(name).setVisible(false); 
    }
       
    
    public FormCache addForm( String name ,  Window form  ) {
        cache.put(name, form);
        return this;
    }
    
    
}
