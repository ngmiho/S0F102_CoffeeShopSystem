/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import bean.DanhMucBean;
import view.KhachHangJPanel;
import view.MenuJPanel;
import view.NhanVienJPanel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.*;
import model.NhanVien;
import view.BanHangJPanel;

/**
 *
 * @author Admin
 */
public class ChuyenManHinhController {

    private JPanel root;
    private String kindSelected = "";
    private NhanVien nv;
    private List<DanhMucBean> listItem = null;

    public ChuyenManHinhController(JPanel pnlRoot, NhanVien nv) {
        this.root = pnlRoot;
        this.nv = nv;
    }

    public void setView(JPanel pnlItem, JLabel lblItem) {
        kindSelected = "BanHang";

        pnlItem.setBackground(new Color(96, 100, 191));
        lblItem.setBackground(new Color(96, 100, 191));

        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new BanHangJPanel(nv));
        root.validate();
        root.repaint();
    }

    public void setEvent(List<DanhMucBean> listItem) {
        this.listItem = listItem;

        for (DanhMucBean item : listItem) {
            item.getLbl().addMouseListener(new LabelEvent(item.getKind(), item.getPnl(), item.getLbl()));
        }

    }

    class LabelEvent implements MouseListener {

        private JPanel node;
        private String kind;

        private JPanel pnlItem;
        private JLabel lblItem;

        public LabelEvent(String kind, JPanel pnlItem, JLabel lblItem) {
            this.kind = kind;
            this.pnlItem = pnlItem;
            this.lblItem = lblItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch (kind) {
                case "NhanVien":
                    node = new NhanVienJPanel();
                    break;
                case "KhachHang":
                    node = new KhachHangJPanel();
                    break;
                case "Menu":
                    node = new MenuJPanel();
                    break;
                case "BanHang":
                    node = new BanHangJPanel(nv);
                    break;
                default:
                    node = new BanHangJPanel(nv);
                    break;
            }

            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBackground(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;

            pnlItem.setBackground(new Color(96, 100, 191));
            lblItem.setBackground(new Color(96, 100, 191));
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            pnlItem.setBackground(new Color(96, 100, 191));
            lblItem.setBackground(new Color(96, 100, 191));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!kindSelected.equalsIgnoreCase(kind)) {
                pnlItem.setBackground(new Color(76, 175, 80));
                lblItem.setBackground(new Color(76, 175, 80));
            }
        }

        public void  setChangeBackground(String kind) {
            for (DanhMucBean item : listItem) {
                if (item.getKind().equalsIgnoreCase(kind)) {
                    item.getPnl().setBackground(new Color(96, 100, 191));
                    item.getLbl().setBackground(new Color(96, 100, 191));
                } else {
                    item.getPnl().setBackground(new Color(76, 175, 80));
                    item.getLbl().setBackground(new Color(76, 175, 80));
                }
            }
        }
    }
}
