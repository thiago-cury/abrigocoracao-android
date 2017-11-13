package thiagocury.eti.br.abrigocoracao;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragApadrinheUmPeludo extends Fragment {


    public FragApadrinheUmPeludo() {
        // Required empty public constructor
    }

    private Button btnApadrinhePeludo;
    private Button btnApadrinhePeludoPeludos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_frag_apadrinhe_um_peludo, container, false);

        btnApadrinhePeludo = (Button) v.findViewById(R.id.btnApadrinhePeludo);
        btnApadrinhePeludoPeludos = (Button) v.findViewById(R.id.btnApadrinhePeludoPeludos);

        btnApadrinhePeludo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle data = new Bundle();
                data.putString("queroserpadrinho","queroserpadrinho");
                FragContato contato = new FragContato();
                contato.setArguments(data);
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.addToBackStack(null);
                transaction.replace(R.id.frame1, contato);
                // Commit the transaction
                transaction.commit();
            }
        });

        btnApadrinhePeludoPeludos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle data = new Bundle();
                data.putString("queroserpadrinho","queroserpadrinho");
                FragConsultaPet consultaPet = new FragConsultaPet();
                consultaPet.setArguments(data);
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.addToBackStack(null);
                transaction.replace(R.id.frame1, consultaPet);
                // Commit the transaction
                transaction.commit();
            }
        });

        return v;
    }
}