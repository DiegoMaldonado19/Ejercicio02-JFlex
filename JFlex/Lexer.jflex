/* Primera seccion: codigo del usuario */


%%


/* Segunda seccion: Configuracion */

%public
%class Lexer
%unicode
%line
%column
%type Token

%{
    /* variables privadas para realizar los ciclos y almacenar la cantidad de palabras por cantidad de vocal */
    private boolean existenTokens = false;
    private int contadorUnaVocal=0;
    private int contadorDosVocales=0;
    private int contadorTresVocales=0;
    private int contadorCuatroVocales=0;
    private int contadorCincoVocales=0;
 
    /* metodo para saber si siguen existiendo tokens */
    public boolean existenTokens(){
    return this.existenTokens;
    }

    /* metodo para obtener la cantidad de palabras con una vocal */
    public int cantidadUnaVocal(){
        return this.contadorUnaVocal;
    }

    /* metodo para obtener la cantidad de palabras con dos vocales */
    public int cantidadDosVocales(){
        return this.contadorDosVocales;
    }

    /* metodo para obtener la cantidad de palabras con tres vocales */
    public int cantidadTresVocales(){
        return this.contadorTresVocales;
    }

    /* metodo para obtener la cantidad de palabras con cuatro vocales */
    public int cantidadCuatroVocales(){
        return this.contadorCuatroVocales;
    }

    /* metodo para obtener la cantidad de palabras con cinco vocales */
    public int cantidadCincoVocales(){
        return this.contadorCincoVocales;
    }

%}

%eof{
    this.existenTokens = false;
%eof}
 

%%

/* Tercer seccion: Reglas lexicas */

([a-zA-Z]+)   {     Token token = new Token("Palabra", yytext(), yyline, yycolumn);
                    this.existenTokens = true;
                    
                    int contadorVocales = 0;
                    
                    char [] lexema = token.getLexema().toCharArray();

                    for(int i=0; i<lexema.length; i++){
                        if(lexema[i]=='a' || lexema[i]=='A' || lexema[i]=='e' || lexema[i]=='E' || lexema[i]=='i' || lexema[i]=='I'
                            lexema[i]=='o' || lexema[i]=='O' || lexema[i]=='u' || lexema[i]=='U'){
                                contadorVocales++;
                        }
                    }
                    switch(contadorVocales){
                        case 1:
                            this.contadorUnaVocal = contadorVocales;
                        break;

                        case 2:
                            this.contadorDosVocales = contadorVocales;
                        break;

                        case 2:
                            this.contadorDosVocales = contadorVocales;
                        break;

                        case 3:
                            this.contadorTresVocales = contadorVocales;
                        break;
                    
                        case 4:
                            this.contadorCuatroVocales = contadorVocales;
                        break;

                        case 5:
                            this.contadorCincoVocales = contadorVocales;
                        break;
                        
                        default:
                        
                        breaK;
                    }
                    return token;
                }

([0-9]+)      { Token token = new Token("Numero", yytext(), yyline, yycolumn);
                this.existenTokens = true;
                return token;}

[^]         {}