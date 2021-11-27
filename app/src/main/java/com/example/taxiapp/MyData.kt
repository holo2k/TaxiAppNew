package com.example.taxiapp

data class guide(val title:String, val desc: String, val image: Int)

data class data_cars(val title:String, val image:Int)

data class login(val id:String,
                 val phone:String,
                 val nickName:String,
                 val avatar:String,
                 val token:String)
data class feelings(val success:Boolean, val data: ArrayList<data_feelings>)
data class data_feelings(val id:Int, val title:String, val image:String, val position: Int, val from:String,val to:String)


object list {
    val list = arrayListOf(
        guide
            (
            "Быстрая доставка",
            "Наши сотрудники выезжают очень оперативно и быстро Наши сотрудники выезжают очень оперативно и быстро Наши сотрудники выезжают очень оперативно и быстро Наши сотрудники выезжают очень оперативно и быстро.",
            R.drawable.taxi
            ),
        guide
            (
            "Хорошее обслуживание",
            "Вежливые водители и машины высшего класса Вежливые водители и машины высшего класса Вежливые водители и машины высшего класса Вежливые водители и машины высшего класса Вежливые водители и машины высшего класса .",
            R.drawable.kubok
        ),
        guide
            (
            "Работаем 24/7",
            "Вы можете заказать такси в любое время суток Вы можете заказать такси в любое время сутокВы можете заказать такси в любое время сутокВы можете заказать такси в любое время сутокВы можете заказать такси в любое время суток.",
            R.drawable.allday
        )
    )

}

object listOfCars{
    val listOfCars= arrayListOf(
        data_cars(
            "Эконом",
            R.drawable.econom
        ),
        data_cars(
            "Комфорт",
            R.drawable.comfort
        ),
        data_cars("Бизнес",
        R.drawable.business)
    )
}
