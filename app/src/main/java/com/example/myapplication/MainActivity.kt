 package com.example.myapplication

import android.icu.text.CaseMap
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.ParcelFileDescriptor
import android.view.View
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.itme_pager.*
import me.relex.circleindicator.CircleIndicator
import me.relex.circleindicator.CircleIndicator3


 class MainActivity : AppCompatActivity() {
    private var skipList = mutableListOf<String>()
    private var themeList = mutableListOf<String>()
    private var aboutList = mutableListOf<String>()
     private var imagelist = mutableListOf<Int>()
     lateinit var listAbout:ArrayList<String>
     lateinit var listTheme:ArrayList<String>
     lateinit var listImage:ArrayList<Int>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        actionBar?.hide()
        supportActionBar?.hide()
        listAbout = ArrayList()
        listTheme = ArrayList()
        listImage = ArrayList()

        sync()
        posToList()




        view_pager2.adapter = ViewPagerAdapter(skipList,themeList,aboutList)
        view_pager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        val indicator = findViewById<CircleIndicator3>(R.id.indicator)
        indicator.setViewPager(view_pager2)

    }
    private fun addToList(skip: String, theme: String, about: String,img:Int){
        skipList.add(skip)
        themeList.add(theme)
        aboutList.add(about)
        imagelist.add(img)

    }
     private fun posToList(){
         for (i in 0..3){
             addToList("O`tkazib yuborish",listTheme[i],listAbout[i],listImage[i])
         }
     }
     private fun sync(){
         listTheme.add("Xush kelibsiz")
         listAbout.add("Kim ko`ribdur, ey ko`ngil, ahli jaxondin yaxshilig`,\nKimki, ondin yaxshi yo`q, ko`z tutma ondin yaxshilig`")
         listTheme.add("Hikoyalar dunyosi")
         listAbout.add("Gar zamonni nayf qilsam ayib qilma, ey rafiq,   Ko`rmadim hargiz,netoyin,bu zamondin yaxshilig`!")
         listTheme.add("Kitob ortidan...")
         listAbout.add("Dilrabolardin yomonliq keldi mahzun ko`ngluma, Kelmadi jonimg`a hech oromi jondin yaxshilig`.")
         listTheme.add("Bizga qo`shiling")
         listAbout.add("Ey ko`ngul, chun yaxshidin ko`rdung yomonliq asru ko`p, Emdi ko`z tutmoq  ne ma`ni har yamondin yaxshilig`? ")
         listImage.add(R.drawable.earphone)
         listImage.add(R.drawable.earphones_2)
         listImage.add(R.drawable.earphones_3)
         listImage.add(R.drawable.ic_launcher_background)


     }
}