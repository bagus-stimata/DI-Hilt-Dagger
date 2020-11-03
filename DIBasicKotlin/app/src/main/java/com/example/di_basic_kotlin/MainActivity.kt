package com.example.di_basic_kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

// In order to satisfy the dependencies of LoginViewModel, you have to also
        // satisfy the dependencies of all of its dependencies recursively.
        // First, create retrofit which is the dependency of UserRemoteDataSource
        val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl("https://example.com")
                .build()
//                .create(LoginService.class);

        // Then, satisfy the dependencies of UserRepository
        val remoteDataSource = UserRemoteDataSource(retrofit)
        val localDataSource = UserLocalDataSource()

        // Now you can create an instance of UserRepository that LoginViewModel needs
        val userRepository: UserRepository = UserRepository(localDataSource, remoteDataSource)
        loginViewModel = LoginViewModel(userRepository)


    }
}