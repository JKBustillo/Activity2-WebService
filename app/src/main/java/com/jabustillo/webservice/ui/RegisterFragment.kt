package com.jabustillo.webservice.ui

import android.os.Bundle
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
import com.jabustillo.webservice.util.PreferenceProvider
import com.jabustillo.webservice.viewmodel.LoginViewModel
import com.jabustillo.webservice.viewmodel.RegisterViewModel
import kotlinx.android.synthetic.main.fragment_register.*

class RegisterFragment : Fragment() {
    private val registerViewModel: RegisterViewModel by activityViewModels()
    private val loginViewModel: LoginViewModel by activityViewModels()
    var theToken : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController()

        registerViewModel.getLogged().observe(viewLifecycleOwner, Observer { logged ->
            if (logged == true) {
                navController.navigate(R.id.homeFragment)
            }
        })

        view.findViewById<Button>(R.id.registerButton).setOnClickListener {
            if (passwordInput.text.toString() == confirmPasswordInput.text.toString()) {
                loginViewModel.signUp(emailInput.text.toString(), passwordInput.text.toString(), userInput.text.toString()).observe(
                    viewLifecycleOwner,
                    Observer { user ->
                        theToken = user.token
                        if (user.token != "") {
                            Toast.makeText(context, "Token " + user.token, Toast.LENGTH_LONG).show()
                            PreferenceProvider.setValue("token", theToken)
                            PreferenceProvider.setValue("user", userInput.text.toString())
                            PreferenceProvider.setValue("email", emailInput.text.toString())
                            PreferenceProvider.setValue("password", passwordInput.text.toString())
                            loginViewModel.setLogged(true)
                        } else {
                            Toast.makeText(
                                    context,
                                    "Token failure " + user.error,
                                    Toast.LENGTH_LONG
                            )
                                    .show()
                        }

                    }
                )
            } else {
                Toast.makeText(
                    requireActivity(),
                    "Las contraseñas no coinciden",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}