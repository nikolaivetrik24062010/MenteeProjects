package com.example.menteeprojects.step2

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

@Composable
fun MovieBookingScreen() {
    Surface(color = Color.White) {
        ConstraintLayout(
            modifier = Modifier.fillMaxSize(),
        ) {
            val (
                titleText, genreText, ratingText,
                castText, descText, bottomSurface,
                bookButton, cinemaNameContainer
            ) = createRefs()

            Text(
                text = "Deadpool",
                fontSize = 28.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.constrainAs(titleText) {
                    top.linkTo(parent.top, 32.dp)
                    start.linkTo(parent.start, 24.dp)
                }
            )

            Text(
                text = "Action | 1h 48m",
                fontSize = 16.sp,
                color = Color.Gray,
                modifier = Modifier.constrainAs(genreText) {
                    top.linkTo(titleText.bottom)
                    start.linkTo(titleText.start)
                }
            )

            Text(
                text = "IMDb 8.0/10",
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                modifier = Modifier.constrainAs(ratingText) {
                    top.linkTo(genreText.bottom, 16.dp)
                    start.linkTo(titleText.start)
                }
            )

            Text(
                text = "CAST",
                fontSize = 14.sp,
                color = Color.Gray,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.constrainAs(castText) {
                    top.linkTo(ratingText.bottom, 32.dp)
                    start.linkTo(titleText.start)
                }
            )

            Text(
                text = "Deadpool is a 2016 superhero film based on the Marvel Comics character. It's hilarious, action-packed, and highly entertaining.",
                color = Color(0x8A000000),
                fontSize = 16.sp,
                modifier = Modifier.constrainAs(descText) {
                    top.linkTo(castText.bottom, 24.dp)
                    start.linkTo(parent.start, 24.dp)
                    end.linkTo(parent.end, 24.dp)
                    width = Dimension.fillToConstraints
                }
            )

            Surface(
                color = Color.LightGray,
                modifier = Modifier.constrainAs(bottomSurface) {
                    top.linkTo(descText.bottom, 36.dp)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                }
            ) {}

            ConstraintLayout(modifier = Modifier.constrainAs(cinemaNameContainer) {
                top.linkTo(descText.bottom, 48.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(bookButton.top, 16.dp)
                width = Dimension.fillToConstraints
            }) {
                val (cinemaNameText, cinemaDistText) = createRefs()

                Text(
                    text = "Velocity Cinema",
                    fontSize = 22.sp,
                    color = Color(0xDD000000),
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.constrainAs(cinemaNameText) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                )

                Text(
                    text = "4.6 km",
                    fontSize = 14.sp,
                    color = Color(0x8A000000),
                    modifier = Modifier.constrainAs(cinemaDistText) {
                        start.linkTo(cinemaNameText.start)
                        end.linkTo(cinemaNameText.end)
                        width = Dimension.fillToConstraints
                    }
                )

                createVerticalChain(cinemaNameText, cinemaDistText, chainStyle = ChainStyle.Packed)
            }

            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(Color(0xFFB71C1C)),
                modifier = Modifier
                    .height(60.dp)
                    .constrainAs(bookButton) {
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        width = Dimension.fillToConstraints
                    }
            ) {
                Text(
                    text = "BOOK TICKETS",
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MovieBookingScreenPreview() {
    MovieBookingScreen()
}