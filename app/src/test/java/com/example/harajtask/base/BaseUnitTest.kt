package com.example.harajtask.base

import com.example.harajtask.essential.data.Post
import com.example.harajtask.essential.util.StaticHelper
import com.example.harajtask.util.InstantExecutorExtension
import com.google.gson.Gson
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.Rule
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnit


@ExperimentalCoroutinesApi
@ExtendWith(InstantExecutorExtension::class)
abstract class BaseUnitTest {
    private val staticHelper = mock<StaticHelper>()
    private val testCoroutineDispatcher = TestCoroutineDispatcher()

    val listMockPost = listOf(
        Post(
            title = "ساعات أطقم رجالي ونسائي",
            username = "عالم النحلة",
            thumbURL = "https://s3-eu-west-1.amazonaws.com/img4.haraj.com.sa/cache4/480x640-1_-J5O3opoUD8LCsJ.jpg",
            commentCount = 0,
            city = "جده",
            date = 1619655809,
            body = "🌹عروض العيد 🌹\nخصم يصل إلى 50%\n#أطقم ساعات رجالية أنيقة كشخة الساعات الأكثر رغبة وطلبا🎁\n#ساعة ⌚\n# قلم 🖋️\n#سبحة\n#كبك\n#علبة\n#كرت ضمان\nسعر الطقم 100 غير شامل التوصيل\n*للعلم *ضمان لمدة سنة من تاريخ الشراء\n_____________________________________\n#اطقم ساعات نسائية أنيقة كشخة الساعات الأكثر رغبة وطلبا... \n#ساعة \n#ثلاث اسورات \n#علبة \n#كرت \n# ضمان \nسعر الطقم 100ريال فقط. \n*للعلم *ضمان لمدة سنة من تاريخ الشراء \n_____________________________________\nللطلب والاستفسار التواصل على الرقم 0577802537 📲"
        )
    )

    @Rule
    @JvmField
    val mockitoRule = MockitoJUnit.rule()!!

    @BeforeEach
    open fun before() {
        MockitoAnnotations.initMocks(this)
        Dispatchers.setMain(this.testCoroutineDispatcher)

        val gson = Gson()
        whenever(staticHelper.getSystemTimeInMillis()).thenReturn(1_628_473_561_000)
        whenever(staticHelper.getAssetJson(null, gson)).thenReturn(listMockPost)
    }

    @AfterEach
    open fun after() {
        Dispatchers.resetMain()
    }
}