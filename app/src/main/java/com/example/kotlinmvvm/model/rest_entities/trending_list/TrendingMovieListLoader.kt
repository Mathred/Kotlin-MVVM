package com.example.kotlinmvvm.model.rest_entities.trending_list

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.kotlinmvvm.model.repository.RepositoryImpl
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import java.util.stream.Collectors
import javax.net.ssl.HttpsURLConnection

object TrendingMovieListLoader {
    fun loadTrendingMovieList(timeWindow: TimeWindow, mediaType: MediaType): TrendingLists? {
        val mediaTypeString: String
        when (mediaType) {
            MediaType.MOVIE -> mediaTypeString = "movie"
            MediaType.TV -> mediaTypeString = "tv"
        }

        val timeWindowString: String
        when (timeWindow) {
            TimeWindow.DAY -> timeWindowString = "day"
            TimeWindow.WEEK -> timeWindowString = "week"
        }

        try {
            val uri =
                URL("https://api.themoviedb.org/3/trending/${mediaTypeString}/${timeWindowString}day?api_key=${RepositoryImpl.API_KEY_V3}")

            lateinit var urlConnection: HttpURLConnection
            try {
                urlConnection = uri.openConnection() as HttpsURLConnection
                urlConnection.requestMethod = "GET"
                urlConnection.readTimeout = 10000
                val bufferedReader = BufferedReader(InputStreamReader(urlConnection.inputStream))
                val lines = if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                    getLinesForOld(bufferedReader)
                } else {
                    getLines(bufferedReader)
                }
                if (mediaType == MediaType.MOVIE) return Gson().fromJson(
                    lines,
                    TrendingMovieListDTO::class.java
                )
                else if (mediaType == MediaType.TV) return Gson().fromJson(
                    lines,
                    TrendingTVListDTO::class.java
                )
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                urlConnection.disconnect()
            }
        } catch (e: MalformedURLException) {
            e.printStackTrace()
        }
        return null
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun getLines(reader: BufferedReader): String {
        return reader.lines().collect(Collectors.joining("\n"))
    }

    private fun getLinesForOld(reader: BufferedReader): String {
        val rawData = StringBuilder(1024)
        var tempVariable: String?

        while (reader.readLine().also { tempVariable = it } != null) {
            rawData.append(tempVariable).append("\n")
        }

        reader.close()
        return rawData.toString()
    }

    enum class TimeWindow {
        DAY, WEEK
    }

    enum class MediaType {
        MOVIE, TV
    }
}