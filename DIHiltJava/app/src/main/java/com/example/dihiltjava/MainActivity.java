package com.example.dihiltjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Qualifier;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.AndroidEntryPoint;
import dagger.hilt.android.components.ApplicationComponent;
import dagger.hilt.android.scopes.ActivityRetainedScoped;
import dagger.hilt.android.scopes.ActivityScoped;
import dagger.hilt.android.scopes.FragmentScoped;
import kotlin.annotation.AnnotationRetention;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    /**
     * Class Injection = Constructor Injection (Biasa) = Field Injection
     * Ini disebut Field Injection
     * syarat: Konstruktur pada SomeClass harus di beri anotasi @Inject
     * dan Konstruktornya adalah Konstruktor tanpa Parameter
     */
    @Inject
    SomeClass someClass;

    /**
     * Interface Injection
     */
    @Impl1 //Di inject menggunakan Implement1
    @Inject
    SomeInterface someInterface1;

    @Impl2 //Di inject menggunakan Implement2
    @Inject
    SomeInterface someInterface2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView1 = findViewById(R.id.textView1);
        TextView textView2 = findViewById(R.id.textView2);
        TextView textView3 = findViewById(R.id.textView3);
        TextView textView4 = findViewById(R.id.textView4);
        TextView textView5 = findViewById(R.id.textView5);

        textView1.setText(someClass.doAThing());
        textView1.setText(someClass.doSomeOtherThing().get(3));

        textView3.setText(someInterface1.doInterfaceThing());
        textView4.setText(someInterface2.doInterfaceThing());


    }

}

/**
 * https://developer.android.com/training/dependency-injection/hilt-android#component-lifetimes
 * check on th "drawable/activity_scope.png"
 * test using
 *
 * @Singleton
 * @ActivityRetainedScoped
 * @ActivityScope
 * @FragmentScope
 * @ViewScope
 * @ServiceScope
 */

class SomeClass{
    @Inject
    SomeOtherClass someOtherClass;

    @Inject
    public SomeClass(){
    }
    public String doAThing(){
        return "Look I did a thing. oke bos";
    }
    public List<String> doSomeOtherThing(){
        return someOtherClass.doSomeOtherThing();
    }
}

class SomeOtherClass{
    @Inject
    public SomeOtherClass(){
    }

    public List<String> doSomeOtherThing(){
        List<String> myArray = new ArrayList<>();
        myArray.add("Bagus");
        myArray.add("Anis");
        myArray.add("Tyat");
        myArray.add("Ibuk");

        return myArray;
    }
}

/**
 *
 * Look at this
 */
interface SomeInterface{
    public String doInterfaceThing();
}

class SomeImplement1 implements SomeInterface {
    @Inject
    public SomeImplement1(){
    }
    @Override
    public String doInterfaceThing() {
        return "Look I did Usual Interface One 1";
    }
}
class SomeImplement2 implements SomeInterface {
    @Inject
    public SomeImplement2(){
    }
    @Override
    public String doInterfaceThing() {
        return "Look I did Usual Interface Two 2 yes";
    }
}

/**
 *  mendeklarasikan "Interface Injection"
 *  Without this you can't declare @Injection on Interface
 */
@InstallIn(ApplicationComponent.class)
@Module
class MyModuleSingletonNoParams{

    @Impl1
    @Singleton
    @Provides
    SomeInterface provideSomeInterface1(){
        return new SomeImplement1();
    }

    @Impl2
    @Singleton
    @Provides
    SomeInterface provideSomeInterface2(){
        return new SomeImplement2();
    }
}

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@interface   Impl1{}

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@interface   Impl2{}