/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author ACER
 */
public class Token {
    /**
     * Variables que son necesarias para construir un objeto de tipo token
     */
    private String tipoToken;
    private String lexema;
    private int columna;
    private int linea;

    /**
     * Constructor de la clase
     * @param tipoToken     tipo de token al que pertenece
     * @param lexema        el contenido que presenta el token en cuestion
     * @param linea         linea en la que se encuentra
     * @param columna       columna en la que se encuentra
     */
    public Token(String tipoToken, String lexema, int linea, int columna) {
        this.tipoToken = tipoToken;
        this.lexema = lexema;
        this.columna = columna;
        this.linea = linea;
    }

    /**
     * Getter para obtener el tipo de token
     * @return 
     */
    public String getTipoToken() {
        return tipoToken;
    }

    /**
     * Getter para obtener el lexema
     * @return 
     */
    public String getLexema() {
        return lexema;
    }

    /**
     * Getter para obtener la columna en donde se encuentra el token
     * @return 
     */
    public int getColumna() {
        return columna;
    }

    /**
     * Getter para obtener la linea en donde se encuentra el token
     * @return 
     */
    public int getLinea() {
        return linea;
    }

    /**
     * Metodo toString
     * @return 
     */
    @Override
    public String toString() {
        return "Token{" + "tipoToken=" + tipoToken + ", lexema=" + lexema + ", columna=" + columna + ", linea=" + linea + '}';
    }
    
    
}
