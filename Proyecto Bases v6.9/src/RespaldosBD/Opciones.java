package RespaldosBD;
import BaseDatos.Funcionalidad;
import java.awt.Color;

public class Opciones extends javax.swing.JFrame 
{
    Funcionalidad db;
    public String usuario;
    public String contraseña;
    
    public Opciones()
    {
        initComponents(); //Carda los elementos del JFrame o JPanel
        setLocationRelativeTo(null); //Centa la pantalla
        setTitle("Administración de Oracle"); //Título
        setResizable(false);
        this.getContentPane().setBackground(Color.white);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JButton();
        btnCrearRespaldos = new javax.swing.JButton();
        btnImportarRespaldo = new javax.swing.JButton();
        btnEstadisticas = new javax.swing.JButton();
        btnDirectorios = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        submenu2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setBackground(new java.awt.Color(255, 0, 0));
        lblTitulo.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Administración de Oracle");
        lblTitulo.setOpaque(true);

        btnCerrarSesion.setText("Cerrar Sesión");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        btnCrearRespaldos.setText("Creación de Respaldos");
        btnCrearRespaldos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearRespaldosActionPerformed(evt);
            }
        });

        btnImportarRespaldo.setText("Recuperación de Respaldos");
        btnImportarRespaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportarRespaldoActionPerformed(evt);
            }
        });

        btnEstadisticas.setText("Administración de Estadísticas");
        btnEstadisticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstadisticasActionPerformed(evt);
            }
        });

        btnDirectorios.setText("Administración de Archivos y Directorios");
        btnDirectorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDirectoriosActionPerformed(evt);
            }
        });

        jMenu1.setText("Opciones");

        submenu2.setText("Salir");
        submenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenu2ActionPerformed(evt);
            }
        });
        jMenu1.add(submenu2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEstadisticas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDirectorios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnImportarRespaldo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCrearRespaldos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnCrearRespaldos, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnImportarRespaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEstadisticas, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnDirectorios, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 40, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenu2ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_submenu2ActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        db.Desconectar();
        this.setVisible(false);
        InicioSesion is= new InicioSesion();
        is.cargarUsuarios();
        is.setVisible(true);
   
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnCrearRespaldosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearRespaldosActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        CrearRespaldo cr= new CrearRespaldo();
        cr.usuario=usuario;
        cr.contraseña=contraseña;
        cr.db=this.db;
        cr.op=this;//le pasamos la referencia de esta ventana
        cr.cargarTablasUsuario(); 
        cr.cargarDirectorios();
        cr.setVisible(true);
    }//GEN-LAST:event_btnCrearRespaldosActionPerformed

    private void btnDirectoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDirectoriosActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        AdminDirectorios ad=new AdminDirectorios();
        ad.usuario=usuario;
        ad.contraseña=contraseña;
        ad.db=this.db;
        ad.op=this;//le pasamos la referencia de esta ventana
        ad.cargarDirectorios();
        ad.cargarUsuarios();
        ad.setVisible(true);
        
    }//GEN-LAST:event_btnDirectoriosActionPerformed

    private void btnImportarRespaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportarRespaldoActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        RecuperacionRespaldos rr= new RecuperacionRespaldos();
        rr.usuario=usuario;
        rr.contraseña=contraseña;
        rr.db=this.db;
        rr.op=this;//le pasamos la referencia de esta ventana
        rr.cargarTablasUsuario();
        rr.cargarDirectorios();
        rr.setVisible(true);
    }//GEN-LAST:event_btnImportarRespaldoActionPerformed

    private void btnEstadisticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstadisticasActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        AdminEstadisticas ae= new AdminEstadisticas();
        ae.usuario=usuario;
        ae.contraseña=contraseña;
        ae.db=this.db;
        ae.op=this;//le pasamos la referencia de esta ventana
        ae.cargarTablasUsuario();
        ae.setVisible(true);
    }//GEN-LAST:event_btnEstadisticasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnCrearRespaldos;
    private javax.swing.JButton btnDirectorios;
    private javax.swing.JButton btnEstadisticas;
    private javax.swing.JButton btnImportarRespaldo;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JMenuItem submenu2;
    // End of variables declaration//GEN-END:variables
}