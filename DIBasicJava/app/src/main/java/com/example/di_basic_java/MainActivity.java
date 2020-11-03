package com.example.di_basic_java;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

// In order to satisfy the dependencies of LoginViewModel, you have to also
        // satisfy the dependencies of all of its dependencies recursively.
        // First, create retrofit which is the dependency of UserRemoteDataSource
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://example.com")
                .build();
//                .create(LoginService.class);

        // Then, satisfy the dependencies of UserRepository
        UserRemoteDataSource remoteDataSource = new UserRemoteDataSource(retrofit);
        UserLocalDataSource localDataSource = new UserLocalDataSource();

        // Now you can create an instance of UserRepository that LoginViewModel needs
        UserRepository userRepository = new UserRepository(localDataSource, remoteDataSource);

        // Lastly, create an instance of LoginViewModel with userRepository
        loginViewModel = new LoginViewModel(userRepository);

    }


}