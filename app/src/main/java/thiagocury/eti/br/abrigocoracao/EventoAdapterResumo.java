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

/**
 * Created by thiagocury on 29/01/16.
 */
public class EventoAdapterResumo  extends BaseAdapter {

    private Context context;
    private ArrayList<Evento> eventos;
    private LayoutInflater inflater;

    public EventoAdapterResumo(Context context, ArrayList<Evento> eventos) {
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
            convertView = inflater.inflate(R.layout.linha_resumo_evento, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }//fecha else

        Evento e = getItem(position);

        holder.tvTituloResumo.setText(e.getTitulo());
        holder.tvLocalResumo.setText(e.getLocal());
        holder.tvDataResumo.setText(e.getData());
        holder.tvHoraInicioResumo.setText(Util.converterHoraMinuto(e.getHoraInicio()));
        holder.tvHoraFimResumo.setText(Util.converterHoraMinuto(e.getHoraFim()));

        return convertView;
    }//fecha getView

    //Classe ViewHolder para performance
    static class ViewHolder {

        TextView tvTituloResumo;
        TextView tvLocalResumo;
        TextView tvDataResumo;
        TextView tvHoraInicioResumo;
        TextView tvHoraFimResumo;

        ViewHolder(View v) {
            tvTituloResumo = (TextView) v.findViewById(R.id.tvTituloResumo);
            tvLocalResumo = (TextView) v.findViewById(R.id.tvLocalResumo);
            tvDataResumo = (TextView) v.findViewById(R.id.tvDataResumo);
            tvHoraInicioResumo = (TextView) v.findViewById(R.id.tvHoraInicioResumo);
            tvHoraFimResumo = (TextView) v.findViewById(R.id.tvHoraFimResumo);
        }//fecha ViewHolder
    }//fecha ViewHolder
}//fecha EventoAdapter