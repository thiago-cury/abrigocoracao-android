package thiagocury.eti.br.abrigocoracao;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragContato extends Fragment {

    private EditText etNomeContato;
    private EditText etEmailContato;
    private EditText etTelefoneContato;
    private EditText etMensagemContato;
    private Spinner spAssuntoContato;
    private Button btnEnviarContato;

    private String email;

    public FragContato() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_frag_contato, container, false);

        email = "contato@101viralatas.com.br";

        etNomeContato = (EditText) v.findViewById(R.id.etNomeContato);
        etEmailContato= (EditText) v.findViewById(R.id.etEmailContato);
        etTelefoneContato= (EditText) v.findViewById(R.id.etTelefoneContato);
        etMensagemContato = (EditText) v.findViewById(R.id.etMensagemContato);
        spAssuntoContato = (Spinner) v.findViewById(R.id.spAssuntoContato);
        btnEnviarContato = (Button) v.findViewById(R.id.btnEnviarContato);


        /* Redirecionamento de emails
        0 – Adoção -> adote@101viralatas.com.br
        1 – Agendamento de Visita -> contato@101viralatas.com.br
        2 – Coleta de Doações -> coleta@101viralatas.com.br
        3 – Doação Mensal -> coleta@101viralatas.com.br
        4 – Encomenda de Produto -> vendas@101viralatas.com.br
        5 – Padrinhos -> padrinho@101viralatas.com.br
        6 – Patrocinio no site -> contato@101viralatas.com.br
        7 – Produtos para Brechó -> coleta@101viralatas.com.br
        8 – Voluntário -> voluntarios@101viralatas.com.br
        9 – Lar Temporário -> contato@101viralatas.com.br
        10 – Outro Assunto -> contato@101viralatas.com.br
        11 – Selecione -> opção padrão
        */
        spAssuntoContato.setSelection(11);

        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0) {
                    email = "adote@101viralatas.com.br";
                }else if(position==1){
                    email = "contato@101viralatas.com.br";
                } else if(position==2){
                    email = "coleta@101viralatas.com.br";
                }else if(position==3){
                    email = "coleta@101viralatas.com.br";
                }else if(position==4){
                    email = "vendas@101viralatas.com.br";
                } else if(position==5){
                    email = "padrinho@101viralatas.com.br";
                }else if(position==6){
                    email = "contato@101viralatas.com.br";
                }else if(position==7){
                    email = "coleta@101viralatas.com.br";
                }else if(position==8){
                    email = "voluntarios@101viralatas.com.br";
                }else if(position==9){
                    email = "contato@101viralatas.com.br";
                }else if(position==10){
                    email = "contato@101viralatas.com.br";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };//fecha onItemSelected

        //Setando o listener para Spinner
        spAssuntoContato.setOnItemSelectedListener(itemSelectedListener);

        if(!getArguments().isEmpty()) {

            if (getArguments().getString("adocao") != null &&
                    getArguments().getSerializable("pet") != null) {

                spAssuntoContato.setSelection(0);
                email = "adote@101viralatas.com.br";
                Pet pet = (Pet) getArguments().getSerializable("pet");

                etMensagemContato.setText(getString(R.string.classe_pet_adapter_dados_pet_escolhido) + ":"
                        + "\n" + getString(R.string.classe_pet_adapter_nome) + ": " + pet.getNomePet()
                        + "\n" + getString(R.string.classe_pet_adapter_porte) + ": " + pet.getPorte()
                        + "\n" + getString(R.string.classe_pet_adapter_ano_nasc) + ": " + pet.getAnoNascAprox());
            }

            if (getArguments().getString("apadrinhamento") != null &&
                    getArguments().getSerializable("pet") != null) {

                spAssuntoContato.setSelection(5);
                email = "padrinho@101viralatas.com.br";
                Pet pet = (Pet) getArguments().getSerializable("pet");

                etMensagemContato.setText(getString(R.string.classe_pet_adapter_dados_pet_escolhido) + ":"
                        + "\n" + getString(R.string.classe_pet_adapter_nome) + ": " + pet.getNomePet()
                        + "\n" + getString(R.string.classe_pet_adapter_porte) + ": " + pet.getPorte()
                        + "\n" + getString(R.string.classe_pet_adapter_ano_nasc) + ": " + pet.getAnoNascAprox());
            }

            if (getArguments().getString("sovoluntariar") != null) {

                spAssuntoContato.setSelection(8);
                email = "voluntarios@101viralatas.com.br";
            }

            if (getArguments().getString("lartemporario") != null) {

                spAssuntoContato.setSelection(9);
                email = "contato@101viralatas.com.br";
            }

            if (getArguments().getString("voluntarios") != null &&
                    getArguments().getSerializable("e") != null) {

                spAssuntoContato.setSelection(8);
                email = "voluntarios@101viralatas.com.br";

                Evento e = (Evento) getArguments().getSerializable("e");

                etMensagemContato.setText(getString(R.string.classe_evento_escolhido) + ":"
                        + "\n" + getString(R.string.classe_evento_titulo) + ": " + e.getTitulo()
                        + "\n" + getString(R.string.classe_evento_descricao) + ": " + e.getDescricao()
                        + "\n" + getString(R.string.classe_evento_data) + ": " + e.getData()
                        + "\n" + getString(R.string.classe_evento_local) + ": " + e.getLocal());
            }

            if (getArguments().getString("adocao") != null) {
                spAssuntoContato.setSelection(0);
                email = "adote@101viralatas.com.br";
            }

            if (getArguments().getString("apadrinhamento") != null) {
                spAssuntoContato.setSelection(5);
                email = "padrinho@101viralatas.com.br";
            }

            if (getArguments().getString("coleta") != null) {
                spAssuntoContato.setSelection(2);
                //Toast.makeText(getBaseContext(),getIntent().getStringExtra("coleta"),Toast.LENGTH_LONG).show();
            }

            if (getArguments().getString("brecho") != null) {
                spAssuntoContato.setSelection(8);
            }

        }//fecha if

        btnEnviarContato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //JÁ ESTAVA DESATIVADO
                /*Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto:"+email));//NÃO FUNCIONOU!
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_EMAIL, etEmailContato.getText().toString());
                intent.putExtra(Intent.EXTRA_SUBJECT, "Contato Via NovoApp: "+spAssuntoContato.getSelectedItem().toString());*/

                if(spAssuntoContato.getSelectedItem().toString().equalsIgnoreCase("Selecione")){
                    Toast.makeText(getActivity().getBaseContext(),"Você não selecionou nenhum assunto. &:-/",Toast.LENGTH_LONG).show();
                }else {

                    String msg = null;

                    msg = "Nome: " + etNomeContato.getText().toString() +
                            "\nEmail: " + etEmailContato.getText().toString() +
                            "\nTelefone: " + etTelefoneContato.getText().toString() +
                            "\nAssunto: " + spAssuntoContato.getSelectedItem().toString() +
                            "\nMensagem: " + etMensagemContato.getText().toString();

                    Intent gmail = new Intent(Intent.ACTION_VIEW);
                    gmail.setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail");
                    gmail.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
                    gmail.setData(Uri.parse(etEmailContato.getText().toString()));
                    gmail.putExtra(Intent.EXTRA_SUBJECT, "Contato Via NovoApp: " + spAssuntoContato.getSelectedItem().toString());
                    gmail.setType("plain/text");
                    gmail.putExtra(Intent.EXTRA_TEXT, msg);

                    startActivity(Intent.createChooser(gmail, "Send Email"));
                }//fecha if
            }
        });
        return v;
    }//fecha OnCreateView
}//fecha FragContato