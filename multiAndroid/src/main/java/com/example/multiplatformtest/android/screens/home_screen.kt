import android.annotation.SuppressLint
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.multiplatformtest.android.R
import com.example.multiplatformtest.android.screens.HospitalsList
import com.example.multiplatformtest.android.screens.NotificationScreen
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(modifier = Modifier.width(intrinsicSize = IntrinsicSize.Min)) {
                Image(
                    painter = painterResource(id = R.drawable.rj_logo),
                    modifier = Modifier
                        .width(120.dp)
                        .height(120.dp)
                        .padding(start = 20.dp),
                    contentDescription = null
                )
                Text("Rajasthan Police App", modifier = Modifier.padding(16.dp))
                Divider()
                NavigationDrawerItem(
                    icon = {
                        Icon(
                            Icons.Default.Notifications,
                            contentDescription = "Notification"
                        )
                    },
                    label = { Text(text = "Notifications") },
                    selected = false,
                    onClick = {
                        scope.launch {
                            drawerState.apply {
                                if (isClosed) open() else close()
                            }
                        }
                    }
                )
                NavigationDrawerItem(
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_health_and_safety_24),
                            contentDescription = "Notification"
                        )
                    },
                    label = { Text(text = "Hospitals") },
                    selected = false,
                    onClick = {
                        scope.launch {
                            drawerState.apply {
                                if (isClosed) open() else close()
                            }
                        }
                    }
                )
                // ...other drawer items
            }
        }
    ) {
        // Screen content
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {

                        Text("RJ Police APP")

                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                drawerState.apply {
                                    if (isClosed) open() else close()
                                }
                            }
                        }) {
                            Icon(
                                Icons.Default.Menu,
                                contentDescription = "menu",
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(Icons.Default.ArrowForward, contentDescription = null)
                        }
                    }

                )
            },

            content = { innerPadding ->
                // Main content of the screen goes here
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                ) {
                    HospitalsList()
//                    NotificationScreen()
//                    Text("Hello, this is your main content with a custom drawer!")
                }
            }
        )
    }
}
