package ru.smak.mvvm262_2024

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.smak.mvvm262_2024.ui.theme.MVVM262_2024Theme

class MainActivity : ComponentActivity() {

    private val mvm: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MVVM262_2024Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainUI(
                        mvm.v1,
                        mvm.v2,
                        Modifier.padding(innerPadding),
                        mvm::changeV1,
                    ){
                        mvm.v2 = it
                    }
                }
            }
        }
    }
}

@Composable
fun MainUI(
    v1: String,
    v2: String,
    modifier: Modifier = Modifier,
    onV1Change: (String)->Unit = {},
    onV2Change: (String)->Unit = {},
){
    Column(modifier = modifier) {
        Row{
            OutlinedTextField(
                value = v1,
                onValueChange = { onV1Change(it) },
                modifier = Modifier.weight(1f)
            )
            OutlinedTextField(
                value = v2,
                onValueChange = { onV2Change(it) },
                modifier = Modifier.weight(1f)
            )
        }
    }
}