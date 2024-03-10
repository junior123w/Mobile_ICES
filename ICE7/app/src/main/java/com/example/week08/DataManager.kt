package com.example.week08

import android.content.Context
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory


class DataManager private constructor()
{
    fun getTextFromResource(context: Context, resourceId: Int): String
    {
        return context.resources.openRawResource(resourceId)
            .bufferedReader()
            .use { it.readText()}
    }

    fun getTextFromAsset(context: Context, fileName: String): String
    {
        return context.resources.assets.open(fileName)
            .bufferedReader()
            .use { it.readText()}
    }

    // Updated deserializeJSON to directly return an Array<TVShow>
    fun deserializeJSON(context: Context): Array<TVShow>? {
        val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
        val adapter: JsonAdapter<Array<TVShow>> = moshi.adapter(Array<TVShow>::class.java)
        val contactListRawString = getTextFromResource(context, R.raw.tvshows)
        return adapter.fromJson(contactListRawString)
    }


    companion object
    {
        val instance: DataManager by lazy { DataManager() }
    }
}