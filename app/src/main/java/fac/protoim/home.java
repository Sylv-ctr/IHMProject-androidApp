package fac.protoim;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class home extends AppCompatActivity {


    final String set = "affiche";

    private ImageView croix;
    RelativeLayout save;
    ListView pastListe;
    ListView prochListe;
    ListView maListe;
    TabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        save = (RelativeLayout) findViewById(R.id.vueSaveParti);
        pastListe = (ListView) findViewById(R.id.listUnePast);
        prochListe = (ListView) findViewById(R.id.listProchTabcome);
        maListe = (ListView) findViewById(R.id.listUneCome);
        TabHost host = (TabHost)findViewById(R.id.tabHost);
        host.setup();


        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("À venir");
        spec.setContent(R.id.tab1);
        spec.setIndicator("À venir");
        host.addTab(spec);

        //Tab 2
        spec = host.newTabSpec("Ma sélection");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Ma sélection");
        host.addTab(spec);

        //Tab 3
        spec = host.newTabSpec("Revoir");
        spec.setContent(R.id.tab3);
        spec.setIndicator("Revoir");
        host.addTab(spec);

        final ImageButton profilButton = (ImageButton) findViewById(R.id.profilButton);
        profilButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, profil.class);
                startActivity(intent);
            }
        });


        afficherListeApercu();

        maListe.setOnItemClickListener(listview);
        prochListe.setOnItemClickListener(listview);
        pastListe.setOnItemClickListener(listview);

        Intent intent = getIntent();
        Boolean monbool = intent.getBooleanExtra(set, false);
        if(monbool==true)
            save.setVisibility(View.VISIBLE);


        croix = (ImageView) findViewById(R.id.delbutton);
        croix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(home.this, croix);
                //Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.croixmenu, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        String action = item.getTitle().toString();
                        if (action.equalsIgnoreCase("OUI")) {
                            save.setVisibility(View.INVISIBLE);
                            Toast.makeText(getApplicationContext(), "Vous êtes bien désinscri", Toast.LENGTH_LONG).show();
                        }
                        if (action.equalsIgnoreCase("NON")) {
                        }

                        return true;
                    }
                });

                popup.show(); //showing popup menu
            }
        }); //closing the setOnClickListener method

    }



    OnItemClickListener listview = new OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {

            Intent intent = new Intent(home.this, vueDetail.class);
            startActivity(intent);
        }
    };

    private List<Apercu> genererApercu(){
        List<Apercu> apercu = new ArrayList<Apercu>();
        apercu.add(new Apercu("24","AVR","Exposition","Venez voir les élèves en partiels"));
        apercu.add(new Apercu("26", "AVR", "Concert", "Grosse soirée pour la mi-partiels"));
        apercu.add(new Apercu("29","AVR","Conférence","Assistez aux soutenances"));
        apercu.add(new Apercu("29","AVR","Conférence","Assistez aux soutenances"));
        apercu.add(new Apercu("29","AVR","Conférence","Assistez aux soutenances"));
        return apercu;
    }

    private void afficherListeApercu(){
        List<Apercu> apercu = genererApercu();

        ApercuAdapter adapter = new ApercuAdapter(home.this, apercu);
        maListe.setAdapter(adapter);
        prochListe.setAdapter(adapter);

        pastListe.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
