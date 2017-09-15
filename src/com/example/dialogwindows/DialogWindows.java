package com.example.dialogwindows;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class DialogWindows extends Activity {

	private Button mainbtn;
	private View CustomView;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		mainbtn = (Button) findViewById(R.id.mainbtn);
		mainbtn.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

				Builder builder=myBuilder(DialogWindows.this);
				final AlertDialog dialog=builder.show();
                //�����Ļ��࣬dialog����ʧ
				dialog.setCanceledOnTouchOutside(false);
//����dialog���button
/*
 * ����btn���ʼ�
 */
				Button ortherbtnemil = (Button)CustomView.findViewById(R.id.ortherbtnemil);
				ortherbtnemil.setOnClickListener(new OnClickListener() {
					public void onClick(View v) {
						
						Toast.makeText(DialogWindows.this, "���ʼ�������", Toast.LENGTH_SHORT).show();
						Intent i = new Intent(Intent.ACTION_SEND);  
						//i.setType("text/plain"); //ģ������ʹ������
						i.setType("message/rfc822") ; // �����ʹ������
						i.putExtra(Intent.EXTRA_EMAIL, new String[]{"asinzuo@qq.com"});  
						i.putExtra(Intent.EXTRA_SUBJECT,"windows���dialog����");  
						i.putExtra(Intent.EXTRA_TEXT,"����");  
						startActivity(Intent.createChooser(i, "ѡ��Ӧ��"));
						dialog.dismiss();
					}
				});
/*
 * ����btn���ʲ���
 */
				Button ortherbtnweb = (Button)CustomView.findViewById(R.id.ortherbtnweb);
				ortherbtnweb.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					
					Toast.makeText(DialogWindows.this, "���ʲ���", Toast.LENGTH_SHORT).show();
					Uri uri = Uri.parse("http://blog.csdn.net/asinzuo");
					Intent intent = new Intent(Intent.ACTION_VIEW, uri);
					startActivity(intent);
					dialog.dismiss();
				}
			});
/*
 * ����imgbtn�ر�dialog			
 */
				ImageButton customviewtvimgCancel=(ImageButton)CustomView.findViewById(R.id.customviewtvimgCancel);
				customviewtvimgCancel.setOnClickListener(new OnClickListener() {
					public void onClick(View v) {
						
					    dialog.dismiss();
					}
				});
			}
		});
	}

	protected Builder myBuilder(DialogWindows dialogWindows) {
		
		final LayoutInflater inflater=this.getLayoutInflater();
		AlertDialog.Builder builder=new AlertDialog.Builder(dialogWindows);
		CustomView=inflater.inflate(R.layout.customview, null);

		return builder.setView(CustomView);
	}

}