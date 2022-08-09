package ir.ebookline.multitheme;

import android.app.*;
import android.os.*;
import android.view.*;
import android.content.*;

public class MainActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if(this.getSharedPreferences("shp",this.MODE_PRIVATE).getInt("theme",1)==1){
            setTheme(R.style.Theme1);
        }else if(this.getSharedPreferences("shp",this.MODE_PRIVATE).getInt("theme",1)==2){
            setTheme(R.style.Theme2);
        }else if(this.getSharedPreferences("shp",this.MODE_PRIVATE).getInt("theme",1)==3){
            setTheme(R.style.Theme3);
        }
        setContentView(R.layout.main);
    }


    public void changeTheme(View v)
    {
        SharedPreferences shp=getSharedPreferences("shp",MODE_PRIVATE);
        int theme=1;
        if(v.getId()==R.id.btn_theme1){
            theme = 1;
        }else if(v.getId()==R.id.btn_theme2){
            theme = 2;
        }else if(v.getId()==R.id.btn_theme3){
            theme = 3;
        }
        boolean b=shp.edit().putInt("theme",theme).commit();
        Intent i=new Intent(MainActivity.this,MainActivity.class);
        startActivity(i);
        finish();
    }

}
