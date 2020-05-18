package com.example.data.network

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val formatter = SimpleDateFormat("YYYYMMDD", Locale.getDefault())

        val url = request.url.newBuilder()
            .addQueryParameter("client_id", "ZYGCC41DAIMA2B0T4TGPJMH3VUV4NCTKVVRW5BALX4LHPBHP")
            .addQueryParameter("client_secret", "HK45YV2CDAOTKY3TVMF2M4NHOXPDPHRYEN2RASZWMEJIJBUK")
            .addQueryParameter("v", formatter.format(Date()))
            .build()
        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}
