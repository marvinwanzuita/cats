package com.mawit.cats

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.mawit.cats.api.CatApi
import com.mawit.cats.api.DogApi
import com.mawit.cats.api.RetrofitHelper
import com.mawit.cats.databinding.ActivityMainBinding
import com.mawit.cats.model.Cat
import com.mawit.cats.model.Dog
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val catRetrofit by lazy {
        RetrofitHelper.catRetrofit
    }

    private val dogRetrofit by lazy {
        RetrofitHelper.dogRetrofit
    }

    private var contadorClicks = 0

    private var catList: List<Cat> = listOf()
    private var dogList: List<Dog> = listOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        /*binding.imgCat.setOnClickListener {

            var catUrl = catList!![contadorClicks].url
            var dogUrl = dogList!![contadorClicks].url

            CoroutineScope(Dispatchers.IO).launch {

                withContext(Dispatchers.Main){
                    Picasso.get()
                        .load(catUrl)
                        .into(binding.imgCat)

                    Picasso.get()
                        .load(dogUrl)
                        .into(binding.imgDog)
                }

                contadorClicks++
            }
        }*/

        binding.imgDog.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                recuperar10CatDog()
                mostrarCatDog(contadorClicks)
                contadorClicks++

            }
        }

        binding.imgCat.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                recuperar10CatDog()
                mostrarCatDog(contadorClicks)
                contadorClicks++

            }
        }

    }

    /*override fun onResume() {
        super.onResume()
        CoroutineScope(Dispatchers.IO).launch {
            recuperar10CatDog()
        }
    }*/

    /*private suspend fun recuperarCatDog(){

        var catRetorno: Response<List<Cat>>? = null
        var dogRetorno: Response<List<Dog>>? = null

        try {
            val catApi = catRetrofit.create( CatApi::class.java )
            catRetorno = catApi.catRandom()

            val dogApi = dogRetrofit.create(DogApi::class.java)
            dogRetorno = dogApi.dogRandom()

        } catch (e: Exception){
            e.printStackTrace()
        }

        if (catRetorno != null && dogRetorno != null){
            if (catRetorno.isSuccessful && dogRetorno.isSuccessful){
                val catList = catRetorno.body()
                val catUrl = catList!![0].url

                val dogList = dogRetorno.body()
                val dogUrl = dogList!![0].url


                withContext(Dispatchers.Main){
                    Picasso.get()
                        .load(catUrl)
                        .into(binding.imgCat)

                    Picasso.get()
                        .load(dogUrl)
                        .into(binding.imgDog)
                }
            }
        }

    }*/

    private suspend fun recuperar10CatDog(){

        var catRetorno: Response<List<Cat>>? = null
        var dogRetorno: Response<List<Dog>>? = null

        try {
            val catApi = catRetrofit.create( CatApi::class.java )
            catRetorno = catApi.cat10Random()

            val dogApi = dogRetrofit.create(DogApi::class.java)
            dogRetorno = dogApi.dog10Random()

        } catch (e: Exception){
            Toast.makeText(this, R.string.connection_error, Toast.LENGTH_SHORT).show()
        }

        if (catRetorno != null && dogRetorno != null){
            if (catRetorno.isSuccessful && dogRetorno.isSuccessful){
                catList = catRetorno.body()!!
                dogList = dogRetorno.body()!!
            }
        }

    }

    private suspend fun mostrarCatDog(contadorClicks: Int){

        withContext(Dispatchers.Main){

             Picasso.get()
                .load(catList[contadorClicks].url)
                .into(binding.imgCat)


            Picasso.get()
                .load(dogList[contadorClicks].url)
                .into(binding.imgDog)
        }

    }

    private suspend fun mostrarCatDogFotosCarregadas(contadorClicks: Int){




        withContext(Dispatchers.Main){

            Picasso.get()
                .load(catList[contadorClicks].url)
                .into(binding.imgCat)


            Picasso.get()
                .load(dogList[contadorClicks].url)
                .into(binding.imgDog)


        }

    }


}