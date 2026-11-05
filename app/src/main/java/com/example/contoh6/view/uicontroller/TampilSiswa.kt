package com.example.contoh6.view.uicontroller

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import com.example.contoh6.R
import com.example.contoh6.model.Siswa

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TampilSiswa(
    statusUiSiswa: Siswa,
    onBackButtonClicked: () -> Unit
) {
    val items = listOf(
        Pair(
            stringResource(R.string.nama),
            statusUiSiswa.nama
        ),
        Pair(
            stringResource(R.string.gender),
            statusUiSiswa.gender
        ),
        Pair(
            stringResource(R.string.alamat),
            statusUiSiswa.alamat
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.detail),
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    ) { isiRuang ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(isiRuang)
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                items.forEach { item ->

                    Column {
                        Text(
                            text = item.first.uppercase(),
                            fontSize = 16.sp
                        )

                        Text(
                            text = item.second,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                    }

                    HorizontalDivider(
                        thickness = 1.dp
                    )
                }

                Spacer(
                    modifier = Modifier.height(10.dp)
                )

                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = onBackButtonClicked
                ) {
                    Text(stringResource(R.string.back))
                }
            }
        }
    }
}