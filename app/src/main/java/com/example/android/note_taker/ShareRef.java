package com.example.android.note_taker;

import android.content.Context;
import android.content.SharedPreferences;

public class ShareRef {
    SharedPreferences cont;
    public ShareRef(Context context) {
        cont = context.getSharedPreferences("ref_file",Context.MODE_PRIVATE);
    }
    public void Save_data(String topic,String note){
        SharedPreferences.Editor editor = cont.edit();
        editor.putString("topics",topic+" : "+note);
        editor.commit();
    }
    public String Load_Data(){
        String FileContent = cont.getString("topics","Sorry no note found");
        return FileContent;
    }

}
