/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg123210086_rovino.alana.h_responsi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

/**
 *
 * @author PC PRAKTIKUM
 */
public class Controller {

    public Controller(View view, Model model) {

//        viewPerpus.getjTextFieldID().setEnabled(false);
        view.gettButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    String judul = view.getJudul().getText();
                    String genre = view.getGenre().getText();
                    String penulis = view.getPenulis().getText();
                    String penerbit = view.getPenerbit().getText();
                    String lokasi = view.getLokasi().getText();
                    int stock = Integer.parseInt(view.getStock().getText());

                    if (judul.equals("") || genre.equals("") || penulis.equals("") || penerbit.equals("") || lokasi.equals("")) {
                       JOptionPane.showMessageDialog(null, "Inputan Tidak Boleh Kosong!");
                       return;
                    }

                    model.tambahData(judul, genre, penulis, penerbit, lokasi, stock);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    JOptionPane.showMessageDialog(null, "Input Gagal!", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        view.getuButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String judul = view.getJudul().getText();
                String genre = view.getGenre().getText();
                String penulis = view.getPenulis().getText();
                String penerbit = view.getPenerbit().getText();
                String lokasi = view.getLokasi().getText();
                int stock = Integer.parseInt(view.getStock().getText());
                String id = view.getId().getText();
                
                if (judul.equals("") || genre.equals("") || penulis.equals("") || penerbit.equals("") || lokasi.equals("")) {
                       JOptionPane.showMessageDialog(null, "Inputan Tidak Boleh Kosong!");
                       return;
                    }

                model.ubahData(judul, genre, penulis, penerbit, lokasi, stock, id);

            }
        });
        
        view.gethButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String id = view.getId().getText();

                    model.hapusData(id);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());

                }

            }
        });
        
        view.getTsButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String data[][];
                data = model.getDataBuku();

                view.getTabel().setModel(new DefaultTableModel(data, new String[]{
                    "Id", "Judul", "Genre", "Penulis", "Penerbit", "Lokasi", "Stock"
                }));

            }
        });

        view.getTabel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = view.getTabel().getSelectedRow();
                
                String id = view.getTabel().getValueAt(row, 0).toString();
                String judul = view.getTabel().getValueAt(row, 1).toString();
                String genre = view.getTabel().getValueAt(row, 2).toString();
                String penulis = view.getTabel().getValueAt(row, 3).toString();
                String penerbit = view.getTabel().getValueAt(row, 4).toString();
                String lokasi = view.getTabel().getValueAt(row, 5).toString();
                String stock = view.getTabel().getValueAt(row, 6).toString();

                view.getId().setText(id);
                view.getJudul().setText(judul);
                view.getGenre().setText(genre);
                view.getPenulis().setText(penulis);
                view.getPenerbit().setText(penerbit);
                view.getLokasi().setText(lokasi);
                view.getStock().setText(stock);
            }

        });

        view.getcButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String kategori = view.getComboBox().getSelectedItem().toString();
                String cari = view.getCari().getText();
                String data[][] = model.DataKategori(kategori, cari);
                  
                view.getTabel().setModel(new DefaultTableModel(data, new String[]{
                    "Id", "Judul", "Genre", "Penulis", "Penerbit", "Lokasi", "Stock"
                }));
                if (data.length == 0) {
                       JOptionPane.showMessageDialog(null, "Data Yang Dicari Tidak Ditemukan!");
                    }

            }
        });

    }

}
