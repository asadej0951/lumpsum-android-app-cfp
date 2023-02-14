package com.example.lumpsum_android_app_cfp.termsService

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.lumpsum_android_app_cfp.R
import com.example.lumpsum_android_app_cfp.data.preferences.Preferences
import com.example.lumpsum_android_app_cfp.databinding.FragmentTermsServiceBinding
import com.example.lumpsum_android_app_cfp.utils.language.LocaleHelper
import com.example.lumpsum_android_app_cfp.view.BaseFragment
import org.koin.android.viewmodel.ext.android.viewModel
import java.util.*

class TermsServiceFragment : BaseFragment() {

    private lateinit var binding: FragmentTermsServiceBinding
    private val viewModel: TermsServiceViewModel by viewModel()
    private lateinit var context: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }
    private fun intiView() {
        viewModel.textTitle.set(resources.getString(R.string.text_title_terms_service))
        viewModel.textButton.set(resources.getString(R.string.text_ok))
        viewModel.textCheckBox.set(resources.getString(R.string.text_check_box_terms_service))
        viewModel.textMessageTermsService.set(resources.getString(R.string.text_message_terms_service))
        // ภาษาที่เป็นตัวย่อ
        val current = Locale.getDefault().language
        viewModel.textButtonSettingLanguage.set(current)
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
        binding.mViewModel = viewModel
        intiView()
        onClickEvent()
        return binding.root
    }
    private fun onClickEvent() {
        viewModel.onClick.observe(requireActivity(), androidx.lifecycle.Observer {
            when (it) {
                "SettingLanguage" -> {
                    val current = Locale.getDefault().language
                    val valueLanguage = if (current != "th") "th" else "en"
                    context = LocaleHelper().setLocale(requireContext(), valueLanguage)
                    intiView()
                }
            }
        })
    }
    companion object {
        fun newInstance(param1: String, param2: String) =
            TermsServiceFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}