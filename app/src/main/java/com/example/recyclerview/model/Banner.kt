package com.example.recyclerview.model

import com.example.recyclerview.R

class Banner(val image: Int, val name: String) {
    companion object {
        fun getBanners(): ArrayList<Banner> {
            return arrayListOf(
                Banner(R.drawable.music_banner, "Banner 1"),
                Banner(R.drawable.music_banner, "Banner 2"),
                Banner(R.drawable.music_banner, "Banner 3"),
                Banner(R.drawable.music_banner, "Banner 4"),
                Banner(R.drawable.music_banner, "Banner 5"),
                Banner(R.drawable.music_banner, "Banner 6"),
                Banner(R.drawable.music_banner, "Banner 7"),
                Banner(R.drawable.music_banner, "Banner 8"),
                Banner(R.drawable.music_banner, "Banner 9"),
                Banner(R.drawable.music_banner, "Banner 10"),
                Banner(R.drawable.music_banner, "Banner 11"),
                Banner(R.drawable.music_banner, "Banner 12"),
                Banner(R.drawable.music_banner, "Banner 13"),
                Banner(R.drawable.music_banner, "Banner 14"),
                Banner(R.drawable.music_banner, "Banner 15"),
            )
        }
    }

}