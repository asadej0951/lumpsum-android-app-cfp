package com.example.lumpsum_android_app_cfp.startApp

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.lumpsum_android_app_cfp.R
import com.example.lumpsum_android_app_cfp.databinding.FragmentStartBinding
import com.example.lumpsum_android_app_cfp.utils.service.ParameterBackgroundCountDown
import org.koin.android.viewmodel.ext.android.viewModel
import java.util.*

class StartAppFragment : Fragment() {

    private lateinit var binding : FragmentStartBinding
    private val mViewModel : StartAppViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_start,container,false)
        binding.mViewModel = mViewModel
        mViewModel.textShow.set(resources.getString(R.string.welcome_app))
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val timer = object: CountDownTimer(10000, 100) {
            override fun onTick(millisUntilFinished: Long) {
                mViewModel.visibilityProgressBar.set(View.VISIBLE)
            }
            override fun onFinish() {
                mViewModel.visibilityProgressBar.set(View.GONE)
                val b = Bundle()
                b.putString("name","message")
                findNavController().navigate(R.id.action_startApp_to_termsServiceFragment,b)
            }
        }
        timer.start()

    }

    override fun onDestroyView() {
        super.onDestroyView()
    }


}