package thiagocury.eti.br.abrigocoracao;


import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragConsultaEvento extends Fragment {

    private TextView tvSaudacaoConsultaEvento;
    private TextView tvTipoEvento;
    private Spinner spTipoEvento;
    private ProgressBar progressEvento;
    private ListView lvEventos;

    private Toolbar toolbar;

    private int posSelec = -1;
    List<Evento> eventosAux;
    private boolean flag = false;

    private ArrayList<Evento> eventos;
    private EventoAdapter adapter;
    private EventoAdapterResumo adapterResumo;
    private EventoJSON eventoJSON;

    private CheckBox chVerResumo;

    private static final String linkEvento = "http://www.abrigocoracao.eco.br/wp-admin/admin-ajax.php?action=get_all_eventos";

    public FragConsultaEvento() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_frag_consulta_evento, container, false);

        tvTipoEvento = (TextView) v.findViewById(R.id.tvTipoEvento);
        tvSaudacaoConsultaEvento = (TextView) v.findViewById(R.id.tvSaudacaoConsultaEvento);
        spTipoEvento = (Spinner) v.findViewById(R.id.spTipoEvento);
        progressEvento = (ProgressBar) v.findViewById(R.id.progressEvento);
        lvEventos = (ListView) v.findViewById(R.id.lvEventos);
        chVerResumo = (CheckBox) v.findViewById(R.id.chVerResumo);

        //Saudação inicial
        tvSaudacaoConsultaEvento.setText(getResources().getString(R.string.tela_consulta_saudacao_eventos));

        //Instanciando o ArrayList
        eventos = new ArrayList<>();
        adapter = new EventoAdapter(getActivity().getBaseContext(), eventos);
        lvEventos.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        //Setando visibilidade das Spinners para invisivel
        spTipoEvento.setVisibility(View.INVISIBLE);
        tvTipoEvento.setVisibility(View.INVISIBLE);
        chVerResumo.setVisibility(View.INVISIBLE);

        CompoundButton.OnCheckedChangeListener itemSelected = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(chVerResumo.isChecked()){
                    //Toast.makeText(getBaseContext(),"voce marcou",Toast.LENGTH_LONG).show();

                    adapterResumo = new EventoAdapterResumo(getActivity().getBaseContext(), eventos);
                    lvEventos.setAdapter(adapterResumo);
                    adapter.notifyDataSetChanged();

                }else{
                    //Toast.makeText(getBaseContext(),"voce DESmarcou",Toast.LENGTH_LONG).show();

                    lvEventos.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }//fecha else
            }//fecha onCheckedChanged
        };//fecha OnCheckedChangeListener

        /*AdapterView.OnItemSelectedListener itemSelected = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }//fecha onItemSelected

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };*/
        chVerResumo.setOnCheckedChangeListener(itemSelected);

        if(verificarConexao()) {
            progressEvento.setVisibility(View.VISIBLE);
            //JSON
            GsonRequest<Evento[]> getEventos =
                    new GsonRequest<Evento[]>(linkEvento, Evento[].class,
                            new Response.Listener<Evento[]>() {
                                @Override
                                public void onResponse(Evento[] response) {
                                    eventosAux = Arrays.asList(response);
                                    for (int i = 0; i < eventosAux.size(); i++) {
                                        Evento e = new Evento();
                                        e.setIdEvento(eventosAux.get(i).getIdEvento());
                                        e.setTitulo(eventosAux.get(i).getTitulo());
                                        e.setDescricao(eventosAux.get(i).getDescricao());
                                        e.setLocal(eventosAux.get(i).getLocal());

                                        //Conversão de data para o padrão brasileiro
                                        e.setData(Util.converterDataBrasil((String)eventosAux.get(i).getData()));

                                        e.setHoraInicio(eventosAux.get(i).getHoraInicio());
                                        e.setHoraFim(eventosAux.get(i).getHoraFim());
                                        e.setTipo(eventosAux.get(i).getTipo());
                                        e.setImagem(eventosAux.get(i).getImagem());
                                        eventos.add(e);
                                    }//fecha for

                                    if(eventosAux.isEmpty()){
//                                        Toast.makeText(
                                        //                                              getBaseContext(),
                                        //"ERRO: " + error.getMessage(),
                                        //                                            getResources().getString(R.string.erro_sem_eventos_inicio),
                                        //                                          Toast.LENGTH_LONG).show();

                                        tvSaudacaoConsultaEvento.setText(getResources().getString(R.string.erro_sem_eventos_inicio));

                                        progressEvento.setVisibility(View.INVISIBLE);
                                        tvTipoEvento.setVisibility(View.INVISIBLE);
                                        chVerResumo.setVisibility(View.INVISIBLE);
                                        spTipoEvento.setVisibility(View.INVISIBLE);
                                    }else {

                                        //Notificando o Adapter a mudança
                                        adapter.notifyDataSetChanged();
                                        progressEvento.setVisibility(View.INVISIBLE);
                                        tvTipoEvento.setVisibility(View.VISIBLE);
                                        chVerResumo.setVisibility(View.VISIBLE);

                                        //Saudação após o download
                                        tvSaudacaoConsultaEvento.setText(getResources().getString(R.string.tela_consulta_saudacao_eventos_finished));

                                        //Listener para as Spinners
                                        spTipoEvento.setVisibility(View.VISIBLE);
                                    }//fecha else

                                    AdapterView.OnItemSelectedListener itemSelected = new AdapterView.OnItemSelectedListener() {
                                        @Override
                                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                            if((spTipoEvento.getSelectedItemPosition() == 0) && flag){
                                                adapter.setEventos(eventos);
                                                adapter.notifyDataSetChanged();
                                                flag = false;
                                            }else {

                                                ArrayList<Evento> eventosFiltro = new ArrayList<>();

                                                //testar o tipo de evento
                                                for (int i = 0; i < eventosAux.size(); i++) {
                                                    if (spTipoEvento.getSelectedItem().toString().equalsIgnoreCase(eventosAux.get(i).getTipo())) {
                                                        eventosFiltro.add(eventosAux.get(i));
                                                    }
                                                }//fecha for

                                                if(eventosFiltro.isEmpty()) {
                                                    Toast.makeText(
                                                            getActivity().getBaseContext(),
                                                            getResources().getString(R.string.erro_sem_eventos),
                                                            Toast.LENGTH_LONG).show();
                                                }//fecha if

                                                adapter.setEventos(eventosFiltro);
                                                adapter.notifyDataSetChanged();
                                                flag = true;
                                            }
                                        }//fecha onItemSelected

                                        @Override
                                        public void onNothingSelected(AdapterView<?> parent) {
                                        }
                                    };

                                    //Setando os listeners
                                    spTipoEvento.setOnItemSelectedListener(itemSelected);
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            // TODO deal with error
                            Toast.makeText(getActivity().getBaseContext(), getResources().getString(R.string.erro_conexao), Toast.LENGTH_LONG).show();
                        }
                    });
            VolleyApplication.getInstance().getRequestQueue().add(getEventos);

            lvEventos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    posSelec = position;
                    //Crouton.makeText(ConsultaPet.this, "posicao: " + posSelec, Style.ALERT).show();
                    Evento e = (Evento) lvEventos.getItemAtPosition(position);

                    Bundle data = new Bundle();
                    data.putSerializable("evento",e);

                    FragDetalheEvento detalhe = new FragDetalheEvento();
                    detalhe.setArguments(data);
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.addToBackStack(null);
                    transaction.replace(R.id.frame1, detalhe);
                    // Commit the transaction
                    transaction.commit();
                }
            });

        }else{
            AlertDialog.Builder msg = new AlertDialog.Builder(getActivity());
            msg.setTitle(getResources().getString(R.string.alert_wifi_titulo));
            msg.setMessage(getResources().getString(R.string.alert_wifi_mensagem));
            msg.setPositiveButton(getResources().getString(R.string.alert_wifi_botao_ok), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    WifiManager wifi = (WifiManager) getActivity().getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                    wifi.setWifiEnabled(true); // Liga o WiFi
                    if (wifi.isWifiEnabled()) {
                        // WiFi está ligado
                        Toast.makeText(getActivity().getBaseContext(),getResources().getString(R.string.wifi_ligado), Toast.LENGTH_LONG).show();
                    }
                }
            });
            msg.show();
        }//fecha

        return v;
    }
    public  boolean verificarConexao() {
        boolean conectado;
        ConnectivityManager conectivtyManager = (ConnectivityManager) getActivity().getBaseContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (conectivtyManager.getActiveNetworkInfo() != null
                && conectivtyManager.getActiveNetworkInfo().isAvailable()
                && conectivtyManager.getActiveNetworkInfo().isConnected()) {
            conectado = true;
        } else {
            conectado = false;
        }
        return conectado;
    }//fecha verificarConexao
}//fecha classe