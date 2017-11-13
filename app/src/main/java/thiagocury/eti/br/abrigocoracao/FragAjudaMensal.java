package thiagocury.eti.br.abrigocoracao;


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
public class FragAjudaMensal extends Fragment {

    private Button btnDoar5;
    private Button btnDoar10;
    private Button btnDoar25;
    private Button btnDoar30;
    private Button btnDoar50;
    private Button btnDoar75;

    public FragAjudaMensal() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_frag_ajuda_mensal, container, false);

        //Referencias
        btnDoar5 = (Button) v.findViewById(R.id.btnDoar5);
        btnDoar10 = (Button) v.findViewById(R.id.btnDoar10);
        btnDoar25 = (Button) v.findViewById(R.id.btnDoar25);
        btnDoar30 = (Button) v.findViewById(R.id.btnDoar30);
        btnDoar50 = (Button) v.findViewById(R.id.btnDoar50);
        btnDoar75 = (Button) v.findViewById(R.id.btnDoar75);

        btnDoar5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://pagseguro.uol.com.br/v2/pre-approvals/request.html?code=41066BC662625E96648CAF85043464A5");
                Intent it5 = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(it5);
            }//fecha onClick
        });//fecha btnDoar5

        btnDoar10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://pagseguro.uol.com.br/v2/pre-approvals/request.html?code=7ED0FFA99B9B050774DC2F946A3F1025");
                Intent it10 = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(it10);
            }//fecha onClick
        });//fecha btnDoar10

        btnDoar25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://pagseguro.uol.com.br/v2/pre-approvals/request.html?code=C32E4D405F5F01133451CF970F11CA3C");
                Intent it25 = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(it25);
            }//fecha onClick
        });//fecha btnDoar25

        btnDoar30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://pagseguro.uol.com.br/v2/pre-approvals/request.html?code=4ABBF233C4C47FE224839FA983995C3A");
                Intent it30 = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(it30);
            }//fecha onClick
        });//fecha btnDoar30

        btnDoar50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://pagseguro.uol.com.br/v2/pre-approvals/request.html?code=09F2FA68C7C77AE8846F8FB52FF2C521");
                Intent it50 = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(it50);
            }//fecha onClick
        });//fecha btnDoar50

        btnDoar75.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://pagseguro.uol.com.br/v2/pre-approvals/request.html?code=48DF4FBED8D8524AA4865FABC5CB5134");
                Intent it75 = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(it75);
            }//fecha onClick
        });//fecha btnDoar75

        return v;
    }

}
