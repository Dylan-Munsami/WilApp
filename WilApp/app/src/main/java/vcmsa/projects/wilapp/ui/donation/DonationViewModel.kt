package vcmsa.projects.wilapp.ui.donation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DonationViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Make a Donation"
    }
    val text: LiveData<String> = _text

}
