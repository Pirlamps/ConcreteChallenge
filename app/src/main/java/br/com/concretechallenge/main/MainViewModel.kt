package br.com.concretechallenge.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import br.com.concretechallenge.experimental.Command
import br.com.concretechallenge.experimental.async
import br.com.concretechallenge.model.UserData

class MainViewModel : ViewModel() {

    private var users: MutableLiveData<List<UserData>>? = MutableLiveData()
    private val command: MutableLiveData<Command>? = MutableLiveData()

    fun getUsers(): LiveData<List<UserData>> {

        users?.takeIf { it.value == null || it.value?.size == 0 }?.let { loadUsers() }

        return users as MutableLiveData
    }

    fun getCommand(): LiveData<Command> {
        return command!!
    }

    fun loadUsers() {
        command?.value = Command.ShowProgress()
        async {
            val dataSet = getData()
            command?.value = Command.HideProgess()
            command?.value = Command.ShowData(dataSet)
        }

    }

    suspend fun getData(): List<UserData> {
        Thread.sleep(4000)
        return listOf(
                UserData("Matheus0", "Rua Coronel Oscar Porto 200", ""),
                UserData("Matheus1", "Rua Coronel Oscar Porto 201", ""),
                UserData("Matheus2", "Rua Coronel Oscar Porto 202", ""),
                UserData("Matheus3", "Rua Coronel Oscar Porto 203", ""),
                UserData("Matheus4", "Rua Coronel Oscar Porto 204", ""),
                UserData("Matheus5", "Rua Coronel Oscar Porto 205", ""),
                UserData("Matheus6", "Rua Coronel Oscar Porto 206", ""),
                UserData("Matheus7", "Rua Coronel Oscar Porto 207", ""),
                UserData("Matheus8", "Rua Coronel Oscar Porto 208", ""),
                UserData("Matheus9", "Rua Coronel Oscar Porto 209", "")
        )
    }
}