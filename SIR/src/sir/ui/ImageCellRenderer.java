package sir.ui;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class ImageCellRenderer extends JLabel implements TableCellRenderer {

    protected ImageIcon iconV = new ImageIcon(getClass().getResource("/sir/ui/Ressources/imgV.png"));
    protected ImageIcon iconF = new ImageIcon(getClass().getResource("/sir/ui/Ressources/imgF.png"));
    protected JLabel icon = new JLabel();

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        String tmp = (String) value;
        if (tmp.equals("V")) {
            icon.setIcon(iconV);
        } else {
            icon.setIcon(iconF);
        }
        setHorizontalAlignment(JLabel.CENTER);
        return icon;
    }
}
