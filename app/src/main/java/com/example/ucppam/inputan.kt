package com.example.ucppam

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Notifications

@Preview(showBackground = true)

@Composable
fun ColumnRow(
    modifier: Modifier = Modifier
){
    Column (
        modifier = modifier.fillMaxSize()
    ){
        HeaderSection()
        Biodata()

    }
}

@Composable
fun HeaderSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Blue)
    )
    {
        Row(
            modifier = Modifier.fillMaxWidth().padding(16.dp),

        )
        {
            Box(contentAlignment = Alignment.BottomEnd) {
                Image(
                    painter = painterResource(id = R.drawable.image),
                    contentDescription = null,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(50.dp)
                )
                Icon(
                    Icons.Filled.CheckCircle,
                    contentDescription = null,
                    modifier = Modifier.size(15.dp).background(Color.Blue)
                )
            }
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Hallo,")
                Text(text = "Muhammmad Adri")
            }
            Box(contentAlignment = Alignment.BottomEnd ){
                Icon(
                    Icons.Filled.Notifications,
                    contentDescription = null,
                    modifier = Modifier.size(15.dp).background(Color.Blue),
                    )
            }
        }

    }
}

@Composable
fun Biodata(){
    Column (modifier = Modifier.padding(15.dp))
    {
        Text("Masukkan Biodata Kamu!")
        Text("Silahkan isi data dengan sebenar-benarnya")
    }

    Column (
        modifier = Modifier.padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var email by remember { mutableStateOf("") }
        var notelepon by remember { mutableStateOf("") }
        var alamat by remember { mutableStateOf("") }
        var thnmasuk by remember { mutableStateOf("") }

        var datathnmasuk = listOf("2020", "2021", "2022")

        var confEmail by remember { mutableStateOf("") }
        var confNotelepon by remember { mutableStateOf("") }
        var confAlamat by remember { mutableStateOf("") }
        var confThmasuk by remember { mutableStateOf("") }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
                .size(300.dp)

        )
        {
            Row(
                modifier = Modifier.fillMaxWidth()
            )
            {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                )
                {
                    TextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text(text = "email") },
                        placeholder = { Text(text = "Isi email Anda") },
                        modifier = Modifier.fillMaxWidth()
                            .padding(10.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                    )


                    TextField(
                        value = notelepon,
                        onValueChange = { notelepon = it },
                        label = { Text(text = "notelepon") },
                        placeholder = { Text(text = "Isi no telepon Anda") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )
                    TextField(
                        value = alamat,
                        onValueChange = { alamat = it },
                        label = { Text(text = "Alamat") },
                        placeholder = { Text(text = "Isi alamat anda") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp)

                    )
                    Row(modifier = Modifier.fillMaxWidth()) {
                        datathnmasuk.forEach { selectedGender ->
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                RadioButton(
                                    selected = thnmasuk == selectedGender,
                                    onClick = { thnmasuk = selectedGender }
                                )
                                Text(text = selectedGender)
                            }
                        }
                    }
                }
            }

        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .size(70.dp),
            contentAlignment = Alignment.Center){
            Button(
                onClick ={
                confEmail = email
                confNotelepon = notelepon
                confAlamat = alamat
                confThmasuk = thnmasuk
            },
                modifier = Modifier.fillMaxWidth()
            )
            {
                Text(text = "submit")
            }
        }
        Column(){
            Text(text = "Data Kamu")
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
                    .size(200.dp)
            ){
                Column (modifier = Modifier.padding(15.dp))
                {
                    TampilData(x = "Email", y = confEmail)
                    TampilData(x = "Phone", y = confNotelepon)
                    TampilData(x = "Address", y = confAlamat)
                    TampilData(x = "Year", y = confThmasuk)
                }
            }
        }

    }
}
@Composable
fun TampilData(x : String, y :String){
    Column (
        modifier = Modifier.padding(1.dp)
    ){
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween)
        {
            Text(text = x,
                modifier = Modifier.weight(0.8f))
            Text(text = ":",
                modifier = Modifier.weight(0.2f))
            Text(text = y,
                modifier = Modifier.weight(2f))
        }
    }
}
