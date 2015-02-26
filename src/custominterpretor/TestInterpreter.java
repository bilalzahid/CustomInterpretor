/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package custominterpretor;

import java.io.IOException;

/**
 *
 * @author bilal
 */
public class TestInterpreter {
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        CustomInterpreter testInterpretor = new CustomInterpreter();
        
        
        System.out.println("Correctly testing interpretor");
        testInterpretor.Interpretor("correct.txt");
        
        System.out.println("\n\nNow checking for syntax errors");
        testInterpretor.Interpretor("SyntaxError.txt");
        
        
        
    }
}
