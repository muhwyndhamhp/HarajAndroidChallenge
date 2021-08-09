package com.example.harajtask.feature.detail

import com.example.harajtask.base.BaseUnitTest
import com.example.harajtask.feature.detail.viewmodel.DetailViewModel
import com.example.harajtask.util.UnitTestExtension.getOrAwaitValue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@ExperimentalCoroutinesApi
class DetailViewModelTest : BaseUnitTest() {

    private val viewModel = DetailViewModel()

    @Test
    fun `set post data to ViewModel`() {
        this.viewModel.setPostData(listMockPost[0])
        val data = viewModel.postData.getOrAwaitValue()
        Assertions.assertEquals("ساعات أطقم رجالي ونسائي", data.title)
        Assertions.assertEquals("عالم النحلة", data.username)
        Assertions.assertEquals(
            "https://s3-eu-west-1.amazonaws.com/img4.haraj.com.sa/cache4/480x640-1_-J5O3opoUD8LCsJ.jpg",
            data.thumbURL
        )
        Assertions.assertEquals(0, data.commentCount)
        Assertions.assertEquals("جده", data.city)
        Assertions.assertEquals(1619655809, data.date)
        Assertions.assertEquals(
            "🌹عروض العيد 🌹\nخصم يصل إلى 50%\n#أطقم ساعات رجالية أنيقة كشخة الساعات الأكثر رغبة وطلبا🎁\n#ساعة ⌚\n# قلم 🖋️\n#سبحة\n#كبك\n#علبة\n#كرت ضمان\nسعر الطقم 100 غير شامل التوصيل\n*للعلم *ضمان لمدة سنة من تاريخ الشراء\n_____________________________________\n#اطقم ساعات نسائية أنيقة كشخة الساعات الأكثر رغبة وطلبا... \n#ساعة \n#ثلاث اسورات \n#علبة \n#كرت \n# ضمان \nسعر الطقم 100ريال فقط. \n*للعلم *ضمان لمدة سنة من تاريخ الشراء \n_____________________________________\nللطلب والاستفسار التواصل على الرقم 0577802537 📲",
            data.body
        )
    }
}