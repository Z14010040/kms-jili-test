//import com.alibaba.fastjson.JSON;
//import com.sansec.kms.result.CodeMsg;
//import com.sansec.kms.result.Result;
//import org.apache.commons.lang3.RandomUtils;
//
//import java.util.concurrent.Callable;
//
///**
// * @Author: WeiBingtao/13156050650@163.com
// * @Version: 1.0
// * @Description:
// * @Date: 2019/6/23 0023 22:54
// */
//class TaskWithGetSymmKey implements Callable<String> {
//    String para_kmsuser;
//    String para_kmspassword;
//    String para_name;
//    String para_cert_path;
//
//    public TaskWithGetSymmKey(String para_kmsuser, String para_kmspassword, String para_name, String para_cert_path) {
//        this.para_kmsuser = para_kmsuser;
//        this.para_kmspassword = para_kmspassword;
//        this.para_name = para_name;
//        this.para_cert_path = para_cert_path;
//    }
//
//    /**
//     * 任务的具体过程，一旦任务传给ExecutorService的submit方法，则该方法自动在一个线程上执行。
//     *
//     * @return
//     * @throws Exception
//     */
//    @Override
//    public String call() throws Exception {
//        Result result = testSecKMS.testgetSymmKey1(para_kmsuser, para_kmspassword, para_name, para_cert_path);
//        return JSON.toJSONString(result);
//    }
//}
