package com.example.dondeestadesdecontactos;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity {
	private static final String TAG = "principal";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//cohesionar el interfaz con la implementacion
		final Button btBuscar = (Button)findViewById(R.id.b1);
		final Button btFavoritos = (Button)findViewById(R.id.b2);
		final EditText texto = (EditText)findViewById(R.id.editText1);
		
		//implementar el oyente para el boton buscar
		btBuscar.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				
				Log.v("principal",texto.getText().toString() );
				Intent mapa = new Intent (android.content.Intent.ACTION_VIEW,
						Uri.parse("geo:0.0?q=" + texto.getText().toString()));
								
				startActivity(mapa);
			}
			
		});
		
		
		//implementar el oyente para el boton favoritos
		btFavoritos.setOnClickListener (new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent segundaVentana = new Intent(MainActivity.this,
						Favoritos.class);
				
				startActivityForResult(segundaVentana, 1);//param (activity, RequestCode)
				
			}
			
		});
	}
	

	
	protected void onActivityResult(int arg0, int arg1, Intent arg2) {
		
		final EditText txt = (EditText)findViewById(R.id.editText1);
		
		if((arg0 == 1) &&  (arg1 == RESULT_OK)){//el valor de requestCode y el valor de ResultCode
			
				//asigna el valor de la llave lugar al texto del EditText
				txt.setText(arg2.getStringExtra("lugar"));
			
		}	
	};
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
