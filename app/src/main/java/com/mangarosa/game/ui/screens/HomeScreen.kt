import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeScreen() {
    val navController = rememberNavController()

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "MENU", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = { navController.navigate("tabuleiro") }, modifier = Modifier.fillMaxWidth()) {
            Text("INICIAR")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = { println("PONTUAÇÃO PARTICIPANTES") }, modifier = Modifier.fillMaxWidth()) {
            Text("PONTUAÇÃO PARTICIPANTES")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = { println("REGRAS DO JOGO") }, modifier = Modifier.fillMaxWidth()) {
            Text("REGRAS DO JOGO")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = { println("SAIR") }, modifier = Modifier.fillMaxWidth()) {
            Text("SAIR")
        }
    }
}
