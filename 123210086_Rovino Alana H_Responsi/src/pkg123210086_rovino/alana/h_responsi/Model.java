/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg123210086_rovino.alana.h_responsi;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author PC PRAKTIKUM
 */
public class Model extends Connector {

    public int getJumlahData() {
        int jumlah = 0;
        try {
            String query = "SELECT * FROM dataperpus";
            statement = koneksi.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                jumlah++;
            }
            return jumlah;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return jumlah;
        }

    }

    public String[][] getDataBuku() {
        String data[][] = new String[getJumlahData()][7];
        try {
            int index = 0;
            String query = "SELECT * FROM dataperpus";
            statement = koneksi.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                data[index][0] = resultSet.getString("id");
                data[index][1] = resultSet.getString("judul");
                data[index][2] = resultSet.getString("genre");
                data[index][3] = resultSet.getString("penulis");
                data[index][4] = resultSet.getString("penerbit");
                data[index][5] = resultSet.getString("lokasi");
                data[index][6] = resultSet.getString("stock");
                index++;
            }
            return data;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return data;
        }
    }

    public void tambahData(String judul, String genre, String penulis, String penerbit, String lokasi, int stock) {
        try {
            String query = "INSERT INTO `dataperpus` (`judul`,`genre`,`penulis`,`penerbit`,`lokasi`,`stock`) VALUES (?,?,?,?,?,?)";
            prepare = koneksi.prepareStatement(query);
            prepare.setString(1, judul);
            prepare.setString(2, genre);
            prepare.setString(3, penulis);
            prepare.setString(4, penerbit);
            prepare.setString(5, lokasi);
            prepare.setInt(6, stock);

            prepare.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void hapusData(String id) {

        try {
            String query =  "DELETE FROM `dataperpus` WHERE `id` = '" 
                            + id + "'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void ubahData(String judul, String genre, String penulis, String penerbit, String lokasi, int stock, String id) {
        try {
            String query = "UPDATE `dataperpus` SET "
                    + "`judul` = '" + judul + "',"
                    + "`genre` = '" + genre + "',"
                    + "`penulis` = '" + penulis + "' ,"
                    + "`penerbit` = '" + penerbit + "',"
                    + "`lokasi` = '" + lokasi + "',"
                    + "`stock` = '" + stock + "' "
                    + "WHERE `id` = '" + id + "'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            statement.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public int jumlahKategori(String kategori, String cari) {
        int jumlah = 0;
        try {
            String query =  "SELECT * FROM dataperpus WHERE `" 
                            + kategori + "` = '" 
                            + cari + "'";
            statement = koneksi.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                jumlah++;
            }
            return jumlah;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return jumlah;
        }
    }

    public String[][] DataKategori(String kategori, String cari) {
        String data[][] = new String[jumlahKategori(kategori, cari)][7];
        try {
            int index = 0;
            String query =  "SELECT * FROM dataperpus WHERE `"
                            + kategori + "` = '" 
                            + cari + "'";
            statement = koneksi.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                data[index][0] = resultSet.getString("id");
                data[index][1] = resultSet.getString("judul");
                data[index][2] = resultSet.getString("genre");
                data[index][3] = resultSet.getString("penulis");
                data[index][4] = resultSet.getString("penerbit");
                data[index][5] = resultSet.getString("lokasi");
                data[index][6] = resultSet.getString("stock");
                index++;
            }
            return data;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return data;
        }

    }

}
