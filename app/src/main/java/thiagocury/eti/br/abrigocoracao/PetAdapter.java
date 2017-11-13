package thiagocury.eti.br.abrigocoracao;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;

/**
 * Created by LiGi on 27/11/2015.
 */
public class PetAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Pet> pets;
    private LayoutInflater inflater;

    public PetAdapter(Context context, ArrayList<Pet> pets) {
        this.context = context;
        this.pets = pets;
        this.inflater = LayoutInflater.from(context);
    }

    public void setPets(ArrayList<Pet> pets) {
        this.pets = pets;
    }

    @Override
    public int getCount() {
        return pets.size();
    }

    @Override
    public Pet getItem(int position) {
        return pets.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.linha_pet, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }//fecha else

        final Pet p = getItem(position);

        //Log.d("PASSOU NO IF","dog: "+p.getNomePet() +"status: "+p.getStatus());

        holder.tvNome.setText(p.getNomePet());
        holder.tvSexo.setText(p.getSexo() + ", ");
        holder.tvIdade.setText((Util.buscarAnoAtual() - p.getAnoNascAprox()) + " " + context.getString(R.string.classe_pet_adapter_ano) + ", ");
        holder.tvPorte.setText(context.getString(R.string.classe_pet_adapter_porte) + ": " + p.getPorte()+", ");


        holder.tvTemperamento.setText(context.getString(R.string.classe_pet_adapter_temperamento) + ": " + p.getTemperamento());

        /* //Leva o usuário para a tela de contato com as informações do cachorro...
        holder.btnLinhaPetApadrinhar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(context, Contato.class);
                it.putExtra("apadrinhamento", "apadrinhamento");
                it.putExtra("pet", p);
                context.startActivity(it);
            }
        });*/

        //if (p.isTemPadrinho().equalsIgnoreCase("0")) {

            holder.tvTemperamento.setText(context.getString(R.string.classe_pet_adapter_temperamento) + ": " + p.getTemperamento()+", ");
            //holder.tvPadrinho.setVisibility(View.VISIBLE);
            //holder.tvPadrinho.setText(context.getString(R.string.classe_pet_adapter_padrinho));
            //holder.btnLinhaPetApadrinhar.setVisibility(View.VISIBLE);
            //Log.d("TAG PETADAPTER","passou no if: "+p.isTemPadrinho());
        //} else {
            //Log.d("TAG PETADAPTER","passou no else: "+p.isTemPadrinho());
            holder.tvPadrinho.setVisibility(View.INVISIBLE);
            //holder.btnLinhaPetApadrinhar.setVisibility(View.INVISIBLE);
        //}//fecha if*/

        Picasso.with(context)
                .load(p.getFotoPet())
                .placeholder(R.drawable.load)
                .transform(new CropCircleTransformation())
                .into(holder.ivFoto);

        return convertView;
    }//fecha getView

    //Classe ViewHolder para performance
    static class ViewHolder {

        ImageView ivFoto;
        TextView tvCodigo;
        TextView tvNome;
        TextView tvIdade;
        TextView tvSexo;
        TextView tvPorte;
        TextView tvTemperamento;
        TextView tvPadrinho;
        //Button btnLinhaPetApadrinhar;

        ViewHolder(View v) {

            ivFoto = (ImageView) v.findViewById(R.id.ivFoto);
            tvNome = (TextView) v.findViewById(R.id.tvNome);
            tvIdade = (TextView) v.findViewById(R.id.tvIdade);
            tvSexo = (TextView) v.findViewById(R.id.tvSexo);
            tvPorte = (TextView) v.findViewById(R.id.tvPorte);
            tvTemperamento = (TextView) v.findViewById(R.id.tvTemperamento);
            tvPadrinho = (TextView) v.findViewById(R.id.tvPadrinho);
            //btnLinhaPetApadrinhar = (Button) v.findViewById(R.id.btnLinhaPetApadrinhar);

        }//fecha ViewHolder
    }//fecha ViewHolder
}//fecha PetAdapter