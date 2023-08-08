package com.example.chuongdkph26546_asm.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.chuongdkph26546_asm.DTO.KhoanChiDTO;
import com.example.chuongdkph26546_asm.DTO.KhoanThuDTO;
import com.example.chuongdkph26546_asm.DbHelper.MyDbHelper;

import java.util.ArrayList;

public class KhoanThuDAO {
    SQLiteDatabase db;
    MyDbHelper dbHelper;

    public KhoanThuDAO(Context context) {
        dbHelper = new MyDbHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public void open() {
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        db.close();
    }

    public ArrayList<KhoanThuDTO> selectAll(){
        ArrayList<KhoanThuDTO> list = new ArrayList<KhoanThuDTO>();

        String sql_select = "SELECT * FROM tb_khoanthu";
        Cursor c = db.rawQuery(sql_select, null);
        if (c.moveToFirst()) {
            while (!c.isAfterLast()) {
                KhoanThuDTO obj = new KhoanThuDTO();
                obj.setId(c.getInt(0));
                obj.setIdLoaiThu(c.getInt(1));
                obj.setTenKhoanThu(c.getString(2));
                obj.setNgayThu(c.getString(3));
                obj.setSoTien(c.getDouble(4));
                obj.setGhiChu(c.getString(5));
                obj.setHoTenNguoiThu(c.getString(6));

                list.add(obj);

                c.moveToNext();
            }
        }
        return list;

    }

    public int selectCount(String ngaybatdau,String ngayketthuc){

        int count = 0;
        String sql_select = "SELECT COUNT (*) FROM tb_khoanthu WHERE  tb_khoanthu.ngayThu  BETWEEN '"+ngaybatdau+"' AND  '"+ngayketthuc+"'";
        db = dbHelper.getWritableDatabase();
        Cursor c  = db.rawQuery(sql_select,  null);
        if (c!=null && c.moveToFirst()) {


            count = c.getInt(0);




        }
        return  count;
    }
    public double selectSum(String ngaybatdau,String ngayketthuc){
        double sum = 0;
        db= dbHelper.getWritableDatabase();
        String sql_select = "SELECT SUM (soTien) as tong_tien FROM tb_khoanthu WHERE  tb_khoanthu.ngayThu  BETWEEN '"+ngaybatdau+"' AND  '"+ngayketthuc+"'";
        Cursor c  = db.rawQuery(sql_select,  null);
        if (c!=null && c.moveToFirst()) {

            sum = c.getDouble(0);


        }
        return  sum;
    }

    public ArrayList<KhoanChiDTO> selectformdate(String ngaybatdau,String ngayketthuc) {

        ArrayList<KhoanChiDTO> list = new ArrayList<KhoanChiDTO>();
        KhoanChiDTO obj = new KhoanChiDTO();
        String sql_select = "SELECT * FROM tb_khoanthu WHERE  tb_khoanthu.ngayThu  BETWEEN '" + ngaybatdau + "' AND  '" + ngayketthuc + "'";
        Cursor c = db.rawQuery(sql_select, null);
        if (c.moveToFirst()) {
            while (!c.isAfterLast()) {

                obj.setId(c.getInt(0));
                obj.setIdLoaiChi(c.getInt(1));
                obj.setTenKhoanChi(c.getString(2));
                obj.setNgayChi(c.getString(3));
                obj.setSoTien(c.getDouble(4));
                obj.setGhiChu(c.getString(5));
                obj.setHoTenNguoiChi(c.getString(6));

                list.add(obj);
                c.moveToNext();
            }
        }
        return  list;
    }

    public  long insert(KhoanThuDTO khoanThuDTO){
        ContentValues contentValues = new ContentValues();

        contentValues.put("idLoaiThu",khoanThuDTO.getIdLoaiThu());
        contentValues.put("tenKhoanThu",khoanThuDTO.getTenKhoanThu());
        contentValues.put("ngayThu",khoanThuDTO.getNgayThu());
        contentValues.put("soTien",khoanThuDTO.getSoTien());
        contentValues.put("ghiChu",khoanThuDTO.getGhiChu());
        contentValues.put("hoTenNguoiThu",khoanThuDTO.getHoTenNguoiThu());

        long res = db.insert("tb_khoanthu",null,contentValues);
        return res;
    }

    public  int delete(int id){

        return  db.delete("tb_khoanthu", "id = "+id,null);
    }

    public  boolean update(KhoanThuDTO khoanThuDTO){
        ContentValues contentValues = new ContentValues();

        contentValues.put("idLoaiThu",khoanThuDTO.getIdLoaiThu());
        contentValues.put("tenKhoanThu",khoanThuDTO.getTenKhoanThu());
        contentValues.put("ngayThu",khoanThuDTO.getNgayThu());
        contentValues.put("soTien",khoanThuDTO.getSoTien());
        contentValues.put("ghiChu",khoanThuDTO.getGhiChu());
        contentValues.put("hoTenNguoiThu",khoanThuDTO.getHoTenNguoiThu());

        long res = db.update("tb_khoanthu",contentValues,"id=?",new String[]{String.valueOf(khoanThuDTO.getId())});

        if (res<=0){
            return  false;
        }
        return true;
    }
}

