import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.lang.System.currentTimeMillis
import java.lang.Thread.sleep


interface StringCalculator {

    fun lengthOf(string: String): Int

    fun upperCaseOf(string: String): String
}

class SlowStringCalculator : StringCalculator {

    override fun lengthOf(string: String): Int {
        sleep(100)
        return string.length
    }

    override fun upperCaseOf(string: String): String {
        sleep(100)
        return string.toUpperCase()
    }
}

interface HasTestCalculator {
    val stringCalculator: StringCalculator
}

interface FirstExamplesUsingString : HasTestCalculator {

    @Test
    fun `string length is correct`() {
        assertEquals(stringCalculator.lengthOf("ab"), 2)
    }
}

interface SecondExamplesUsingString : HasTestCalculator {

    @Test
    fun `string uppercase is correct`() {
        assertEquals(stringCalculator.upperCaseOf("abc"), "ABC")
    }
}

class SlowStringCalculatorTests : SecondExamplesUsingString, FirstExamplesUsingString {
    override val stringCalculator = SlowStringCalculator()
}

class FastStringCalculator : StringCalculator {

    override fun lengthOf(string: String): Int {
        return string.length
    }

    override fun upperCaseOf(string: String): String {
        return string.toUpperCase()
    }
}

class FastStringCalculatorTests : SecondExamplesUsingString, FirstExamplesUsingString {
    override val stringCalculator = FastStringCalculator()

    @Test
    fun `another test for fast calculator`() {
        val startTime = currentTimeMillis()
        stringCalculator.upperCaseOf("abc")
        val endTime = currentTimeMillis()
        assertTrue(endTime - startTime < 100)
    }
}
