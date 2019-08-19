/*
 * Copyright (C) 2018 The OpenFlutter Organization
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jarvan.fluwx.handler

import com.jarvan.fluwx.constant.CallResult
import com.jarvan.fluwx.constant.WechatPluginKeys
import com.tencent.mm.opensdk.modelbiz.ChooseCardFromWXCardPackage
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel

class FluwxSelectInvoiceHandler {


    fun selectInvoice(call: MethodCall, result: MethodChannel.Result) {

        if (WXAPiHandler.wxApi == null) {
            result.error(CallResult.RESULT_API_NULL, "please config  wxapi first", null)
            return
        } else {
            val request = ChooseCardFromWXCardPackage.Req()
            request.appId = call.argument("appId")
            request.locationId = call.argument("locationId")
            request.signType = call.argument("signType")
            request.cardSign = call.argument("cardSign")
            request.timeStamp = call.argument<Long>("timeStamp").toString()
            request.nonceStr = call.argument("nonceStr")
            request.cardId = call.argument("cardId")
            request.cardType = call.argument("cardType")
            request.canMultiSelect = call.argument("canMultiSelect")
            println(request.appId)
            println(request.locationId)
            println(request.cardSign)
            println(request.nonceStr)
            println(request.cardId)
            println(request.cardType)
            println(request.canMultiSelect)
            val done = WXAPiHandler.wxApi!!.sendReq(request)
            result.success(
                    mapOf(
                            WechatPluginKeys.PLATFORM to WechatPluginKeys.ANDROID,
                            WechatPluginKeys.RESULT to done
                    )
            )

        }
    }


}