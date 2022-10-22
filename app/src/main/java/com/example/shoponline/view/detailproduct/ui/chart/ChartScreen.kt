package com.example.shoponline.view.detailproduct.ui.chart

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import me.bytebeats.views.charts.bar.render.yaxis.SimpleYAxisDrawer
import me.bytebeats.views.charts.line.LineChart
import me.bytebeats.views.charts.line.LineChartData
import me.bytebeats.views.charts.line.render.line.SolidLineDrawer
import me.bytebeats.views.charts.line.render.point.FilledCircularPointDrawer
import me.bytebeats.views.charts.line.render.xaxis.SimpleXAxisDrawer
import me.bytebeats.views.charts.simpleChartAnimation

@Composable
fun ChartScreen() {
    LineChart(
        lineChartData = LineChartData(
            points = listOf(
                LineChartData.Point(33f, "Line 1"),
                LineChartData.Point(44f, "Line 2"),
                LineChartData.Point(10f, "Line 3"),
                LineChartData.Point(2f, "Line 4"),
                LineChartData.Point(50f, "Line 5"),
                LineChartData.Point(100f, "Line 6"),
                LineChartData.Point(130f, "Line 7")
            )
        ),
        // Optional properties.
        modifier = Modifier.fillMaxWidth().height(350.dp),
        animation = simpleChartAnimation(),
        pointDrawer = FilledCircularPointDrawer(),
        lineDrawer = SolidLineDrawer(),
        xAxisDrawer = SimpleXAxisDrawer(),
        horizontalOffset = 5f
    )
}