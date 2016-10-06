package fac.protoim;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TabHost;

import java.util.ArrayList;
import java.util.List;

public class profil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);


        final Switch showFilter = (Switch)findViewById(R.id.activFilter);
        final Switch showNotif = (Switch)findViewById(R.id.activNotif);
        final Switch activSync = (Switch)findViewById(R.id.activSynchroCalendar);
        final Switch activSms = (Switch)findViewById(R.id.activSMSService);
        final TabHost host = (TabHost)findViewById(R.id.tabHostFilter);
        host.setup();

        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("Type");
        spec.setContent(R.id.tab1Filter);
        spec.setIndicator("Type");
        host.addTab(spec);

        //Tab 2
        spec = host.newTabSpec("Thème");
        spec.setContent(R.id.tab2Filter);
        spec.setIndicator("Thème");
        host.addTab(spec);

        //Tab 3
        spec = host.newTabSpec("Lieu");
        spec.setContent(R.id.tab3Filter);
        spec.setIndicator("Lieu");
        host.addTab(spec);
        /*
        Spinner spinner;
        //Récupération du Spinner déclaré dans le fichier main.xml de res/layout
        spinner = (Spinner)findViewById(R.id.listeDerFiltre);
        //Création d'une liste d'élément à mettre dans le Spinner(pour l'exemple)
        List exempleList = new ArrayList();
        exempleList.add("Assinie");
        exempleList.add("Bassam");
        exempleList.add("Abidjan");

		/*Le Spinner a besoin d'un adapter pour sa presentation alors on lui passe le context(this) et
                un fichier de presentation par défaut( android.R.layout.simple_spinner_item)
		Avec la liste des elements (exemple) */
        /*
        ArrayAdapter adapter = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                exempleList
        );


               /* On definit une présentation du spinner quand il est déroulé         (android.R.layout.simple_spinner_dropdown_item) */
        /*
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Enfin on passe l'adapter au Spinner et c'est tout
        spinner.setAdapter(adapter);
        */


        ImageView img = (ImageView) findViewById(R.id.backHome);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(profil.this, home.class);
                startActivity(intent);
            }
        });

        FloatingActionButton fab1 = (FloatingActionButton) findViewById(R.id.fabTab1);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(profil.this, listTypeFilter.class);
                startActivity(intent);
            }
        });

        FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.fabTab2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        FloatingActionButton fab3 = (FloatingActionButton) findViewById(R.id.fabTab3);
        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        showFilter.setChecked(true);
        showFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (showFilter.isChecked()) {
                    host.getTabWidget().getChildAt(0).setVisibility(View.VISIBLE);
                    host.getTabWidget().getChildAt(1).setVisibility(View.VISIBLE);
                    host.getTabWidget().getChildAt(2).setVisibility(View.VISIBLE);
                    host.setVisibility(View.VISIBLE);
                } else {
                    host.getTabWidget().getChildAt(0).setVisibility(View.GONE);
                    host.getTabWidget().getChildAt(1).setVisibility(View.GONE);
                    host.getTabWidget().getChildAt(2).setVisibility(View.GONE);
                    host.setVisibility(View.GONE);

                }
            }
        });

        showNotif.setChecked(true);
        showNotif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(showNotif.isChecked()){
                    activSms.setVisibility(View.VISIBLE);
                    activSync.setVisibility(View.VISIBLE);
                } else {
                    activSms.setVisibility(View.GONE);
                    activSync.setVisibility(View.GONE);

                }
            }
        });


    }

}
