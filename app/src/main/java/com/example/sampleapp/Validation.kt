package com.example.sampleapp

import android.util.Patterns
import android.view.View
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import androidx.core.widget.doAfterTextChanged
import androidx.databinding.BaseObservable
import androidx.databinding.BindingAdapter
import com.example.sampleapp.utils.FieldsValidation
import com.example.sampleapp.viewModel.ValidationViewModel
import com.google.android.material.textfield.TextInputLayout

object Validation : BaseObservable() {

    @BindingAdapter("fullNameValidation", "viewModel")
    @JvmStatic
    fun setFullNameError(
        inputLayout: TextInputLayout, fullName: String?, viewModel: ValidationViewModel
    ) {
        inputLayout.editText?.doAfterTextChanged {
            FieldsValidation.validateName(inputLayout, viewModel)
        }
    }

    @BindingAdapter("emailValidation", "viewModel")
    @JvmStatic
    fun setEmailError(
        inputLayout: TextInputLayout, email: String?, viewModel: ValidationViewModel
    ) {
        inputLayout.editText?.doAfterTextChanged {
            FieldsValidation.validateEmail(inputLayout, viewModel)
        }
    }

    @BindingAdapter("passwordValidation", "viewModel")
    @JvmStatic
    fun setPasswordError(
        inputLayout: TextInputLayout, password: String?, viewModel: ValidationViewModel
    ) {
        inputLayout.editText?.doAfterTextChanged {
            FieldsValidation.validatePassword(inputLayout, viewModel)
        }
    }

    @BindingAdapter("confirmPasswordValidation", "password", "viewModel")
    @JvmStatic
    fun setConfirmPasswordError(
        inputLayout: TextInputLayout,
        confirmPassword: String?,
        password: String?,
        viewModel: ValidationViewModel
    ) {
        inputLayout.editText?.doAfterTextChanged {
            FieldsValidation.validateConfirmPassword(inputLayout, viewModel)
        }
    }
    @BindingAdapter("DummyAttribute","viewModel")
    @JvmStatic
  fun setDateError(inputLayout: TextInputLayout,id:Boolean,viewModel: ValidationViewModel){
    inputLayout.editText?.doAfterTextChanged {
        FieldsValidation.validateDate(inputLayout,viewModel)
    }
}
    @BindingAdapter("Attribute","viewModelRef")
    @JvmStatic
    fun setTimeError(inputLayout: TextInputLayout,id:Boolean,viewModel: ValidationViewModel){
        inputLayout.editText?.doAfterTextChanged {
            FieldsValidation.validateTime(inputLayout,viewModel)
        }
    }
}