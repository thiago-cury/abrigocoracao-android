package thiagocury.eti.br.abrigocoracao;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.util.ArrayList;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;
import jp.wasabeef.picasso.transformations.CropSquareTransformation;

/**
 * Created by thiagocury on 21/12/15.
 */
public class EventoAdapter  extends BaseAdapter {

    private Context context;
    private ArrayList<Evento> eventos;
    private LayoutInflater inflater;

    public EventoAdapter(Context context, ArrayList<Evento> eventos) {
        this.context = context;
        this.eventos = eventos;
        this.inflater = LayoutInflater.from(context);
    }

    public void setEventos(ArrayList<Evento> eventos) {
        this.eventos = eventos;
    }

    @Override
    public int getCount() {
        return eventos.size();
    }

    @Override
    public Evento getItem(int position) {
        return eventos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ViewHolder holder;



        if (convertView == null) {
            convertView = inflater.inflate(R.layout.linha_evento, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }//fecha else

        Evento e = getItem(position);

        holder.tvTitulo.setText(e.getTitulo());
        holder.tvDescricao.setText(e.getDescricao());
        holder.tvLocal.setText(e.getLocal());
        holder.tvData.setText(e.getData());
        holder.tvHoraInicio.setText(Util.converterHoraMinuto(e.getHoraInicio()));
        holder.tvHoraFim.setText(Util.converterHoraMinuto(e.getHoraFim()));
        holder.tvTipo.setText(e.getTipo());

        Transformation transformation = new Transformation() {

            @Override
            public Bitmap transform(Bitmap source) {
                int targetWidth = holder.ivImagemEvento.getWidth();

                double aspectRatio = (double) source.getHeight() / (double) source.getWidth();
                int targetHeight = (int) (targetWidth * aspectRatio);
                Bitmap result = Bitmap.createScaledBitmap(source, targetWidth, targetHeight, false);
                if (result != source) {
                    // Same bitmap is returned if sizes are the same
                    source.recycle();
                }
                return result;
            }

            @Override
            public String key() {
                return "transformation" + " desiredWidth";
            }
        };

        Picasso.with(context)
                .load(e.getImagem())
                .placeholder(R.drawable.load)
                .transform(transformation)
                .into(holder.ivImagemEvento);

        return convertView;
    }//fecha getView

    //Classe ViewHolder para performance
    static class ViewHolder {

        ImageView ivImagemEvento;
        TextView tvTitulo;
        TextView tvDescricao;
        TextView tvLocal;
        TextView tvData;
        TextView tvHoraInicio;
        TextView tvHoraFim;
        TextView tvTipo;

        ViewHolder(View v) {

            ivImagemEvento = (ImageView) v.findViewById(R.id.ivImagemEvento);
            tvTitulo = (TextView) v.findViewById(R.id.tvTitulo);
            tvDescricao = (TextView) v.findViewById(R.id.tvDescricao);
            tvLocal = (TextView) v.findViewById(R.id.tvLocal);
            tvData = (TextView) v.findViewById(R.id.tvData);
            tvHoraInicio = (TextView) v.findViewById(R.id.tvHoraInicio);
            tvHoraFim = (TextView) v.findViewById(R.id.tvHoraFim);
            tvTipo = (TextView) v.findViewById(R.id.tvTipo);
        }//fecha ViewHolder
    }//fecha ViewHolder
}//fecha EventoAdapter