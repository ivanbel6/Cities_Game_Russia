import java.util.*
import java.io.File
import kotlin.system.exitProcess

class CitiesGame {
    private val cities: List<String> = loadCitiesFromFile()
    private var currentPlayerIndex = 0

    fun play() {
        var lastCity = ""
        while (true) {
            val currentPlayer = getPlayer(currentPlayerIndex)
            println("${currentPlayer.name}, ваш ход:")
            val city = currentPlayer.takeTurn(lastCity)
            if (isCityValid(city, lastCity)) {
                lastCity = city
                currentPlayerIndex = (currentPlayerIndex + 1) % 2
            } else {
                println("Ошибка! Вы ввели неверный город.")
                println("${currentPlayer.name} проиграл!")
                break
            }
        }
    }

    private fun isCityValid(city: String, lastCity: String): Boolean {
        if (city.isEmpty()) return false
        if (!cities.contains(city)) return false
        if (lastCity.isNotEmpty() && city[0].toUpperCase() != lastCity[lastCity.lastIndex].toUpperCase()) return false
        return true
    }

    private fun getPlayer(playerIndex: Int): Player {
        return if (playerIndex == 0) {
            Player("Игрок 1")
        } else {
            Player("Игрок 2")
        }
    }

    private fun loadCitiesFromFile(): List<String> {
        val cities: MutableList<String> = mutableListOf()
        val file = File("cities.txt")
        val scanner = Scanner(file)

        while (scanner.hasNextLine()) {
            val city = scanner.nextLine()
            cities.add(city)
        }

        scanner.close()
        return cities
    }
}

data class Player(val name: String) {
    private val scanner = Scanner(System.`in`)

    fun takeTurn(lastCity: String): String {
        val timer = Timer()
        val cityThread = CityThread()
        timer.schedule(cityThread, 10000L)

        println("Вам осталось 10 секунд чтобы назвать город:")
        val city = scanner.nextLine().trim()

        timer.cancel()

        return city
    }

    private inner class CityThread : TimerTask() {
        override fun run() {
            println("Время вышло!")
            exitProcess(0)
        }
    }
}

fun main() {
    val game = CitiesGame()
    game.play()
}
