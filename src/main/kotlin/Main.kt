import kotlin.random.Random

val arrayCity: Array<String> = arrayOf("Москва","Санкт-Петербург","Барнаул","Омск","Екатеринбург",
    "Бабаево","Псков","Тверь","Сочи","Петрозаводск","Нью-Йорк","Лондон","Париж","Владивосток","Воронеж")
fun main(args: Array<String>) {
    var answer = ""
    while(answer != "EXIT") {

        val ListRoute = mutableListOf<String>()
        randomCity(ListRoute)
        val countPassengers = Random.nextInt(5, 202)

        val train = mutableListOf<wagon>()
        var remainderPassengers = countPassengers

        while (remainderPassengers > 0) {
            val wagonCapasity = Random.nextInt(5, 26)
            var passengersInWagon: Int
            if (remainderPassengers < wagonCapasity)
                passengersInWagon = remainderPassengers
            else
                passengersInWagon = wagonCapasity
            train.add(wagon(wagonCapasity, passengersInWagon))
            remainderPassengers -= passengersInWagon
        }

        println("Поезд из направления ${ListRoute[0]} - ${ListRoute[1]} состоит из ${train.size} вагонов отправляется!")
        var count = 0
        for (i in train) {
            println("Вагон ${count + 1}: вместимость ${i.capasity}, пассажиров в вагоне: ${i.countPassengers}")
            count++
        }

        println("Хотите отправить ещё один поезд? Для выхода напишите EXIT")
        answer = readln();
    }

}

fun randomCity(ListRoute: MutableList<String>){
    val random1 = Random.nextInt(0,arrayCity.size - 1)
    var random2 = Random.nextInt(0,arrayCity.size - 1)
    while (random1 == random2)
        random2 = Random.nextInt(0,arrayCity.size - 1)
    ListRoute.add(arrayCity[random1])
    ListRoute.add(arrayCity[random2])
}