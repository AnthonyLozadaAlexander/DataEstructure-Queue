/*
 * Created by JFormDesigner on Thu Jun 11 23:23:00 GMT-05:00 2026
 */

package Vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

/**
 * @author USUARIO
 */
public class FrmSimulador extends JFrame {
    public FrmSimulador() {
        initComponents();
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
        btnEliminarPrimero2 = new JButton();
        Derecha = new JPanel();
        Centro = new JPanel();

        //======== this ========
        setName("this");
        var contentPane = getContentPane();

        //======== Titulo ========
        {
            Titulo.setBackground(new Color(0x000033));
            Titulo.setName("Titulo");

            //---- label1 ----
            label1.setText("Simulador Cola <String> - Simulador");
            label1.setFont(new Font("Cascadia Code", Font.BOLD, 20));
            label1.setBackground(Color.white);
            label1.setForeground(Color.white);
            label1.setName("label1");

            GroupLayout TituloLayout = new GroupLayout(Titulo);
            Titulo.setLayout(TituloLayout);
            TituloLayout.setHorizontalGroup(
                TituloLayout.createParallelGroup()
                    .addGroup(TituloLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(label1)
                        .addContainerGap(693, Short.MAX_VALUE))
            );
            TituloLayout.setVerticalGroup(
                TituloLayout.createParallelGroup()
                    .addGroup(TituloLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(label1)
                        .addContainerGap(23, Short.MAX_VALUE))
            );
        }

        //======== Botones ========
        {
            Botones.setName("Botones");

            //---- btnCrear ----
            btnCrear.setText("+ Crear Cola");
            btnCrear.setFont(new Font("Cascadia Code", Font.BOLD, 16));
            btnCrear.setForeground(new Color(0x5e9900));
            btnCrear.setName("btnCrear");

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
            label5.setText("Consultar");
            label5.setFont(new Font("Cascadia Code", Font.BOLD, 18));
            label5.setBackground(Color.white);
            label5.setName("label5");

            //---- btnVerPrimero ----
            btnVerPrimero.setText("Ver Primero");
            btnVerPrimero.setFont(new Font("Cascadia Code", Font.BOLD, 16));
            btnVerPrimero.setForeground(new Color(0x0033ff));
            btnVerPrimero.setName("btnVerPrimero");

            //---- btnEliminarPrimero2 ----
            btnEliminarPrimero2.setText("Ver Ultimo");
            btnEliminarPrimero2.setFont(new Font("Cascadia Code", Font.BOLD, 16));
            btnEliminarPrimero2.setForeground(new Color(0x0033ff));
            btnEliminarPrimero2.setName("btnEliminarPrimero2");

            GroupLayout BotonesLayout = new GroupLayout(Botones);
            Botones.setLayout(BotonesLayout);
            BotonesLayout.setHorizontalGroup(
                BotonesLayout.createParallelGroup()
                    .addGroup(BotonesLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(BotonesLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnVerPrimero, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDesencolar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCrear, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEncolar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtValor)
                            .addComponent(btnEliminarPrimero, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnVaciarCola, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label5, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminarPrimero2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(51, Short.MAX_VALUE))
            );
            BotonesLayout.setVerticalGroup(
                BotonesLayout.createParallelGroup()
                    .addGroup(BotonesLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(label2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCrear)
                        .addGap(18, 18, 18)
                        .addComponent(label3)
                        .addGap(18, 18, 18)
                        .addComponent(btnEncolar)
                        .addGap(18, 18, 18)
                        .addComponent(txtValor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(label4)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDesencolar)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminarPrimero)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnVaciarCola)
                        .addGap(27, 27, 27)
                        .addComponent(label5)
                        .addGap(18, 18, 18)
                        .addComponent(btnVerPrimero)
                        .addGap(12, 12, 12)
                        .addComponent(btnEliminarPrimero2)
                        .addContainerGap(80, Short.MAX_VALUE))
            );
        }

        //======== Derecha ========
        {
            Derecha.setName("Derecha");

            GroupLayout DerechaLayout = new GroupLayout(Derecha);
            Derecha.setLayout(DerechaLayout);
            DerechaLayout.setHorizontalGroup(
                DerechaLayout.createParallelGroup()
                    .addGap(0, 212, Short.MAX_VALUE)
            );
            DerechaLayout.setVerticalGroup(
                DerechaLayout.createParallelGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
            );
        }

        //======== Centro ========
        {
            Centro.setName("Centro");

            GroupLayout CentroLayout = new GroupLayout(Centro);
            Centro.setLayout(CentroLayout);
            CentroLayout.setHorizontalGroup(
                CentroLayout.createParallelGroup()
                    .addGap(0, 653, Short.MAX_VALUE)
            );
            CentroLayout.setVerticalGroup(
                CentroLayout.createParallelGroup()
                    .addGap(0, 594, Short.MAX_VALUE)
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(Titulo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(Botones, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(Centro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(Derecha, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(Titulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(Botones, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(Centro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(Derecha, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    private JButton btnEliminarPrimero2;
    private JPanel Derecha;
    private JPanel Centro;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
