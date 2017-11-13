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

import com.squareup.picasso.Picasso;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragDetalhePet extends Fragment {

    private TextView tvNome;
    private TextView tvIdade;
    private TextView tvSexo;
    private TextView tvPorte;
    private TextView tvTemperamento;
    private TextView tvHistoria;
    private ImageView ivFoto;
    private Button btnAdote;
    private Button btnDetalhePetApadrinhePeludo;

    private Pet pet;

    public FragDetalhePet() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_frag_detalhe_pet, container, false);

        tvNome = (TextView) v.findViewById(R.id.tvNomefragDetalhe);
        tvIdade = (TextView) v.findViewById(R.id.tvIdadefragDetalhe);
        tvSexo = (TextView) v.findViewById(R.id.tvSexofragDetalhe);
        tvPorte = (TextView) v.findViewById(R.id.tvPortefragDetalhe);
        tvTemperamento = (TextView) v.findViewById(R.id.tvTemperamentofragDetalhe);
        tvHistoria = (TextView) v.findViewById(R.id.tvHistoriafragDetalhe);
        ivFoto = (ImageView) v.findViewById(R.id.ivFotofragDetalhe);
        btnAdote = (Button) v.findViewById(R.id.btnAdotefragDetalhe);
        btnDetalhePetApadrinhePeludo = (Button) v.findViewById(R.id.btnDetalhePetApadrinhePeludofragDetalhe);

        tvHistoria.setVisibility(View.INVISIBLE);

        pet = (Pet) getArguments().getSerializable("pet");

        if(pet != null){

            tvNome.setText(pet.getNomePet());
            tvIdade.setText(getResources().getString(R.string.tela_detalhe_pet_idade)+" " + (Util.buscarAnoAtual() - pet.getAnoNascAprox()) + " Ano(s), ");
            tvSexo.setText(pet.getSexo()+", ");
            tvPorte.setText(getResources().getString(R.string.tela_detalhe_pet_porte)+" " + pet.getPorte()+", ");
            tvTemperamento.setText(getResources().getString(R.string.tela_detalhe_pet_temperamento)+" " + pet.getTemperamento());

            //if(pet.isTemPadrinho().equalsIgnoreCase("0")) {
                //btnDetalhePetApadrinhePeludo.setVisibility(View.VISIBLE);
            //}else{
                btnDetalhePetApadrinhePeludo.setVisibility(View.INVISIBLE);
            //}//fecha if

            if(!pet.getHistoria().equalsIgnoreCase("Historia não cadastrada.")){
                tvHistoria.setText(getResources().getString(R.string.tela_detalhe_pet_historia)+": "+pet.getHistoria());
                tvHistoria.setVisibility(View.VISIBLE);
            }

            if(pet.getTemperamento().equalsIgnoreCase("Outros")) {
                tvTemperamento.setVisibility(View.INVISIBLE);
            }

            Picasso.with(getActivity().getBaseContext())
                    .load(pet.getFotoPet())
                    .placeholder(R.drawable.load)
                    .transform(new CropCircleTransformation())
                    .into(ivFoto);
        }//fecha if

        btnAdote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle data = new Bundle();
                data.putString("adocao","Adoção");
                data.putSerializable("pet",pet);
                FragContato contato = new FragContato();
                contato.setArguments(data);
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.addToBackStack(null);
                transaction.replace(R.id.frame1, contato);
                // Commit the transaction
                transaction.commit();
            }
        });

        btnDetalhePetApadrinhePeludo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle data = new Bundle();
                data.putString("apadrinhamento","apadrinhamento");
                data.putSerializable("pet",pet);
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
}//fecha classe