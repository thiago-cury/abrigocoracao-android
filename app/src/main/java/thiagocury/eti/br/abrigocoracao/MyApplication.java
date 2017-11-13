package thiagocury.eti.br.abrigocoracao;

import android.app.Application;
import android.support.multidex.MultiDex;

/**
 * Created by thiagocury on 07/10/16.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
    }
}