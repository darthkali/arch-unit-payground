package de.darthkali.schichten.persistence

import de.darthkali.schichten.Util.FachlicheArchiv
import org.springframework.stereotype.Repository

@Repository
class PizzaRepository {

    fun savePizza(){
        val fachlicheArchiv = FachlicheArchiv().save()
    }
}