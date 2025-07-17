package vcmsa.projects.wilapp.ui.oursocials

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OurSocialsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is our socials Fragment"
    }
    val text: LiveData<String> = _text
}