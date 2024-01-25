package com.example.sampleapp

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.RadioButton
import android.widget.TimePicker
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.sampleapp.databinding.FragmentRegisterBinding
import com.example.sampleapp.utils.FieldsValidation
import com.example.sampleapp.viewModel.ValidationViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Calendar


class Register : Fragment() {
    private lateinit var binding: FragmentRegisterBinding
    private lateinit var viewModel: ValidationViewModel

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false)

        val places = listOf("Please select", "Bangalore", "Mangalore", "Mysore", "Hassan")
        val language = arrayListOf("Kotlin", "java", "Python", "HTML", "CSS")


        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item, places
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner.adapter = adapter
        val calender = Calendar.getInstance()
        binding.date.setOnClickListener {
            val year = calender.get(Calendar.YEAR)
            val month = calender.get(Calendar.MONTH)
            val day = calender.get(Calendar.DAY_OF_MONTH)
            val datePickerDialog = DatePickerDialog(
                requireContext(),
                { _: DatePicker?, selectedYear: Int, monthOfYear: Int, dayOfMonth: Int ->
                    val selectedDate = "$selectedYear-${monthOfYear + 1}-$dayOfMonth"
                    binding.RegisterTextviewDate.editText?.setText(selectedDate)
                },
                year,
                month,
                day
            )
            datePickerDialog.show()
        }
        binding.time.setOnClickListener {
            val hour = calender.get(Calendar.HOUR)
            val min = calender.get(Calendar.MINUTE)
            val timePickerDialog = TimePickerDialog(
                requireContext(),
                { _: TimePicker?, selectedHour: Int, selectedMin: Int ->
                    val selectedTime = "$selectedHour:$selectedMin"
                    binding.RegisterTextviewTime.editText?.setText(selectedTime)
                },
                hour,
                min,
                true
            )
            timePickerDialog.show()
        }
        var list = listOf<Int>()
        var displayString = ""
        binding.MultiSelect.buildCheckedSpinner(language) { selectedPositionList, display ->
            list = selectedPositionList
            displayString = display
        }

        binding.signInFooter2.setOnClickListener {
            it.findNavController().navigate(R.id.action_register_to_login)
        }
        binding.SignInToolbar.setOnClickListener {
            it.findNavController().navigate(R.id.action_register_to_login)
        }

        binding.RegisterButton.setOnClickListener {
            FieldsValidation.validateName(binding.RegisterTextviewName, viewModel)
            FieldsValidation.validateEmail(binding.RegisterTextviewEmail, viewModel)
            FieldsValidation.validatePassword(binding.RegisterTextviewPassword, viewModel)
            FieldsValidation.validateConfirmPassword(
                binding.RegisterTextviewConfirmPassword,
                viewModel
            )
            FieldsValidation.validateRadioGroup(binding.RadioGroup, binding.errorMsg, viewModel)
            FieldsValidation.validateDate(binding.RegisterTextviewDate, viewModel)
            FieldsValidation.validateDate(binding.RegisterTextviewTime, viewModel)
            FieldsValidation.validateSpinner(
                binding.spinner,
                binding.spinnerError,
                binding.background1,
                requireContext(),
                viewModel
            )
            FieldsValidation.validateMultiSelect(
                binding.MultiSelectError,
                requireContext(),
                list,
                binding.background,
                viewModel
            )


            if (viewModel.nameError == false && viewModel.emailError == false && viewModel.passwordError == false && viewModel.confirmPasswordError == false && viewModel.dateError == false && viewModel.hourError == false && viewModel.radioError && viewModel.spinnerError && viewModel.multiSpinnerError) {
                if (binding.checkbox1.isChecked) {

                    val name = viewModel.name
                    val email = viewModel.email
                    val password = viewModel.password
                    val conPassword = viewModel.confirmPassword
                    val date = viewModel.date
                    val hour = viewModel.time
                    val selectedId = binding.RadioGroup.checkedRadioButtonId
                    val radioButton = view?.findViewById<RadioButton>(selectedId)
                    val gender = radioButton?.text.toString()
                    CoroutineScope(Dispatchers.IO).launch {
                        val retrofit = Service(context)
                        try {
                            withContext(Dispatchers.Main) {
                                if (name != null && email != null && password != null && conPassword != null) {

                                    retrofit.registerFunction(
                                        this@Register,
                                        name,
                                        email,
                                        password,
                                        conPassword,
                                        gender,
                                        binding.spinner.selectedItem.toString(),
                                        displayString,
                                        date,
                                        hour
                                    )

                                }

                            }
                        } catch (e: Exception) {
                            Toast.makeText(
                                context,
                                "failed to connect to server",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        }
                    }
                } else {
                    Toast.makeText(context, "please accept the agreement", Toast.LENGTH_SHORT)
                        .show()
                }
            } else {
                Toast.makeText(context, "Please enter all fields", Toast.LENGTH_SHORT).show()
            }
        }


        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[ValidationViewModel::class.java]
        binding.validationViewModel = viewModel
    }


}