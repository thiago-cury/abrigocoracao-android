package thiagocury.eti.br.abrigocoracao;


import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragDoacao extends Fragment {


    public FragDoacao() {
        // Required empty public constructor
    }

    private Button btnDoacaoProdutos;
    private Button btnItensBrecho;
    private Button btnLarCaoTemporario;
    /*private ImageButton btnMoip;*/
    private Button btnPagSeguro;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_frag_doacao, container, false);

        btnDoacaoProdutos = (Button) v.findViewById(R.id.btnDoacaoProdutos);
        /*btnPagSeguro = (Button) v.findViewById(R.id.btnPagSeguro);
        btnLarCaoTemporario = (Button) v.findViewById(R.id.btnLarCao);*/

        btnDoacaoProdutos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle data = new Bundle();
                data.putString("coleta","Coleta de Doações");
                FragContato contato = new FragContato();
                contato.setArguments(data);
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.addToBackStack(null);
                transaction.replace(R.id.frame1, contato);
                // Commit the transaction
                transaction.commit();
            }
        });

        /*btnLarCaoTemporario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle data = new Bundle();
                data.putString("lartemporario","lartemporario");
                FragContato contato = new FragContato();
                contato.setArguments(data);
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.addToBackStack(null);
                transaction.replace(R.id.frame1, contato);
                // Commit the transaction
                transaction.commit();
            }
        });

        btnPagSeguro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://www.101viralatas.com.br/home/content.aspx?t=2&item=5");
                Intent it = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(it);
            }//fecha onClick
        });//fecha btnMoip
        */
        return v;
    }
}