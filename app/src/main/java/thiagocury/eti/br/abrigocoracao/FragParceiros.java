package thiagocury.eti.br.abrigocoracao;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragParceiros extends Fragment {


    public FragParceiros() {
        // Required empty public constructor
    }

    private ImageView ivPartner1;
    private ImageView ivPartner2;
    private ImageView ivPartner3;
    private ImageView ivPartner4;
    private ImageView ivPartner5;
    private ImageView ivPartner6;
    private ImageView ivPartner7;
    private ImageView ivPartner8;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_frag_parceiros, container, false);

        ivPartner1 = (ImageView) v.findViewById(R.id.ivPartner1);
        /*ivProntoVet = (ImageView) v.findViewById(R.id.ivProntoVet);
        ivDasPpet = (ImageView) v.findViewById(R.id.ivDasPpet);
        ivSOSRacoes = (ImageView) v.findViewById(R.id.ivSOSRacoes);
        ivVetMax = (ImageView) v.findViewById(R.id.ivVetMax);
        ivAgrosul = (ImageView) v.findViewById(R.id.ivAgrosul);*/

        ivPartner1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://www.thiagocury.eti.br");
                Intent it = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(it);
            }
        });

        /*ivProntoVet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://hospitalprontovet.com.br/");
                Intent it = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(it);
            }
        });

        ivDasPpet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://www.dasppet.com.br/rs/index.html");
                Intent it = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(it);
            }
        });

        ivSOSRacoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://sosracoes.com.br/");
                Intent it = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(it);
            }
        });

        ivVetMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://www.clinicavetmax.com.br/");
                Intent it = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(it);
            }
        });

        ivAgrosul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://agrosul.com/");
                Intent it = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(it);
            }
        });*/

        return v;
    }//fecha onCreateView
}//fecha classe