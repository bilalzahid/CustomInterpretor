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
public class CustomInterpretor {

    Map<String, Integer> variables;
    
    public CustomInterpretor(){
        variables = new HashMap<String, Integer>();
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String file_name = "code.txt";
        try{
            ReadFile file = new ReadFile( file_name );
            String[] aryLines = file.OpenFile( );
            int numOfLines = file.readLines();
            //HashMap variables = new HashMap(100);
            CustomInterpretor interpretor = new CustomInterpretor();
            //Map<String, Integer> variables = new HashMap<String, Integer>();
            for ( int i=0; i < numOfLines; i++ ) {
                
                System.out.println(aryLines[i]); 
                String[] chunksOfLine = new String[100];
                chunksOfLine = aryLines[i].split(" ");              
                //System.out.println(chunksOfLine[j]);
                if(chunksOfLine[0].equals("let")){
                    if(!isInteger(chunksOfLine[1]) && chunksOfLine[2].equals("=")){
                        
                        interpretor.variables.put(chunksOfLine[1], Integer.parseInt(chunksOfLine[3]));
                    }
                    else{
                        System.out.println("Syntax Error at line # :"+(i+1)+"\n"+aryLines[i]);
                    }
                }
                    
                else if(chunksOfLine[0].equals("print")){
                    System.out.println("output: "+interpretor.variables.get(chunksOfLine[1]));
                }
                
                
                else if(chunksOfLine.length>=3   ){
                    //System.out.println("length : "+chunksOfLine.length);
                    int answer=0;
                    if(chunksOfLine[1].equals("=")){
                        
                        //Check for addition
                        if(chunksOfLine[3].equals("+")  ){
                            if(isInteger(chunksOfLine[2]) && isInteger(chunksOfLine[4]) ){
                                answer   = Integer.parseInt(chunksOfLine[2]) + Integer.parseInt(chunksOfLine[4] ) ;
                            }
                            else if(isInteger(chunksOfLine[2]) && !(isInteger(chunksOfLine[4]))){
                                answer = Integer.parseInt(chunksOfLine[2]) + interpretor.variables.get(chunksOfLine[4]) ;
                            }
                            else if(!(isInteger(chunksOfLine[2])) && isInteger(chunksOfLine[4])){
                                answer =   interpretor.variables.get(chunksOfLine[2]) + Integer.parseInt(chunksOfLine[4]) ;
                            }
                            else if(!(isInteger(chunksOfLine[2])) && !(isInteger(chunksOfLine[4]))){
                                answer =   interpretor.variables.get(chunksOfLine[2]) + interpretor.variables.get(chunksOfLine[4]) ;
                            }
                            interpretor.variables.put(chunksOfLine[0], answer );
                        }
                        
                        //Check for multiplication
                        else if(chunksOfLine[3].equals("*")  ){
                            
                            if(isInteger(chunksOfLine[2]) && isInteger(chunksOfLine[4]) ){
                                answer   = Integer.parseInt(chunksOfLine[2]) * Integer.parseInt(chunksOfLine[4] ) ;
                            }
                            else if(isInteger(chunksOfLine[2]) && !(isInteger(chunksOfLine[4]))){
                                answer = Integer.parseInt(chunksOfLine[2]) * interpretor.variables.get(chunksOfLine[4]) ;
                            }
                            else if(!(isInteger(chunksOfLine[2])) && isInteger(chunksOfLine[4])){
                                answer =   interpretor.variables.get(chunksOfLine[2]) * Integer.parseInt(chunksOfLine[4]) ;
                            }
                            else if(!(isInteger(chunksOfLine[2])) && !(isInteger(chunksOfLine[4]))){
                                answer =   interpretor.variables.get(chunksOfLine[2]) * interpretor.variables.get(chunksOfLine[4]) ;
                            }
                            interpretor.variables.put(chunksOfLine[0], answer );
                        }
                        
                        //Check for subtraction
                        else if(chunksOfLine[3].equals("-")  ){
                            
                            if(isInteger(chunksOfLine[2]) && isInteger(chunksOfLine[4]) ){
                                answer   = Integer.parseInt(chunksOfLine[2]) - Integer.parseInt(chunksOfLine[4] ) ;
                            }
                            else if(isInteger(chunksOfLine[2]) && !(isInteger(chunksOfLine[4]))){
                                answer = Integer.parseInt(chunksOfLine[2]) - interpretor.variables.get(chunksOfLine[4]) ;
                            }
                            else if(!(isInteger(chunksOfLine[2])) && isInteger(chunksOfLine[4])){
                                answer =   interpretor.variables.get(chunksOfLine[2]) - Integer.parseInt(chunksOfLine[4]) ;
                            }
                            else if(!(isInteger(chunksOfLine[2])) && !(isInteger(chunksOfLine[4]))){
                                answer =   interpretor.variables.get(chunksOfLine[2]) - interpretor.variables.get(chunksOfLine[4]) ;
                            }
                            interpretor.variables.put(chunksOfLine[0], answer );
                        }
                        
                        //check for division
                        else if(chunksOfLine[3].equals("/")  ){
                            
                            if(isInteger(chunksOfLine[2]) && isInteger(chunksOfLine[4]) ){
                                answer   = Integer.parseInt(chunksOfLine[2]) / Integer.parseInt(chunksOfLine[4] ) ;
                            }
                            else if(isInteger(chunksOfLine[2]) && !(isInteger(chunksOfLine[4]))){
                                answer = Integer.parseInt(chunksOfLine[2]) / interpretor.variables.get(chunksOfLine[4]) ;
                            }
                            else if(!(isInteger(chunksOfLine[2])) && isInteger(chunksOfLine[4])){
                                answer =   interpretor.variables.get(chunksOfLine[2]) / Integer.parseInt(chunksOfLine[4]) ;
                            }
                            else if(!(isInteger(chunksOfLine[2])) && !(isInteger(chunksOfLine[4]))){
                                answer =   interpretor.variables.get(chunksOfLine[2]) / interpretor.variables.get(chunksOfLine[4]) ;
                            }
                            interpretor.variables.put(chunksOfLine[0], answer );
                        }
                        
                    }
                    else{
                        System.out.println("Syntax Error at line # :"+(i+1)+"\n"+aryLines[i]);
                    }
                         
                    //System.out.println("result: "+answer);
                    
                    
                }

                else {
                    System.out.println("Syntax Error at line # :"+(i+1)+"\n"+aryLines[i]);
                }
                
                //System.out.println("\n");
                
                //HashMap<Integer, String>  map = new HashMap(source);
            }
        }
        
        
        /*catch (ArrayIndexOutOfBoundsException e) {
         System.out.println("Array is out of Bounds"+e);
        }*/
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
