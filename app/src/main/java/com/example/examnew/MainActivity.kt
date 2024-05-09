package com.example.examnew

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.examnew.ViewModel.CreditCardViewModel
import com.example.examnew.ui.theme.ExamNewTheme

class MainActivity : ComponentActivity() {
private val view:CreditCardViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExamNewTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android",view)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String,viewModel: CreditCardViewModel, modifier: Modifier = Modifier) {
    val creditcard by viewModel.creditcard.observeAsState(emptyList())
    LaunchedEffect(Unit) {
        viewModel.fetchCreditCard()
    }
    LazyColumn() {
        items(creditcard) { card ->
            Text(text = card.id)
            Text(text = card.card_holder)
            Text(text = card.card_number)
            Text(text = card.expiration_date)
            Text(text = card.cvv)
            Spacer(modifier = Modifier.height(15.dp))
        }


    }
}

