package thiagocury.eti.br.abrigocoracao;


import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */

public class FragTelaInicial extends Fragment {

    private Button btnAdoteJa;
    private TextView tvSaud1;
    private TextView tvSaud2;
    private TextView tvSaud3;
    private TextView tvSaud4;

    public FragTelaInicial() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_frag_tela_inicial, container, false);

        //Referencias
        btnAdoteJa = (Button) v.findViewById(R.id.btnAdoteJa);
        tvSaud1 = (TextView) v.findViewById(R.id.frag_tela_inicial_saudacao_1);
        tvSaud2 = (TextView) v.findViewById(R.id.frag_tela_inicial_saudacao_2);
        tvSaud3 = (TextView) v.findViewById(R.id.frag_tela_inicial_saudacao_3);
        tvSaud4 = (TextView) v.findViewById(R.id.frag_tela_inicial_saudacao_4);

        /*data0.putSerializable("titulo", titulo);
        data0.putSerializable("mensagem", mensagem);*/

        if(!getArguments().isEmpty()) {

            if (getArguments().getString("titulo") != null &&
                getArguments().getSerializable("mensagem") != null) {

                String titulo = getArguments().getSerializable("titulo").toString();
                String mensagem = getArguments().getSerializable("mensagem").toString();

                tvSaud1.setText("Atenção mensagem importante!");

                tvSaud2.setText(titulo);
                tvSaud3.setText(mensagem);

                /*Log.d("FRAGTELAINICIAL","FRAGTELAINICIAL: "+titulo);
                Log.d("FRAGTELAINICIAL","FRAGTELAINICIAL: "+mensagem);*/
            }
        }

        btnAdoteJa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragConsultaPet pet = new FragConsultaPet();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                Bundle data = new Bundle();
                data.putSerializable("gambi","gambi");
                pet.setArguments(data);

                transaction.addToBackStack(null);
                transaction.replace(R.id.frame1, pet);
                // Commit the transaction
                transaction.commit();
            }
        });
        return v;
    }//fecha onCreateView
}//fecha classe