package com.example.harajtask.feature.home

import com.example.harajtask.base.BaseUnitTest
import com.example.harajtask.feature.home.repository.HomeRepository
import com.example.harajtask.feature.home.viewmodel.HomeViewModel
import com.example.harajtask.util.UnitTestExtension.getOrAwaitValue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

@ExperimentalCoroutinesApi
class HomeViewModelTest : BaseUnitTest() {

    private val repository = HomeRepository()

    private val viewModel = HomeViewModel(repository)

    @Test
    fun `get data`() {
        this.viewModel.getData(null)
        val data = viewModel.postData.getOrAwaitValue()
        assertEquals("ساعات أطقم رجالي ونسائي", data?.get(0)?.title)
        assertEquals("عالم النحلة", data?.get(0)?.username)
        assertEquals(
            "https://s3-eu-west-1.amazonaws.com/img4.haraj.com.sa/cache4/480x640-1_-J5O3opoUD8LCsJ.jpg",
            data?.get(0)?.thumbURL
        )
        assertEquals(0, data?.get(0)?.commentCount)
        assertEquals("جده", data?.get(0)?.city)
        assertEquals(1619655809, data?.get(0)?.date)
        assertEquals(
            "🌹عروض العيد 🌹\nخصم يصل إلى 50%\n#أطقم ساعات رجالية أنيقة كشخة الساعات الأكثر رغبة وطلبا🎁\n#ساعة ⌚\n# قلم 🖋️\n#سبحة\n#كبك\n#علبة\n#كرت ضمان\nسعر الطقم 100 غير شامل التوصيل\n*للعلم *ضمان لمدة سنة من تاريخ الشراء\n_____________________________________\n#اطقم ساعات نسائية أنيقة كشخة الساعات الأكثر رغبة وطلبا... \n#ساعة \n#ثلاث اسورات \n#علبة \n#كرت \n# ضمان \nسعر الطقم 100ريال فقط. \n*للعلم *ضمان لمدة سنة من تاريخ الشراء \n_____________________________________\nللطلب والاستفسار التواصل على الرقم 0577802537 📲",
            data?.get(0)?.body
        )
    }

    @Test
    fun `get data with filter`() {
        this.viewModel.getData(null, filter = "faisal")
        val data = viewModel.postData.getOrAwaitValue()
        assertEquals(null, data?.get(0)?.title)
    }
}