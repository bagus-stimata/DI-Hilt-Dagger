package com.example.di_basic_kotlin

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

class MainViewModel @ViewModelInject constructor(private val repoItemMapper: RepoItemMapper) : ViewModel() {
//class MainViewModel : ViewModel() {

    @Inject
    lateinit var someClass: SomeClass

    fun testAja() {
        println("Test aja")
        println("result: ${repoItemMapper.doAThing()}")
    }

}

class RepoItemMapper @Inject constructor(){

    fun doAThing(): String{
        return "result: Repo Item Mapper Ini"
    }
}


class SomeClass @Inject constructor(){

    fun doAThing(): String{
        return "result: Look I did a Thing"
    }

}


