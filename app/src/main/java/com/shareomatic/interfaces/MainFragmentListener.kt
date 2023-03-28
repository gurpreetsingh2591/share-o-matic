package com.shareomatic.interfaces

import com.shareomatic.annotation.FragmentType


interface MainFragmentListener {
    fun showFragment(@FragmentType tag:String, payload:String?)
    fun popTillFragment( tag:String,  flag:Int)
    fun popTopMostFragment()
    fun backTopMostFragment()
    fun drawerOpen()
}