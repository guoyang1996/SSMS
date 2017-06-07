package com.example.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
      
    }

	private void init() {
		final EditText  user_et = (EditText) findViewById(R.id.et_user);
		final EditText pw_et = (EditText) findViewById(R.id.et_pw);
		Button login_btn = (Button) findViewById(R.id.btn_login);
		
		login_btn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				if(user_et.getText().length()==0){
					user_et.setError("用户名不能为空");
				}else if(pw_et.getText().length()==0){
					pw_et.setError("密码不能为空");
				}else{
					Toast toast = Toast.makeText(getApplicationContext(), user_et.getText()+""+pw_et.getText(), Toast.LENGTH_LONG);
					toast.show();
					Intent intent=new Intent(LoginActivity.this, MainActivity.class);
					LoginActivity.this.startActivity(intent);
					//此处必须手动，以免返回时返回登录界面
					LoginActivity.this.finish();
				}
				
			}
			
		});
			
	
	}




}
