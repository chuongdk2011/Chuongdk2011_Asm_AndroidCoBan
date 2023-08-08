package com.example.chuongdkph26546_asm.DTO;

public class LoaiChiDTO {
    int id;
    String tenLoaiChi;

    public LoaiChiDTO() {
    }

    public LoaiChiDTO(int id, String tenLoaiChi) {
        this.id = id;
        this.tenLoaiChi = tenLoaiChi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenLoaiChi() {
        return tenLoaiChi;
    }

    public void setTenLoaiChi(String tenLoaiChi) {
        this.tenLoaiChi = tenLoaiChi;
    }
}
