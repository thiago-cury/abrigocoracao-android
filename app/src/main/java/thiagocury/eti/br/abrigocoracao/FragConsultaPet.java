package thiagocury.eti.br.abrigocoracao;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;
import com.parse.FindCallback;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.android.volley.Response.Listener;
import com.android.volley.Response.ErrorListener;

/**
 * A simple {@link android.app.Fragment} subclass.
 */
public class FragConsultaPet extends Fragment  {

    //Widgets
    private ListView lvListaPets;
    private ArrayList<Pet> pets;
    private ArrayList<Pet> petsPadrinho;
    private TextView tvSaudacaoConsulta;
    private TextView tvTipo;
    private TextView tvSexo;
    private TextView tvPorte;
    private TextView tvIdade;
    private PetAdapter adapter;
    private PetJSON petJSON;

    private Spinner spTipo;
    private Spinner spPorte;
    private Spinner spSexo;
    private Spinner spIdade;

    private Toolbar toolbar;

    private int posSelec = -1;
    private ProgressBar progress;
    List<Pet> petsAux;
    private boolean flag = false;

    private RelativeLayout mRoot;

    private static final String linkPet = "http://www.abrigocoracao.eco.br/wp-admin/admin-ajax.php?action=get_all_animais";

    public FragConsultaPet() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_frag_consulta_pet, container, false);

        //Referencias
        lvListaPets = (ListView) v.findViewById(R.id.lvListaPets);
        //tvSaudacaoConsulta = (TextView) v.findViewById(R.id.tvSaudacaoConsulta);
        tvTipo = (TextView) v.findViewById(R.id.tvTipo);
        tvSexo = (TextView) v.findViewById(R.id.tvSexo);
        tvPorte = (TextView) v.findViewById(R.id.tvPorte);
        tvIdade = (TextView) v.findViewById(R.id.tvIdade);
        progress = (ProgressBar) v.findViewById(R.id.progress);
        spPorte = (Spinner) v.findViewById(R.id.spPorte);
        spTipo = (Spinner) v.findViewById(R.id.spTipo);
        spSexo = (Spinner) v.findViewById(R.id.spSexo);
        spIdade = (Spinner) v.findViewById(R.id.spIdade);
        //mRoot = (RelativeLayout) v.findViewById(R.id.content_tela_principal_rl);

        //Saudação inicial
        //tvSaudacaoConsulta.setText(getResources().getString(R.string.tela_consulta_saudacao));
        //Snackbar.make(mRoot,"SnackBAr Test" , Snackbar.LENGTH_LONG).show();

        Toast.makeText(getActivity().getBaseContext(),
                        getResources().getString(
                            R.string.tela_consulta_saudacao),
                            Toast.LENGTH_SHORT).show();

        //Instanciando o ArrayList
        pets = new ArrayList<>();
        adapter = new PetAdapter(getActivity(), pets);
        lvListaPets.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        //Setando visibilidade das Spinners para invisivel
        spTipo.setVisibility(View.INVISIBLE);
        spPorte.setVisibility(View.INVISIBLE);
        spSexo.setVisibility(View.INVISIBLE);
        spIdade.setVisibility(View.INVISIBLE);
        //Setando visibilidade dos TextViews para invisivel
        tvPorte.setVisibility(View.INVISIBLE);
        tvIdade.setVisibility(View.INVISIBLE);
        tvSexo.setVisibility(View.INVISIBLE);
        tvTipo.setVisibility(View.INVISIBLE);

        if(verificarConexao()) {
            progress.setVisibility(View.VISIBLE);
            //JSON
            GsonRequest<Pet[]> getPets =
                  new GsonRequest<Pet[]>(linkPet, Pet[].class,
                            new Response.Listener<Pet[]>() {
                                @Override
                                public void onResponse(Pet[] response) {
                                    petsAux = Arrays.asList(response);
                                    for (int i = 0; i < petsAux.size(); i++) {
                                        Pet p = new Pet();

                                        p.setIdPet(petsAux.get(i).getIdPet());
                                        p.setQRCodePet(petsAux.get(i).getQRCodePet());
                                        p.setNomePet(petsAux.get(i).getNomePet());
                                        p.setAnoNascAprox(petsAux.get(i).getAnoNascAprox());
                                        p.setSexo(petsAux.get(i).getSexo());
                                        p.setPorte(petsAux.get(i).getPorte());
                                        p.setTemperamento(petsAux.get(i).getTemperamento());
                                        p.setFotoPet(petsAux.get(i).getFotoPet());
                                        p.setTipo(petsAux.get(i).getTipo());
                                        p.setEstaCastrado(petsAux.get(i).isEstaCastrado());
                                        p.setEstaPasseando(petsAux.get(i).isEstaPasseando());
                                        p.setSetor(petsAux.get(i).getSetor());
                                        p.setStatus(petsAux.get(i).getStatus());
                                        p.setHistoria(petsAux.get(i).getHistoria());
                                        p.setNecessidadesEspeciais(petsAux.get(i).getNecessidadesEspeciais());
                                        p.setObs(petsAux.get(i).getObs());
                                        p.setPodePassear(petsAux.get(i).isPodePassear());
                                        p.setDataCadastro(petsAux.get(i).getDataCadastro());
                                        p.setHoraCadastro(petsAux.get(i).getHoraCadastro());
                                        p.setTemPadrinho(petsAux.get(i).isTemPadrinho());

                                        pets.add(p);
                                    }//fecha for

                                    if (petsAux.isEmpty()) {
                                        //mostrarMensagemSemDogs();
                                        tvSaudacaoConsulta.setText(getResources().getString(R.string.tela_consulta_toast_consulta_inicio));

                                        tvPorte.setVisibility(View.INVISIBLE);
                                        tvTipo.setVisibility(View.INVISIBLE);
                                        tvIdade.setVisibility(View.INVISIBLE);
                                        tvSexo.setVisibility(View.INVISIBLE);

                                        spPorte.setVisibility(View.INVISIBLE);
                                        spIdade.setVisibility(View.INVISIBLE);
                                        spSexo.setVisibility(View.INVISIBLE);
                                        spTipo.setVisibility(View.INVISIBLE);

                                        progress.setVisibility(View.INVISIBLE);
                                    }else {

                                        //Notificando o Adapter a mudança
                                        adapter.notifyDataSetChanged();
                                        progress.setVisibility(View.INVISIBLE);

                                        //Saudação após o download
                                        //tvSaudacaoConsulta.setText(getResources().getString(R.string.tela_consulta_saudacao_finished));
                                        Toast.makeText(getActivity().getBaseContext(),
                                                        getResources().getString(
                                                            R.string.tela_consulta_saudacao_finished),
                                                            Toast.LENGTH_SHORT).show();

                                        //Visibilidade para as Spinners
                                        spPorte.setVisibility(View.VISIBLE);
                                        spTipo.setVisibility(View.VISIBLE);
                                        spIdade.setVisibility(View.VISIBLE);
                                        spSexo.setVisibility(View.VISIBLE);
                                        //Visibilidade dos TextViews
                                        tvPorte.setVisibility(View.VISIBLE);
                                        tvIdade.setVisibility(View.VISIBLE);
                                        tvSexo.setVisibility(View.VISIBLE);
                                        tvTipo.setVisibility(View.VISIBLE);

                                    }//fecha else

                                    if (getArguments().getString("queroserpadrinho") != null) {
                                        petsPadrinho = new ArrayList<Pet>();
                                        for (int i = 0; i < pets.size(); i++) {
                                            if (pets.get(i).isTemPadrinho().equalsIgnoreCase("0")) {
                                                petsPadrinho.add(pets.get(i));
                                            }//fecha if
                                        }//fecha for
                                        adapter.setPets(petsPadrinho);
                                        adapter.notifyDataSetChanged();
                                    }//fecha if tela de padrinho

                                    AdapterView.OnItemSelectedListener itemSelected = new AdapterView.OnItemSelectedListener() {
                                        @Override
                                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            /*
            1 1 0 0 -12
            1 1 1 0 -14
            1 1 1 1 -15
            0 0 1 1 -3
            0 1 1 1 -7

            1 1 0 1 -13
            1 0 1 1 -11

            1 0 1 0 -10
            0 1 0 1 -5
            1 0 0 1 -9
            0 1 1 0 -6

            1 0 0 0 -8
            0 1 0 0 -4
            0 0 1 0 -2
            0 0 0 1 -1
            */
                                            ArrayList<Pet> petsFiltro = new ArrayList<>();
                                            ArrayList<Pet> petsFiltroComb = new ArrayList<>();
                                            //Log.d("PROBABILIDADE","instanciou");

                                            if((spPorte.getSelectedItemPosition() == 0) &&
                                                    spTipo.getSelectedItemPosition() == 0 &&
                                                    spIdade.getSelectedItemPosition() == 0 &&
                                                    spSexo.getSelectedItemPosition() == 0 && flag){

                                                adapter.setPets(pets);
                                                adapter.notifyDataSetChanged();
                                                flag = false;
                                                //Log.d("PROBABILIDADE","0000");

                                            }else if(spPorte.getSelectedItemPosition() != 0 &&
                                                    spTipo.getSelectedItemPosition() != 0 &&
                                                    spIdade.getSelectedItemPosition() == 0 &&
                                                    spSexo.getSelectedItemPosition() == 0) {
                                                //Log.d("PROBABILIDADE", "1100");
                                                //Porte - Tipo
                                                for (int i = 0; i < petsAux.size(); i++) {
                                                    if (spPorte.getSelectedItem().toString().equalsIgnoreCase(petsAux.get(i).getPorte()) &&
                                                            spTipo.getSelectedItem().toString().equalsIgnoreCase(petsAux.get(i).getTipo())) {
                                                        petsFiltro.add(petsAux.get(i));
                                                    }//fecha if
                                                }//fecha for
                                                if(petsFiltro.isEmpty()) {
                                                    adapter.setPets(petsFiltro);
                                                    adapter.notifyDataSetChanged();
                                                    //Log.d("PROBABILIDADE", "combinação sem resultado!");
                                                    mostrarMensagem();
                                                }//Finaleira de cada elseif

                                            }else if(spPorte.getSelectedItemPosition() != 0 &&
                                                    spTipo.getSelectedItemPosition() != 0 &&
                                                    spIdade.getSelectedItemPosition() != 0 &&
                                                    spSexo.getSelectedItemPosition() == 0) {
                                                //Log.d("PROBABILIDADE","1110");
                                                //Porte - Tipo - Idade
                                                for (int i = 0; i < petsAux.size(); i++) {
                                                    //Filhote
                                                    if (spPorte.getSelectedItem().toString().equalsIgnoreCase(petsAux.get(i).getPorte()) &&
                                                            spTipo.getSelectedItem().toString().equalsIgnoreCase(petsAux.get(i).getTipo())&&
                                                            spIdade.getSelectedItem().toString().equalsIgnoreCase("Filhote")) {

                                                        if (petsAux.get(i).getAnoNascAprox() == Util.buscarAnoAtual()) {
                                                            petsFiltro.add(petsAux.get(i));
                                                        }

                                                        if (petsAux.get(i).getAnoNascAprox() == (Util.buscarAnoAtual() - 1)) {
                                                            petsFiltro.add(petsAux.get(i));
                                                        }

                                                    }
                                                    //Adulto
                                                    if (spPorte.getSelectedItem().toString().equalsIgnoreCase(petsAux.get(i).getPorte()) &&
                                                            spTipo.getSelectedItem().toString().equalsIgnoreCase(petsAux.get(i).getTipo())&&
                                                            spIdade.getSelectedItem().toString().equalsIgnoreCase("Adulto")) {

                                                        if (petsAux.get(i).getAnoNascAprox() < (Util.buscarAnoAtual() - 1)) {
                                                            petsFiltro.add(petsAux.get(i));
                                                        }

                                                    }
                                                    //Idoso
                                                    if (spPorte.getSelectedItem().toString().equalsIgnoreCase(petsAux.get(i).getPorte()) &&
                                                            spTipo.getSelectedItem().toString().equalsIgnoreCase(petsAux.get(i).getTipo())&&
                                                            spIdade.getSelectedItem().toString().equalsIgnoreCase("Idoso")) {

                                                        if (petsAux.get(i).getAnoNascAprox() < (Util.buscarAnoAtual() - 10)) {
                                                            petsFiltro.add(petsAux.get(i));
                                                        }
                                                    }
                                                }//fecha for
                                                if(petsFiltro.isEmpty()) {
                                                    adapter.setPets(petsFiltro);
                                                    adapter.notifyDataSetChanged();
                                                    //Log.d("PROBABILIDADE", "combinação sem resultado!");
                                                    mostrarMensagem();
                                                }//Finaleira de cada elseif


                                            }else if(spPorte.getSelectedItemPosition() != 0 &&
                                                    spTipo.getSelectedItemPosition() != 0 &&
                                                    spIdade.getSelectedItemPosition() != 0 &&
                                                    spSexo.getSelectedItemPosition() != 0) {
                                                //Log.d("PROBABILIDADE","1111");
                                                //Porte - Tipo - Idade - Sexo
                                                for (int i = 0; i < petsAux.size(); i++) {
                                                    //Filhote
                                                    if (spPorte.getSelectedItem().toString().equalsIgnoreCase(petsAux.get(i).getPorte()) &&
                                                            spTipo.getSelectedItem().toString().equalsIgnoreCase(petsAux.get(i).getTipo())&&
                                                            spSexo.getSelectedItem().toString().equalsIgnoreCase(petsAux.get(i).getSexo())&&
                                                            spIdade.getSelectedItem().toString().equalsIgnoreCase("Filhote")) {

                                                        if (petsAux.get(i).getAnoNascAprox() == Util.buscarAnoAtual()) {
                                                            petsFiltro.add(petsAux.get(i));
                                                        }

                                                        if (petsAux.get(i).getAnoNascAprox() == (Util.buscarAnoAtual() - 1)) {
                                                            petsFiltro.add(petsAux.get(i));
                                                        }

                                                    }
                                                    //Adulto
                                                    if (spPorte.getSelectedItem().toString().equalsIgnoreCase(petsAux.get(i).getPorte()) &&
                                                            spTipo.getSelectedItem().toString().equalsIgnoreCase(petsAux.get(i).getTipo())&&
                                                            spSexo.getSelectedItem().toString().equalsIgnoreCase(petsAux.get(i).getSexo())&&
                                                            spIdade.getSelectedItem().toString().equalsIgnoreCase("Adulto")) {

                                                        if (petsAux.get(i).getAnoNascAprox() < (Util.buscarAnoAtual() - 1)) {
                                                            petsFiltro.add(petsAux.get(i));
                                                        }

                                                    }
                                                    //Idoso
                                                    if (spPorte.getSelectedItem().toString().equalsIgnoreCase(petsAux.get(i).getPorte()) &&
                                                            spTipo.getSelectedItem().toString().equalsIgnoreCase(petsAux.get(i).getTipo())&&
                                                            spSexo.getSelectedItem().toString().equalsIgnoreCase(petsAux.get(i).getSexo())&&
                                                            spIdade.getSelectedItem().toString().equalsIgnoreCase("Idoso")) {

                                                        if (petsAux.get(i).getAnoNascAprox() < (Util.buscarAnoAtual() - 10)) {
                                                            petsFiltro.add(petsAux.get(i));
                                                        }
                                                    }
                                                }//fecha for
                                                if(petsFiltro.isEmpty()) {
                                                    adapter.setPets(petsFiltro);
                                                    adapter.notifyDataSetChanged();
                                                    //Log.d("PROBABILIDADE", "combinação sem resultado!");
                                                    mostrarMensagem();
                                                }//Finaleira de cada elseif

                                            }else if(spPorte.getSelectedItemPosition() == 0 &&
                                                    spTipo.getSelectedItemPosition() == 0 &&
                                                    spIdade.getSelectedItemPosition() != 0 &&
                                                    spSexo.getSelectedItemPosition() != 0) {
                                                //Log.d("PROBABILIDADE","0011");
                                                //Idade - Sexo
                                                for (int i = 0; i < petsAux.size(); i++) {
                                                    //Filhote
                                                    if (spSexo.getSelectedItem().toString().equalsIgnoreCase(petsAux.get(i).getSexo())&&
                                                            spIdade.getSelectedItem().toString().equalsIgnoreCase("Filhote")) {

                                                        if (petsAux.get(i).getAnoNascAprox() == Util.buscarAnoAtual()) {
                                                            petsFiltro.add(petsAux.get(i));
                                                        }

                                                        if (petsAux.get(i).getAnoNascAprox() == (Util.buscarAnoAtual() - 1)) {
                                                            petsFiltro.add(petsAux.get(i));
                                                        }

                                                    }
                                                    //Adulto
                                                    if (spSexo.getSelectedItem().toString().equalsIgnoreCase(petsAux.get(i).getSexo())&&
                                                            spIdade.getSelectedItem().toString().equalsIgnoreCase("Adulto")) {

                                                        if (petsAux.get(i).getAnoNascAprox() < (Util.buscarAnoAtual() - 1)) {
                                                            petsFiltro.add(petsAux.get(i));
                                                        }

                                                    }
                                                    //Idoso
                                                    if (spSexo.getSelectedItem().toString().equalsIgnoreCase(petsAux.get(i).getSexo())&&
                                                            spIdade.getSelectedItem().toString().equalsIgnoreCase("Idoso")) {

                                                        if (petsAux.get(i).getAnoNascAprox() < (Util.buscarAnoAtual() - 10)) {
                                                            petsFiltro.add(petsAux.get(i));
                                                        }
                                                    }
                                                }//fecha for
                                                if(petsFiltro.isEmpty()) {
                                                    adapter.setPets(petsFiltro);
                                                    adapter.notifyDataSetChanged();
                                                    //Log.d("PROBABILIDADE", "combinação sem resultado!");
                                                    mostrarMensagem();
                                                }//Finaleira de cada elseif

                                            }else if(spPorte.getSelectedItemPosition() == 0 &&
                                                    spTipo.getSelectedItemPosition() != 0 &&
                                                    spIdade.getSelectedItemPosition() != 0 &&
                                                    spSexo.getSelectedItemPosition() != 0) {
                                                //Log.d("PROBABILIDADE","0111");
                                                //Tipo - Idade - Sexo
                                                for (int i = 0; i < petsAux.size(); i++) {
                                                    //Filhote
                                                    if (spTipo.getSelectedItem().toString().equalsIgnoreCase(petsAux.get(i).getTipo())&&
                                                            spSexo.getSelectedItem().toString().equalsIgnoreCase(petsAux.get(i).getSexo())&&
                                                            spIdade.getSelectedItem().toString().equalsIgnoreCase("Filhote")) {

                                                        if (petsAux.get(i).getAnoNascAprox() == Util.buscarAnoAtual()) {
                                                            petsFiltro.add(petsAux.get(i));
                                                        }

                                                        if (petsAux.get(i).getAnoNascAprox() == (Util.buscarAnoAtual() - 1)) {
                                                            petsFiltro.add(petsAux.get(i));
                                                        }

                                                    }
                                                    //Adulto
                                                    if (spTipo.getSelectedItem().toString().equalsIgnoreCase(petsAux.get(i).getTipo())&&
                                                            spSexo.getSelectedItem().toString().equalsIgnoreCase(petsAux.get(i).getSexo())&&
                                                            spIdade.getSelectedItem().toString().equalsIgnoreCase("Adulto")) {

                                                        if (petsAux.get(i).getAnoNascAprox() < (Util.buscarAnoAtual() - 1)) {
                                                            petsFiltro.add(petsAux.get(i));
                                                        }

                                                    }
                                                    //Idoso
                                                    if (spTipo.getSelectedItem().toString().equalsIgnoreCase(petsAux.get(i).getTipo())&&
                                                            spSexo.getSelectedItem().toString().equalsIgnoreCase(petsAux.get(i).getSexo())&&
                                                            spIdade.getSelectedItem().toString().equalsIgnoreCase("Idoso")) {

                                                        if (petsAux.get(i).getAnoNascAprox() < (Util.buscarAnoAtual() - 10)) {
                                                            petsFiltro.add(petsAux.get(i));
                                                        }
                                                    }
                                                }//fecha for
                                                if(petsFiltro.isEmpty()) {
                                                    adapter.setPets(petsFiltro);
                                                    adapter.notifyDataSetChanged();
                                                    //Log.d("PROBABILIDADE", "combinação sem resultado!");
                                                    mostrarMensagem();
                                                }//Finaleira de cada elseif

                                            }else if(spPorte.getSelectedItemPosition() != 0 &&
                                                    spTipo.getSelectedItemPosition() == 0 &&
                                                    spIdade.getSelectedItemPosition() != 0 &&
                                                    spSexo.getSelectedItemPosition() == 0) {
                                                //Log.d("PROBABILIDADE","1010");
                                                //Porte - Idade
                                                for (int i = 0; i < petsAux.size(); i++) {
                                                    //Filhote
                                                    if (spPorte.getSelectedItem().toString().equalsIgnoreCase(petsAux.get(i).getPorte())&&
                                                            spIdade.getSelectedItem().toString().equalsIgnoreCase("Filhote")) {

                                                        if (petsAux.get(i).getAnoNascAprox() == Util.buscarAnoAtual()) {
                                                            petsFiltro.add(petsAux.get(i));
                                                        }

                                                        if (petsAux.get(i).getAnoNascAprox() == (Util.buscarAnoAtual() - 1)) {
                                                            petsFiltro.add(petsAux.get(i));
                                                        }

                                                    }
                                                    //Adulto
                                                    if (spPorte.getSelectedItem().toString().equalsIgnoreCase(petsAux.get(i).getPorte())&&
                                                            spIdade.getSelectedItem().toString().equalsIgnoreCase("Adulto")) {

                                                        if (petsAux.get(i).getAnoNascAprox() < (Util.buscarAnoAtual() - 1)) {
                                                            petsFiltro.add(petsAux.get(i));
                                                        }

                                                    }
                                                    //Idoso
                                                    if (spPorte.getSelectedItem().toString().equalsIgnoreCase(petsAux.get(i).getPorte())&&
                                                            spIdade.getSelectedItem().toString().equalsIgnoreCase("Idoso")) {

                                                        if (petsAux.get(i).getAnoNascAprox() < (Util.buscarAnoAtual() - 10)) {
                                                            petsFiltro.add(petsAux.get(i));
                                                        }
                                                    }
                                                }//fecha for
                                                if(petsFiltro.isEmpty()) {
                                                    adapter.setPets(petsFiltro);
                                                    adapter.notifyDataSetChanged();
                                                    //Log.d("PROBABILIDADE", "combinação sem resultado!");
                                                    mostrarMensagem();
                                                }//Finaleira de cada elseif

                                            }else if(spPorte.getSelectedItemPosition() == 0 &&
                                                    spTipo.getSelectedItemPosition() != 0 &&
                                                    spIdade.getSelectedItemPosition() == 0 &&
                                                    spSexo.getSelectedItemPosition() != 0) {
                                                //Log.d("PROBABILIDADE","0101");
                                                //Tipo - Sexo
                                                for (int i = 0; i < petsAux.size(); i++) {
                                                    if (spTipo.getSelectedItem().toString().equalsIgnoreCase(petsAux.get(i).getTipo()) &&
                                                            spSexo.getSelectedItem().toString().equalsIgnoreCase(petsAux.get(i).getSexo())) {
                                                        petsFiltro.add(petsAux.get(i));
                                                    }//fecha if
                                                }//fecha for
                                                if(petsFiltro.isEmpty()) {
                                                    adapter.setPets(petsFiltro);
                                                    adapter.notifyDataSetChanged();
                                                    //Log.d("PROBABILIDADE", "combinação sem resultado!");
                                                    mostrarMensagem();
                                                }//Finaleira de cada elseif

                                            }else if(spPorte.getSelectedItemPosition() != 0 &&
                                                    spTipo.getSelectedItemPosition() == 0 &&
                                                    spIdade.getSelectedItemPosition() == 0 &&
                                                    spSexo.getSelectedItemPosition() != 0) {
                                                //Log.d("PROBABILIDADE","1001");
                                                //Porte - Sexo
                                                for (int i = 0; i < petsAux.size(); i++) {
                                                    if (spPorte.getSelectedItem().toString().equalsIgnoreCase(petsAux.get(i).getPorte()) &&
                                                            spSexo.getSelectedItem().toString().equalsIgnoreCase(petsAux.get(i).getSexo())) {
                                                        petsFiltro.add(petsAux.get(i));
                                                    }//fecha if
                                                }//fecha for
                                                if(petsFiltro.isEmpty()) {
                                                    adapter.setPets(petsFiltro);
                                                    adapter.notifyDataSetChanged();
                                                    //Log.d("PROBABILIDADE", "combinação sem resultado!");
                                                    mostrarMensagem();
                                                }//Finaleira de cada elseif

                                            }else if(spPorte.getSelectedItemPosition() == 0 &&
                                                    spTipo.getSelectedItemPosition() != 0 &&
                                                    spIdade.getSelectedItemPosition() != 0 &&
                                                    spSexo.getSelectedItemPosition() == 0) {
                                                //Log.d("PROBABILIDADE","0110");
                                                //Tipo - Idade
                                                for (int i = 0; i < petsAux.size(); i++) {
                                                    //Filhote
                                                    if (spTipo.getSelectedItem().toString().equalsIgnoreCase(petsAux.get(i).getTipo())&&
                                                            spIdade.getSelectedItem().toString().equalsIgnoreCase("Filhote")) {

                                                        if (petsAux.get(i).getAnoNascAprox() == Util.buscarAnoAtual()) {
                                                            petsFiltro.add(petsAux.get(i));
                                                        }

                                                        if (petsAux.get(i).getAnoNascAprox() == (Util.buscarAnoAtual() - 1)) {
                                                            petsFiltro.add(petsAux.get(i));
                                                        }

                                                    }
                                                    //Adulto
                                                    if (spTipo.getSelectedItem().toString().equalsIgnoreCase(petsAux.get(i).getTipo())&&
                                                            spIdade.getSelectedItem().toString().equalsIgnoreCase("Adulto")) {

                                                        if (petsAux.get(i).getAnoNascAprox() < (Util.buscarAnoAtual() - 1)) {
                                                            petsFiltro.add(petsAux.get(i));
                                                        }

                                                    }
                                                    //Idoso
                                                    if (spTipo.getSelectedItem().toString().equalsIgnoreCase(petsAux.get(i).getTipo())&&
                                                            spIdade.getSelectedItem().toString().equalsIgnoreCase("Idoso")) {

                                                        if (petsAux.get(i).getAnoNascAprox() < (Util.buscarAnoAtual() - 10)) {
                                                            petsFiltro.add(petsAux.get(i));
                                                        }
                                                    }
                                                }//fecha for
                                                if(petsFiltro.isEmpty()) {
                                                    adapter.setPets(petsFiltro);
                                                    adapter.notifyDataSetChanged();
                                                    //Log.d("PROBABILIDADE", "combinação sem resultado!");
                                                    mostrarMensagem();
                                                }//Finaleira de cada elseif

                                            }else if(spPorte.getSelectedItemPosition() != 0 &&
                                                    spTipo.getSelectedItemPosition() != 0 &&
                                                    spIdade.getSelectedItemPosition() == 0 &&
                                                    spSexo.getSelectedItemPosition() != 0) {
                                                //Log.d("PROBABILIDADE","1101");
                                                //Porte - Tipo - Sexo
                                                for (int i = 0; i < petsAux.size(); i++) {
                                                    if (spPorte.getSelectedItem().toString().equalsIgnoreCase(petsAux.get(i).getPorte()) &&
                                                            spTipo.getSelectedItem().toString().equalsIgnoreCase(petsAux.get(i).getTipo()) &&
                                                            spSexo.getSelectedItem().toString().equalsIgnoreCase(petsAux.get(i).getSexo())) {
                                                        petsFiltro.add(petsAux.get(i));
                                                    }//fecha if
                                                }//fecha for
                                                if(petsFiltro.isEmpty()) {
                                                    adapter.setPets(petsFiltro);
                                                    adapter.notifyDataSetChanged();
                                                    //Log.d("PROBABILIDADE", "combinação sem resultado!");
                                                    mostrarMensagem();
                                                }//Finaleira de cada elseif

                                            }else if(spPorte.getSelectedItemPosition() != 0 &&
                                                    spTipo.getSelectedItemPosition() == 0 &&
                                                    spIdade.getSelectedItemPosition() != 0 &&
                                                    spSexo.getSelectedItemPosition() != 0) {
                                                //Log.d("PROBABILIDADE","1011");
                                                //Porte - Idade - Sexo
                                                for (int i = 0; i < petsAux.size(); i++) {
                                                    //Filhote
                                                    if (spPorte.getSelectedItem().toString().equalsIgnoreCase(petsAux.get(i).getPorte())&&
                                                            spSexo.getSelectedItem().toString().equalsIgnoreCase(petsAux.get(i).getSexo())&&
                                                            spIdade.getSelectedItem().toString().equalsIgnoreCase("Filhote")) {

                                                        if (petsAux.get(i).getAnoNascAprox() == Util.buscarAnoAtual()) {
                                                            petsFiltro.add(petsAux.get(i));
                                                        }

                                                        if (petsAux.get(i).getAnoNascAprox() == (Util.buscarAnoAtual() - 1)) {
                                                            petsFiltro.add(petsAux.get(i));
                                                        }

                                                    }
                                                    //Adulto
                                                    if (spPorte.getSelectedItem().toString().equalsIgnoreCase(petsAux.get(i).getPorte())&&
                                                            spSexo.getSelectedItem().toString().equalsIgnoreCase(petsAux.get(i).getSexo())&&
                                                            spIdade.getSelectedItem().toString().equalsIgnoreCase("Adulto")) {

                                                        if (petsAux.get(i).getAnoNascAprox() < (Util.buscarAnoAtual() - 1)) {
                                                            petsFiltro.add(petsAux.get(i));
                                                        }

                                                    }
                                                    //Idoso
                                                    if (spPorte.getSelectedItem().toString().equalsIgnoreCase(petsAux.get(i).getPorte())&&
                                                            spSexo.getSelectedItem().toString().equalsIgnoreCase(petsAux.get(i).getSexo())&&
                                                            spIdade.getSelectedItem().toString().equalsIgnoreCase("Idoso")) {

                                                        if (petsAux.get(i).getAnoNascAprox() < (Util.buscarAnoAtual() - 10)) {
                                                            petsFiltro.add(petsAux.get(i));
                                                        }
                                                    }
                                                }//fecha for
                                                if(petsFiltro.isEmpty()) {
                                                    adapter.setPets(petsFiltro);
                                                    adapter.notifyDataSetChanged();
                                                    //Log.d("PROBABILIDADE", "combinação sem resultado!");
                                                    mostrarMensagem();
                                                }//Finaleira de cada elseif


                                            }else  if(spPorte.getSelectedItemPosition() != 0 &&
                                                    spTipo.getSelectedItemPosition() == 0 &&
                                                    spIdade.getSelectedItemPosition() == 0 &&
                                                    spSexo.getSelectedItemPosition() == 0) {
                                                //Log.d("PROBABILIDADE","1000");
                                                //Porte
                                                for (int i = 0; i < petsAux.size(); i++) {
                                                    if (spPorte.getSelectedItem().toString().equalsIgnoreCase(petsAux.get(i).getPorte())) {
                                                        petsFiltro.add(petsAux.get(i));
                                                    }//fecha if
                                                }//fecha for
                                                if(petsFiltro.isEmpty()) {
                                                    adapter.setPets(petsFiltro);
                                                    adapter.notifyDataSetChanged();
                                                    //Log.d("PROBABILIDADE", "combinação sem resultado!");
                                                    mostrarMensagem();
                                                }//Finaleira de cada elseif

                                            }else  if(spPorte.getSelectedItemPosition() == 0 &&
                                                    spTipo.getSelectedItemPosition() != 0 &&
                                                    spIdade.getSelectedItemPosition() == 0 &&
                                                    spSexo.getSelectedItemPosition() == 0) {
                                                //Log.d("PROBABILIDADE","0100");
                                                //Tipo
                                                for (int i = 0; i < petsAux.size(); i++) {
                                                    if (spTipo.getSelectedItem().toString().equalsIgnoreCase(petsAux.get(i).getTipo())) {
                                                        petsFiltro.add(petsAux.get(i));
                                                    }//fecha if
                                                }//fecha for
                                                if(petsFiltro.isEmpty()) {
                                                    adapter.setPets(petsFiltro);
                                                    adapter.notifyDataSetChanged();
                                                    //Log.d("PROBABILIDADE", "combinação sem resultado!");
                                                    mostrarMensagem();
                                                }//Finaleira de cada elseif

                                            }else  if(spPorte.getSelectedItemPosition() == 0 &&
                                                    spTipo.getSelectedItemPosition() == 0 &&
                                                    spIdade.getSelectedItemPosition() != 0 &&
                                                    spSexo.getSelectedItemPosition() == 0) {
                                                //Log.d("PROBABILIDADE","0010");
                                                for (int i = 0; i < petsAux.size(); i++) {
                                                    //Filhote
                                                    if (spIdade.getSelectedItem().toString().equalsIgnoreCase("Filhote")) {
                                                        if (petsAux.get(i).getAnoNascAprox() == Util.buscarAnoAtual()) {
                                                            petsFiltro.add(petsAux.get(i));
                                                        }
                                                        if (petsAux.get(i).getAnoNascAprox() == (Util.buscarAnoAtual() - 1)) {
                                                            petsFiltro.add(petsAux.get(i));
                                                        }
                                                    }

                                                    //Adulto
                                                    if (spIdade.getSelectedItem().toString().equalsIgnoreCase("Adulto")) {
                                                        if (petsAux.get(i).getAnoNascAprox() < (Util.buscarAnoAtual() - 1)) {
                                                            petsFiltro.add(petsAux.get(i));
                                                        }

                                                    }

                                                    //Idoso
                                                    if (spIdade.getSelectedItem().toString().equalsIgnoreCase("Idoso")) {
                                                        if (petsAux.get(i).getAnoNascAprox() < (Util.buscarAnoAtual() - 10)) {
                                                            petsFiltro.add(petsAux.get(i));
                                                        }
                                                    }
                                                }//fecha for
                                                if(petsFiltro.isEmpty()) {
                                                    adapter.setPets(petsFiltro);
                                                    adapter.notifyDataSetChanged();
                                                    //Log.d("PROBABILIDADE", "combinação sem resultado!");
                                                    mostrarMensagem();
                                                }//Finaleira de cada elseif

                                            }else  if(spPorte.getSelectedItemPosition() == 0 &&
                                                    spTipo.getSelectedItemPosition() == 0 &&
                                                    spIdade.getSelectedItemPosition() == 0 &&
                                                    spSexo.getSelectedItemPosition() != 0) {
                                                //Log.d("PROBABILIDADE", "0001");
                                                //Sexo
                                                for (int i = 0; i < petsAux.size(); i++) {
                                                    if (spSexo.getSelectedItem().toString().equalsIgnoreCase(petsAux.get(i).getSexo())) {
                                                        petsFiltro.add(petsAux.get(i));
                                                    }//fecha if
                                                }//fecha for
                                                if(petsFiltro.isEmpty()) {
                                                    adapter.setPets(petsFiltro);
                                                    adapter.notifyDataSetChanged();
                                                    //Log.d("PROBABILIDADE", "combinação sem resultado!");
                                                    mostrarMensagem();
                                                }//Finaleira de cada elseif
                                            }//fecha else

                                            flag = true;
                                            if(petsFiltro.isEmpty() &&
                                                    spPorte.getSelectedItemPosition() == 0 &&
                                                    spTipo.getSelectedItemPosition() == 0 &&
                                                    spIdade.getSelectedItemPosition() == 0 &&
                                                    spSexo.getSelectedItemPosition() == 0) {

                                                //Log.d("PROBABILIDADE", "escolheu todos de novo!");
                                                adapter.setPets(pets);
                                                adapter.notifyDataSetChanged();
                                            }

                                            if(!petsFiltro.isEmpty()) {
                                                adapter.setPets(petsFiltro);
                                                adapter.notifyDataSetChanged();
                                                //Log.d("PROBABILIDADE", "setou os dogs");
                                            }
                                        }//fecha onItemSelected

                                        @Override
                                        public void onNothingSelected(AdapterView<?> parent) {

                                        }
                                    };

                                    //Setando os listeners
                                    spPorte.setOnItemSelectedListener(itemSelected);
                                    spTipo.setOnItemSelectedListener(itemSelected);
                                    spSexo.setOnItemSelectedListener(itemSelected);
                                    spIdade.setOnItemSelectedListener(itemSelected);
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            // TODO deal with error
                            Toast.makeText(
                                    getActivity(),
                                    //"ERRO: " + error.getMessage(),
                                    getResources().getString(R.string.erro_conexao),
                                    Toast.LENGTH_LONG).show();

                        }
                    });
            VolleyApplication.getInstance().getRequestQueue().add(getPets);

            lvListaPets.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    posSelec = position;

                    Pet p = (Pet) lvListaPets.getItemAtPosition(position);
                    Bundle data = new Bundle();
                    data.putSerializable("pet",p);

                    FragDetalhePet detalhe = new FragDetalhePet();
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
                        Toast.makeText(
                                getActivity(),
                                getResources().getString(R.string.wifi_ligado),
                                Toast.LENGTH_LONG).show();

                    }
                }
            });
            msg.show();
        }//fecha
        return v;
    }
    public void mostrarMensagem(){
        Toast.makeText(
                getActivity().getBaseContext(),
                getResources().getString(R.string.tela_consulta_toast_consulta_invalida),
                Toast.LENGTH_LONG).show();
    }

    public void mostrarMensagemSemDogs(){
        Toast.makeText(
                getActivity().getBaseContext(),
                getResources().getString(R.string.tela_consulta_toast_consulta_inicio),
                Toast.LENGTH_SHORT).show();
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
}//fecha fecha classe FragConsultaPet