package de.darthkali.schichten.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class OrderService {

//    @Transactional
    fun order(){
        println("keine Transaktion")
    }
}