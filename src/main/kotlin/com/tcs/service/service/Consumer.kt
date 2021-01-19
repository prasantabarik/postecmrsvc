package com.tcs.service.service

import com.tcs.service.constant.URLPath.BASE_URI
import com.tcs.service.events.PostEcmrEvent
import com.tcs.service.model.ECMR
import com.tcs.service.model.ECMRPosted
import com.tcs.service.model.PostECMR
import com.tcs.service.utility.Utility
import io.eventuate.tram.events.subscriber.DomainEventEnvelope
import io.eventuate.tram.events.subscriber.DomainEventHandlers
import io.eventuate.tram.events.subscriber.DomainEventHandlersBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class Consumer {

    @Autowired
    lateinit var producer: Producer

    @Autowired
    lateinit var updateStatusFlag: UpdateStatusFlag

    fun domainEventHandlers(): DomainEventHandlers {

        return DomainEventHandlersBuilder
                .forAggregateType(PostECMR::class.java.name)
                .onEvent(PostEcmrEvent::class.java) { dee: DomainEventEnvelope<PostEcmrEvent> -> run {
                    val post: PostEcmrEvent = dee.event
                    println(post.ShipmentId)
                    val result = Utility.convert(BASE_URI + post.ShipmentId, ECMR())
                    updateStatusFlag.changeFlag(result)

                    producer.create(ECMRPosted(post.ShipmentId))

                }

                }.build()
    }

}
