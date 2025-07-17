package vcmsa.projects.wilapp.ui.oursocials

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import vcmsa.projects.wilapp.databinding.FragmentOursocialsBinding

class OurSocialsFragment : Fragment() {

    private var _binding: FragmentOursocialsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val oursocialsViewModel =
            ViewModelProvider(this).get(OurSocialsViewModel::class.java)

        _binding = FragmentOursocialsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textOursocials
        oursocialsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}