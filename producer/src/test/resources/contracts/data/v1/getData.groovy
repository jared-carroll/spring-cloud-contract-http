package contracts.data.v1

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'GET'
        url '/data'
    }

    response {
        status 200
        headers {
            header 'Content-type': 'application/json;charset=UTF-8'
        }
        body data: [
                $(consumer(15), producer(regex(number()))),
                $(consumer(150), producer(regex(number()))),
                $(consumer(35), producer(regex(number())))
        ]
    }
}