package com.example.ucp1

import android.preference.PreferenceActivity.Header
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun ucp(modifier: Modifier = Modifier){

    var asal by remember { mutableStateOf("") }
    var tujuan by remember { mutableStateOf("") }
    var Class by remember { mutableStateOf("") }
    var datePickerState by remember { mutableStateOf("") }

    var confasal by remember { mutableStateOf("") }
    var conftujuan by remember { mutableStateOf("") }
    var confClass by remember { mutableStateOf("") }
    var confdatePickerState by remember { mutableStateOf("") }

    val dataClass = listOf("Ekonomi", "Bussiness")


    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.size(16.dp))
        TextField(
            value = asal,
            onValueChange = { asal = it },
            label = { Text(text = "Asal") },
            placeholder = { Text(text = "masukan Kota Asal") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
        )
        Spacer(modifier = Modifier.size(4.dp))

        Spacer(modifier = Modifier.size(4.dp))
        TextField(
            value = tujuan,
            onValueChange = { tujuan = it },
            label = { Text(text = "Tujuan") },
            placeholder = { Text(text = "masukan Kota Tujuan") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        Spacer(modifier = Modifier.size(4.dp))
        TextField(
            value = datePickerState,
            onValueChange = { datePickerState = it },
            label = { Text(text = "Tanggal") },
            placeholder = { Text(text = "masukan Tanggal") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            horizontalArrangement = Arrangement.Center // Menempatkan radio button di tengah
        ) {
            dataClass.forEach { selectedClass ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(horizontal = 8.dp)
                ) {
                    RadioButton(
                        selected = Class == selectedClass,
                        onClick = { Class = selectedClass }
                    )
                    Text(text = selectedClass)
                }
            }
        }

        Spacer(modifier = Modifier.size(8.dp))
        Button(
            onClick = {
                confasal = asal
                conftujuan = tujuan
                confdatePickerState = datePickerState
                confClass = Class
            },
            modifier = Modifier
                .fillMaxWidth() // Membuat button memanjang sesuai lebar kolom
                .padding(horizontal = 16.dp) // Opsional: memberi padding agar tidak penuh di layar
        ) {
            Text(text = "Submit")
        }

        if (confasal.isNotEmpty() || conftujuan.isNotEmpty() ) {
            Spacer(modifier = Modifier.size(8.dp))
            TampilData(Param = "asal", Argu = confasal)
            TampilData(Param = "tujuan", Argu = conftujuan)
            TampilData(Param = "Tanggal", Argu = confdatePickerState)
            TampilData(Param = "Class", Argu = confClass)
            FotterSection()
            Spacer(modifier = Modifier.size(4.dp))
        }
    }
}



@Composable
fun TampilData(Param: String, Argu: String) {
    Column(modifier = Modifier.padding(vertical = 2.dp)) { // Mengurangi padding agar lebih rapat
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "$Param:",
                modifier = Modifier.weight(0.5f),
                color = Color.Black
            )
            Text(
                text = Argu,
                modifier = Modifier.weight(1.5f),
                color = Color.Black
            )
        }
    }
}

    @Composable
    fun HeaderSection() {
        Box(
            modifier = Modifier
                .fillMaxWidth() // Full lebar
                .background(Color.LightGray)
                .padding(vertical = 6.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "Hallo",
                    color = Color.Black
                )
            }
        }
    }

@Composable
fun FotterSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth() // Full lebar
            .background(Color.Black)
            .padding(vertical = 6.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.kai),
                contentDescription = null,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(50.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "Keberangkatan",
                color = Color.White

            )
        }
    }
}