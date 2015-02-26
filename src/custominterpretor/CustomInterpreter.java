/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package custominterpretor;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author bilal
 */
public class CustomInterpreter {

    Map<String, Integer> variables;
    
    public CustomInterpreter(){
        variables = new HashMap<String, Integer>();
    }
    
    public void Interpretor(String file_name) {
    
    
    /**
     * @param args the command line arguments
     */
        try{
            ReadFile file = new ReadFile( file_name );
            String[] aryLines = file.OpenFile();
            int numOfLines = file.readLines();
            CustomInterpreter interpretor = new CustomInterpreter();
            for ( int i=0; i < numOfLines; i++ ) {
                
                System.out.println(aryLines[i]); 
                String[] chunksOfLine = new String[100];
                chunksOfLine = aryLines[i].split(" ");     
                if(chunksOfLine[0].equals("let")){
                    if(!isInteger(chunksOfLine[1]) && chunksOfLine[2].equals("=")){
                        
                        variables.put(chunksOfLine[1], Integer.parseInt(chunksOfLine[3]));
                    }
                    else{
                        System.out.println("Syntax Error at line # :"+(i+1)+" "+aryLines[i]);
                    }
                }
                    
                else if(chunksOfLine[0].equals("print")){
                    if(isInteger(chunksOfLine[1])){
                        System.out.println("output: "+chunksOfLine[1]);
                    }
                    else if(variables.containsKey(chunksOfLine[1])){
                        System.out.println("output: "+variables.get(chunksOfLine[1]));
                    }
                    else{
                        System.out.println("output: "+chunksOfLine[1]+" doesn't exists");
                    }
                }
                
                
                else if(chunksOfLine.length>=3   ){
                    int answer=0;
                    if(chunksOfLine[1].equals("=")){
                        
                        //Check for addition
                        
                        if(chunksOfLine[3].equals("+")  ){
                            if(isInteger(chunksOfLine[2]) && isInteger(chunksOfLine[4]) ){
                                answer   = Integer.parseInt(chunksOfLine[2]) + Integer.parseInt(chunksOfLine[4] ) ;
                            }
                            else if(isInteger(chunksOfLine[2]) && !(isInteger(chunksOfLine[4]))){
                                answer = Integer.parseInt(chunksOfLine[2]) + variables.get(chunksOfLine[4]) ;
                            }
                            else if(!(isInteger(chunksOfLine[2])) && isInteger(chunksOfLine[4])){
                                answer =   variables.get(chunksOfLine[2]) + Integer.parseInt(chunksOfLine[4]) ;
                            }
                            else if(!(isInteger(chunksOfLine[2])) && !(isInteger(chunksOfLine[4]))){
                                answer =   variables.get(chunksOfLine[2]) + variables.get(chunksOfLine[4]) ;
                            }
                            variables.put(chunksOfLine[0], answer );
                        }
                        
                        //Check for multiplication
                        else if(chunksOfLine[3].equals("*")  ){
                            
                            if(isInteger(chunksOfLine[2]) && isInteger(chunksOfLine[4]) ){
                                answer   = Integer.parseInt(chunksOfLine[2]) * Integer.parseInt(chunksOfLine[4] ) ;
                            }
                            else if(isInteger(chunksOfLine[2]) && !(isInteger(chunksOfLine[4]))){
                                answer = Integer.parseInt(chunksOfLine[2]) * variables.get(chunksOfLine[4]) ;
                            }
                            else if(!(isInteger(chunksOfLine[2])) && isInteger(chunksOfLine[4])){
                                answer =   variables.get(chunksOfLine[2]) * Integer.parseInt(chunksOfLine[4]) ;
                            }
                            else if(!(isInteger(chunksOfLine[2])) && !(isInteger(chunksOfLine[4]))){
                                answer =   variables.get(chunksOfLine[2]) * variables.get(chunksOfLine[4]) ;
                            }
                            variables.put(chunksOfLine[0], answer );
                        }
                        
                        //Check for subtraction
                        else if(chunksOfLine[3].equals("-")  ){
                            
                            if(isInteger(chunksOfLine[2]) && isInteger(chunksOfLine[4]) ){
                                answer   = Integer.parseInt(chunksOfLine[2]) - Integer.parseInt(chunksOfLine[4] ) ;
                            }
                            else if(isInteger(chunksOfLine[2]) && !(isInteger(chunksOfLine[4]))){
                                answer = Integer.parseInt(chunksOfLine[2]) - variables.get(chunksOfLine[4]) ;
                            }
                            else if(!(isInteger(chunksOfLine[2])) && isInteger(chunksOfLine[4])){
                                answer =   variables.get(chunksOfLine[2]) - Integer.parseInt(chunksOfLine[4]) ;
                            }
                            else if(!(isInteger(chunksOfLine[2])) && !(isInteger(chunksOfLine[4]))){
                                answer =   variables.get(chunksOfLine[2]) - variables.get(chunksOfLine[4]) ;
                            }
                            variables.put(chunksOfLine[0], answer );
                        }
                        
                        //check for division
                        else if(chunksOfLine[3].equals("/")  ){
                            
                            if(isInteger(chunksOfLine[2]) && isInteger(chunksOfLine[4]) ){
                                answer   = Integer.parseInt(chunksOfLine[2]) / Integer.parseInt(chunksOfLine[4] ) ;
                            }
                            else if(isInteger(chunksOfLine[2]) && !(isInteger(chunksOfLine[4]))){
                                answer = Integer.parseInt(chunksOfLine[2]) / variables.get(chunksOfLine[4]) ;
                            }
                            else if(!(isInteger(chunksOfLine[2])) && isInteger(chunksOfLine[4])){
                                answer =   variables.get(chunksOfLine[2]) / Integer.parseInt(chunksOfLine[4]) ;
                            }
                            else if(!(isInteger(chunksOfLine[2])) && !(isInteger(chunksOfLine[4]))){
                                answer =   variables.get(chunksOfLine[2]) / variables.get(chunksOfLine[4]) ;
                            }
                            variables.put(chunksOfLine[0], answer );
                        }
                        
                    }
                    else{
                        System.out.println("Syntax Error at line # :"+(i+1)+" "+aryLines[i]);
                    }
                         
                    
                    
                    
                }

                else {
                    System.out.println("Syntax Error at line # :"+(i+1)+" "+aryLines[i]);
                }
                
            }
        }
        
        catch ( IOException e ) {
            System.out.println( e.getMessage() );
        }
        
    }
    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } 
        catch (NumberFormatException nfe) {
            return false;
        }
        
        
    }
    
}
