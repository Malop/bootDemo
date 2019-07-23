package com.mwp.demo.controller;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.mwp.demo.alipay.AlipayConfig;
import com.mwp.demo.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/demo")
public class AliPayController {

    private static Logger logger = LoggerFactory.getLogger(AliPayController.class);

    /**
     *
     * @Title: AlipayController.java
     * @Description: 前往支付宝第三方网关进行支付
     */
    @RequestMapping(value = "/goAliPay", produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String goAliPay(String orderId, HttpServletRequest request, HttpServletRequest response) throws Exception {

        orderId = "2019072200000002222123";
        //获得初始化的AliPayClient
        AlipayClient aliPayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl,
                AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json",
                AlipayConfig.charset, AlipayConfig.alipay_public_key,
                AlipayConfig.sign_type);

        //设置请求参数
        AlipayTradePagePayRequest aliPayRequest = new AlipayTradePagePayRequest();
        aliPayRequest.setReturnUrl(AlipayConfig.return_url);
        aliPayRequest.setNotifyUrl(AlipayConfig.notify_url);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = orderId;
        //付款金额，必填
        String total_amount = "234.98";
        //订单名称，必填
        String subject = "测试订单";
        //商品描述，可空
        String body = "用户订购商品个数：2";

        /*该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。
        * m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。
        * 该参数数值不接受小数点， 如 1.5h，可转换为 90m。
        */
        String timeout_express = "1c";

        aliPayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"timeout_express\":\""+ timeout_express +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //请求
        String result = aliPayClient.pageExecute(aliPayRequest).getBody();
        return result;
    }

    @RequestMapping("/notify_url")
    public String notify_url(){
        return "alipay/notify_url";
    }

    @RequestMapping("/return_url")
    public String return_url(){
        return "alipay/return_url";
    }
}
