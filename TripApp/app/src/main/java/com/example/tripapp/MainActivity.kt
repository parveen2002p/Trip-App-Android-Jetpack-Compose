package com.example.tripapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.FlowRowScopeInstance.weight
//import androidx.compose.foundation.layout.FlowRowScopeInstance.weight
import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.FlowRowScopeInstance.align
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tripapp.ui.theme.TripAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TripAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //val myList= createPeopleList()
                    GreetingUI2()
                }
            }
        }
    }
}


class StopData (val stop_name_km: String,
                val total_distance: Float,
                val stop_distance: Float,
                val left_distance: Float,
){
    var stop_name_display: String=""

    fun changeToKm() {
        stop_name_display=stop_name_km
        //print("Yes ch1")
    }
//    fun changeToMiles() {
//        stop_name_display=stop_name_miles
//        //print("Yes ch2")
//    }
}

//Kalindi Kunj 0, stop=4, left= 13-0
//Kalkaji mandir 4 , stop=5.2 -4, left= 13-4
//nehru enclave 5.2 , stop=6.4 - 5.2, left= 13-5.2
//okhla nsic 6.4 , stop=7 -6.4, left= 13-6.4
//greater kailash 7 , stop=7.5 -7, left= 13-7
//okhla vihar 7.5 , stop=8 -7.5, left= 13-7.5
//okhlka sanctuary 8 , stop=9-8, left= 13-8
//gurgaon 9 , stop=11 -9, left= 13-9
//rajeev nagar 11 , stop=13 -11, left= 13-11
//rewari 13 , stop=0, left= 0

fun createPeopleList(): List<StopData> {
    val myList = mutableListOf<StopData>()
    myList.add(StopData("Kalindi Kunj",0f,4f,13f))
    myList.add(StopData("Kalkaji Mandir",4f,1.2f,9f))
    myList.add(StopData("Nehru Enclave",5.2f,1.2f,7.8f))
    myList.add(StopData("Okhla Nsic",6.4f,0.6f,6.6f))
    myList.add(StopData("Greater Kailash",7f,0.5f,6f))
    myList.add(StopData("Okhla Ph2",7.5f,0.5f,5.5f))
    myList.add(StopData("Okhla Santuary",8f,1f,5f))
    myList.add(StopData("Gurgaon",9f,2f,4f))
    myList.add(StopData("Rajiv Nagar",11f,2f,2f))
    myList.add(StopData("Rewari",13f,0f,0f))
    for (stop in myList) {
        stop.changeToKm()
    }
    return myList
}

fun createPeopleList2(): List<StopData> {
    val myList = mutableListOf<StopData>()
    myList.add(StopData("Kalindi Kunj",0f,4f,21f))
    myList.add(StopData("Kalkaji Mandir",4f,1.2f,17f))
    myList.add(StopData("Nehru Enclave",5.2f,1.2f,15.8f))
    myList.add(StopData("Okhla Nsic",6.4f,0.6f,14.6f))
    myList.add(StopData("Greater Kailash",7f,0.5f,14f))
    myList.add(StopData("Okhla Ph2",7.5f,0.5f,13.5f))
    myList.add(StopData("Okhla Santuary",8f,1f,13f))
    myList.add(StopData("Gurgaon",9f,2f,12f))
    myList.add(StopData("Rajiv Nagar",11f,2f,10f))
    myList.add(StopData("Rewari",13f,1f,8f))
    myList.add(StopData("Alaknanda",14f,1f,7f))
    myList.add(StopData("Gurugram",15f,1f,6f))
    myList.add(StopData("Hisar",16f,1f,5f))
    myList.add(StopData("Hisar Old",17f,1f,4f))
    myList.add(StopData("Jaipur",18f,1f,3f))
    myList.add(StopData("Central Jaipur",19f,1f,2f))
    myList.add(StopData("Pilani",20f,1f,1f))
    myList.add(StopData("Bikaner",21f,0f,0f))
    for (stop in myList) {
        stop.changeToKm()
    }
    return myList
}

