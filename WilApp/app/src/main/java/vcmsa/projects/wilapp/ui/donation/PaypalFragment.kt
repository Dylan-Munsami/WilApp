package vcmsa.projects.wilapp.ui.donation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import vcmsa.projects.wilapp.databinding.FragmentPaypalBinding

class PaypalFragment : Fragment() {

    private var _binding: FragmentPaypalBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // val paypalViewModel = ViewModelProvider(this).get(PaypalViewModel::class.java)

        _binding = FragmentPaypalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
