/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sir.ui;

import java.awt.Color;
import java.awt.Component;
import static java.lang.Boolean.TRUE;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author solenn
 */
class CouleurCellRenderer extends JLabel implements TableCellRenderer {

    protected ImageIcon prio = new ImageIcon(getClass().getResource("/sir/ui/Ressources/Prio.png"));
    protected JLabel icon = new JLabel();

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
        String tmp = (String) value;
        if (tmp.equals("V")){
            icon.setIcon(prio);
        }
        setHorizontalAlignment(JLabel.CENTER);
        return icon;
    }
}
