package com.example.chuongdkph26546_asm.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.chuongdkph26546_asm.DTO.LoaiChiDTO;
import com.example.chuongdkph26546_asm.DTO.LoaiThuDTO;
import com.example.chuongdkph26546_asm.DbHelper.MyDbHelper;

import java.util.ArrayList;

public class LoaiThuDAO {
    SQLiteDatabase db;
    MyDbHelper dbHelper;

    public LoaiThuDAO(Context context) {
        dbHelper = new MyDbHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public void open() {
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        db.close();
    }

    public ArrayList<LoaiThuDTO> selectAll(){
        ArrayList<LoaiThuDTO> list = new ArrayList<LoaiThuDTO>();

        String sql_select = "SELECT * FROM tb_loaithu";
        Cursor c = db.rawQuery(sql_select, null);
        if (c.moveToFirst()) {
            while (!c.isAfterLast()) {
                LoaiThuDTO obj = new LoaiThuDTO();
                obj.setId(c.getInt(0));
                obj.setTenLoaiThu(c.getString(1));


                list.add(obj);

                c.moveToNext();
            }
        }
        return list;

    }

    public  long insert(LoaiThuDTO loaiThuDTO){
        ContentValues contentValues = new ContentValues();

        contentValues.put("tenLoai",loaiThuDTO.getTenLoaiThu());

        long res = db.insert("tb_loaithu",null,contentValues);
        return res;
    }

    public  int delete(int id){

        return  db.delete("tb_loaithu", "id = "+id,null);
    }

    public  boolean update(LoaiThuDTO loaiThuDTO){
        ContentValues contentValues = new ContentValues();

        contentValues.put("tenLoai",loaiThuDTO.getTenLoaiThu());

        long res = db.update("tb_loaithu",contentValues,"id=?",new String[]{String.valueOf(loaiThuDTO.getId())});

        if (res<=0){
            return  false;
        }
        return true;
    }
}
