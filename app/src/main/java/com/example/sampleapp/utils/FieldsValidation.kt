package com.example.sampleapp.utils

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.Patterns
import android.view.View
import android.widget.LinearLayout
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.widget.doAfterTextChanged
import com.anurag.multiselectionspinner.MultiSpinner
import com.example.sampleapp.R
import com.example.sampleapp.viewModel.ValidationViewModel
import com.google.android.material.textfield.TextInputLayout
import com.puskal.multiselectspinner.MultiSelectSpinnerView
import kotlin.coroutines.coroutineContext

object FieldsValidation {

    @JvmStatic
    fun validateName(inputLayout:TextInputLayout,viewModel: ValidationViewModel) {
        val pattern = Regex("^[A-Za-z-' ]+\$")
        if (inputLayout.editText?.text.isNullOrEmpty()) {
            inputLayout.isErrorEnabled = true
            inputLayout.error = "This field cannot be empty"
        } else if (!pattern.matches(inputLayout.editText?.text.toString())) {
            inputLayout.isErrorEnabled = true
            inputLayout.error = "invalid Name"
        } else {
            inputLayout.isErrorEnabled = false
            inputLayout.error = null
        }
        viewModel.nameError = inputLayout.isErrorEnabled
    }
    @JvmStatic
    fun validateEmail(inputLayout:TextInputLayout,viewModel: ValidationViewModel){
        val pattern = Patterns.EMAIL_ADDRESS
        if (inputLayout.editText?.text.isNullOrEmpty()) {
            inputLayout.isErrorEnabled = true
            inputLayout.error = "This field cannot be empty"
        } else if (!pattern.matcher(inputLayout.editText?.text.toString()).matches()) {
            inputLayout.isErrorEnabled = true
            inputLayout.error = "invalid email address"
        } else {
            inputLayout.isErrorEnabled = false
            inputLayout.error = null
        }
        viewModel.emailError = inputLayout.isErrorEnabled
    }

    @JvmStatic
    fun validatePassword(inputLayout:TextInputLayout,viewModel: ValidationViewModel){
        var pattern = Regex(
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
            if (inputLayout.editText?.text.isNullOrEmpty()) {
                inputLayout.isErrorEnabled = true
                inputLayout.error = "This field cannot be empty"
            } else if (!pattern.matches(inputLayout.editText?.text.toString())) {
                inputLayout.isErrorEnabled = true
                inputLayout.error = "invalid password"
            } else {
                inputLayout.isErrorEnabled = false

                inputLayout.error = null
            }
            viewModel.passwordError = inputLayout.isErrorEnabled
    }
    @JvmStatic
    fun validateConfirmPassword(inputLayout:TextInputLayout,viewModel: ValidationViewModel){
        if (inputLayout.editText?.text.isNullOrEmpty()) {
            inputLayout.isErrorEnabled = true
            inputLayout.error = "This field cannot be empty"
        } else if (viewModel.confirmPassword != viewModel.password) {
            inputLayout.isErrorEnabled = true
            inputLayout.error = "doesnot match"
        } else {
            inputLayout.isErrorEnabled = false
            inputLayout.error = null
        }
        viewModel.confirmPasswordError = inputLayout.isErrorEnabled
    }
    @JvmStatic
    fun validateRadioGroup(radioGroup: RadioGroup,textView: TextView,viewModel: ValidationViewModel){
        val selectedId = radioGroup.checkedRadioButtonId
        val msg:String="please select one of option"
        if (selectedId == -1) {
            textView.text = msg
            textView.visibility = View.VISIBLE
        } else {
            textView.text = null
            textView.visibility = View.GONE
            viewModel.radioError=true
        }
    }
    @JvmStatic
    fun validateSpinner(spinner: Spinner,textView: TextView,view: View,context: Context,viewModel: ValidationViewModel){
        val msg="please select one of option"
        val drawable: Drawable? =ContextCompat.getDrawable(context,R.drawable.redborder)
        val drawable1:Drawable?=ContextCompat.getDrawable(context,R.drawable.border)
        if ( spinner.selectedItem == "Please select") {
            textView.text=msg
            textView.visibility=View.VISIBLE
            view.background=drawable
        } else {
           textView.text=null
            textView.visibility=View.GONE
           view.background=drawable1
            viewModel.spinnerError=true
        }
    }
    @JvmStatic
    fun validateDate(inputLayout: TextInputLayout,viewModel: ValidationViewModel){
        if(inputLayout.editText?.text.isNullOrEmpty()){
          inputLayout.isErrorEnabled=true
          inputLayout.error="This field can't be empty"
        }else{
            inputLayout.isErrorEnabled=false
            inputLayout.error=null
        }
        viewModel.dateError=inputLayout.isErrorEnabled
    }
    @JvmStatic
    fun validateTime(inputLayout: TextInputLayout,viewModel: ValidationViewModel){
        if(inputLayout.editText?.text.isNullOrEmpty()){
            inputLayout.isErrorEnabled=true
            inputLayout.error="This field can't be empty"
        }else{
            inputLayout.isErrorEnabled=false
            inputLayout.error=null
        }
        viewModel.hourError=inputLayout.isErrorEnabled
    }
    @JvmStatic
    fun validateMultiSelect(textView: TextView,context: Context,list: List<Int>,view: View,viewModel: ValidationViewModel){
        val msg="please select one of option"
        val drawable: Drawable? =ContextCompat.getDrawable(context,R.drawable.redborder)
        val drawable1:Drawable?=ContextCompat.getDrawable(context,R.drawable.border)
        if ( list.isEmpty()) {
            textView.text=msg
            textView.visibility=View.VISIBLE
            view.background=drawable
        } else {
            textView.text=null
            textView.visibility=View.GONE
           view.background=drawable1
            viewModel.multiSpinnerError=true
        }
    }
}