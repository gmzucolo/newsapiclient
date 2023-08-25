package com.example.newsapiclient.data.api

import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsApiServiceTest {
    private lateinit var server: MockWebServer
    private lateinit var apiService: NewsApiService

    @Before
    fun setUp() {
        server = MockWebServer()
        apiService = Retrofit.Builder()
            .baseUrl(server.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApiService::class.java)
    }

    private fun enqueueMockResponse(
        fileName: String
    ) {
        val inputStream = javaClass.classLoader!!.getResourceAsStream(fileName)
        val source = inputStream.source().buffer()
        val mockResponse = MockResponse()
        server.enqueue(
            mockResponse
                .setBody(source.readString(Charsets.UTF_8))
        )
    }

    @Test
    fun getTopHeadlines_sentRequest_receivedExpected() {
        runBlocking {
            // GIVEN
            enqueueMockResponse("newsresponse.json")
            // WHEN
            val responseBody = apiService.getTopHeadlines("us", 1).body()
            // THEN
            val request = server.takeRequest()
            assertThat(responseBody).isNotNull()
            assertThat(request.path).isEqualTo("/v2/top-headlines?country=us&page=1&apiKey=3718b52364ee4df3af586a80d4cc5000")
        }
    }

    @Test
    fun getTopHeadlines_receivedResponse_correctPageSize() {
        runBlocking {
            // GIVEN
            enqueueMockResponse("newsresponse.json")
            // WHEN
            val responseBody = apiService.getTopHeadlines("us", 1).body()
            // THEN
            val articleList = responseBody!!.articles
            assertThat(articleList.size).isEqualTo(20)
        }
    }

    @Test
    fun getTopHeadlines_receivedResponse_correctContent() {
        runBlocking {
            // GIVEN
            enqueueMockResponse("newsresponse.json")
            // WHEN
            val responseBody = apiService.getTopHeadlines("us", 1).body()
            // THEN
            val articleList = responseBody!!.articles
            val article = articleList[0]
            assertThat(article.author).isEqualTo("")
            assertThat(article.url).isEqualTo("https://www.cbssports.com/mlb/news/shohei-ohtani-injury-angels-superstar-leaves-game-with-arm-fatigue-in-second-inning-but-no-pain/")
            assertThat(article.publishedAt).isEqualTo("2023-08-23T23:42:00Z")
        }
    }

    @After
    fun tearDown() {
        server.shutdown()
    }
}