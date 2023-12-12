@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.nejlepsipocasi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.Navigation
import androidx.navigation.compose.rememberNavController
import com.example.nejlepsipocasi.ui.theme.NejlepsiPocasiTheme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NejlepsiPocasiTheme {
                // A surface container using the 'background' color from the theme
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                val coroutineScope = rememberCoroutineScope()

                ModalNavigationDrawer(
                    drawerState =  drawerState,
                    drawerContent = {
                            Column(modifier = Modifier
                                .fillMaxHeight()
                                .background(Color.Gray)) {
                                Text(text = "Meníčko")

                        }
                    },
                    gesturesEnabled = true
                ) {
                    val navController = rememberNavController()
                    Scaffold (
                        bottomBar = {
                            NavigationBar {
                                NavigationBarItem(
                                    selected = true,
                                    onClick = { /*TODO*/ },
                                    icon = {
                                        Icon(painter = painterResource(id = R.drawable.ic_snow), contentDescription = "Dnešní počasí")
                                    })
                                NavigationBarItem(
                                    selected = false,
                                    onClick = { /*TODO*/ },
                                    icon = {
                                        Icon(painter = painterResource(id = R.drawable.ic_cloud), contentDescription = "Zítřejší počasí")
                                    })
                            }
                            Text(text = "Tohle je Bottom bar")
                        }
                    ){padding ->
                        Surface(
                            modifier = Modifier
                                .padding(padding)
                                .fillMaxSize(),
                            color = MaterialTheme.colorScheme.background
                        ) {
                            Column {
                                Button(onClick = {
                                    coroutineScope.launch {
                                        drawerState.open()
                                    }
                                }) {
                                    Text(text = "...")
                                }
                                Greeting("Android")
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NejlepsiPocasiTheme {
        Greeting("Android")
    }
}