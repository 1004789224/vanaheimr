package io.vanaheimr.common.core



 class RequestContext( map:MutableMap<String,Any> = mutableMapOf()) :MutableMap<String,Any> by map{
    companion object{
        private val threadLocal = ThreadLocal<RequestContext>()
        fun get():RequestContext{
            return threadLocal.get()?: kotlin.run {
                val requestContext = RequestContext()
                threadLocal.set(requestContext)
                requestContext
            }
        }
        fun clear() {
            threadLocal.remove()
        }
    }

    var requestId:String by this

    var userId:Long by this

    var tenantId:Long by this

    var userName:String by this

    var tenantName:String by this

    var ip:String by this

}