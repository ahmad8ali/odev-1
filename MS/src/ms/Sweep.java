package ms;
import javax.swing.JToggleButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.application.Application;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Sweep extends javax.swing.JFrame {
    
    
    final int wid = 9, hei = 9, noOfBombs = 10;
    JToggleButton[][] blocks = new JToggleButton[hei][wid];
    int[][] blox = new int[hei][wid];
    boolean first, canPlay;
   
    ActionListener listen = new ActionListener(){
        public void actionPerformed(ActionEvent e){
            int i = 0, j = 0;
            boolean found = false;
            for(i = 0; i < hei; i++){
                for(j = 0; j < wid; j++){
                    if(e.getSource() == blocks[i][j]){
                        found = true;
                        break;
                    }
                }
                if(found) break;
            }
            if(canPlay){
                blocks[i][j].setSelected(true);
                if(!first){
                    spawn(i, j);
                    first = true;
                }
                if(blox[i][j]!= -1 ){
                    open(i,j);
                    reval();
                } else lose();
                checkWin();
            } else reval();
        }
    };
    
    private void checkWin(){
        boolean won = true;
        for(int i = 0; i < hei; i++){
            for(int j = 0; j < wid; j++){
                if(blox[i][j] == 0) {
                    won = false;
                    break;
                }
            }
            if(!won) break;
        }
        if(won){
            javax.swing.JOptionPane.showMessageDialog(null, "kazandınız !!!");
            canPlay=false;
        }
    }
    
    private void lose(){
        canPlay = false;
        for(int i = 0; i < hei; i++){
            for(int j = 0; j < wid; j++){
                if(blox[i][j] == -1) {
                    blocks[i][j].setText("BOMBA");
                    blocks[i][j].setSelected(true);
                }
            }
        }
    }
    
    private void open(int y, int x){
        if(y < 0 || x < 0 || x > wid - 1 || y > hei - 1 || blox[y][x] != 0) return;
        int bombs = 0;
        for(int i = y - 1; i <= y + 1;i++){
            for(int j = x - 1; j <= x + 1;j++){
                if(!(j < 0 || i < 0 || j > wid - 1 || i > hei - 1) && blox[i][j] == -1)
                    bombs++;
            }
        }
        if(bombs == 0){
            blox[y][x] = -2;
            for(int i = y - 1; i <= y + 1;i++){
                for(int j = x - 1; j <= x + 1;j++){
                    if(!(j < 0 || i < 0 || j > wid - 1 || i > hei - 1))
                    if(i != y || j != x) open(i,j);
                }
            }
        } else blox[y][x] = bombs;
    }
    
    
    private void reval(){
        for(int i = 0; i < hei; i++){
            for(int j = 0; j < wid; j++){
                if(blox[i][j] == 0){
                    blocks[i][j].setText("");
                    blocks[i][j].setSelected(false);

                }
                if(blox[i][j] == -2){
                    blocks[i][j].setText("");
                    blocks[i][j].setSelected(true);
                }
                if(blox[i][j] > 0){
                    blocks[i][j].setText(""+blox[i][j]);
                    blocks[i][j].setSelected(true);
                }
                if(!canPlay && blox[i][j] == -1) blocks[i][j].setSelected(true);
            }
        }
        jPanel1.repaint();
    }
    
    private void spawn(int y, int x){
        for(int k = 1; k <= noOfBombs;k++){
            int i, j;
            do{
                i = (int)(Math.random()*(wid-.01));
                j = (int)(Math.random()*(hei-.01));
            }
            while(blox[i][j] == -1 || (i == y && j == x));
            blox[i][j] = -1;
            
        }
    }
    public void setDefaultCloseOperation(){
        close();
     }  
    public Sweep() {
        initComponents();
        for(int i = 0; i < hei; i++){
            for(int j = 0; j < wid; j++){
                blocks[i][j] = new JToggleButton();
                blocks[i][j].setSize(jPanel1.getWidth()/wid, jPanel1.getHeight()/hei);
                jPanel1.add(blocks[i][j]);
                blocks[i][j].setLocation(j*jPanel1.getWidth()/wid, i*jPanel1.getHeight()/hei);
                blocks[i][j].addActionListener(listen);
            }
        }
        first = false;
        canPlay = true;
    }
    
    private void resiz(){
        for(int i = 0; i < hei; i++){
            for(int j = 0; j < wid; j++){
                blocks[i][j].setSize(jPanel1.getWidth()/wid, jPanel1.getHeight()/hei);
                jPanel1.add(blocks[i][j]);
                blocks[i][j].setLocation(j*jPanel1.getWidth()/wid, i*jPanel1.getHeight()/hei);
            }
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jPanel1ComponentResized(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 322, Short.MAX_VALUE)
        );

        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\AHMAD\\Desktop\\00.png")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jMenu1.setText("Game");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("New game");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Baslangic");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Normal");
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Uzman");
        jMenu1.add(jMenuItem4);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_END, 0));
        jMenuItem5.setText("Exit");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(226, 226, 226)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(229, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel1ComponentResized
        resiz();
    }//GEN-LAST:event_jPanel1ComponentResized

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        blox = new int[hei][wid];
        reval();
        canPlay = true;
        first = false;
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed
    
    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
       
        blox = new int[hei][wid];
        close();
        canPlay = true;
        first = false;
        
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        blox = new int[hei][wid];
        reval();
        canPlay = true;
        first = false;

    }//GEN-LAST:event_jButton1ActionPerformed
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
        * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
        */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
           
                }
            }
           
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Sweep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sweep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sweep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sweep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sweep().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
