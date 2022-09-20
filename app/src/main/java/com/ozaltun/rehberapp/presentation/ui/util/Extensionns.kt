package com.ozaltun.rehberapp.presentation.ui.util

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation


fun Navigation.go(it: View, id: Int) {
    findNavController(it).navigate(id)
}

fun Navigation.go(it: View, id: NavDirections) {
    findNavController(it).navigate(id)
}
