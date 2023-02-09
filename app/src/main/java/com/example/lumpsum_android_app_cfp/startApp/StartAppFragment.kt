package com.example.lumpsum_android_app_cfp.startApp

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.lumpsum_android_app_cfp.R
import com.example.lumpsum_android_app_cfp.databinding.FragmentStartBinding

class StartAppFragment : Fragment() {

    private var _binding: FragmentStartBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this)[StartAppViewModel::class.java]

        _binding = FragmentStartBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val timer = object: CountDownTimer(10000, 2) {
            override fun onTick(millisUntilFinished: Long) {
                binding.progressBar.visibility = View.VISIBLE
                Log.i("checkTimeCountDown",millisUntilFinished.toString())
            }
            override fun onFinish() {
                binding.progressBar.visibility = View.GONE
                val b = Bundle()
                b.putString("name","message")
                findNavController().navigate(R.id.action_startApp_to_termsServiceFragment,b)
            }
        }
        timer.start()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}