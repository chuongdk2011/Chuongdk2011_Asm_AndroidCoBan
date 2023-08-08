package com.example.chuongdkph26546_asm.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.chuongdkph26546_asm.DTO.KhoanChiDTO;
import com.example.chuongdkph26546_asm.DbHelper.MyDbHelper;

import java.util.ArrayList;

public class KhoanChiDAO {
    SQLiteDatabase db;
    MyDbHelper dbHelper;

    public KhoanChiDAO(Context context) {
        dbHelper = new MyDbHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public void open() {
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        db.close();
    }

    public ArrayList<KhoanChiDTO> selectAll(){
        ArrayList<KhoanChiDTO> list = new ArrayList<KhoanChiDTO>();

        String sql_select = "SELECT * FROM tb_khoanchi";
        Cursor c = db.rawQuery(sql_select, null);
        if (c.moveToFirst()) {
            while (!c.isAfterLast()) {
                KhoanChiDTO obj = new KhoanChiDTO();
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
        return list;

    }

    public int selectCount(String ngaybatdau,String ngayketthuc){

        int count = 0;
        String sql_select = "SELECT COUNT (*) FROM tb_khoanchi WHERE  tb_khoanchi.ngayChi  BETWEEN '"+ngaybatdau+"' AND  '"+ngayketthuc+"'";
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
        String sql_select = "SELECT SUM (soTien) as tong_tien FROM tb_khoanchi WHERE  tb_khoanchi.ngayChi  BETWEEN '"+ngaybatdau+"' AND  '"+ngayketthuc+"'";
        Cursor c  = db.rawQuery(sql_select,  null);
        if (c!=null && c.moveToFirst()) {

           sum = c.getDouble(0);


        }
        return  sum;
    }

    public ArrayList<KhoanChiDTO> selectformdate(String ngaybatdau,String ngayketthuc) {

        ArrayList<KhoanChiDTO> list = new ArrayList<KhoanChiDTO>();
        KhoanChiDTO obj = new KhoanChiDTO();
        db = dbHelper.getReadableDatabase();
        String sql_select = "SELECT tenKhoanChi,ngayChi,soTien,ghiChu,hoTenNguoiChi FROM tb_khoanchi WHERE  tb_khoanchi.ngayChi  BETWEEN '" + ngaybatdau + "' AND  '" + ngayketthuc + "'";
        Cursor c = db.rawQuery(sql_select, null);
        if (c.moveToFirst()) {
            while (!c.isAfterLast()) {

                obj.setTenKhoanChi(c.getString(0));
                obj.setNgayChi(c.getString(1));
                obj.setSoTien(c.getDouble(2));
                obj.setGhiChu(c.getString(3));
                obj.setHoTenNguoiChi(c.getString(4));

                list.add(obj);
                c.moveToNext();
            }
        }
            return  list;
    }
    public  long insert(KhoanChiDTO khoanChiDTO){
        ContentValues contentValues = new ContentValues();

        contentValues.put("idLoaiChi",khoanChiDTO.getIdLoaiChi());
        contentValues.put("tenKhoanChi",khoanChiDTO.getTenKhoanChi());
        contentValues.put("ngayChi",khoanChiDTO.getNgayChi());
        contentValues.put("soTien",khoanChiDTO.getSoTien());
        contentValues.put("ghiChu",khoanChiDTO.getGhiChu());
        contentValues.put("hoTenNguoiChi",khoanChiDTO.getHoTenNguoiChi());

        long res = db.insert("tb_khoanchi",null,contentValues);
        return res;
    }

    public  int delete(int id){

        return  db.delete("tb_khoanchi", "id = "+id,null);
    }

    public  boolean update(KhoanChiDTO khoanChiDTO){
        ContentValues contentValues = new ContentValues();

        contentValues.put("idLoaiChi",khoanChiDTO.getIdLoaiChi());
        contentValues.put("tenKhoanChi",khoanChiDTO.getTenKhoanChi());
        contentValues.put("ngayChi",khoanChiDTO.getNgayChi());
        contentValues.put("soTien",khoanChiDTO.getSoTien());
        contentValues.put("ghiChu",khoanChiDTO.getGhiChu());
        contentValues.put("hoTenNguoiChi",khoanChiDTO.getHoTenNguoiChi());

        long res = db.update("tb_khoanchi",contentValues,"id=?",new String[]{String.valueOf(khoanChiDTO.getId())});

        if (res<=0){
            return  false;
        }
        return true;
    }
}
