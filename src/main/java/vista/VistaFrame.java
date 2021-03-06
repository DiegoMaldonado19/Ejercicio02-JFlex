/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import java.io.Reader;
import java.io.StringReader;
import lexer.Lexer;
import modelo.Token;

/**
 *
 * @author ACER
 */
public class VistaFrame extends javax.swing.JFrame {

    /**
     * Objeto de la clase Lexer que es la encargada de hacer el analisis lexico
     */
    Lexer lexer;
    
    /**
     * Creates new form VistaFrame
     */
    public VistaFrame() {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaAnalisis = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        areaResultado = new javax.swing.JTextArea();
        botonAnalizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("EJERCICIO 02");

        jLabel2.setText("FECHA: 14/02/2022");

        jLabel3.setText("Ingresa un carácter alfanúmerico (letras y numeros enteros) en el área de texto");

        areaAnalisis.setColumns(20);
        areaAnalisis.setRows(5);
        jScrollPane1.setViewportView(areaAnalisis);

        jLabel4.setText("Resultado de Análisis:");

        areaResultado.setColumns(20);
        areaResultado.setRows(5);
        jScrollPane2.setViewportView(areaResultado);

        botonAnalizar.setText("ANALIZAR");
        botonAnalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAnalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jScrollPane1))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel4))))
                        .addGap(18, 18, 18)
                        .addComponent(botonAnalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(282, 282, 282)
                        .addComponent(jLabel2)))
                .addContainerGap(164, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(37, 37, 37)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonAnalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAnalizarActionPerformed
        /**
         * Instanciamos un objeto reader con el texto del area de texto
         */
        Reader reader = new StringReader(areaAnalisis.getText());
        
        /**
         * Creamos un objeto Lexer enviando como parametro nuestro reader
         */
        lexer = new Lexer(reader);
        try {
            
            /**
             * Mientras existan mas tokens que leer ejecutara el codigo
             */
            while(true){
                
                /**
                 * Aplicamos el meto yylex() para realizar el analisis, este retorna un objeto de tipo token
                 */
                Token token = lexer.yylex();
                
                /**
                 * Si ya no hay mas tokens que leer para el ciclo
                 */
                if(!lexer.existenTokens()){
                    break;
                }
                
                /**
                 * Si el tipo de token es igual al tipo numero se imprime en el area de texto la fila y columna
                 */
                if(token.getTipoToken().equals("Numero")){
                    areaResultado.append("Token: "+token.getTipoToken()+"  Lexema: "+token.getLexema()+"   En Fila: "+
                            token.getLinea()+"    En Columna: "+token.getColumna());
                    areaResultado.append(System.getProperty("line.separator"));
                }
                /**
                 * Si el tipo de token es palabra solo se imprime en el area de texto su tipo y lexema
                 */
                else{
                    areaResultado.append("Token: "+token.getTipoToken()+"  Lexema: "+token.getLexema());
                    areaResultado.append(System.getProperty("line.separator"));
                }   
            }
            
            /**
             * Aquí llamamos a las funciones que retornan la cantidad de palabras por cantidad de vocales
             */
            areaResultado.append(System.getProperty("line.separator"));
            areaResultado.append("--------------------------------------------------------");
            areaResultado.append(System.getProperty("line.separator"));
            areaResultado.append("Palabras con una vocal: "+String.valueOf(lexer.cantidadUnaVocal()));
            areaResultado.append(System.getProperty("line.separator"));
            areaResultado.append("Palabras con dos vocales: "+String.valueOf(lexer.cantidadDosVocales()));
            areaResultado.append(System.getProperty("line.separator"));
            areaResultado.append("Palabras con tres vocales: "+String.valueOf(lexer.cantidadTresVocales()));
            areaResultado.append(System.getProperty("line.separator"));
            areaResultado.append("Palabras con cuatro vocales: "+String.valueOf(lexer.cantidadCuatroVocales()));
            areaResultado.append(System.getProperty("line.separator"));
            areaResultado.append("Palabras con cinco vocales: "+String.valueOf(lexer.cantidadCincoVocales()));
            areaResultado.append(System.getProperty("line.separator"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_botonAnalizarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaAnalisis;
    private javax.swing.JTextArea areaResultado;
    private javax.swing.JButton botonAnalizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
