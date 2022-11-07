/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SemanticAnalyzer.TableStructure;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 *
 * @author omera
 */
public abstract class ParentTableAttr {
    
    public String 
            NAME,
            TYPE,
            SIZE,
            TYPE_MODIFIER,
            DIMENSION;
    
    public ParentTableAttr(String NAME, String TYPE, String TYPE_MODIFIER, String DIMENSION) {
        this.NAME = NAME;
        this.TYPE = TYPE;
        if (this.TYPE.isEmpty()) {
            this.TYPE = "void"; //empty type means its a function with void return type
        }
        this.TYPE_MODIFIER = TYPE_MODIFIER;
        this.DIMENSION = DIMENSION;
    }
    
    public boolean isAbstract() {
        return "Abstract".equals(TYPE_MODIFIER);
    }
    
    public ArrayList<String> tablevalues() {
        ArrayList<String> header = new ArrayList<>();
        header.add(NAME);
        header.add(TYPE);
        header.add(SIZE);
        header.add(TYPE_MODIFIER);
        header.add(DIMENSION);
        
        return header;
    }
    
    public Field[] tableheading() {
        for (Field field : this.getClass().getFields()) {
            System.out.println(field);
        }
        return null;
    }
          
    /**
     * 
     * @return Generate Key for HashMap
     */
    public String keyGenerate() {
        return NAME;
    }
}


