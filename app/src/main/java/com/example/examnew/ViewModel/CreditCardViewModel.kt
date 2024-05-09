package com.example.examnew.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examnew.Model.CreditCard
import kotlinx.coroutines.launch

class CreditCardViewModel:ViewModel() {
private val repository=CreditCardRepository()
private val _creditCards=MutableLiveData<List<CreditCard>>()
val creditcard:LiveData<List<CreditCard>> = _creditCards

    fun fetchCreditCard(){
viewModelScope.launch {
var list=repository.getCreditCards()
_creditCards.value=list
}
    }
}