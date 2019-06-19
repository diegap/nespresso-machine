package trainning.nespresso.machine.domain

import org.assertj.core.api.Assertions.assertThat
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object CoffeeMachineSpec : Spek({
    describe("A Nespresso coffee machine") {
        val coffeeMachine: CoffeeMachine

        context("is turned off and start button is pressed") {

            it("should be ready to work after a few seconds") {
                assertThat(coffeMachine.isReady()).isTrue()
            }
        }
    }
})