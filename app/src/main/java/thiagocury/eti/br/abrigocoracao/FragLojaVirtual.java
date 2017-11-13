package thiagocury.eti.br.abrigocoracao;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragLojaVirtual extends Fragment {


    public FragLojaVirtual() {
        // Required empty public constructor
    }

    private Button btnBotaoLoja;

    private ImageView ivFoto1;
    private ImageView ivFoto2;
    private ImageView ivFoto3;
    private ImageView ivFoto4;
    private ImageView ivFoto5;
    private ImageView ivFoto6;

    private Loja loja;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_frag_loja_virtual, container, false);

        //Buscando Referências
        btnBotaoLoja = (Button) v.findViewById(R.id.btnLojaBotao);
        ivFoto1 = (ImageView) v.findViewById(R.id.ivFoto1);
        ivFoto2 = (ImageView) v.findViewById(R.id.ivFoto2);
        ivFoto3 = (ImageView) v.findViewById(R.id.ivFoto3);
        ivFoto4 = (ImageView) v.findViewById(R.id.ivFoto4);
        ivFoto5 = (ImageView) v.findViewById(R.id.ivFoto5);
        ivFoto6 = (ImageView) v.findViewById(R.id.ivFoto6);

        loja = new Loja();

        Picasso.with(getActivity().getBaseContext())
                .load(loja.getFoto1())
                .placeholder(R.drawable.load)
                //.transform(new CropCircleTransformation())
                .into(ivFoto1);

        Picasso.with(getActivity().getBaseContext())
                .load(loja.getFoto2())
                .placeholder(R.drawable.load)
                //.transform(new CropCircleTransformation())
                .into(ivFoto2);

        Picasso.with(getActivity().getBaseContext())
                .load(loja.getFoto3())
                .placeholder(R.drawable.load)
                //.transform(new CropCircleTransformation())
                .into(ivFoto3);

        Picasso.with(getActivity().getBaseContext())
                .load(loja.getFoto4())
                .placeholder(R.drawable.load)
                //.transform(new CropCircleTransformation())
                .into(ivFoto4);

        Picasso.with(getActivity().getBaseContext())
                .load(loja.getFoto5())
                .placeholder(R.drawable.load)
                //.transform(new CropCircleTransformation())
                .into(ivFoto5);

        Picasso.with(getActivity().getBaseContext())
                .load(loja.getFoto6())
                .placeholder(R.drawable.load)
                //.transform(new CropCircleTransformation())
                .into(ivFoto6);

        View.OnClickListener click = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://www.loja101viralatas.com.br/");
                Intent it = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(it);
            }
        };

        ivFoto1.setOnClickListener(click);
        ivFoto2.setOnClickListener(click);
        ivFoto3.setOnClickListener(click);
        ivFoto4.setOnClickListener(click);
        ivFoto5.setOnClickListener(click);
        ivFoto6.setOnClickListener(click);

        btnBotaoLoja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://www.loja101viralatas.com.br/");
                Intent it = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(it);
            }//fecha onClick
        });//fecha btnBotaoLoja

        return v;
    }//fecha onCreateView
}//fecha classe
