package com.jabustillo.webservice.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.jabustillo.webservice.R
import com.jabustillo.webservice.model.Course
import com.jabustillo.webservice.util.PreferenceProvider
import com.jabustillo.webservice.viewmodel.CourseViewModel
import com.jabustillo.webservice.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {
    private val loginViewModel: LoginViewModel by activityViewModels()
    private val courseViewModel: CourseViewModel by activityViewModels()
    var theToken : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController()

        loginViewModel.getLogged().observe(viewLifecycleOwner, Observer { logged ->
            if (logged == true) {
                navController.navigate(R.id.homeFragment)
            }
        })

        view.findViewById<Button>(R.id.loginButton).setOnClickListener {
            if (userLoginInput.text.toString() == PreferenceProvider.getValue("user").toString() && passwordLoginInput.text.toString() == PreferenceProvider.getValue("pass").toString()) {
                // val usuario : String = userLoginInput.text.toString()
                // val clave : String = passwordLoginInput.text.toString()

                val email : String =  "augusto@a.com"
                val clave : String = "123456"
                val usuario : String = "elprofesor"

                loginViewModel.signIn(email,clave,usuario).observe(viewLifecycleOwner, Observer { user ->

                    //Log.d("MyOut", "Fragment  signIn " + user + " error " + user.error)
                    theToken = user.token
                    if (user.token != "") {
                        Toast.makeText(context, "Token " + user.token, Toast.LENGTH_LONG).show()
                        // courseViewModel.getCourses("elprofesor",theToken)
                        PreferenceProvider.setValue("token", theToken)
                        loginViewModel.setLogged(true)
                    } else {
                        Toast.makeText(context, "Token failure " + user.error, Toast.LENGTH_LONG)
                            .show()
                    }

                })
            } else {
                Toast.makeText(
                    requireActivity(),
                    "Credenciales incorrectas",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        view.findViewById<Button>(R.id.gotoRegisterButton).setOnClickListener {
            navController.navigate(R.id.registerFragment)
        }
    }
}
