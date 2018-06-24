
import bit.minicc.CodeGenerator;
import bit.minicc.Parser;
import bit.minicc.Preprocessor;
import bit.minicc.Scanner;
import bit.minicc.SemanticChecker;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chris
 */
public class MiniCCompiler {
    
    /**
     * @param args the command line arguments
    */
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Hello World!");
        if(args.length < 1){
            System.out.println("Usage: test.c");
            return;
        } else {
            System.out.println(args[0]);
        }
        
        Preprocessor pp = new Preprocessor();
        Scanner scanner = new Scanner();
        Parser parser = new Parser();
        SemanticChecker sc = new SemanticChecker();
        CodeGenerator cg = new CodeGenerator();
        
        String code = pp.run(args[0]);
        scanner.run(code);
        parser.run();
        sc.run();
        cg.run();
        
    }
}
