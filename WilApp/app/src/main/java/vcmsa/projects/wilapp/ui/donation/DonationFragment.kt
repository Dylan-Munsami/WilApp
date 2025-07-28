package vcmsa.projects.wilapp.ui.donation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
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

        // Payment method navigation
        binding.cardZapper.setOnClickListener {
            findNavController().navigate(R.id.nav_zapper)
        }

        binding.cardPaypal.setOnClickListener {
            findNavController().navigate(R.id.nav_paypal)
        }

        binding.cardEft.setOnClickListener {
            findNavController().navigate(R.id.nav_eft)
        }

        // Slider logic: live update text + fill input field
        binding.seekBarAmount.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val amount = progress + 50 // Start at R50
                val meals = amount / 50    // R50 = 1 person
                binding.tvSliderFeedback.text = "You're donating R$amount — that feeds $meals ${if (meals == 1) "person" else "people"}!"
                binding.editAmount.setText(amount.toString())
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        // Optional: initialize feedback on load
        val initialAmount = binding.seekBarAmount.progress + 50
        val initialMeals = initialAmount / 50
        binding.tvSliderFeedback.text = "You're donating R$initialAmount — that feeds $initialMeals ${if (initialMeals == 1) "person" else "people"}!"
        binding.editAmount.setText(initialAmount.toString())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
