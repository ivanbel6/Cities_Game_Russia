import org.testng.Assert.assertFalse
import org.testng.AssertJUnit.*
import org.testng.annotations.Test

class CitiesGameTest{
    @Test
    fun testIsCityValidWithCorrectInput() {
        val game = CitiesGame()

        val result = game.isCityValid("Moscow", "Washington")

        assertTrue(result)
    }

    @Test
    fun testisCityValidWithWrongNameOfCity() {
        val game = CitiesGame()

        val result = game.isCityValid("Mars", "Washington")

        assertFalse(result)
    }

    @Test
    fun testIsCityValidWithWrongFirstLetterOfCity() {
        val game = CitiesGame()

        val result = game.isCityValid("London", "Paris")

        assertFalse(result)
    }

    @Test
    fun testisCityValidWithEmptyCityName() {
        val game = CitiesGame()

        val result = game.isCityValid("", "Paris")

        assertFalse(result)
    }


}