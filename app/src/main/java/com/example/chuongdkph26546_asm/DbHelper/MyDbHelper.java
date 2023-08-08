package com.example.chuongdkph26546_asm.DbHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDbHelper extends SQLiteOpenHelper {
    final  static  String DB_NAME = "chuongdk";
    final static  int DB_VERSION = 1;

    public  MyDbHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql_create_tb_loaithu = "CREATE TABLE tb_loaithu ( id INTEGER NOT NULL, tenLoai TEXT NOT NULL, PRIMARY KEY(id AUTOINCREMENT))";
        db.execSQL(sql_create_tb_loaithu);

        String sql_create_tb_khoanthu = "CREATE TABLE  tb_khoanthu  ( id INTEGER NOT NULL, idLoaiThu INTEGER NOT NULL,tenKhoanThu TEXT NOT NULL, ngayThu TEXT NOT NULL, soTien INTEGER NOT NULL, ghiChu TEXT NOT NULL, hoTenNguoiThu TEXT NOT NULL,PRIMARY KEY( id  AUTOINCREMENT))";
        db.execSQL(sql_create_tb_khoanthu);

        String sql_crate_tb_loaichi = "CREATE TABLE  tb_loaichi  ( id INTEGER NOT NULL, tenLoaiChi TEXT NOT NULL, PRIMARY KEY( id  AUTOINCREMENT))";
        db.execSQL(sql_crate_tb_loaichi);

        String sql_create_tb_khoanchi = "CREATE TABLE  tb_khoanchi  ( id INTEGER NOT NULL, idLoaiChi INTEGER NOT NULL, tenKhoanChi INTEGER NOT NULL, ngayChi TEXT NOT NULL, soTien INTEGER NOT NULL, ghiChu TEXT NOT NULL, hoTenNguoiChi TEXT NOT NULL, PRIMARY KEY( id AUTOINCREMENT))";
        db.execSQL(sql_create_tb_khoanchi);

        String sql_insert_tb_loaithu = "INSERT INTO tb_loaithu(tenLoai) VALUES ('Lãi ngân hàng'),('Lương'),('Đòi nợ')";
        db.execSQL(sql_insert_tb_loaithu);

        String sql_insert_tb_khoanthu = "INSERT INTO tb_khoanthu(idLoaiThu,tenKhoanThu,ngayThu,soTien,ghiChu,hoTenNguoiThu) VALUES (1,'Lương tháng 8','2022-8-22','77','Đủ, ổn định','Đặng Khánh Chương'),(2,'Lương tháng 8','2022-9-22','88','Đủ, ổn định','Đặng Khánh Chương'),(3,'Lương tháng 7','2022-7-22','99','Đủ, ổn định','Đặng Khánh Chương')";
        db.execSQL(sql_insert_tb_khoanthu);

        String sql_insert_tb_khoanchi = "INSERT INTO tb_khoanchi(idLoaiChi,tenKhoanChi,ngayChi,soTien,ghiChu,hoTenNguoiChi) VALUES (1,'Tiền Điện T8','2022-8-22','15','ổn','Đặng Khánh Chương'),(2,'Tiền Điện T9','2022-9-22','15',' ổn định','Đặng Khánh Chương'),(3,'Tiền Điện T5','2022-5-22','15','ổn định','Đặng Khánh Chương'),(4,'Tiền Điện T7','2022-7-22','15','ổn','Đặng Khánh Chương'),(5,'Tiền Điện T6','2022-6-22','15','ổn','Đặng Khánh Chương')";
        db.execSQL(sql_insert_tb_khoanchi);


        String sql_insert_tb_loaichi = "INSERT INTO tb_loaichi(tenLoaiChi) VALUES ('Sinh hoạt'),('Du lịch'),('Tiền Điện')";
        db.execSQL(sql_insert_tb_loaichi);


    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
