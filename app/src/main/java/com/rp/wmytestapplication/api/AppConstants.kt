package com.rp.wmytestapplication.api

object AppConstants {

    private val BASE_HOST = String.format("https://gist.githubusercontent.com/peymano-wmt/32dcb892b06648910ddd40406e37fdab/raw/db25946fd77c5873b0303b858e861ce724e0dcd0/")

    fun getBaseHost(): String {
        return BASE_HOST
    }

    const val COUNTRY_LIST_URL: String = "countries.json"
}