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
public abstract class ChildTableAttr extends ParentTableAttr {
    public String 
            PARAM_LIST,
            TYPE_EXP,
            ACCESS_MODIFIER;

    public ChildTableAttr(String NAME, String TYPE, String TYPE_MODIFIER, 
            String DIMENSION, String PARAM_LIST, 
            String TYPE_EXP, String ACCESS_MODIFIER) 
    {
        super(NAME, TYPE, TYPE_MODIFIER, DIMENSION);
        this.PARAM_LIST = PARAM_LIST;
        this.TYPE_EXP = TYPE_EXP;
        this.ACCESS_MODIFIER = ACCESS_MODIFIER;
    }

    @Override
    public ArrayList<String> tablevalues() {
        ArrayList<String> header = super.tablevalues();
        header.add(PARAM_LIST);
        header.add(TYPE_EXP);
        header.add(ACCESS_MODIFIER);
        return header;
    }

    @Override
    public String keyGenerate() {
        return super.keyGenerate() + "," + PARAM_LIST;
    }

}