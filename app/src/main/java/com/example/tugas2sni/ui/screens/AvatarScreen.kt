package com.example.tugas2sni.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tugas2sni.R

@Composable
fun AvatarScreen() {
	// State untuk setiap komponen wajah
	var isBrowEnabled by remember { mutableStateOf(true) }
	var isEyeEnabled by remember { mutableStateOf(true) }
	var isNoseEnabled by remember { mutableStateOf(true) }
	var isMouthEnabled by remember { mutableStateOf(true) }

	Column(
		modifier = Modifier
			.fillMaxSize()
			.padding(24.dp),
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		// Judul Halaman
		Text(
			text = "Avatar Anda",
			style = MaterialTheme.typography.headlineLarge,
			color = MaterialTheme.colorScheme.primary
		)

		Spacer(modifier = Modifier.height(32.dp))

		// Tumpukan gambar avatar menggunakan Box
		Box(
			modifier = Modifier
				.size(300.dp)
				.align(Alignment.CenterHorizontally)
		) {
			// Base wajah
			Image(
				painter = painterResource(R.drawable.face),
				contentDescription = "Base",
				modifier = Modifier.fillMaxSize()
			)

			// Alis
			if (isBrowEnabled) {
				Image(
					painter = painterResource(R.drawable.brow),
					contentDescription = "Alis",
					modifier = Modifier
						.align(Alignment.Center)
						.size(width = 160.dp, height = 40.dp)
						.offset(y = (-40).dp)
				)
			}

			// Mata
			if (isEyeEnabled) {
				Image(
					painter = painterResource(R.drawable.eye),
					contentDescription = "Mata",
					modifier = Modifier
						.align(Alignment.Center)
						.size(width = 140.dp, height = 50.dp)
						.offset(y = (-15).dp)
				)
			}

			// Hidung
			if (isNoseEnabled) {
				Image(
					painter = painterResource(R.drawable.nose),
					contentDescription = "Hidung",
					modifier = Modifier
						.align(Alignment.Center)
						.size(36.dp)
						.offset(y = (20).dp)
				)
			}

			// Mulut
			if (isMouthEnabled) {
				Image(
					painter = painterResource(R.drawable.mouth),
					contentDescription = "Mulut",
					modifier = Modifier
						.align(Alignment.Center)
						.size(width = 55.dp, height = 60.dp)
						.offset(y = 55.dp)
				)
			}
		}



		Spacer(modifier = Modifier.height(32.dp))

		// Checkbox
		Row(
			modifier = Modifier.fillMaxWidth(),
			horizontalArrangement = Arrangement.SpaceAround
		) {
			CheckboxWithLabel(label = "Alis", checked = isBrowEnabled) { isBrowEnabled = it }
			CheckboxWithLabel(label = "Mata", checked = isEyeEnabled) { isEyeEnabled = it }
			CheckboxWithLabel(label = "Hidung", checked = isNoseEnabled) { isNoseEnabled = it }
			CheckboxWithLabel(label = "Mulut", checked = isMouthEnabled) { isMouthEnabled = it }
		}
	}
}

@Composable
fun CheckboxWithLabel(label: String, checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
	Row(
		verticalAlignment = Alignment.CenterVertically
	) {
		Checkbox(checked = checked, onCheckedChange = onCheckedChange)
		Text(text = label)
	}
}

@Preview(showBackground = true)
@Composable
fun AvatarScreenPreview() {
	AvatarScreen()
}