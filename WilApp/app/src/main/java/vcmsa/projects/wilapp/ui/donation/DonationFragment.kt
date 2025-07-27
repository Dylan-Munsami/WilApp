package vcmsa.projects.wilapp.ui.donation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import vcmsa.projects.wilapp.R
import vcmsa.projects.wilapp.databinding.FragmentDonationBinding

class DonationFragment : Fragment() {

    private var _binding: FragmentDonationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val donationViewModel =
            ViewModelProvider(this).get(DonationViewModel::class.java)

        _binding = FragmentDonationBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDonation
        donationViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cardZapper.setOnClickListener {
            findNavController().navigate(R.id.nav_zapper)
        }

        binding.cardPaypal.setOnClickListener {
            findNavController().navigate(R.id.nav_paypal)
        }

        binding.cardEft.setOnClickListener {
            findNavController().navigate(R.id.nav_eft)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
