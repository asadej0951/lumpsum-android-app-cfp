package com.example.lumpsum_android_app_cfp.termsService

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.lumpsum_android_app_cfp.R
import com.example.lumpsum_android_app_cfp.databinding.FragmentTermsServiceBinding
import com.example.lumpsum_android_app_cfp.view.BaseFragment
import org.koin.android.viewmodel.ext.android.viewModel

class TermsServiceFragment : BaseFragment() {

    private lateinit var binding: FragmentTermsServiceBinding
    private val viewModel : TermsServiceViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
        intiView()
    }

    private fun intiView() {
       binding.mViewModel = viewModel

//        viewModel.textTitle.set(resources.getString(R.string.text_title_terms_service))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_terms_service,
            container,
            false
        )
        return binding.root
    }

    companion object {

        fun newInstance(param1: String, param2: String) =
            TermsServiceFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}