package com.example.chuongdkph26546_asm.DTO;

public class KhoanThuDTO {
    int id;
    int idLoaiThu;
    String tenKhoanThu;
    String ngayThu;
    Double soTien;
    String ghiChu;
    String hoTenNguoiThu;

    public KhoanThuDTO() {
    }

    public KhoanThuDTO(int id, int idLoaiThu, String tenKhoanThu, String ngayThu, Double soTien, String ghiChu, String hoTenNguoiThu) {
        this.id = id;
        this.idLoaiThu = idLoaiThu;
        this.tenKhoanThu = tenKhoanThu;
        this.ngayThu = ngayThu;
        this.soTien = soTien;
        this.ghiChu = ghiChu;
        this.hoTenNguoiThu = hoTenNguoiThu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdLoaiThu() {
        return idLoaiThu;
    }

    public void setIdLoaiThu(int idLoaiThu) {
        this.idLoaiThu = idLoaiThu;
    }

    public String getTenKhoanThu() {
        return tenKhoanThu;
    }

    public void setTenKhoanThu(String tenKhoanThu) {
        this.tenKhoanThu = tenKhoanThu;
    }

    public String getNgayThu() {
        return ngayThu;
    }

    public void setNgayThu(String ngayThu) {
        this.ngayThu = ngayThu;
    }

    public Double getSoTien() {
        return soTien;
    }

    public void setSoTien(Double soTien) {
        this.soTien = soTien;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getHoTenNguoiThu() {
        return hoTenNguoiThu;
    }

    public void setHoTenNguoiThu(String hoTenNguoiThu) {
        this.hoTenNguoiThu = hoTenNguoiThu;
    }
}
