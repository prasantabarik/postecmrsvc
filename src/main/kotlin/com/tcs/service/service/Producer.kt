package com.tcs.service.service

import com.tcs.service.events.ECMRPostedEvent
import com.tcs.service.events.PostEcmrEvent
import com.tcs.service.model.ECMRPosted
import com.tcs.service.model.PostECMR
import io.eventuate.tram.events.common.DomainEvent
import io.eventuate.tram.events.publisher.DomainEventPublisher
import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@Transactional
class Producer() {

@Autowired
lateinit var  domainEventPublisher: DomainEventPublisher

fun create(posted : ECMRPosted) {
//  repo.save(posted)
  publishTodoEvent(posted, ECMRPostedEvent())
}

    fun publishTodoEvent(posted: ECMRPosted, vararg domainEvents: DomainEvent) {
        domainEventPublisher.publish(ECMRPosted::class.java, posted.ShipmentId, Arrays.asList(*domainEvents))
    }

}