package vcmsa.projects.wilapp.ui.donation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import vcmsa.projects.wilapp.databinding.FragmentDonationBinding

class DonationFragment : Fragment() {

    private var _binding: FragmentDonationBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}