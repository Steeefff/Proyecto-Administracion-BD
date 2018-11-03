package RespaldosBD;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class EquipoDesarrollador extends javax.swing.JFrame 
{

    public EquipoDesarrollador() 
    {
        initComponents(); //Carga los elementos del JFrame o JPanel
        this.setVisible(true); //Hace visible la ventana
        this.setLocationRelativeTo(null); //Centa la pantalla
        this.setTitle("Equipo Desarrollador"); //Título
        ImageIcon imagen=new ImageIcon("src/Imagenes/empresaOracle.jpg");
        Icon icono=new ImageIcon(imagen.getImage().getScaledInstance(lblFondo.getWidth(),lblFondo.getHeight(),Image.SCALE_DEFAULT));
        lblFondo.setIcon(icono);
        this.repaint();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        lblFondo = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        nombre1 = new javax.swing.JLabel();
        nombre2 = new javax.swing.JLabel();
        nombre3 = new javax.swing.JLabel();
        nombre4 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        barraSuperior = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        subitem1 = new javax.swing.JMenuItem();
        subitem2 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setBackground(new java.awt.Color(255, 0, 0));
        lblTitulo.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Equipo Desarrollador");
        lblTitulo.setOpaque(true);

        nombre1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nombre1.setText("Luis Carlos Sánchez");

        nombre2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nombre2.setText("Kristopher Barrot");

        nombre3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nombre3.setText("Ricardo Vargas");

        nombre4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nombre4.setText("Johel López");

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jMenu1.setText("Opciones");

        subitem1.setText("Regresar");
        subitem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subitem1ActionPerformed(evt);
            }
        });
        jMenu1.add(subitem1);

        subitem2.setText("Salir");
        subitem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subitem2ActionPerformed(evt);
            }
        });
        jMenu1.add(subitem2);

        barraSuperior.add(jMenu1);

        setJMenuBar(barraSuperior);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombre2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombre3, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombre4, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 178, Short.MAX_VALUE)
                        .addComponent(lblFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(nombre1)
                        .addGap(18, 18, 18)
                        .addComponent(nombre2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(nombre3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(nombre4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(lblFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     //////////////////////////////////////////////////  ACCIONES  ////////////////////////////////////////////////////////
    
    private void subitem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subitem1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        InicioSesion is= new InicioSesion();
        is.cargarUsuarios();
        is.setVisible(true);
    }//GEN-LAST:event_subitem1ActionPerformed

    private void subitem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subitem2ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_subitem2ActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        InicioSesion is= new InicioSesion();
        is.cargarUsuarios();
        is.setVisible(true);
    }//GEN-LAST:event_btnRegresarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraSuperior;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel nombre1;
    private javax.swing.JLabel nombre2;
    private javax.swing.JLabel nombre3;
    private javax.swing.JLabel nombre4;
    private javax.swing.JMenuItem subitem1;
    private javax.swing.JMenuItem subitem2;
    // End of variables declaration//GEN-END:variables
}
