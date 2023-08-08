package com.example.chuongdkph26546_asm.DTO;

public class KhoanChiDTO {
    int id;
    int idLoaiChi;
    String tenKhoanChi;
    String ngayChi;
    Double soTien;
    String ghiChu;
    String hoTenNguoiChi;

    public KhoanChiDTO() {
    }

    public KhoanChiDTO(int id, int idLoaiChi, String tenKhoanChi, String ngayChi, Double soTien, String ghiChu, String hoTenNguoiChi) {
        this.id = id;
        this.idLoaiChi = idLoaiChi;
        this.tenKhoanChi = tenKhoanChi;
        this.ngayChi = ngayChi;
        this.soTien = soTien;
        this.ghiChu = ghiChu;
        this.hoTenNguoiChi = hoTenNguoiChi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdLoaiChi() {
        return idLoaiChi;
    }

    public void setIdLoaiChi(int idLoaiChi) {
        this.idLoaiChi = idLoaiChi;
    }

    public String getTenKhoanChi() {
        return tenKhoanChi;
    }

    public void setTenKhoanChi(String tenKhoanChi) {
        this.tenKhoanChi = tenKhoanChi;
    }

    public String getNgayChi() {
        return ngayChi;
    }

    public void setNgayChi(String ngayChi) {
        this.ngayChi = ngayChi;
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

    public String getHoTenNguoiChi() {
        return hoTenNguoiChi;
    }

    public void setHoTenNguoiChi(String hoTenNguoiChi) {
        this.hoTenNguoiChi = hoTenNguoiChi;
    }
}
