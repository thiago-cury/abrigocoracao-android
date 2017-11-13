package thiagocury.eti.br.abrigocoracao;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Toast;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

public class TelaPrincipal extends AppCompatActivity {

    //Menu
    private Drawer result = null;

    FragmentManager fgm;
    private String titulo = null;
    private String mensagem = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fgm = getFragmentManager();
        Log.d("LOG TELAPRINCIPAL: ","entrada tela principal: "+getFragmentManager().getBackStackEntryCount());

         if (getIntent().getExtras() != null) {

             if(getIntent().getExtras().get("titulo") != null){

                 titulo = getIntent().getExtras().get("titulo").toString();
                 mensagem = getIntent().getExtras().get("mensagem").toString();

                 /*Toast.makeText(getBaseContext(), "Titulo: " + titulo +" - mensagem: "+mensagem, Toast.LENGTH_LONG).show();*/

                 /*for (String key : getIntent().getExtras().keySet()) {
                     Object value = getIntent().getExtras().get(key);
                     //Log.d(TAG, "Key: " + key + " Value: " + value);

                 }*/
             }
         }

        //##MENU
        //Com o cabeçalho
        //####################### SÓ O CABEÇALHO #######################
        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.menu)
                .addProfiles(
                        //new ProfileDrawerItem().withName("Thiago Cury").withEmail("thiagocury@gmail.com").withIcon(getResources().getDrawable(R.mipmap.ic_launcher))
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })
                .build();

        //Menu
        //####################### SÓ O MENU #######################
        result = new DrawerBuilder()
                .withActivity(this)
                //.withAccountHeader(headerResult)
                //.withToolbar(toolbar); //com ToolBar
                //.withActionBarDrawerToggleAnimated(true) //com ActionBar
                //.withActionBarDrawerToggle(true) //com ActionBar
                //.withTranslucentStatusBar(false) //com ActionBar
                //.withActionBarDrawerToggle(true) //com ActionBar
                .withActivity(this)
                .withToolbar(toolbar)
                .withAccountHeader(headerResult)

                //.withSelectedItem(-1) //criar sem deixar pré selecionado
                .addDrawerItems(
                        new PrimaryDrawerItem().withName(R.string.menu_tela_principal).withIdentifier(0).withIcon(R.mipmap.ic_home),
                        new DividerDrawerItem(),
                        /*new PrimaryDrawerItem().withName(R.string.menu_cadastro_pets).withIdentifier(1).withIcon(R.mipmap.ic_launcher),*/
                        new PrimaryDrawerItem().withName(R.string.menu_consulta_pets).withIdentifier(2).withIcon(R.mipmap.ic_nossos_pets),
                        new PrimaryDrawerItem().withName(R.string.menu_eventos).withIdentifier(3).withIcon(R.mipmap.ic_eventos),
                        /*new PrimaryDrawerItem().withName(R.string.menu_lojavirtual).withIdentifier(33).withIcon(R.mipmap.ic_loja_virtual),*/
                        new PrimaryDrawerItem().withName(R.string.menu_doacao).withIdentifier(5).withIcon(R.mipmap.ic_doacao),
                        /*new PrimaryDrawerItem().withName(R.string.menu_docao_mensal).withIdentifier(52).withIcon(R.mipmap.ic_doacao_mensal),*/
                        /*new PrimaryDrawerItem().withName(R.string.menu_apadrinhe_um_peludo).withIdentifier(53).withIcon(R.mipmap.ic_pata),*/
                        new PrimaryDrawerItem().withName(R.string.menu_como_ajudar).withIdentifier(4).withIcon(R.mipmap.ic_como_ajudar),
                        new PrimaryDrawerItem().withName(R.string.menu_historia).withIdentifier(6).withIcon(R.mipmap.ic_historia),
                        new PrimaryDrawerItem().withName(R.string.redeSocial).withIdentifier(61).withIcon(R.mipmap.ic_social_group),
                        new PrimaryDrawerItem().withName(R.string.menu_parceiros).withIdentifier(7).withIcon(R.mipmap.ic_parceiros),
                        new PrimaryDrawerItem().withName(R.string.menu_contato).withIdentifier(8).withIcon(R.mipmap.ic_contato),
                        new PrimaryDrawerItem().withName(R.string.menu_sobre).withIdentifier(9).withIcon(R.mipmap.ic_sobre),
                        new PrimaryDrawerItem().withName(R.string.menu_sair).withIdentifier(10).withIcon(R.mipmap.ic_sair )
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {

                    @Override
                    public boolean onItemClick(AdapterView<?> adapterView, View view, int i, long l, IDrawerItem iDrawerItem) {

                        switch (iDrawerItem.getIdentifier()) {

                            case 0:
                                //Log.d("case 0: ","case 0: "+getFragmentManager().getBackStackEntryCount());
                                FragmentTransaction ft0 = fgm.beginTransaction();
                                FragTelaInicial fti = new FragTelaInicial();

                                if(titulo != null && mensagem != null){
                                    Bundle data0 = new Bundle();
                                    data0.putSerializable("titulo", titulo);
                                    data0.putSerializable("mensagem", mensagem);
                                    fti.setArguments(data0);
                                }else{
                                    Bundle data0 = new Bundle();
                                    data0.putSerializable("titulo", null);
                                    data0.putSerializable("mensagem", null);
                                    fti.setArguments(data0);
                                }

                                ft0.replace(R.id.frame1, fti);
                                ft0.commit();
                                break;
                            case 1:
                                /*Intent it1 = new Intent(TelaPrincipal.this, CadastroPet.class);
                                startActivity(it1);
                                break;*/

                            case 2:
                                FragmentTransaction ft2 = fgm.beginTransaction();
                                FragConsultaPet fcp = new FragConsultaPet();

                                Bundle data2 = new Bundle();
                                data2.putSerializable("gambi","gambi");
                                fcp.setArguments(data2);
                                ft2.replace(R.id.frame1, fcp);
                                ft2.addToBackStack(null);
                                ft2.commit();
                                break;

                            case 3:
                                FragmentTransaction ft3 = fgm.beginTransaction();
                                FragConsultaEvento fce = new FragConsultaEvento();
                                ft3.replace(R.id.frame1, fce);
                                ft3.addToBackStack(null);
                                ft3.commit();
                                break;

                            case 33:
                                FragmentTransaction ft33 = fgm.beginTransaction();
                                FragLojaVirtual flv = new FragLojaVirtual();
                                ft33.replace(R.id.frame1, flv);
                                ft33.addToBackStack(null);
                                ft33.commit();
                                break;

                            case 4:
                                FragmentTransaction ft4 = fgm.beginTransaction();
                                FragComoAjudar fca = new FragComoAjudar();
                                ft4.replace(R.id.frame1, fca);
                                ft4.addToBackStack(null);
                                ft4.commit();
                                break;

                            case 5:
                                FragmentTransaction ft5 = fgm.beginTransaction();
                                FragDoacao fd = new FragDoacao();
                                ft5.replace(R.id.frame1, fd);
                                ft5.addToBackStack(null);
                                ft5.commit();
                                break;

                            case 52:
                                FragmentTransaction ft52 = fgm.beginTransaction();
                                FragAjudaMensal fam = new FragAjudaMensal();
                                ft52.replace(R.id.frame1, fam);
                                ft52.addToBackStack(null);
                                ft52.commit();
                                break;

                            case 53:
                                FragmentTransaction ft53 = fgm.beginTransaction();
                                FragApadrinheUmPeludo faup = new FragApadrinheUmPeludo();
                                ft53.replace(R.id.frame1, faup);
                                ft53.addToBackStack(null);
                                ft53.commit();
                                break;

                            case 6:
                                FragmentTransaction ft6 = fgm.beginTransaction();
                                FragHistoria fh = new FragHistoria();
                                ft6.replace(R.id.frame1, fh);
                                ft6.addToBackStack(null);
                                ft6.commit();
                                break;

                            case 61:
                                FragmentTransaction ft61 = fgm.beginTransaction();
                                FragNossoFacebook fnf = new FragNossoFacebook();
                                ft61.replace(R.id.frame1, fnf);
                                ft61.addToBackStack(null);
                                ft61.commit();
                                break;

                            case 7:
                                FragmentTransaction ft7 = fgm.beginTransaction();
                                FragParceiros fp = new FragParceiros();
                                ft7.replace(R.id.frame1, fp);
                                ft7.addToBackStack(null);
                                ft7.commit();
                                break;

                            case 8:
                                FragmentTransaction ft8 = fgm.beginTransaction();
                                FragContato fc = new FragContato();

                                Bundle data8 = new Bundle();
                                data8.putSerializable("gambi","gambi");
                                fc.setArguments(data8);
                                ft8.replace(R.id.frame1, fc);
                                ft8.addToBackStack(null);
                                ft8.commit();
                                break;

                            case 9:
                                FragmentTransaction ft9 = fgm.beginTransaction();
                                FragSobre fs = new FragSobre();
                                ft9.replace(R.id.frame1, fs);
                                ft9.commit();
                                break;

                            case 10:
                                onBackPressed();
                                break;

                        }//fecha switch
                        return false;
                    }
                }).withOnDrawerListener(new Drawer.OnDrawerListener() {
                    @Override
                    public void onDrawerOpened(View view) {
                    }
                    @Override
                    public void onDrawerClosed(View view) {
                    }
                    @Override
                    public void onDrawerSlide(View view, float v) {
                    }
                })
                .build();
        result.setSelectionByIdentifier(0);//Pré selecionando o primeiro item

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            Window window = this.getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#4CAF50"));
        }//fecha if
    }//fecha onCreate

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() == 1 || getFragmentManager().getBackStackEntryCount() == 0){
            super.onBackPressed();
        } else {
            getFragmentManager().popBackStack();
        }
    }
}//fecha classe