@Composable
fun GreetingUI2(modifier:Modifier=Modifier){
    var result by remember { mutableStateOf(0) }
    var buttonText by remember { mutableStateOf("Km") }
    var result2 by remember { mutableStateOf(0) }
    var result3 by remember { mutableStateOf(0) }
    var points by remember { mutableStateOf(createPeopleList()) }
    //var points= createPeopleList()

    LaunchedEffect(result3) {

        result = 0
        buttonText = "Km"
        result2 = 0
        if (result3==1) {
            points = createPeopleList2()
        }
        else{
            points = createPeopleList()
        }
    }

    Column {

//        Spacer(
//            modifier = Modifier
//                .height(16.dp)
//                .border(2.dp, Color.Black)
//        )

//        Column (verticalArrangement = Arrangement.Top,
//        horizontalAlignment = Alignment.End,
//        modifier = Modifier.border(2.dp, Color.Black))
//        {
            Box(modifier = Modifier
                //.border(2.dp, Color.Black)
                .fillMaxWidth()) {
                //modifier=modifier.height(5.dp).width(40.dp).padding(start=160.dp,bottom=.160.dp, end = 20.dp)
                Button(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(15.dp)
                        //.border(2.dp, Color.Black)
                        .height(50.dp)
                        .width(120.dp), onClick = {
                        result = ButtonClicked(points, buttonText)
                        buttonText = if (buttonText == "Miles") "Km" else "Miles"
                    },
                    enabled = true
                ) {
                    Text(buttonText)
                    modifier
                        .align(alignment = Alignment.Bottom)
                        .border(2.dp, Color.Black)
                }
//                Button(
//                    modifier = Modifier
//                        .align(Alignment.TopStart)
//                        .padding(15.dp)
//                        //.border(2.dp, Color.Black)
//                        .height(50.dp)
//                        .width(60.dp), onClick = {
//                        result2 = ButtonClicked2(points, result2)
//                    },
//                    enabled = true
//                ) {
//                    Text("Change View")
//                    modifier
//                        .align(alignment = Alignment.Bottom)
//                        //.border(2.dp, Color.Black)
//                }
                IconButton(
                    onClick = {
                        result3 = ButtonClicked3(result3)
                    },
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(15.dp)
                        .border(1.5.dp, Color.Black)
                        .height(45.dp)
                        .width(60.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = "Change View"
                    )
                }

            }
        //}
        generateTopCard(points = points, buttonText = buttonText, stopNum = result2)
//        Column(
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally,
//            modifier = Modifier.border(2.dp, Color.Black)
//        ) {
        Spacer(
            modifier = Modifier
                .height(10.dp)
                .border(2.dp, Color.Black)
        )
        Row (horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                //.border(2.dp, Color.Black)
                .fillMaxWidth()
                .padding(6.dp)) {
            Spacer(
                modifier = Modifier
                    .border(2.dp, Color.Black)
                    .width(25.dp)
            )
            LinearProgressIndicator(
                progress = (points.get(result2).total_distance / points[0].left_distance), modifier = Modifier
                    .height(35.dp)
                    .width(295.dp),
                    //.border(2.dp, Color.Black),
                color = Color.Green
            )
        }
            Spacer(
                modifier = Modifier
                    .height(16.dp)
                    .border(2.dp, Color.Black)
            )
        //}
        Row (horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                //.border(2.dp, Color.Black)
                .fillMaxWidth()
                .padding(6.dp)){
            Spacer(
                modifier = Modifier
                    .border(2.dp, Color.Black)
                    .width(35.dp)
            )
            if (result3==1) {
                LazyColumn(
                    verticalArrangement = Arrangement.Center,
                    //horizontalAlignment = Alignment.,
                    modifier = Modifier
                        .border(1.dp, Color.DarkGray)
                        .height(330.dp)
                        .width(270.dp)
                        .padding(17.dp, 14.dp, 14.dp, 14.dp)
                    //.padding(20.dp)
//                    .background(
//                        Color.LightGray
//                    )
                ) {
                    itemsIndexed(points) { index, point ->
                        generateTextData(point, buttonText, result2, index)
                    }
                }
            }
            else {
                Column(
                    verticalArrangement = Arrangement.Center,
                    //horizontalAlignment = Alignment.,
                    modifier = Modifier
                        .border(1.dp, Color.DarkGray)
                        .height(330.dp)
                        .width(270.dp)
                        .padding(17.dp, 14.dp, 14.dp, 14.dp)
                    //.padding(20.dp)
//                    .background(
//                        Color.LightGray
//                    )
                ) {
                    for (nums in 0..9) {
                        generateTextData2(points[nums], buttonText, result2, nums)
                    }
                }
            }
        }
        Spacer(
            modifier = Modifier
                .height(20.dp)
                .border(2.dp, Color.Black)
        )
//        Column {
            Box(modifier = Modifier
                //.border(2.dp, Color.Black)
                .fillMaxWidth()) {
                //modifier=modifier.height(5.dp).width(40.dp).padding(start=160.dp,bottom=.160.dp, end = 20.dp)
                Button(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(5.dp)
                        .height(50.dp)
                        .width(140.dp)
                        //.border(2.dp, Color.Black)
                            ,
                            onClick = {
                        result2 = ButtonClicked2(points, result2)
                    },
                    enabled = true
                ) {
                    Text("Reached")
                    Modifier
                        .align(alignment = Alignment.Bottom)
                        .border(2.dp, Color.Black)
                }
            }
        //}
        Row (horizontalArrangement = Arrangement.spacedBy(5.dp),
            modifier = Modifier
                //.border(2.dp, Color.Black)
                .fillMaxWidth()
                .padding(4.dp)){
            Image(
                painter = painterResource(R.drawable.journey_img),
                contentDescription = "Contact profile picture",
                modifier = Modifier
                    // Set image size to 40 dp
                    //.size(440.dp)
                    .fillMaxWidth().padding(5.dp),
                    // Clip image to be shaped as a circle
                    //.clip(CircleShape))
            )
        }
    }
}


