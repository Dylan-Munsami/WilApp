package vcmsa.projects.wilapp.ui.volunteer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class VolunteerViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is volunteer Fragment"
    }
    val text: LiveData<String> = _text
}