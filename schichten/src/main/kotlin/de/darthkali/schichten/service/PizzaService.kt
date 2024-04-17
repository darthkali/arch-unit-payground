package de.darthkali.schichten.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service

class PizzaService {

    @Transactional
    fun pizza(){
        println("Pizza ist lecker")
    }

}