@Composable
fun generateTextData(points: StopData,buttonText: String,result2: Int,index: Int,modifier:Modifier=Modifier){
    Text(
        text = if (buttonText == "Miles") points.stop_name_km else points.stop_name_km, // Update this line
        modifier = Modifier
            .padding(6.dp)
            .background(if (index <= result2) Color.Red else Color.DarkGray)
            .fillMaxWidth(),
            //.border(3.dp, Color.Black),
        fontSize=25.sp,
        //lineHeight=16.sp,
        textAlign = TextAlign.Center,
        color = Color.White,
        style = MaterialTheme.typography.bodyLarge,
    )
}

@Composable
fun generateTextData2(points: StopData,buttonText: String,result2: Int,index: Int,modifier:Modifier=Modifier){
    Text(
        text = if (buttonText == "Miles") points.stop_name_km else points.stop_name_km, // Update this line
        modifier = Modifier
            .padding(3.dp)
            .background(if (index <= result2) Color.Red else Color.DarkGray)
            .fillMaxWidth(),
        //.border(3.dp, Color.Black),
        fontSize=18.sp,
        //lineHeight=16.sp,
        textAlign = TextAlign.Center,
        color = Color.White,
        style = MaterialTheme.typography.bodyLarge,
    )
}

// distance covered, left , stop distance

@Composable
fun generateTopCard(points: List<StopData>,buttonText: String,modifier:Modifier=Modifier,stopNum: Int){
    var distanceCovered=points.get(stopNum).total_distance
    var distanceleft=points.get(stopNum).left_distance
    var distanceStop=points.get(stopNum).stop_distance
    //Column {
        Text(
            text = "Total distance covered: %.1f %s".format(if (buttonText == "Miles") distanceCovered * 0.6213
            else distanceCovered, if (buttonText == "Miles") "Miles" else "Km"),
            //text = if (buttonText == "Miles") "Total distance covered: $distanceCovered Miles" else "Total distance covered: $distanceCovered Km",
            modifier = Modifier
                .padding(4.dp)
                .background(color = Color.Gray)
                //.border(3.dp, Color.Black)
                .fillMaxWidth()
                .background(Color.LightGray),
            fontSize = 25.sp,
            //lineHeight = 116.sp,
            textAlign = TextAlign.Center,
            color = Color.Blue,
            style = MaterialTheme.typography.titleLarge,
        )
        Row(horizontalArrangement = Arrangement.spacedBy(5.dp),
            modifier = Modifier
                //.border(2.dp, Color.Black)
                .fillMaxWidth()
                .padding(4.dp))
            {
            Text(
                text = "Next stop : %.1f %s".format(if (buttonText == "Miles") distanceStop * 0.6213
                else distanceStop, if (buttonText == "Miles") "Miles away" else "Km away"),
                //text = if (buttonText == "Miles") "Next stop : $distanceStop Miles away" else "Next stop : $distanceStop Km away",
                modifier = Modifier
                    .padding(4.dp)
                    .background(color = Color.LightGray)
                    //.border(3.dp, Color.Black)
                    .weight(1f),
                fontSize = 20.sp,
                //lineHeight = 116.sp,
                textAlign = TextAlign.Center,
                color = Color.Blue,
                style = MaterialTheme.typography.bodyLarge,
            )
            Text(
                text = "Journey left : %.1f %s".format(if (buttonText == "Miles") distanceleft * 0.6213
                else distanceleft, if (buttonText == "Miles") "Miles" else "Km"),
                //text = if (buttonText == "Miles") "Journey left : $distanceleft Miles" else "Journey left : $distanceleft Km",
                modifier = Modifier
                    .padding(4.dp)
                    .background(color = Color.LightGray)
                    //.border(3.dp, Color.Black)
                    .weight(1f),
                fontSize = 20.sp,
                //lineHeight = 116.sp,
                textAlign = TextAlign.Center,
                color = Color.Blue,
                style = MaterialTheme.typography.bodyLarge,
            )
        //}
    }
}

var ButtonText:String="Miles"

fun ButtonClicked (myList: List<StopData>,buttonText: String) : Int{
// change list text & Button text
//    for (stop in myList) {
//        if (buttonText=="Miles") {
//            stop.changeToKm()
//        }
//        else{
//            stop.changeToMiles()
//        }
//    }
    return if (buttonText == "Miles") 1 else 0
}

fun ButtonClicked2 (myList: List<StopData>,result2: Int) : Int{
    if(result2+1<myList.size){
        return result2+1
    }
    else{
        return result2
    }
}

fun ButtonClicked3 (result3: Int) : Int{
    return if (result3 == 0) 1 else 0
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TripAppTheme {
        val myList= createPeopleList()
        GreetingUI2()
    }
}