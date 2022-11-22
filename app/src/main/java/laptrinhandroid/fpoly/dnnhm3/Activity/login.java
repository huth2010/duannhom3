package laptrinhandroid.fpoly.dnnhm3.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLException;

import laptrinhandroid.fpoly.dnnhm3.DAO.DAONhanVien;
import laptrinhandroid.fpoly.dnnhm3.Entity.NhanVien;
import laptrinhandroid.fpoly.dnnhm3.R;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button btnLogin=findViewById(R.id.btnLogin);
        EditText inputEmail=findViewById(R.id.inputEmail);
        inputEmail.setText("haidzkkk.gamil.com");
        EditText inputPassword=findViewById(R.id.inputPassword);
         inputPassword.setText("thanhhai");
        try {
            Log.d("sssw", "onCreate: "+GiaoDienChinh.nhanVien1.getListNhanVien().get(0));
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
 
        inputEmail.setText("haidzkkk.gamil.com");
        inputPassword.setText("thanhhai");
        ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setTitle("Vui lòng chờ ...");
        btnLogin.setOnClickListener(view -> {
            progressDialog.show();
            if(!TextUtils.isEmpty(inputEmail.getText().toString())&&!TextUtils.isEmpty(inputPassword.getText().toString())){
                try {
                    NhanVien nhanVien=new DAONhanVien().checkLogin(inputEmail.getText().toString(),inputPassword.getText().toString());

                    if(nhanVien!=null){
                         Intent intent=new Intent(login.this,GiaoDienChinh.class);
                        intent.putExtra("NV",nhanVien);
                        startActivity(intent);
                    }else{
                        progressDialog.dismiss();
                        Toast.makeText(login.this, "Sai mật khẩu", Toast.LENGTH_SHORT).show();
 

                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    Log.d("fgggg", "onClick: "+e.toString());
                    Toast.makeText(login.this, e.toString()+"", Toast.LENGTH_SHORT).show();
                }

            }

        });
    }
}