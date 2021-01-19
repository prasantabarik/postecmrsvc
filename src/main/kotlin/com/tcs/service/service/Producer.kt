package com.tcs.service.service

import com.tcs.service.events.ECMRPostedEvent
import com.tcs.service.model.ECMRPosted
import io.eventuate.tram.events.common.DomainEvent
import io.eventuate.tram.events.publisher.DomainEventPublisher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@Transactional
class Producer {

@Autowired
lateinit var  domainEventPublisher: DomainEventPublisher

fun create(posted : ECMRPosted) {
  publishTodoEvent(posted, ECMRPostedEvent(posted.ShipmentId))
}

    fun publishTodoEvent(posted: ECMRPosted, vararg domainEvents: DomainEvent) {
        domainEventPublisher.publish(ECMRPosted::class.java, posted.ShipmentId, Arrays.asList(*domainEvents))
    }

}