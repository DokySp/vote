package space.doky.voting.presenter

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import space.doky.voting.presenter.databinding.ActivitySecondBinding
import space.doky.voting.presenter.viewmodel.SecondViewModel

@AndroidEntryPoint
class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    private val viewModel: SecondViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        initButton()
    }

    private fun initView() {
        lifecycleScope.launch {
            viewModel.getThumbUpFlow().collect {
                binding.labelDisplay.text = it
            }
        }
    }

    private fun initButton() {
        binding.buttonThumbUp.setOnClickListener {
            lifecycleScope.launch {
                viewModel.setThumbUp()
//                    .apply {
//                    binding.labelDisplay.text = this
//                }
            }
        }
    }
}