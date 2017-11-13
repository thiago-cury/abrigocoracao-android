package thiagocury.eti.br.abrigocoracao;


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
public class FragComoAjudar extends Fragment {


    public FragComoAjudar() {
        // Required empty public constructor
    }

    private Button btnVoluntariadoQueroVoluntariar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_frag_como_ajudar, container, false);

        btnVoluntariadoQueroVoluntariar = (Button) v.findViewById(R.id.btnVoluntariadoQueroVoluntariar);

        btnVoluntariadoQueroVoluntariar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle data = new Bundle();
                data.putString("sovoluntariar","sovoluntariar");
                FragContato contato = new FragContato();
                contato.setArguments(data);
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.addToBackStack(null);
                transaction.replace(R.id.frame1, contato);
                // Commit the transaction
                transaction.commit();
            }
        });
        return v;
    }
}
