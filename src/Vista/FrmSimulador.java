/*
 * Created by JFormDesigner on Thu Jun 11 23:23:00 GMT-05:00 2026
 */

package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.LineBorder;

/**
 * @author USUARIO
 */
public class FrmSimulador extends JFrame {
    PanelMemoria panel = new PanelMemoria();

    public FrmSimulador() {
        initComponents();
        // java.awt.Dimension tamanioOriginal = Centro.getPreferredSize();
        // Centro.setLayout(new java.awt.BorderLayout());
        // panel.setPreferredSize(tamanioOriginal);

        // agregamos al panel centro el panelMemoria
        Centro.add(panel, java.awt.BorderLayout.CENTER);

        // reactualizamos la memoria visual
        Centro.revalidate();
        Centro.repaint();
    }

    public PanelMemoria getPanelMemoria(){
        return panel;
    }

    public javax.swing.JButton getBtnEncolar(){
        return btnEncolar;
    }

    public javax.swing.JButton getBtnCrear(){
        return btnCrear;
    }

    public javax.swing.JTextField getTxtValorEncolar(){
        return txtValor;
    }

    public void txtValor(String dato){
        txtValor.setText(dato);
    }


    private void btnCrear(ActionEvent e) {
       /* // Guardamos el tamanio original del Panel Centro
        java.awt.Dimension tamanioOriginal = Centro.getPreferredSize();

        // cambiamos el layout del Panel Centro
        Centro.setLayout(new java.awt.BorderLayout());

        // instanciamos el PanelMemoria
        PanelMemoria panelDibujo = new PanelMemoria();

        // le damos el tamanio original al panelDibujo
        panelDibujo.setPreferredSize(tamanioOriginal);


        Centro.add(panelDibujo, java.awt.BorderLayout.CENTER);
        Centro.revalidate();
        Centro.repaint();

        btnCrear.setEnabled(false);*/
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Daniel Sanchez (Anthony Lozada)
        Titulo = new JPanel();
        label1 = new JLabel();
        Botones = new JPanel();
        btnCrear = new JButton();
        label2 = new JLabel();
        label3 = new JLabel();
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
        Derecha = new JPanel();
        label6 = new JLabel();
        scrollPane1 = new JScrollPane();
        txtHistorial = new JTextArea();
        label7 = new JLabel();
        lblTamanio = new JLabel();
        label9 = new JLabel();
        lblFrente = new JLabel();
        label11 = new JLabel();
        lblFIn = new JLabel();
        label13 = new JLabel();
        btnAscendente = new JButton();
        btnDescendente = new JButton();
        btnDescendente2 = new JButton();
        Centro = new JPanel();

        //======== this ========
        setBackground(Color.white);
        setName("this");
        var contentPane = getContentPane();

        //======== Titulo ========
        {
            Titulo.setBackground(new Color(0x000033));
            Titulo.setName("Titulo");

            //---- label1 ----
            label1.setText("Simulador Grafico - Cola <String> ");
            label1.setFont(new Font("Cascadia Code", Font.BOLD, 18));
            label1.setBackground(Color.white);
            label1.setForeground(Color.white);
            label1.setName("label1");

            GroupLayout TituloLayout = new GroupLayout(Titulo);
            Titulo.setLayout(TituloLayout);
            TituloLayout.setHorizontalGroup(
                TituloLayout.createParallelGroup()
                    .addGroup(TituloLayout.createSequentialGroup()
                        .addGap(357, 357, 357)
                        .addComponent(label1)
                        .addContainerGap(377, Short.MAX_VALUE))
            );
            TituloLayout.setVerticalGroup(
                TituloLayout.createParallelGroup()
                    .addGroup(TituloLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(label1)
                        .addContainerGap(22, Short.MAX_VALUE))
            );
        }

        //======== Botones ========
        {
            Botones.setBorder(null);
            Botones.setBackground(Color.white);
            Botones.setName("Botones");

            //---- btnCrear ----
            btnCrear.setText("+ Crear Cola");
            btnCrear.setFont(new Font("Cascadia Code", Font.BOLD, 16));
            btnCrear.setForeground(new Color(0x5e9900));
            btnCrear.setName("btnCrear");
            // btnCrear.addActionListener(e -> btnCrear(e));

            //---- label2 ----
            label2.setText("COLA");
            label2.setFont(new Font("Cascadia Code", Font.BOLD, 18));
            label2.setBackground(Color.white);
            label2.setName("label2");

            //---- label3 ----
            label3.setText("INSERTAR");
            label3.setFont(new Font("Cascadia Code", Font.BOLD, 18));
            label3.setBackground(Color.white);
            label3.setName("label3");

            //---- btnEncolar ----
            btnEncolar.setText("+ Encolar");
            btnEncolar.setFont(new Font("Cascadia Code", Font.BOLD, 16));
            btnEncolar.setForeground(new Color(0x0033ff));
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

            GroupLayout BotonesLayout = new GroupLayout(Botones);
            Botones.setLayout(BotonesLayout);
            BotonesLayout.setHorizontalGroup(
                BotonesLayout.createParallelGroup()
                    .addGroup(BotonesLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(BotonesLayout.createParallelGroup()
                            .addGroup(BotonesLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(txtBuscar, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))
                            .addGroup(BotonesLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnVerPrimero, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnVerUltimo, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))
                            .addGroup(BotonesLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
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
            BotonesLayout.setVerticalGroup(
                BotonesLayout.createParallelGroup()
                    .addGroup(BotonesLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(label2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCrear)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(label3)
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
                        .addContainerGap(117, Short.MAX_VALUE))
            );
        }

        //======== Derecha ========
        {
            Derecha.setBorder(null);
            Derecha.setBackground(Color.white);
            Derecha.setName("Derecha");

            //---- label6 ----
            label6.setText("[ TAMA\u00d1O ]:");
            label6.setFont(new Font("Cascadia Code", Font.BOLD, 18));
            label6.setBackground(Color.white);
            label6.setName("label6");

            //======== scrollPane1 ========
            {
                scrollPane1.setName("scrollPane1");

                //---- txtHistorial ----
                txtHistorial.setName("txtHistorial");
                scrollPane1.setViewportView(txtHistorial);
            }

            //---- label7 ----
            label7.setText("[ HISTORIAL ]");
            label7.setFont(new Font("Cascadia Code", Font.BOLD, 18));
            label7.setBackground(Color.white);
            label7.setName("label7");

            //---- lblTamanio ----
            lblTamanio.setText("N");
            lblTamanio.setFont(new Font("Cascadia Code", Font.BOLD, 16));
            lblTamanio.setBackground(Color.white);
            lblTamanio.setName("lblTamanio");

            //---- label9 ----
            label9.setText("[ FRENTE ]:");
            label9.setFont(new Font("Cascadia Code", Font.BOLD, 18));
            label9.setBackground(Color.white);
            label9.setName("label9");

            //---- lblFrente ----
            lblFrente.setText("N");
            lblFrente.setFont(new Font("Cascadia Code", Font.BOLD, 16));
            lblFrente.setBackground(Color.white);
            lblFrente.setName("lblFrente");

            //---- label11 ----
            label11.setText("[ FINAL  ]:");
            label11.setFont(new Font("Cascadia Code", Font.BOLD, 18));
            label11.setBackground(Color.white);
            label11.setName("label11");

            //---- lblFIn ----
            lblFIn.setText("N");
            lblFIn.setFont(new Font("Cascadia Code", Font.BOLD, 16));
            lblFIn.setBackground(Color.white);
            lblFIn.setName("lblFIn");

            //---- label13 ----
            label13.setText("Ordenar");
            label13.setFont(new Font("Cascadia Code", Font.BOLD, 18));
            label13.setBackground(Color.white);
            label13.setName("label13");

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

            //---- btnDescendente2 ----
            btnDescendente2.setText("Invertir");
            btnDescendente2.setFont(new Font("Cascadia Code", Font.BOLD, 16));
            btnDescendente2.setName("btnDescendente2");

            GroupLayout DerechaLayout = new GroupLayout(Derecha);
            Derecha.setLayout(DerechaLayout);
            DerechaLayout.setHorizontalGroup(
                DerechaLayout.createParallelGroup()
                    .addComponent(scrollPane1, GroupLayout.Alignment.TRAILING)
                    .addGroup(DerechaLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(DerechaLayout.createParallelGroup()
                            .addGroup(DerechaLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(label13, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
                            .addGroup(DerechaLayout.createSequentialGroup()
                                .addComponent(label6)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblTamanio, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                            .addGroup(DerechaLayout.createSequentialGroup()
                                .addComponent(label9)
                                .addGap(12, 12, 12)
                                .addComponent(lblFrente, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                            .addGroup(DerechaLayout.createSequentialGroup()
                                .addComponent(label11)
                                .addGap(12, 12, 12)
                                .addComponent(lblFIn, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                            .addGroup(DerechaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(btnDescendente2, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
                                .addGroup(DerechaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnAscendente, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnDescendente))
                                .addComponent(label7, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(32, Short.MAX_VALUE))
            );
            DerechaLayout.setVerticalGroup(
                DerechaLayout.createParallelGroup()
                    .addGroup(DerechaLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(DerechaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label6)
                            .addComponent(lblTamanio))
                        .addGap(18, 18, 18)
                        .addGroup(DerechaLayout.createParallelGroup()
                            .addComponent(label9)
                            .addGroup(DerechaLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(lblFrente)))
                        .addGap(18, 18, 18)
                        .addGroup(DerechaLayout.createParallelGroup()
                            .addComponent(label11)
                            .addGroup(DerechaLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(lblFIn)))
                        .addGap(30, 30, 30)
                        .addComponent(label13)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAscendente)
                        .addGap(18, 18, 18)
                        .addComponent(btnDescendente)
                        .addGap(26, 26, 26)
                        .addComponent(btnDescendente2)
                        .addGap(52, 52, 52)
                        .addComponent(label7)
                        .addGap(18, 18, 18)
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE))
            );
        }

        //======== Centro ========
        {
            Centro.setBackground(Color.white);
            Centro.setBorder(new LineBorder(Color.black, 1, true));
            Centro.setName("Centro");
            Centro.setLayout(new BorderLayout());
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(Botones, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(Centro, GroupLayout.PREFERRED_SIZE, 630, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(Derecha, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addComponent(Titulo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(Titulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(4, 4, 4)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(Botones, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Derecha, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Centro, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE))
                    .addGap(0, 0, 0))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Daniel Sanchez (Anthony Lozada)
    private JPanel Titulo;
    private JLabel label1;
    private JPanel Botones;
    private JButton btnCrear;
    private JLabel label2;
    private JLabel label3;
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
    private JPanel Derecha;
    private JLabel label6;
    private JScrollPane scrollPane1;
    private JTextArea txtHistorial;
    private JLabel label7;
    private JLabel lblTamanio;
    private JLabel label9;
    private JLabel lblFrente;
    private JLabel label11;
    private JLabel lblFIn;
    private JLabel label13;
    private JButton btnAscendente;
    private JButton btnDescendente;
    private JButton btnDescendente2;
    private JPanel Centro;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
