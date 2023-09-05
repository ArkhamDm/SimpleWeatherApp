package com.example.test

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.test.databinding.FragmentTemperatureBinding
import com.example.test.viewmodel.TempViewModel
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.ValueFormatter


class TemperatureFragment : Fragment() {
    lateinit var TemperatureFragBinding: FragmentTemperatureBinding
    private val viewModel: TempViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        TemperatureFragBinding = FragmentTemperatureBinding.inflate(inflater, container, false)
        return TemperatureFragBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val entries: MutableList<Entry> = ArrayList()
        viewModel.tempGraph?.apply {
            var k = 0f
            for (hour in this.hour) {
                entries.add(Entry(k, hour.temp_c.toFloat()))
                k++
            }
        }

        // Add more entries as needed
        val dataSet = LineDataSet(entries, "Температура по часам")
        dataSet.color = Color.BLUE
        dataSet.lineWidth = 2f
        dataSet.setDrawCircles(true)
        dataSet.setCircleColor(Color.BLUE)
        dataSet.circleRadius = 3f
        dataSet.setDrawValues(false)

        val lineData = LineData(dataSet)

        TemperatureFragBinding.apply {
            LineGraph.data = lineData

            LineGraph.description.isEnabled = false
            LineGraph.axisLeft.setDrawGridLines(false)
            LineGraph.xAxis.setDrawGridLines(false)
            LineGraph.xAxis.position = XAxis.XAxisPosition.BOTTOM
            LineGraph.xAxis.labelCount = entries.size
            /*LineGraph.xAxis.valueFormatter = object : ValueFormatter() {
                override fun getAxisLabel(value: Float, axis: AxisBase?): String {
                    // Convert the x-axis values to meaningful labels (e.g., dates)
                    // Return the label for the corresponding entry index
                    return "${value.toInt()}"
                }
            }*/
            LineGraph.axisRight.isEnabled = false
            LineGraph.setDrawGridBackground(true)
            LineGraph.animateY(500)
            LineGraph.invalidate()
        }
    }

}