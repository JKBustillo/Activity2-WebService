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
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {
    private val loginViewModel: LoginViewModel by activityViewModels()

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
                loginViewModel.setLogged(true)
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
