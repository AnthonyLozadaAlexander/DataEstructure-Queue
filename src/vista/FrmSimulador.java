/*
 * Created by JFormDesigner on Thu Jun 11 23:23:00 GMT-05:00 2026
 */

package vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 * Ventana principal del simulador gráfico de la estructura {@code cola<String>}
 * Extiende {@link javax.swing.JFrame} y contiene todos los componentes visuales:
 * panel de botones, panel gráfico central de memoria y panel de información lateral.
 * Diseñado con JFormDesigner y adaptada para el patrón MVC.
 *
 * @author Grupo-02
 */
public class FrmSimulador extends JFrame {

    /** Panel gráfico personalizado que dibuja visualmente los nodos de la cola. */
    panelMemoria panel = new panelMemoria();

    /**
     * Crea e inicializa la ventana del simulador.
     * Configura el {@link panelMemoria} y lo agrega al panel central de la interfaz.
     */
    public FrmSimulador() {
        initComponents();
        txtHistorial.setEditable(false);
        txtHistorial.setBackground(Color.WHITE);
        txtHistorial.setWrapStyleWord(true);
        txtHistorial.setLineWrap(true);
        
        panel.setFont(new Font("Arial", Font.BOLD, 11));
        panel.setBackground(Color.white);

        JScrollPane scrollCentro = new JScrollPane(panel);
        scrollCentro.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollCentro.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

        centro.removeAll();
        centro.add(scrollCentro, BorderLayout.CENTER); // agregamos al panel centro el panelMemoria

        // reactualizamos la memoria visual
        centro.revalidate();
        centro.repaint();
    }

    /**
     * Retorna el panel de memoria que dibuja visualmente la cola.
     *
     * @return el {@link panelMemoria} embebido en la vista
     */
    public panelMemoria getPanelMemoria(){
        return panel;
    }

    /**
     * Retorna el botón para ordenar la cola de forma descendente.
     *
     * @return botón "Descendente"
     */
    public javax.swing.JButton getBtnDescendente(){
        return btnDescendente;
    }

    /**
     * Retorna el botón para ordenar la cola de forma ascendente.
     *
     * @return botón "Ascendente"
     */
    public javax.swing.JButton getBtnAscendente(){
        return btnAscendente;
    }

    /**
     * Retorna el botón de búsqueda de elementos en la cola.
     *
     * @return botón "Buscar"
     */
    public javax.swing.JButton getBtnBuscar(){
        return btnBuscar;
    }

    /**
     * Retorna el botón para encolar un nuevo elemento.
     *
     * @return botón "Encolar"
     */
    public javax.swing.JButton getBtnEncolar(){
        return btnEncolar;
    }

    /**
     * Retorna el botón para crear/mostrar la cola en el panel gráfico.
     *
     * @return botón "Crear Cola"
     */
    public javax.swing.JButton getBtnCrear(){
        return btnCrear;
    }

    /**
     * Retorna el botón para desencolar (extraer) el primer elemento.
     *
     * @return botón "Desencolar"
     */
    public javax.swing.JButton getBtnDesencolar(){
        return btnDesencolar;
    }

    /**
     * Retorna el botón para invertir el orden de la cola.
     *
     * @return botón "Invertir Cola"
     */
    public javax.swing.JButton getBtnInvertirCola(){
        return btnInvertir;
    }

    /**
     * Retorna el botón para vaciar completamente la cola.
     *
     * @return botón "Vaciar Cola"
     */
    public javax.swing.JButton getBtnVaciarCola(){
        return btnVaciarCola;
    }

    /**
     * Actualiza la etiqueta que muestra el tamaño actual de la cola.
     *
     * @param dato texto con el número de elementos a mostrar
     */
    public void setLblTamanio(String dato){
        lblTamanio.setText(dato);
    }

    /**
     * Retorna el campo de texto donde el usuario ingresa el valor a encolar.
     *
     * @return campo de texto {@code txtValor}
     */
    public javax.swing.JTextField getTxtValorEncolar(){
        return txtValor;
    }

    /**
     * Limpia o establece el valor del campo de texto de inserción.
     *
     * @param dato texto a colocar en el campo (generalmente cadena vacía para limpiar)
     */
    public void setTxtValor(String dato){
        txtValor.setText(dato);
    }

