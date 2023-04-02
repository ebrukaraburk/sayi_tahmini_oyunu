package com.example.sayi_tahmini;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView txtKalanHak,txtSonuc;
    private EditText editTxtSayi;
    private int kalanHak=5,randomSayi;
    private boolean tahminDogrumu=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtKalanHak=(TextView)findViewById(R.id.txtViewKalanHak);
        txtSonuc=(TextView)findViewById(R.id.txtViewSonuc);
        editTxtSayi= (EditText) findViewById(R.id.editTxtSayi);
        Random rndNumber = new Random();
        randomSayi= rndNumber.nextInt(10)+1;
        System.out.println("random sayi:"+randomSayi);
    }
    @SuppressLint("SetTextI18n")
    public void btnTahminEt(View v){
        String gelenDeger = editTxtSayi.getText().toString();
        if(!TextUtils.isEmpty(gelenDeger)){
            if(kalanHak>0 && !tahminDogrumu){



                if(gelenDeger.equals(String.valueOf(randomSayi))) {
                    sonucGoster("dogru tahmin ettiniz");
                    tahminDogrumu=true;
                }
                else {
                    txtSonuc.setText("yanliş tahmin");
                    editTxtSayi.setText("");
                }
                kalanHak--;

                txtKalanHak.setText("kalan hak:"+kalanHak);
                if(kalanHak==0 && !tahminDogrumu)
                    sonucGoster("hakkiniz bitti");
                editTxtSayi.setText("");
            }
            else
                txtSonuc.setText("oyun bitti.");

    }
        else
            txtSonuc.setText("bos  birakilamaz");
}

    private void sonucGoster(String mesaj) {
        editTxtSayi.setEnabled(false);
        txtSonuc.setText(mesaj);
    }

}

