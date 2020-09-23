package com.uninorte.a_202030_kotlinsimpleviewmodellivedatawithfragments.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.uninorte.a_202030_kotlinsimpleviewmodellivedatawithfragments.R
import com.uninorte.a_202030_kotlinsimpleviewmodellivedatawithfragments.viewmodel.LoginViewModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class LoginFragment : Fragment() {

    val loginViewModel: LoginViewModel by activityViewModels()
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
                navController.navigate(R.id.HomeFragment)
            }
        })

        view.findViewById<Button>(R.id.buttonLogin).setOnClickListener {
            loginViewModel.setLogged(true)
        }
    }
}