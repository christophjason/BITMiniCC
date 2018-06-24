/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bit.minicc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chris
 */
public class Preprocessor {
    public String run(String iFile){ 
        File file = new File(iFile);
        BufferedReader reader = null;
        ArrayList<String> lines =new ArrayList<String>();

            try {
                System.out.println("Read the file line by line");
                reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
                while((tempString = reader.readLine()) != null) {
                    lines.add(tempString + '\0');
                    System.out.println("line " + line + ":" + tempString);
                    line++;
                    }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if(reader != null){
                try {
                reader.close();
            } catch (IOException e1) {
            }
        }
    }
            int state = 0;
            String code = "";
            for(String line:lines){
                for(int i=0; i< line.length(); i++){
                    String symbol = line.substring(i,i+1);
                    switch (state) {
                        case 0:
                            if(symbol.equals("/")){
                                state = 1;
                            } else {
                                code += symbol;
                            }   break;
                        case 1:
                            if(symbol.equals("/")){
                                state = 2;
                            } else if(symbol.equals("*")){
                                state = 3;
                            } else {
                                code += symbol;
                            }   break;
                        case 2:
                            if(symbol.equals("\0")){
                                state = 0;
                            }break;
                        case 3:
                            if(symbol.equals("*")){
                                state = 4;
                            }   break;
                        case 4:
                            if(symbol.equals("/")){
                                state = 0;
                            } else {
                                state = 3;
                            }   break;
                        default:
                            break;
                    }
                }
            }
            System.out.println("Removed Comment:");
            System.out.println(code);
            return code;
    }
    
}