    /**
     * Actualiza la etiqueta que muestra el elemento del frente de la cola.
     *
     * @param dato texto con el valor del elemento frente
     */
    public void setLblFrente(String dato){
        lblFrente.setText(dato);
    }

    /**
     * Agrega una línea de texto al historial de operaciones de la vista.
     *
     * @param dato mensaje a registrar en el historial
     */
    public void setTxtHistorial(String dato){
        txtHistorial.append(dato + "\n");
    }

    /**
     * Actualiza la etiqueta que muestra el elemento del final de la cola.
     *
     * @param dato texto con el valor del elemento final
     */
    public void setLblFin(String dato){
        lblFIn.setText(dato);
    }

    /**
     * Retorna el botón para eliminar el primer elemento sin retornar su valor.
     *
     * @return botón "Eliminar Primero"
     */
    public javax.swing.JButton getBtnEliminarPrimero(){
        return btnEliminarPrimero;
    }

     /**
      * Retorna el texto ingresado en el campo de búsqueda.
      *
      * @return cadena de texto a buscar en la cola
      */
     public String getTxtBuscar(){
         return txtBuscar.getText();
     }

     /**
      * Retorna el botón para resaltar/ver el primer elemento de la cola.
      *
      * @return botón "Ver Primero"
      */
     public javax.swing.JButton getBtnVerPrimero(){
         return btnVerPrimero;
     }

     /**
      * Retorna el botón para resaltar/ver el último elemento de la cola.
      *
      * @return botón "Ver Ultimo"
      */
     public javax.swing.JButton getBtnVerUltimo(){
        return btnVerUltimo;
     }

     /**
      * Manejador de eventos para el botón Crear.
      * Método generado automáticamente por JFormDesigner.
      *
      * @param e el evento de acción del botón
      */
     private void btnCrear(ActionEvent e) {

     }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Daniel Sanchez (Anthony Lozada)
        titulo = new JPanel();
        lblTitulo = new JLabel();
        botones = new JPanel();
        btnCrear = new JButton();
        label2 = new JLabel();
        lblInsertar = new JLabel();
        btnEncolar = new JButton();
        txtValor = new JTextField();
        label4 = new JLabel();
        btnDesencolar = new JButton();
        btnEliminarPrimero = new JButton();
        btnVaciarCola = new JButton();
        label5 = new JLabel();
        btnVerPrimero = new JButton();
        btnVerUltimo = new JButton();
        txtBuscar = new JTextField();
        btnBuscar = new JButton();
        derecha = new JPanel();
        lblTamano = new JLabel();
        scrollPane1 = new JScrollPane();
        txtHistorial = new JTextArea();
        label7 = new JLabel();
        lblTamanio = new JLabel();
        lblPrimero = new JLabel();
        lblFrente = new JLabel();
        lblUltimo = new JLabel();
        lblFIn = new JLabel();
        lblOrdenamiento = new JLabel();
        btnAscendente = new JButton();
        btnDescendente = new JButton();
        btnInvertir = new JButton();
        lblEstado = new JLabel();
        centro = new JPanel();

        //======== this ========
        setBackground(Color.white);
        setName("this");
        var contentPane = getContentPane();

        //======== titulo ========
        {
            titulo.setBackground(new Color(0x2203bd));
            titulo.setName("titulo");
            titulo.setLayout(new BorderLayout());

            //---- lblTitulo ----
            lblTitulo.setText("Simulador Grafico - Cola <String> ");
            lblTitulo.setFont(new Font("Cascadia Code", Font.BOLD, 18));
            lblTitulo.setBackground(Color.white);
            lblTitulo.setForeground(Color.white);
            lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
            lblTitulo.setName("lblTitulo");
            titulo.add(lblTitulo, BorderLayout.CENTER);
        }

