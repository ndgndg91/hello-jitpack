package extensions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class AnyExtKtTest {
    @Test
    @DisplayName("doWhenNotNull_String_type")
    fun doWhenNotNull_String() {
        // given
        val nullTarget: String? = null
        val nonNullTarget = "ndgndg91"
        var nullTargetInvoked = false
        var nonNullTargetInvoked = false

        // when
        nullTarget.doWhenNotNull { nullTargetInvoked = true }
        nonNullTarget.doWhenNotNull { nonNullTargetInvoked = true }

        // then
        assertThat(nullTargetInvoked).isFalse()
        assertThat(nonNullTargetInvoked).isTrue()
    }

    @Test
    @DisplayName("doWhenNotNull_Number_type")
    fun doWhenNotNull_Number() {
        // given
        val nullIntTarget: Int? = null
        val nullLongTarget: Long? = null
        val nullDoubleTarget: Double? = null
        val nonNullIntTarget = 100
        val nonNullLongTarget = 1000L
        val nonNullDoubleTarget = 1.0
        var nullIntInvoked = false
        var nullLongInvoked = false
        var nullDoubleInvoked = false
        var nonNullIntInvoked = false
        var nonNullLongInvoked = false
        var nonNullDoubleInvoked = false


        // when
        nullIntTarget.doWhenNotNull { nullIntInvoked = true }
        nullLongTarget.doWhenNotNull { nullLongInvoked = true }
        nullDoubleTarget.doWhenNotNull { nullDoubleInvoked = true }
        nonNullIntTarget.doWhenNotNull { nonNullIntInvoked = true }
        nonNullLongTarget.doWhenNotNull { nonNullLongInvoked = true }
        nonNullDoubleTarget.doWhenNotNull { nonNullDoubleInvoked = true }

        // then
        assertThat(nullIntInvoked).isFalse()
        assertThat(nullLongInvoked).isFalse()
        assertThat(nullDoubleInvoked).isFalse()
        assertThat(nonNullIntInvoked).isTrue()
        assertThat(nonNullLongInvoked).isTrue()
        assertThat(nonNullDoubleInvoked).isTrue()
    }

    @Test
    @DisplayName("doAndReturnWhenNotNull_String_type")
    fun doAndReturnWhenNotNull_String() {
        // given
        val nullTarget: String? = null
        val nonNullTarget = "ndgndg91"

        // when
        val nullResult = nullTarget.doAndReturnWhenNotNull { it }
        val nonNullResult = nonNullTarget.doAndReturnWhenNotNull { it }

        // then
        assertThat(nullResult).isNull()
        assertThat(nonNullResult).isEqualTo("ndgndg91")
    }

    @Test
    @DisplayName("doAndReturnWhenNotNull_Number_type")
    fun doAndReturnWhenNotNull_Number() {
        // given
        val nullIntTarget: Int? = null
        val nullLongTarget: Long? = null
        val nullDoubleTarget: Double? = null
        val nonNullIntTarget = 100
        val nonNullLongTarget = 1000L
        val nonNullDoubleTarget = 1.0


        // when
        val nullInt = nullIntTarget.doAndReturnWhenNotNull { it }
        val nullLong = nullLongTarget.doAndReturnWhenNotNull { it }
        val nullDouble = nullDoubleTarget.doAndReturnWhenNotNull { it }
        val int = nonNullIntTarget.doAndReturnWhenNotNull { it }
        val long = nonNullLongTarget.doAndReturnWhenNotNull { it }
        val double = nonNullDoubleTarget.doAndReturnWhenNotNull { it }

        // then
        assertThat(nullInt).isNull()
        assertThat(nullLong).isNull()
        assertThat(nullDouble).isNull()
        assertThat(int).isEqualTo(100)
        assertThat(long).isEqualTo(1000L)
        assertThat(double).isEqualTo(1.0)
    }
}