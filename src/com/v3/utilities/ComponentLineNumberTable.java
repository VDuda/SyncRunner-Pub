package com.v3.utilities;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

public class ComponentLineNumberTable extends JComponent {
    private final JTable table;
    private final JScrollPane scrollPane;

    public ComponentLineNumberTable(JScrollPane jScrollPane, JTable table) {
        this.scrollPane = jScrollPane;
        this.table = table;
        this.table.getModel().addTableModelListener(new TableModelListener() {
            public void tableChanged(TableModelEvent tme) {
                ComponentLineNumberTable.this.repaint();
            }
        });

        this.table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent lse) {
                ComponentLineNumberTable.this.repaint();
            }
        });

        this.scrollPane.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent ae) {
                ComponentLineNumberTable.this.repaint();
            }
        });

        setPreferredSize(new Dimension(26, 50));
    }

    protected void paintComponent(Graphics g) {
        Point viewPosition = scrollPane.getViewport().getViewPosition();
        Dimension viewSize = scrollPane.getViewport().getViewSize();
        if (getHeight() < viewSize.height) {
            Dimension size = getPreferredSize();
            size.height = viewSize.height;
            setSize(size);
            setPreferredSize(size);
    	}

        super.paintComponent(g);

        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());

        FontMetrics fm = g.getFontMetrics();

        for(int r=0; r < table.getRowCount(); r++) {
            Rectangle cellRect = table.getCellRect(r, 0, false);

            boolean rowSelected = table.isRowSelected(r);

            if (rowSelected) {
                g.setColor(table.getSelectionBackground());
                g.fillRect(0, cellRect.y, getWidth(), cellRect.height);
            }

            if ((cellRect.y + cellRect.height) - viewPosition.y >= 0 && cellRect.y < viewPosition.y + viewSize.height) {
                g.setColor(table.getGridColor());
                g.drawLine(0, cellRect.y+cellRect.height, getWidth(), cellRect.y+cellRect.height);
                g.setColor(rowSelected ? table.getSelectionForeground() : getForeground());
                String s = Integer.toString(r+1);
                //			String, This portion CENTERS				   , HEIGHT adjustment
                g.drawString(s, getWidth()-getWidth()/2-fm.stringWidth(s)/2, cellRect.y+cellRect.height - fm.getDescent());
            }
        }

        if (table.getShowVerticalLines()) {
            g.setColor(table.getGridColor());
            g.drawRect(0, 0, getWidth()-1, getHeight()-1);
        }
    }
}