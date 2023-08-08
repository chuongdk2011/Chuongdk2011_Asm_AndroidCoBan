package com.example.chuongdkph26546_asm.DTO;

public class LoaiThuDTO {
    int id;
    String tenLoaiThu;

    public LoaiThuDTO() {
    }

    public LoaiThuDTO(int id, String tenLoaiThu) {
        this.id = id;
        this.tenLoaiThu = tenLoaiThu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenLoaiThu() {
        return tenLoaiThu;
    }

    public void setTenLoaiThu(String tenLoaiThu) {
        this.tenLoaiThu = tenLoaiThu;
    }
}
