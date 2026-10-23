package com.example.pertemuan6.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.pertemuan6.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormIsian(
    OnSubmitBtnClick: () -> Unit
) {
    // State agar form bisa diketik dan dipilih
    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jenisKelaminTerpilih by remember { mutableStateOf("Laki-laki") }
    val jenisK = listOf("Laki-laki", "Perempuan")

    Scaffold(modifier = Modifier,
        topBar = {
            TopAppBar(
                title = { Text(stringResource(id = R.string.home), color = Color.White) },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = colorResource(id = R.color.teal_700)
                )
            )
        }
    ) { isiRuang ->
        Column(
            modifier = Modifier.padding(isiRuang),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Input Nama Lengkap (Bisa diketik)
            OutlinedTextField(
                value = nama,
                onValueChange = { nama = it },
                singleLine = true,
                modifier = Modifier.padding(top = 20.dp).width(250.dp),
                label = { Text(text = "Nama Lengkap") },
            )

            // Garis Pertama (Atas)
            HorizontalDivider(
                modifier = Modifier.padding(20.dp).width(250.dp),
                thickness = 1.dp,
                color = Color.Red
            )


            Row {
                jenisK.forEach { item ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .selectable(
                                selected = (jenisKelaminTerpilih == item),
                                onClick = { jenisKelaminTerpilih = item }
                            )
                            .padding(end = 16.dp)
                    ) {
                        RadioButton(
                            selected = (jenisKelaminTerpilih == item),
                            onClick = { jenisKelaminTerpilih = item }
                        )
                        Text(text = item)
                    }
                }
            }

            // Garis Kedua (Bawah)
            HorizontalDivider(
                modifier = Modifier.padding(20.dp).width(250.dp),
                thickness = 1.dp,
                color = Color.Red
            )

            // Input Alamat (Bisa diketik)
            OutlinedTextField(
                value = alamat,
                onValueChange = { alamat = it },
                singleLine = true,
                modifier = Modifier.width(250.dp),
                label = { Text(text = "Alamat") },
            )

            Spacer(modifier = Modifier.height(30.dp))

            Button(
                modifier = Modifier.fillMaxWidth(1f).padding(all = 25.dp),
                onClick = OnSubmitBtnClick
            ) {
                Text(stringResource(id = R.string.submit))
            }
        }
    }
}