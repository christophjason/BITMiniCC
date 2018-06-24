/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bit.minicc;

/**
 *
 * @author chris
 */
enum SymbolKind {
    SYM_FUNC,
    SYM_ANG,
    SYM_VAR,
}

public class SymbolEntry {
    public String name;
    public SymbolKind kind;
    public int type;
    public int reg;
    public int offset;
    
    public boolean initialized;
}
