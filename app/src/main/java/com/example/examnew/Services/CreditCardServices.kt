package com.example.examnew.Services

import com.example.examnew.Model.CreditCard
import retrofit2.http.GET

interface CreditCardServices {
    @GET("CreditCard")
    suspend fun getItem():List<CreditCard>
}