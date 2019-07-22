package com.mwp.demo.alipay;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016101000656454";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDo5GiQLGM5lChk9b6r3/xT7mz+cdSf37PHGKbTSfVQP05NDrJkoPRvAUwz4e0mIdNTlTDnZDkBQ0rR4Y8lISYrcMmfHv6lgNMsXdnuAVxcPAqJMMgy9vVLILB/gb75T+CkFI90CkGReACYM8SH2EFnHADCjp44/AsT6XvKok9TYouk7hKqlJHjqDt35iH4bwcQFylUhuJDCLXhFhoEoBd+BE9a3wd0fl8gP73cpYsrmJE/ZDPyVHWOCKZsDpj7+4DaTwRdw7dvyek3Krm5rbY/pDSTuTZUFmSkSK95Rs0y/PWfQtOz2xZ9iP1op3kT0NFCOcUlCR9rfbZHQxoKwuiHAgMBAAECggEAfl2w/smW7V8eq+lLlCbs2v271jQdksHm4ljV7D9tBCXVbqpS0ZckCjdCCcTE0LP53phM+MDAzZadulQRP6xE8b05KUXAFj1YV/J0lVfXrZRGgzoc5sppPmJ2YjkcTlqxIVamn+gQu8XJTMyKDsugcToYj3ijEXhw6lT9/m0jbbI54FbDpEwoybAmKvOhPlZaIsQg9h9BGer1b2lGEMF8dUel7Meyr6d5A/pQIe72ot5hounQuA+M2seAc2AwI47s71m+5T3OuG5IU0bce6ia3UNrNKjiLf5IxEI7AfjbBvFzKtvr7YavSGjKNEwFsiSoiNwUZEdfRWFY4YIZSsbcwQKBgQD4GCFmBTyrrxrDr/4EGOZc0vGOSfkSdVKZWVZv92xAH7dw24edFZQBFfqxXhNdvX5oHyiw+SLNLA26Zs0FLTSWUD9DhE6Es0l/OgtlIVLTVvQuIjvR4wP7FgCG6/a8D2fmbgxYU1GvRm1/jcRnivv1hucBZGGDemp0Hy2uBRK48wKBgQDwUEPOJJE5nXrd0CEpNG21SeMsnp+dDk0f2oTSlREwwuKlGmX9hmibHwlpIXMwPSt2sa/haX984iZ/F4Ir02QkFkB9TOXDes9Pit03NGUXRrEAOQT5Yn9jB4z8sZGDk8xkDZHGd7pSi8SuMkSdyULIoPhdHp574smq1vi4eGl3HQKBgQC8Z07NtAJr+rEflIIZyHMAYO0x+jkc7F3KuM5sfwAE/lEHcp9dCmr4HCHiGigo0uOw3KDBLKFiICdYvALMAJVj5RL2Cf66xZB1/rVymkjU177dXgABlx2Jyx6hV4ZrMGPd2Qqk9LkemyRCbn2NiD1pKoY5R2rKNueqwZamBZI/QwKBgC8SOcXWKdAURa3PB7/PcjHRcDscMv2LgJXdsqig5EYd1lEqs5GOU00XLju2fp6TTMEqGt5XUM6AabP5Qdkdxf6/kRA6EMNSeesFs0EN9UMy6Ja3lH7YyUT3hKk2it8wAxgSBFzQtOFYWUUZuZECjB9KUHvE9JwllwTsqLlRdK8NAoGAbyqxgtyQpokkVnxK1ulr6BgbP1uGde13IPnjNkR7w8dXOes/kE8BsftmItPeaL5a8+/qYo4Bw0UcOoW+cIB0munOtrjdqTAJyhRerc2zOfzWeGyNu46Ib3GO2Oexp1xPh8Db9KRjNqMhY7GRK122WIQTmCuwwTKanDPN+fbRl9o=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlEeRRRaPm4n+D7rAytx5RBBbZ+wzRMh0N7E9JM6YfNVhhD8SK9myvDiHV2MlP+aabhCYiEOkHXHJa8bkzq8tkr0CtrnXsILIvWpoulS5tSGJb3F/6AOiHQWXa0v+sgFjZQpa0YQo1fJpdqS5IoNrCBq61RYgdLjwntc3Xl8UobdujowQIbZYUMLGS0g45Jm/MKE398EMF4P1VJr1pgA4fwu93d1J+BNUxluLoG8SxhQ7WIoGEemMXXhavRMBM1vgugHLkApIk5JOvz4wwHGonOtx2ZdhZyDKBhUtdUtUhM63ceo9I1vN1yxj7HIskrQ0dgbqh/gA/j3JFK89T2A7vQIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8081/demo/notify_url";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8081/demo/return_url";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

