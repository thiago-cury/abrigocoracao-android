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
public class FragNossoFacebook extends Fragment {


    public FragNossoFacebook() {
        // Required empty public constructor
    }

    private ImageView facebook;
    private ImageView instagram;
    private ImageView twitter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_frag_nosso_facebook, container, false);

        facebook = (ImageView) v.findViewById(R.id.Facebook);
        instagram = (ImageView) v.findViewById(R.id.Instagram);
        twitter = (ImageView) v.findViewById(R.id.Twitter);

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri1 = Uri.parse("https://www.facebook.com/abrigocoracao");
                Intent it1 = new Intent(Intent.ACTION_VIEW, uri1);
                startActivity(it1);
            }//fecha onClick
        });//fecha Facebook

        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.instagram.com/abrigocoracao/");
                Intent it = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(it);
            }//fecha onClick
        });//fecha Instagram

        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("#");
                Intent it = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(it);
            }//fecha onClick
        });//fecha Twitter

        return v;
    }//fecha onCreateView
}//fecha classe
