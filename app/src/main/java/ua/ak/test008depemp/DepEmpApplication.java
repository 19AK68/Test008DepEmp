package ua.ak.test008depemp;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by София on 02.03.2018.
 */

public class DepEmpApplication  extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
//        RealmConfiguration config = new RealmConfiguration.Builder().name("myrealm.realm").build();
//        Realm.setDefaultConfiguration(config);
    }
}
