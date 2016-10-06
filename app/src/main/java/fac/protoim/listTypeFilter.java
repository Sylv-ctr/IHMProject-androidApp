package fac.protoim;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class listTypeFilter extends AppCompatActivity {

    ListView mListView;
    String[] prenoms = new String[]{
            "Antoine", "Benoit", "Cyril", "David", "Eloise", "Florent",
            "Gerard", "Hugo", "Ingrid", "Jonathan", "Kevin", "Logan",
            "Mathieu", "Noemie", "Olivia", "Philippe", "Quentin", "Romain",
            "Sophie", "Tristan", "Ulric", "Vincent", "Willy", "Xavier", "Yann", "Zoé"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_type_filter);

        mListView = (ListView) findViewById(R.id.listView1);
        afficherListeTypes();
        //final TextView text = (TextView) findViewById(R.id.testText);
        //final RelativeLayout tab = (RelativeLayout) findViewById(R.id.tab1Filter);

        final Button addButton = (Button) findViewById(R.id.addTypeButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //test si un item est checked alors on créer un textview dans la page profil dans le tabs Type


                Intent intent = new Intent(listTypeFilter.this, profil.class);

                startActivity(intent);

                Toast.makeText(getApplicationContext(),"Filtre(s) ajouté(s)",Toast.LENGTH_LONG).show();




            }
        });

    }

    private void afficherListeNoms() {
        //android.R.layout.simple_list_item_1 est une vue disponible de base dans le SDK android,
        //Contenant une TextView avec comme identifiant "@android:id/text1"

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(listTypeFilter.this, android.R.layout.simple_list_item_1, prenoms);
        mListView.setAdapter(adapter);
    }

    private List<Type> genererType(){
        List<Type> type = new ArrayList<Type>();
        type.add(new Type("Rencontre & Débat"));
        type.add(new Type("Spectacle"));
        type.add(new Type("Conférence"));
        type.add(new Type("Exposition"));
        type.add(new Type("Concert"));
        return type;
    }

    private void afficherListeTypes(){
        List<Type> types = genererType();

        TypeAdapter adapter = new TypeAdapter(listTypeFilter.this, types);
        mListView.setAdapter(adapter);
    }





        /*
        //Récupération du Spinner déclaré dans le fichier main.xml de res/layout
        listType = (ListView)findViewById(R.id.listView1);
        listType.setChoiceMode(listType.CHOICE_MODE_MULTIPLE);
        //Création d'une liste d'élément à mettre dans le Spinner(pour l'exemple)
        List exempleList = new ArrayList();
        exempleList.add("Conférence");
        exempleList.add("Salon");
        exempleList.add("Show");
        exempleList.add("Atelier");
        exempleList.add("Networking");
        exempleList.add("Concert");
        exempleList.add("Exposition");
        exempleList.add("Manifestation culturelle");


		//Le Spinner a besoin d'un adapter pour sa presentation alors on lui passe le context(this) et
		// un fichier de presentation par défaut( android.R.layout.simple_spinner_item)
		// Avec la liste des elements (exemple)


        ArrayAdapter adapter = new ArrayAdapter(
                this,
                android.R.layout.simple_list_item_checked,
                exempleList
        );


        //On definit une présentation du spinner quand il est déroulé         (android.R.layout.simple_spinner_dropdown_item)


        adapter.setDropDownViewResource(android.R.layout.simple_list_item_multiple_choice);
        //Enfin on passe l'adapter au Spinner et c'est tout
        listType.setAdapter(adapter);
        */



}
