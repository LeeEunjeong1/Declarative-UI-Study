package com.example.android_musinsa_clone

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToolbarWithMenu("MUSINSA")
        }
    }
}

@ExperimentalPagerApi
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolbarWithMenu(name: String) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = name) },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Filled.Favorite,
                            contentDescription = "Menu"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "Search"
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Filled.ShoppingCart,
                            contentDescription = "Basket"
                        )
                    }
                }
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),

                verticalArrangement = Arrangement.Center
            ) {
                val pagerState = rememberPagerState()
                val coroutineScope = rememberCoroutineScope()

                androidx.compose.material.TabRow(
                    selectedTabIndex = pagerState.currentPage,
                    backgroundColor = Color.White,
                    indicator = { tabPositions ->
                        androidx.compose.material.TabRowDefaults.Indicator(
                            Modifier.pagerTabIndicatorOffset(
                                pagerState,
                                tabPositions = tabPositions
                            )
                        )
                    }) {
                    pageList.forEachIndexed { index, title ->
                        Tab(
                            text = {
                                if (pagerState.currentPage == index) {
                                    Text(
                                        text = title,
                                        fontWeight = FontWeight.Bold
                                    )
                                } else {
                                    Text(
                                        text = title
                                    )
                                }

                            },
                            selected = pagerState.currentPage == index,
                            onClick = {
                                coroutineScope.launch {
                                    pagerState.scrollToPage(index)
                                }
                            },
                        )
                    }
                }
                HorizontalPager(count = pageList.size, state = pagerState) { page ->
                    Text(
                        modifier = Modifier.wrapContentSize(),
                        text = pageList[page],
                        textAlign = TextAlign.Center,
                        fontSize = 30.sp
                    )

                }
            }

        }
    )
}

@OptIn(ExperimentalPagerApi::class)
@Preview
@Composable
fun PreviewScreen() {
    ToolbarWithMenu(name = "MUSINSA")
}

val pageList = listOf("추천", "랭킹", "스타일", "세일", "뷰티")