package com.nexauren.dreamforge

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Collections
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Ink = Color(0xFF0B1020)
private val Panel = Color(0xFF151D32)
private val Accent = Color(0xFF9B8CFF)
private val Mint = Color(0xFF66E8C5)
private val Muted = Color(0xFFAAB4CC)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme(
                colorScheme = darkColorScheme(
                    background = Ink,
                    surface = Panel,
                    primary = Accent,
                    secondary = Mint,
                    onBackground = Color.White,
                    onSurface = Color.White
                )
            ) {
                GeneratorScreen(
                    onGenerate = {
                        Toast.makeText(
                            this,
                            "A interface está pronta. Falta ligar o serviço de geração de imagens por IA.",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                )
            }
        }
    }
}

@Composable
private fun GeneratorScreen(onGenerate: () -> Unit) {
    var prompt by remember { mutableStateOf("") }
    var selectedStyle by remember { mutableStateOf("Cinematic") }
    var ratio by remember { mutableStateOf("1:1") }
    var activeTab by remember { mutableStateOf("Create") }
    val styles = listOf("Cinematic", "Anime", "Realistic", "3D", "Illustration", "Logo")

    Scaffold(
        containerColor = Ink,
        bottomBar = {
            NavigationBar(containerColor = Panel, contentColor = Color.White) {
                NavigationBarItem(
                    selected = activeTab == "Create",
                    onClick = { activeTab = "Create" },
                    icon = { Icon(Icons.Default.AutoAwesome, contentDescription = null) },
                    label = { Text("Create") }
                )
                NavigationBarItem(
                    selected = activeTab == "Gallery",
                    onClick = { activeTab = "Gallery" },
                    icon = { Icon(Icons.Default.Collections, contentDescription = null) },
                    label = { Text("Gallery") }
                )
                NavigationBarItem(
                    selected = activeTab == "Settings",
                    onClick = { activeTab = "Settings" },
                    icon = { Icon(Icons.Default.Settings, contentDescription = null) },
                    label = { Text("Settings") }
                )
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(
                    Brush.verticalGradient(
                        listOf(Color(0xFF19183A), Ink, Ink)
                    )
                )
                .padding(horizontal = 20.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(Modifier.height(18.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(44.dp)
                        .background(
                            Brush.linearGradient(listOf(Accent, Mint)),
                            RoundedCornerShape(14.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.Default.Image, contentDescription = null, tint = Ink)
                }
                Spacer(Modifier.width(12.dp))
                Column(Modifier.weight(1f)) {
                    Text("DreamForge", fontSize = 21.sp, fontWeight = FontWeight.ExtraBold)
                    Text("AI IMAGE STUDIO", color = Mint, fontSize = 10.sp, letterSpacing = 2.sp)
                }
                Surface(color = Color(0xFF253B43), shape = RoundedCornerShape(50)) {
                    Text("BETA", color = Mint, fontSize = 11.sp, modifier = Modifier.padding(horizontal = 11.dp, vertical = 6.dp))
                }
            }

            Spacer(Modifier.height(30.dp))
            Text("Imagine it.", fontSize = 36.sp, fontWeight = FontWeight.Black, lineHeight = 40.sp)
            Text("Create it.", fontSize = 36.sp, fontWeight = FontWeight.Black, color = Mint, lineHeight = 40.sp)
            Spacer(Modifier.height(10.dp))
            Text(
                "Transform your ideas into stunning visuals with AI.",
                color = Muted,
                fontSize = 15.sp
            )

            Spacer(Modifier.height(25.dp))
            Text("YOUR PROMPT", fontSize = 11.sp, color = Muted, letterSpacing = 1.5.sp, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(9.dp))
            Surface(
                color = Panel,
                shape = RoundedCornerShape(20.dp),
                border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFF303A56))
            ) {
                Column(Modifier.fillMaxWidth().padding(15.dp)) {
                    Box(Modifier.fillMaxWidth().heightIn(min = 115.dp)) {
                        if (prompt.isEmpty()) {
                            Text(
                                "A futuristic city at sunset, cinematic lighting, highly detailed...",
                                color = Muted
                            )
                        }
                        BasicTextField(
                            value = prompt,
                            onValueChange = { prompt = it },
                            modifier = Modifier.fillMaxWidth(),
                            textStyle = androidx.compose.ui.text.TextStyle(
                                color = Color.White,
                                fontSize = 15.sp,
                                lineHeight = 22.sp
                            )
                        )
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Describe what you imagine", color = Muted, fontSize = 11.sp)
                        Text("${prompt.length}/500", color = Muted, fontSize = 11.sp)
                    }
                }
            }

            Spacer(Modifier.height(23.dp))
            Text("CHOOSE A STYLE", fontSize = 11.sp, color = Muted, letterSpacing = 1.5.sp, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth().horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                styles.forEach { style ->
                    FilterChip(
                        selected = selectedStyle == style,
                        onClick = { selectedStyle = style },
                        label = { Text(style) },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = Accent,
                            selectedLabelColor = Color.White,
                            labelColor = Muted
                        )
                    )
                }
            }

            Spacer(Modifier.height(20.dp))
            Text("IMAGE RATIO", fontSize = 11.sp, color = Muted, letterSpacing = 1.5.sp, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(10.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(9.dp)) {
                listOf("1:1", "3:4", "9:16", "16:9").forEach { option ->
                    val chosen = ratio == option
                    Surface(
                        onClick = { ratio = option },
                        color = if (chosen) Color(0xFF302B5A) else Panel,
                        shape = RoundedCornerShape(12.dp),
                        border = androidx.compose.foundation.BorderStroke(
                            1.dp,
                            if (chosen) Accent else Color(0xFF303A56)
                        )
                    ) {
                        Text(
                            option,
                            modifier = Modifier.padding(horizontal = 15.dp, vertical = 11.dp),
                            color = if (chosen) Color.White else Muted,
                            fontWeight = if (chosen) FontWeight.Bold else FontWeight.Normal
                        )
                    }
                }
            }

            Spacer(Modifier.height(25.dp))
            Button(
                onClick = onGenerate,
                modifier = Modifier.fillMaxWidth().height(56.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Accent)
            ) {
                Icon(Icons.Default.AutoAwesome, contentDescription = null)
                Spacer(Modifier.width(9.dp))
                Text("Generate image", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            }
            Spacer(Modifier.height(10.dp))
            Text(
                "Style: $selectedStyle  •  Ratio: $ratio",
                modifier = Modifier.fillMaxWidth(),
                color = Muted,
                fontSize = 12.sp
            )
            Spacer(Modifier.height(26.dp))
            Text("YOUR CREATIVE SPACE", fontSize = 11.sp, color = Muted, letterSpacing = 1.5.sp, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(10.dp))
            Surface(color = Panel, shape = RoundedCornerShape(18.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        Modifier.size(50.dp).background(Color(0xFF292747), RoundedCornerShape(14.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(Icons.Default.Image, contentDescription = null, tint = Accent)
                    }
                    Spacer(Modifier.width(13.dp))
                    Column {
                        Text("Your creations will appear here", fontWeight = FontWeight.SemiBold)
                        Text("Generate your first image to start a gallery.", color = Muted, fontSize = 12.sp)
                    }
                }
            }
            Spacer(Modifier.height(24.dp))
        }
    }
}
