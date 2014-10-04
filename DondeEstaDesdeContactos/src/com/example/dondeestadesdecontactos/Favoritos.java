package com.example.dondeestadesdecontactos;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Favoritos extends ActionBarActivity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_favoritos);
		
		/**
		for (int j=1; j <= 10; j++){
		String n = "b"+j;
		String recurso = "R.id."+j;
		final Button n.toString() = (Button)findViewById(n);
		n.setOnClickListener(new devolverLugar());
	    }*/
		
		//cohesionar los botones
		final Button b1 = (Button)findViewById(R.id.b1);
		final Button b2 = (Button)findViewById(R.id.b2);
		final Button b3 = (Button)findViewById(R.id.b3);
		final Button b4 = (Button)findViewById(R.id.b4);
		final Button b5 = (Button)findViewById(R.id.b5);
		final Button b6 = (Button)findViewById(R.id.b6);
		final Button b7 = (Button)findViewById(R.id.b7);
		final Button b8 = (Button)findViewById(R.id.b8);
		final Button b9 = (Button)findViewById(R.id.b9);
		final Button b10 = (Button)findViewById(R.id.b10);
		
		
	
		//declarar los oyentes
		b1.setOnClickListener(new devolverLugar());		
		b2.setOnClickListener(new devolverLugar());	
		b3.setOnClickListener(new devolverLugar());	
		b4.setOnClickListener(new devolverLugar());	
		b5.setOnClickListener(new devolverLugar());	
		b6.setOnClickListener(new devolverLugar());	
		b7.setOnClickListener(new devolverLugar());	
		b8.setOnClickListener(new devolverLugar());	
		b9.setOnClickListener(new devolverLugar());	
		b10.setOnClickListener(new devolverLugar());	
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.favoritos, menu);
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
	
	//clase interna para centralizar el evento click de los botones
	
	class devolverLugar implements Button.OnClickListener {

		@Override
		public void onClick(View v) {
			
			//capturar el boton que ha sido clickado
			Button boton = (Button)findViewById(v.getId()); //v.getId devuelve el recurso del view
															//que en este caso es un boton
			
			//crear el intent de vuelta
			Intent retorno = new Intent();
			retorno.putExtra("lugar", boton.getText());
			
			//estableccer el resultado. Puede ser RESULT_OK si ha ido bien
			//                                    RESULT_CANCEL si el usuario ha cancelado 
			//								      RESULT_FIRST_USER
			setResult(RESULT_OK, retorno);//param (resulado, intent)
		
			finish();//cierra el activity
		}
		
	
	}
}
