/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SemanticAnalyzer.TableStructure;

import java.util.ArrayList;

/**
 *
 * @author omera
 */

public class ClassTableRow extends ChildTableAttr {
    public String
            STATIC;

    public ClassTableRow(String NAME, String TYPE, String TYPE_MODIFIER, 
            String PARAM_LIST,
            String ACCESS_MODIFIER, String STATIC) 
    {
        super(NAME, TYPE, TYPE_MODIFIER, PARAM_LIST, 
                ACCESS_MODIFIER);
        if (this.ACCESS_MODIFIER.isEmpty() ) {
            this.ACCESS_MODIFIER = "public"; //empty Am means public
        }
        this.STATIC = STATIC;
    }
    
    public boolean isFunction() {
        return !(NAME.isEmpty() || PARAM_LIST.isEmpty());
    }

    @Override
    public ArrayList<String> tablevalues() {
        ArrayList<String> record = super.tablevalues();
        record.add(record.get(4));
        record.set(4,STATIC);
        return record;
    }
    
    @Override
    public ArrayList<String> tableheading() {
        
        ArrayList<String> header = super.tableheading();
        header.add(header.get(4));
        header.set(4,"STC");
    
        return header;
    }

}

