package Vista;

import Controlador.Controlador_Persona;
import TDA_Lista.ListaEnlazada;
import TDA_Lista.ListaEnlazadaServices;
import TDA_Lista.TipoOrdenacion;
import Modelo.Datos_Persona;
import Tabla.Datos_Tabla;
import Tabla.OrdenTabla;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * @author Jaime Mendoza
 */
public class FrmPrincipal extends javax.swing.JFrame {

    Datos_Tabla tablaDatos = new Datos_Tabla();
    OrdenTabla ordenT = new OrdenTabla();
    Controlador_Persona ctrlPersona = new Controlador_Persona();

    public FrmPrincipal() {
        initComponents();
        cargarTabla();

        //Centrar ventana
        this.setLocationRelativeTo(null);

    }

    private void cargarTabla() {
        tablaDatos.setListaDatos(ctrlPersona.guardarLista());
        tblCuenta.setModel(tablaDatos);
        tblCuenta.updateUI();
    }

    private void cargarTablaOrden(ListaEnlazadaServices<Datos_Persona> listaPrueba) {
        tablaDatos.setListaDatos(listaPrueba);
        tblOrden.setModel(tablaDatos);
        tblOrden.updateUI();
    }

    private String cambiarNombre() {
        String nr = cbxAtributo.getSelectedItem().toString();
        if (nr.equals("Nombre"))
        {
            nr = "nombre";
        } else
        {
            if (nr.equals("Cedula"))
            {
                nr = "cedula";
            } else
            {
                if (nr.equals("Nombre Impuesto"))
                {
                    nr = "nombre impuesto";
                } else
                {
                    if (nr.equals("Estado Impuesto"))
                    {
                        nr = "estado impuesto";
                    }
                }
            }
        }
        return nr;
    }

    private void buscarAtributo(ListaEnlazada lista, String atributo, String nr, String txt) {
        ctrlPersona.ordenarShell(atributo, TipoOrdenacion.ASCENDENTE);
        try
        {
            lista = ctrlPersona.getListaDatos().getLista().buscarDatoPosicionObjetoBinaria(nr, txt);
            ordenT.setListaDatos(lista);
            tblResultados.setModel(ordenT);
            tblResultados.updateUI();
        } catch (Exception ex)
        {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void buscar() {
        String nr = cbxAtributoBuscar.getSelectedItem().toString();
        String txt = txtDato.getText();
        ListaEnlazada lista = new ListaEnlazada();
        try
        {
            if (txt.trim().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Por favor ingrese el dato que desea buscar");
            } else
            {
                if (nr.equals("Nombre"))
                {
                    nr = "nombre";
                    buscarAtributo(lista, "nombre", nr, txt);
                } else
                {
                    if (nr.equals("Cedula"))
                    {
                        nr = "cedula";
                        buscarAtributo(lista, "cedula", nr, txt);
                    } else
                    {
                        if (nr.equals("Nombre Impuesto"))
                        {
                            nr = "nombre impuesto";
                            buscarAtributo(lista, "nombre impuesto", nr, txt);
                        } else
                        {
                            if (nr.equals("Estado Impuesto"))
                            {
                                nr = "estado impuesto";

                                lista = ctrlPersona.getListaDatos().getLista().buscarDatoPosicionObjetoBinaria(nr, Double.valueOf(txt));
                                ordenT.setListaDatos(lista);
                                tblResultados.setModel(ordenT);
                                tblResultados.updateUI();
                            }
                        }
                    }
                }
            }
        } catch (Exception e)
        {
            System.out.println("ERROR: " + e);
        }
    }

    private void ordenarQuickShort() {
        if (cbxOrden.getSelectedIndex() == 1)
        {
            ctrlPersona.ordenarQuickShort(cambiarNombre(), TipoOrdenacion.ASCENDENTE);
            cargarTablaOrden(ctrlPersona.getListaDatos());
        } else
        {
            if (cbxOrden.getSelectedIndex() == 2)
            {
                ctrlPersona.ordenarQuickShort(cambiarNombre(), TipoOrdenacion.DESCENDENTE);
                cargarTablaOrden(ctrlPersona.getListaDatos());
            } else
            {
                JOptionPane.showMessageDialog(null, "Por favor seleccione el formato de orden");
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cbxAtributoBuscar = new javax.swing.JComboBox<>();
        cbxAtributo = new javax.swing.JComboBox<>();
        cbxOrden = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCuenta = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btnOrdenar = new javax.swing.JButton();
        txtDato = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblResultados = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblOrden = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbxAtributoBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Nombre", "Cedula", "Nombre Impuesto", "Estado Impuesto" }));
        cbxAtributoBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxAtributoBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(cbxAtributoBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 70, 130, -1));

        cbxAtributo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Nombre", "Cedula", "Nombre Impuesto", "Estado Impuesto" }));
        cbxAtributo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxAtributoActionPerformed(evt);
            }
        });
        jPanel1.add(cbxAtributo, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 90, 130, -1));

        cbxOrden.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Ascendente", "Descendente" }));
        jPanel1.add(cbxOrden, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, 130, -1));

        tblCuenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblCuenta);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 410, 350));

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Examen Unidad 2");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 960, 50));

        jLabel8.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Orden:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, -1, -1));

        jLabel10.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(3, 19, 29));
        jLabel10.setText("SECCIÓN DE BUSQUEDA");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 30, 170, 30));

        jLabel12.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(2, 14, 26));
        jLabel12.setText("DATOS ORDENADOS");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 210, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Dato a buscar:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 120, -1, -1));

        jLabel14.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(2, 22, 28));
        jLabel14.setText("MENU DE OPCIONES:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, 140, 30));

        jLabel15.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Ordenar por:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Buscar por:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 70, -1, -1));

        btnOrdenar.setText("Ordenar");
        btnOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarActionPerformed(evt);
            }
        });
        jPanel1.add(btnOrdenar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 170, -1, -1));

        txtDato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDatoActionPerformed(evt);
            }
        });
        jPanel1.add(txtDato, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 120, 120, -1));

        tblResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblResultados);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 210, 280, 150));

        tblOrden.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tblOrden);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 240, 320, 370));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 160, -1, -1));

        jLabel6.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("DATOS:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 60, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1129, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarActionPerformed
        ordenarQuickShort();
    }//GEN-LAST:event_btnOrdenarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscar();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtDatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDatoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDatoActionPerformed

    private void cbxAtributoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxAtributoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxAtributoActionPerformed

    private void cbxAtributoBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxAtributoBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxAtributoBuscarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnOrdenar;
    private javax.swing.JComboBox<String> cbxAtributo;
    private javax.swing.JComboBox<String> cbxAtributoBuscar;
    private javax.swing.JComboBox<String> cbxOrden;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblCuenta;
    private javax.swing.JTable tblOrden;
    private javax.swing.JTable tblResultados;
    private javax.swing.JTextField txtDato;
    // End of variables declaration//GEN-END:variables
}
