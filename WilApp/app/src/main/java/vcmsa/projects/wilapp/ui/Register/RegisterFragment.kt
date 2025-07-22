package vcmsa.projects.wilapp.ui.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import vcmsa.projects.wilapp.R
import vcmsa.projects.wilapp.ui.login.RegisterViewModel

class RegisterFragment : Fragment() {

    private lateinit var registerViewModel: RegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        registerViewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_register, container, false)

        val nameEditText: EditText = root.findViewById(R.id.editTextName)
        val emailEditText: EditText = root.findViewById(R.id.editTextEmail)
        val passwordEditText: EditText = root.findViewById(R.id.editTextPassword)
        val registerButton: Button = root.findViewById(R.id.buttonRegister)

        registerButton.setOnClickListener {
            // Handle registration logic here
        }

        return root
    }
}
