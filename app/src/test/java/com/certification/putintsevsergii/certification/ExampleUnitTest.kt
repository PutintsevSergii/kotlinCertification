package com.certification.putintsevsergii.certification

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.content.Context
import com.certification.putintsevsergii.certification.database.AppDatabase
import com.certification.putintsevsergii.certification.networking.NetworkManager
import com.certification.putintsevsergii.certification.networking.data.ChartsResponse
import com.certification.putintsevsergii.certification.networking.data.Feed
import com.certification.putintsevsergii.certification.networking.data.Result
import org.junit.*

import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import retrofit2.mock.Calls
/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Rule
    @JvmField
    var rule = InstantTaskExecutorRule()

    val arr = ArrayList<Result>()
    val mockResp = ChartsResponse(Feed(arr))

    private lateinit var vm: TopChartsViewModel
    private lateinit var repo: TopChartsRepository
    @Mock
    lateinit var client: NetworkManager
    @Mock
    lateinit var database: AppDatabase

    @Mock
    private lateinit var mMockContext: Context

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        Mockito.`when`(client.getTopSongCharts(10))
                .thenReturn(Calls.response(mockResp))

    }

    @Test
    fun testVmInitialized() {

        repo = TopChartsRepository(client, database)
        Assert.assertNotNull(repo)

        val result = repo.fetchTopSongCarts(10)
       Assert.assertEquals("Checks mock call successfull" , 0, result?.size )
    }
}
