package br.com.concretechallenge.experimental

import br.com.concretechallenge.model.Item

sealed class Command {
    class ShowProgress : Command()
    class HideProgess : Command()
    class ShowData(val data: List<Item>) : Command()
}