package com.example.examnew.ViewModel

import com.example.examnew.Model.CreditCard
import com.example.examnew.Services.CreditCardServices
import com.example.examnew.Services.RetrofitInstance

class CreditCardRepository {
    private val creditcardservices:CreditCardServices=RetrofitInstance.creditCardServices
suspend fun getCreditCards():List<CreditCard>{
    return creditcardservices.getItem()
}
}