package com.example.sampleapp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.sampleapp.databinding.FragmentRegisterBinding
import com.example.sampleapp.viewModel.RegisterViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class Register : Fragment() {
    private lateinit var binding: FragmentRegisterBinding
    private lateinit var viewModel: RegisterViewModel
    val namePattern = Regex("^[A-Za-z-' ]+\$")
    val passwordPattern = Regex(
        "^" +
                "(?=.*[0-9])" +         //at least 1 digit
                "(?=.*[a-z])" +         //at least 1 lower case letter
                "(?=.*[A-Z])" +         //at least 1 upper case letter
                "(?=.*[a-zA-Z])" +      //any letter
                "(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=\\S+$)" +           //no white spaces
                ".{4,}" +               //at least 4 characters
                "$"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false)


        var isValidName = false
        binding.name.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Not needed, but required to implement
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Not needed, but required to implement
            }

            override fun afterTextChanged(s: Editable?) {
                if (s.toString().isEmpty()) {
                    binding.RegisterTextviewName.error = "Field can't be empty"

                } else if (!namePattern.matches(s.toString())) {
                    binding.RegisterTextviewName.error = "Enter a valid full name"

                } else {
                    isValidName = true
                    binding.RegisterTextviewName.error = null
                }
            }
        })
        //email field validation
        var isValidEmail = false
        binding.Email.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Not needed, but required to implement
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Not needed, but required to implement
            }

            override fun afterTextChanged(s: Editable?) {
                if (s.toString().isEmpty()) {
                    binding.RegisterTextviewEmail.error = "Field can't be empty"

                } else if (!Patterns.EMAIL_ADDRESS.matcher(s.toString()).matches()) {
                    binding.RegisterTextviewEmail.error = "Enter a valid email address"

                } else {
                    isValidEmail = true
                    binding.RegisterTextviewEmail.error = null

                }
            }
        })
        //password field validation
        var isValidPassword = false
        binding.Password.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Not needed, but required to implement
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Not needed, but required to implement
            }

            override fun afterTextChanged(s: Editable?) {
                if (s.toString().isEmpty()) {
                    binding.RegisterTextviewPassword.error = "Field can't be empty"

                } else if (!passwordPattern.matches(s.toString())) {
                    binding.RegisterTextviewPassword.error = "Enter a valid password"

                } else {
                    isValidPassword = true
                    binding.RegisterTextviewPassword.error = null

                }
            }

        })
        //confirm password validation
        var isValidConfirm = false
        binding.ConfirmPassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Not needed, but required to implement
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Not needed, but required to implement
            }

            override fun afterTextChanged(s: Editable?) {
                if (s.toString().isEmpty()) {
                    binding.RegisterTextviewConfirmPassword.error = "Field can't be empty"

                } else if (binding.Password.text.toString() != binding.ConfirmPassword.text.toString()) {
                    binding.RegisterTextviewConfirmPassword.error = "Password doesn't match"

                } else {
                    isValidConfirm = true
                    binding.RegisterTextviewConfirmPassword.error = null
                }
            }
        })
        binding.signInFooter2.setOnClickListener {
            it.findNavController().navigate(R.id.action_register_to_login)
        }
        binding.RegisterButton.setOnClickListener {
            if (isValidName && isValidEmail && isValidPassword && isValidConfirm) {
                val name = binding.name.text.toString()
                val email = binding.Email.text.toString()
                val password = binding.Password.text.toString()
                val conPassword = binding.ConfirmPassword.text.toString()
                CoroutineScope(Dispatchers.IO).launch {
                    val retrofit = Service()
                    try{
                        retrofit.registerFunction(name, email, password, conPassword)
                        withContext(Dispatchers.Main){
                            val l=LoadingDialog(this@Register)
                            l.startDialog(true)

                        }
                    }catch (e:Exception){
                              Log.d("MainActivity","$e")
                    }
                }



            }
            binding.SignInToolbar.setOnClickListener {
                it.findNavController().navigate(R.id.action_register_to_login)
            }

        }
        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[RegisterViewModel::class.java]
        binding.registerViewModel = viewModel
    }

}