package br.com.concretechallenge.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import br.com.concretechallenge.experimental.Command
import kotlinx.coroutines.experimental.async

class MainViewModel : ViewModel() {

    private val command: MutableLiveData<Command> = MutableLiveData()
    private val controller = MainController()

    fun getCommand(): LiveData<Command> {
        return command
    }

    fun loadRepos() {
        command.value = Command.ShowProgress()
        async {
            val dataSet = controller.getRepos()
            command.postValue(Command.HideProgess())
            command.postValue(Command.ShowData(dataSet.items))
        }

    }

}