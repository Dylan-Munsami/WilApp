package vcmsa.projects.wilapp.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import vcmsa.projects.wilapp.R

class LoginFragment : Fragment() {

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_login, container, false)

        val emailEditText: EditText = root.findViewById(R.id.editTextEmail)
        val passwordEditText: EditText = root.findViewById(R.id.editTextPassword)
        val loginButton: Button = root.findViewById(R.id.buttonLogin)

        loginButton.setOnClickListener {
            // Handle login logic here
        }

        return root
    }
}
