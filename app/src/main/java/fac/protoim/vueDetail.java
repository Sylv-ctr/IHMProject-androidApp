package fac.protoim;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class vueDetail extends AppCompatActivity {



    final String set = "affiche";
    private FloatingActionButton button1;
    private ImageView button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vue_detail);

        final ImageView backButton = (ImageView) findViewById(R.id.backHome);
        backButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent intent = new Intent(vueDetail.this, home.class);
                startActivity(intent);
            }
        });

        button1 = (FloatingActionButton) findViewById(R.id.fabParticiper);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(vueDetail.this, button1);
                //Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.poopup_menu, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        String action = item.getTitle().toString();
                        if (action.equalsIgnoreCase("Sauvegarder pour plus tard")) {
                            Intent intent = new Intent(getApplicationContext(),home.class);
                            intent.putExtra(set, true);
                            Toast.makeText(getApplicationContext(), "Sauvegardé dans vos favoris", Toast.LENGTH_LONG).show();
                        }
                        if (action.equalsIgnoreCase("S'inscrire")) {
                            Intent intent = new Intent(getApplicationContext(),home.class);
                            intent.putExtra(set, true);
                            Toast.makeText(getApplicationContext(), "Inscription enregistrée, évènement sauvegardé", Toast.LENGTH_LONG).show();
                        }

                        return true;
                    }
                });

                popup.show(); //showing popup menu
            }
        }); //closing the setOnClickListener method





        button2 = (ImageView) findViewById(R.id.map);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(vueDetail.this, button2);
                //Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.map_menu, popup.getMenu());

                popup.show(); //showing popup menu
            }
        }); //closing the setOnClickListener method



    }

}
