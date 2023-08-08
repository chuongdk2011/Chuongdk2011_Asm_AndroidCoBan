package com.example.chuongdkph26546_asm.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.chuongdkph26546_asm.DTO.KhoanThuDTO;
import com.example.chuongdkph26546_asm.DTO.LoaiChiDTO;
import com.example.chuongdkph26546_asm.DbHelper.MyDbHelper;

import java.util.ArrayList;

public class LoaiChiDAO {
    SQLiteDatabase db;
    MyDbHelper dbHelper;

    public LoaiChiDAO(Context context) {
        dbHelper = new MyDbHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public void open() {
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        db.close();
    }

    public ArrayList<LoaiChiDTO> selectAll(){
        ArrayList<LoaiChiDTO> list = new ArrayList<LoaiChiDTO>();

        String sql_select = "SELECT * FROM tb_loaichi";
        Cursor c = db.rawQuery(sql_select, null);
        if (c.moveToFirst()) {
            while (!c.isAfterLast()) {
                LoaiChiDTO obj = new LoaiChiDTO();
                obj.setId(c.getInt(0));
                obj.setTenLoaiChi(c.getString(1));

                list.add(obj);

                c.moveToNext();
            }
        }
        return list;

    }

    public  long insert(LoaiChiDTO loaiChiDTO){
        ContentValues contentValues = new ContentValues();

        contentValues.put("tenLoaiChi",loaiChiDTO.getTenLoaiChi());

        long res = db.insert("tb_loaichi",null,contentValues);
        return res;
    }

    public  int delete(int id){

        return  db.delete("tb_loaichi", "id = "+id,null);
    }

    public  boolean update(LoaiChiDTO loaiChiDTO){
        ContentValues contentValues = new ContentValues();

        contentValues.put("tenLoaiChi",loaiChiDTO.getTenLoaiChi());

        long res = db.update("tb_loaichi",contentValues,"id=?",new String[]{String.valueOf(loaiChiDTO.getId())});

        if (res<=0){
            return  false;
        }
        return true;
    }
}
