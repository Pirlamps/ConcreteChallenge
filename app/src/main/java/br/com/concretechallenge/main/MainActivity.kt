package br.com.concretechallenge.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View.GONE
import android.view.View.VISIBLE
import br.com.concretechallenge.R
import br.com.concretechallenge.experimental.Command
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mainAdapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val model = ViewModelProviders.of(this).get(MainViewModel::class.java)

        mainAdapter = MainAdapter()
        val linearLayoutManager = LinearLayoutManager(this)

        main_rv.apply {
            adapter = mainAdapter
            layoutManager = linearLayoutManager
            setHasFixedSize(true)
            addItemDecoration(DividerItemDecoration(context, linearLayoutManager.orientation))
        }

        sync_fab.setOnClickListener {
            model.loadUsers()
        }

        model.getCommand().observe(this, Observer { command -> executor(command) })
    }

    private fun executor(command: Command?) {
        when (command) {
            is Command.ShowProgress -> progressBar_cyclic.visibility = VISIBLE
            is Command.HideProgess -> progressBar_cyclic.visibility = GONE
            is Command.ShowData -> mainAdapter.setData(command.data)
        }
    }
}
