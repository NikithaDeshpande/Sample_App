package com.example.sampleapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.sampleapp.databinding.FragmentLoginBinding
import com.example.sampleapp.utils.FieldsValidation
import com.example.sampleapp.viewModel.LoginViewModel
import com.example.sampleapp.viewModel.ValidationViewModel
import com.google.android.material.textfield.TextInputEditText

class NnNLogin : Fragment() {
    private lateinit var binding:FragmentLoginBinding
    private lateinit var viewModel: LoginViewModel
    private lateinit var viewModel1:ValidationViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    )
            : View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        binding.lifecycleOwner = viewLifecycleOwner

        val cardView = view?.findViewById<CardView>(R.id.card1)
        val emailEditText = view?.findViewById<TextInputEditText>(R.id.email)
        val cardView1 = view?.findViewById<CardView>(R.id.card2)
        val emailEditText1 = view?.findViewById<TextInputEditText>(R.id.password)

        emailEditText?.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                cardView?.cardElevation = resources.getDimension(R.dimen.elevation_focused)
            } else {
                if (cardView != null) {
                    cardView.cardElevation = resources.getDimension(R.dimen.elevation_default)
                }
            }
        }

        emailEditText1?.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                cardView1?.cardElevation = resources.getDimension(R.dimen.elevation_focused)
            } else {
                if (cardView1 != null) {
                    cardView1.cardElevation = resources.getDimension(R.dimen.elevation_default)
                }
            }
        }


        binding.LoginFooter2.setOnClickListener {
            it.findNavController().navigate(R.id.action_login_to_register)
        }

binding.LoginButton.setOnClickListener {
    FieldsValidation.validateEmail(binding.LoginEmail,viewModel1)
    FieldsValidation.validatePassword(binding.LoginPassword,viewModel1)
    val service=Service(requireContext())
  service.loginFunction(this,binding.email.text.toString(),binding.password.text.toString())
}

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel1 = ViewModelProvider(this)[ValidationViewModel::class.java]
        binding.validationViewModel = viewModel1
    }

}