        //======== botones ========
        {
            botones.setBorder(null);
            botones.setBackground(Color.white);
            botones.setName("botones");

            //---- btnCrear ----
            btnCrear.setText(" Crear Cola");
            btnCrear.setFont(new Font("Cascadia Code", Font.BOLD, 16));
            btnCrear.setForeground(new Color(0x5e9900));
            btnCrear.setIcon(new ImageIcon("C:\\Users\\USUARIO\\OneDrive\\Documentos\\Estructuras\\ProjectQueue\\images\\icons8-add-pequenio.png"));
            btnCrear.setName("btnCrear");
            btnCrear.addActionListener(e -> btnCrear(e));

            //---- label2 ----
            label2.setText("COLA");
            label2.setFont(new Font("Cascadia Code", Font.BOLD, 18));
            label2.setBackground(Color.white);
            label2.setName("label2");

            //---- lblInsertar ----
            lblInsertar.setText("INSERTAR");
            lblInsertar.setFont(new Font("Cascadia Code", Font.BOLD, 18));
            lblInsertar.setBackground(Color.white);
            lblInsertar.setName("lblInsertar");

            //---- btnEncolar ----
            btnEncolar.setText(" Encolar");
            btnEncolar.setFont(new Font("Cascadia Code", Font.BOLD, 16));
            btnEncolar.setForeground(new Color(0x0033ff));
            btnEncolar.setIcon(new ImageIcon("C:\\Users\\USUARIO\\OneDrive\\Documentos\\Estructuras\\ProjectQueue\\images\\masAzul.png"));
            btnEncolar.setName("btnEncolar");

            //---- txtValor ----
            txtValor.setName("txtValor");

            //---- label4 ----
            label4.setText("ELIMINAR");
            label4.setFont(new Font("Cascadia Code", Font.BOLD, 18));
            label4.setBackground(Color.white);
            label4.setName("label4");

            //---- btnDesencolar ----
            btnDesencolar.setText("- Desencolar");
            btnDesencolar.setFont(new Font("Cascadia Code", Font.BOLD, 16));
            btnDesencolar.setForeground(new Color(0xff3333));
            btnDesencolar.setName("btnDesencolar");

            //---- btnEliminarPrimero ----
            btnEliminarPrimero.setText("- Eliminar 1ro");
            btnEliminarPrimero.setFont(new Font("Cascadia Code", Font.BOLD, 16));
            btnEliminarPrimero.setForeground(new Color(0xff3333));
            btnEliminarPrimero.setName("btnEliminarPrimero");

            //---- btnVaciarCola ----
            btnVaciarCola.setText("x Vaciar Cola");
            btnVaciarCola.setFont(new Font("Cascadia Code", Font.BOLD, 16));
            btnVaciarCola.setForeground(new Color(0xff3333));
            btnVaciarCola.setName("btnVaciarCola");

            //---- label5 ----
            label5.setText("CONSULTAR");
            label5.setFont(new Font("Cascadia Code", Font.BOLD, 18));
            label5.setBackground(Color.white);
            label5.setName("label5");

            //---- btnVerPrimero ----
            btnVerPrimero.setText("Ver Primero");
            btnVerPrimero.setFont(new Font("Cascadia Code", Font.BOLD, 16));
            btnVerPrimero.setForeground(new Color(0x0033ff));
            btnVerPrimero.setName("btnVerPrimero");

            //---- btnVerUltimo ----
            btnVerUltimo.setText("Ver Ultimo");
            btnVerUltimo.setFont(new Font("Cascadia Code", Font.BOLD, 16));
            btnVerUltimo.setForeground(new Color(0x0033ff));
            btnVerUltimo.setName("btnVerUltimo");

            //---- txtBuscar ----
            txtBuscar.setName("txtBuscar");

            //---- btnBuscar ----
            btnBuscar.setText("Buscar");
            btnBuscar.setFont(new Font("Cascadia Code", Font.BOLD, 16));
            btnBuscar.setForeground(new Color(0x0033ff));
            btnBuscar.setName("btnBuscar");

            GroupLayout botonesLayout = new GroupLayout(botones);
            botones.setLayout(botonesLayout);
            botonesLayout.setHorizontalGroup(
                botonesLayout.createParallelGroup()
                    .addGroup(botonesLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(botonesLayout.createParallelGroup()
                            .addGroup(botonesLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(txtBuscar, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))
                            .addGroup(botonesLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnVerPrimero, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnVerUltimo, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))
                            .addGroup(botonesLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblInsertar, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnEncolar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtValor)
                                .addComponent(btnDesencolar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnEliminarPrimero, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnVaciarCola, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label5, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnCrear, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(24, Short.MAX_VALUE))
            );
            botonesLayout.setVerticalGroup(
                botonesLayout.createParallelGroup()
                    .addGroup(botonesLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(label2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCrear)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblInsertar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEncolar)
                        .addGap(18, 18, 18)
                        .addComponent(txtValor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(label4)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDesencolar)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminarPrimero)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnVaciarCola)
                        .addGap(18, 18, 18)
                        .addComponent(label5)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnVerPrimero)
                        .addGap(12, 12, 12)
                        .addComponent(btnVerUltimo)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(45, Short.MAX_VALUE))
            );
        }

        //======== derecha ========
        {
            derecha.setBorder(null);
            derecha.setBackground(Color.white);
            derecha.setName("derecha");

            //---- lblTamano ----
            lblTamano.setText("[TAMA\u00d1O]:");
            lblTamano.setFont(new Font("Cascadia Code", Font.BOLD, 18));
            lblTamano.setBackground(Color.white);
            lblTamano.setName("lblTamano");

            //======== scrollPane1 ========
            {
                scrollPane1.setName("scrollPane1");

                //---- txtHistorial ----
                txtHistorial.setFont(new Font("Cascadia Code", Font.BOLD, 14));
                txtHistorial.setName("txtHistorial");
                scrollPane1.setViewportView(txtHistorial);
            }

            //---- label7 ----
            label7.setText("[HISTORIAL]");
            label7.setFont(new Font("Cascadia Code", Font.BOLD, 19));
            label7.setBackground(Color.white);
            label7.setName("label7");

            //---- lblTamanio ----
            lblTamanio.setText("N");
            lblTamanio.setFont(new Font("Cascadia Code", Font.BOLD, 14));
            lblTamanio.setBackground(Color.white);
            lblTamanio.setName("lblTamanio");

            //---- lblPrimero ----
            lblPrimero.setText("[PRIMERO]:");
            lblPrimero.setFont(new Font("Cascadia Code", Font.BOLD, 18));
            lblPrimero.setBackground(Color.white);
            lblPrimero.setName("lblPrimero");

            //---- lblFrente ----
            lblFrente.setFont(new Font("Cascadia Code", Font.BOLD, 14));
            lblFrente.setBackground(Color.white);
            lblFrente.setText("N");
            lblFrente.setName("lblFrente");

            //---- lblUltimo ----
            lblUltimo.setText("[ULTIMO]:");
            lblUltimo.setFont(new Font("Cascadia Code", Font.BOLD, 18));
            lblUltimo.setBackground(Color.white);
            lblUltimo.setName("lblUltimo");

            //---- lblFIn ----
            lblFIn.setText("N");
            lblFIn.setFont(new Font("Cascadia Code", Font.BOLD, 14));
            lblFIn.setBackground(Color.white);
            lblFIn.setName("lblFIn");

            //---- lblOrdenamiento ----
            lblOrdenamiento.setText("[ORDENAMIENTO]");
            lblOrdenamiento.setFont(new Font("Cascadia Code", Font.BOLD, 19));
            lblOrdenamiento.setBackground(Color.white);
            lblOrdenamiento.setName("lblOrdenamiento");

            //---- btnAscendente ----
            btnAscendente.setText("Ascendente");
            btnAscendente.setFont(new Font("Cascadia Code", Font.BOLD, 16));
            btnAscendente.setForeground(new Color(0x0066ff));
            btnAscendente.setName("btnAscendente");

            //---- btnDescendente ----
            btnDescendente.setText("Descendente");
            btnDescendente.setFont(new Font("Cascadia Code", Font.BOLD, 16));
            btnDescendente.setForeground(new Color(0x0066ff));
            btnDescendente.setName("btnDescendente");

            //---- btnInvertir ----
            btnInvertir.setText("Invertir");
            btnInvertir.setFont(new Font("Cascadia Code", Font.BOLD, 16));
            btnInvertir.setName("btnInvertir");

            //---- lblEstado ----
            lblEstado.setText("[ESTADO]");
            lblEstado.setFont(new Font("Cascadia Code", Font.BOLD, 19));
            lblEstado.setBackground(Color.white);
            lblEstado.setName("lblEstado");

            GroupLayout derechaLayout = new GroupLayout(derecha);
            derecha.setLayout(derechaLayout);
            derechaLayout.setHorizontalGroup(
                derechaLayout.createParallelGroup()
                    .addComponent(scrollPane1)
                    .addGroup(derechaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(derechaLayout.createParallelGroup()
                            .addGroup(derechaLayout.createSequentialGroup()
                                .addGroup(derechaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addGroup(derechaLayout.createSequentialGroup()
                                        .addComponent(lblTamano)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblTamanio, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(derechaLayout.createSequentialGroup()
                                        .addComponent(lblUltimo)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblFIn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(derechaLayout.createSequentialGroup()
                                        .addComponent(lblPrimero)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblFrente, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 17, Short.MAX_VALUE))
                            .addGroup(GroupLayout.Alignment.TRAILING, derechaLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(derechaLayout.createParallelGroup()
                                    .addGroup(GroupLayout.Alignment.TRAILING, derechaLayout.createSequentialGroup()
                                        .addComponent(label7)
                                        .addGap(58, 58, 58))
                                    .addGroup(GroupLayout.Alignment.TRAILING, derechaLayout.createSequentialGroup()
                                        .addComponent(lblEstado)
                                        .addGap(76, 76, 76))
                                    .addGroup(GroupLayout.Alignment.TRAILING, derechaLayout.createSequentialGroup()
                                        .addGroup(derechaLayout.createParallelGroup()
                                            .addComponent(lblOrdenamiento)
                                            .addGroup(derechaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(btnAscendente, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnDescendente, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnInvertir, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))
                                        .addGap(39, 39, 39))))))
            );
            derechaLayout.setVerticalGroup(
                derechaLayout.createParallelGroup()
                    .addGroup(derechaLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(lblEstado)
                        .addGap(18, 18, 18)
                        .addGroup(derechaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTamano)
                            .addComponent(lblTamanio))
                        .addGap(18, 18, 18)
                        .addGroup(derechaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPrimero)
                            .addComponent(lblFrente, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(derechaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUltimo)
                            .addComponent(lblFIn))
                        .addGap(34, 34, 34)
                        .addComponent(lblOrdenamiento)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAscendente)
                        .addGap(18, 18, 18)
                        .addComponent(btnDescendente)
                        .addGap(18, 18, 18)
                        .addComponent(btnInvertir)
                        .addGap(28, 28, 28)
                        .addComponent(label7)
                        .addGap(18, 18, 18)
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE))
            );
        }

        //======== centro ========
        {
            centro.setBackground(Color.white);
            centro.setBorder(null);
            centro.setName("centro");
            centro.setLayout(new BorderLayout());
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(botones, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(centro, GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(derecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(6, 6, 6))
                .addComponent(titulo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(titulo, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(botones, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(centro, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(derecha, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(0, 0, 0))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Daniel Sanchez (Anthony Lozada)
    private JPanel titulo;
    private JLabel lblTitulo;
    private JPanel botones;
    private JButton btnCrear;
    private JLabel label2;
    private JLabel lblInsertar;
    private JButton btnEncolar;
    private JTextField txtValor;
    private JLabel label4;
    private JButton btnDesencolar;
    private JButton btnEliminarPrimero;
    private JButton btnVaciarCola;
    private JLabel label5;
    private JButton btnVerPrimero;
    private JButton btnVerUltimo;
    private JTextField txtBuscar;
    private JButton btnBuscar;
    private JPanel derecha;
    private JLabel lblTamano;
    private JScrollPane scrollPane1;
    private JTextArea txtHistorial;
    private JLabel label7;
    private JLabel lblTamanio;
    private JLabel lblPrimero;
    private JLabel lblFrente;
    private JLabel lblUltimo;
    private JLabel lblFIn;
    private JLabel lblOrdenamiento;
    private JButton btnAscendente;
    private JButton btnDescendente;
    private JButton btnInvertir;
    private JLabel lblEstado;
    private JPanel centro;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
