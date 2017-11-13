package thiagocury.eti.br.abrigocoracao;


import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragDetalheEvento extends Fragment {

    private TextView tvDetalheEventoTitulo;
    private TextView tvDetalheEventoDescricao;
    private TextView tvDetalheEventoLocal;
    private TextView tvDetalheEventoData;
    private TextView tvDetalheEventoHoraInicio;
    private TextView tvDetalheEventoHoraFim;
    private TextView tvDetalheEventoTipo;
    private ImageView ivDetalheEventoFoto;
    private Button btnDetalheEventoParticipe;

    private Evento e;

    public FragDetalheEvento() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_frag_detalhe_evento, container, false);

        tvDetalheEventoTitulo = (TextView) v.findViewById(R.id.tvDetalheEventoTitulo);
        tvDetalheEventoDescricao = (TextView) v.findViewById(R.id.tvDetalheEventoDescricao);
        tvDetalheEventoLocal = (TextView) v.findViewById(R.id.tvDetalheEventoLocal);
        tvDetalheEventoData = (TextView) v.findViewById(R.id.tvDetalheEventoData);
        tvDetalheEventoHoraInicio = (TextView) v.findViewById(R.id.tvDetalheEventoHoraInicio);
        tvDetalheEventoHoraFim = (TextView) v.findViewById(R.id.tvDetalheEventoHoraFim);
        tvDetalheEventoTipo = (TextView) v.findViewById(R.id.tvDetalheEventoTipo);
        ivDetalheEventoFoto = (ImageView) v.findViewById(R.id.ivDetalheEventoFoto);
        btnDetalheEventoParticipe = (Button) v.findViewById(R.id.btnDetalheEventoParticipe);

        if(getArguments().getSerializable("evento")!=null){

            e = (Evento) getArguments().getSerializable("evento");

            tvDetalheEventoTitulo.setText(e.getTitulo());
            tvDetalheEventoDescricao.setText(e.getDescricao());
            tvDetalheEventoLocal.setText(e.getLocal());
            tvDetalheEventoData.setText(e.getData());
            tvDetalheEventoHoraInicio.setText(e.getHoraInicio());
            tvDetalheEventoHoraFim.setText(e.getHoraFim());
            tvDetalheEventoTipo.setText(e.getTipo());

            /*Toast.makeText(getActivity().getBaseContext(),
                    "TESTE: "+e.getImagem(),
                    Toast.LENGTH_SHORT).show();*/

            Picasso.with(getActivity().getBaseContext())
                    .load(e.getImagem())
                    .placeholder(R.drawable.load)
                    .into(ivDetalheEventoFoto);
        }//fecha if

        btnDetalheEventoParticipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle data = new Bundle();
                data.putString("voluntarios","voluntarios");
                data.putSerializable("e",e);
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
    }//fecha onCreateView
}//fecha FragDetalheEvento
