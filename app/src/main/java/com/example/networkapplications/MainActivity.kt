package com.example.networkapplications

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.networkapplications.*
import com.example.networkapplications.entity.Fact

class MainActivity : AppCompatActivity(), OnFragmentDataListener {
    private val MY_SETTINGS = "my_settings"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fm = supportFragmentManager
        var fragment = fm.findFragmentById(R.id.fragmentContainer)
        if(fragment == null){
            fragment = MainFragment()
            fm.beginTransaction()
                .add(R.id.fragmentContainer, fragment, MainFragment.TAG)
                .commit()
        }
        val sp: SharedPreferences = getSharedPreferences(MY_SETTINGS,
            Context.MODE_PRIVATE)
        val hasVisited = sp.getBoolean("hasVisited", false)
        if(!hasVisited){
            val dialogNotification = DialogNotification()
            val fragmentManager = supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            dialogNotification.show(transaction, "dialog")
            val e = sp.edit()
            e.putBoolean("hasVisited", true)
            e.apply()
        }
    }

    override fun onOpenAboutFragment(fact: Fact?) {
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragment: Fragment? = fragmentManager.findFragmentById(R.id.fragmentContainer)
        if(fragment is MainFragment) {
            val fragmentReplace = AboutFragment()

            val bundle = Bundle()
            bundle.putParcelable("facts", fact)
            Log.e("Text", fact?.text + " text")
            fragmentReplace.arguments = bundle
            fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragmentReplace, MainFragment.TAG)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .addToBackStack(MainFragment.TAG)
                .commit()
        }
    }
}