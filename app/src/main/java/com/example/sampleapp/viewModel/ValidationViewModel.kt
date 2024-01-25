package com.example.sampleapp.viewModel

import android.widget.TextView
import androidx.lifecycle.ViewModel

class ValidationViewModel:ViewModel() {
    var name:String?=null
    var email:String?=null
    var password:String?=null
    var confirmPassword:String?=null
    var date:String?=null
    var time:String?=null

    var nameError:Boolean?=null
    var emailError:Boolean?=null
    var passwordError:Boolean?=null
    var confirmPasswordError:Boolean?=null
    var dateError:Boolean?=null
    var hourError:Boolean?=null
    var radioError:Boolean=false
    var spinnerError:Boolean=false
    var multiSpinnerError:Boolean=false

}