package com.example.test

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.test.databinding.FragmentWelcomeBinding
import com.example.test.viewmodel.TempViewModel
import java.math.RoundingMode
import kotlin.math.roundToLong


class WelcomeFragment : Fragment() {
    private lateinit var WelcomeFragBinding: FragmentWelcomeBinding
    private val viewModel: TempViewModel by activityViewModels()
    private val ImagesList = listOf(
        R.drawable.small_cloud,
        R.drawable.small_cloud,
        R.drawable.small_cloud
    )
    private val DaysNameList = listOf(
        "Сегодня",
        "Пятница",
        "Суббота"
    )
    private val TempsList = listOf(
        "24",
        "20",
        "17"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        WelcomeFragBinding = FragmentWelcomeBinding.inflate(inflater, container, false)
        return WelcomeFragBinding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        WelcomeFragBinding.apply {
            viewModel.weather.observe(viewLifecycleOwner) { newValue ->
                temperatureText.text = newValue.current.temp_c.toInt().toString()
                conditionText.text = newValue.current.condition.text
                cityText.text = newValue.location.name
                dateText.text = newValue.forecast.forecastday[0].date
                windspeedText.text = (newValue.current.wind_kph / 3.6).toBigDecimal().setScale(1, RoundingMode.UP).toString() + " м/с"
                pressureText.text = newValue.current.pressure_mb.toInt().toString()
                humidityPercText.text = newValue.current.humidity.toString() + "%"

                dayTempText1.text = newValue
                    .forecast.forecastday[0].day.mintemp_c.toInt().toString() + "/" +
                        newValue.forecast.forecastday[0].day.maxtemp_c.toInt().toString()
                dayTempText2.text = newValue
                    .forecast.forecastday[1].day.mintemp_c.toInt().toString() + "/" +
                        newValue.forecast.forecastday[1].day.maxtemp_c.toInt().toString()
                dayTempText3.text = newValue
                    .forecast.forecastday[0].day.mintemp_c.toInt().toString() + "/" +
                        newValue.forecast.forecastday[0].day.maxtemp_c.toInt().toString()

            }
        }

        val controller = findNavController()
        WelcomeFragBinding.apply {

            imageView.setOnClickListener {
                val builder = AlertDialog.Builder(context)
                val inflater = layoutInflater
                val dialogLayout = inflater.inflate(R.layout.city_dialog_layout, null)
                val editText = dialogLayout.findViewById<EditText>(R.id.editFieldCity)

                with(builder) {
                    setTitle("Введи город")
                    setPositiveButton("OK") {
                            _, _ -> viewModel.getWeather(editText.text.toString())
                    }
                    setNegativeButton("Отмена") {
                            dialog, _ -> dialog.cancel()
                    }
                    setView(dialogLayout)
                    show()
                }
            }
            TodayLinear.setOnClickListener {
                viewModel.showTempGraph(0)
                controller.navigate(R.id.action_welcomeFragment_to_temperatureFragment)
            }
            YesterdayLinear.setOnClickListener {
                viewModel.showTempGraph(1)
                controller.navigate(R.id.action_welcomeFragment_to_temperatureFragment)
            }
            YesterdayNextLinear.setOnClickListener {
                viewModel.showTempGraph(2)
                controller.navigate(R.id.action_welcomeFragment_to_temperatureFragment)
            }
        }

    }
}