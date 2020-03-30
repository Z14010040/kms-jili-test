//import com.sansec.kms.result.Result;
//import com.sansec.kms.service.impl.KMS_SIWEI;
//import com.sansec.kms.service.impl.Util;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.jmeter.config.Arguments;
//import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
//import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
//import org.apache.jmeter.samplers.SampleResult;
//
//import java.io.IOException;
//
///**
// * @Author: WeiBingtao/13156050650@163.com
// * @Version: 1.0
// * @Description:
// * @Date: 2019/7/3 20:54
// */
//public class GetSymmKey extends AbstractJavaSamplerClient {
//    private String configpath;
//    private String username;
//    private String password;
//    private String name;
//    private String certpath;
//    private SampleResult sr;
//    private KMS_SIWEI kms_siwei;
//
////    每个线程开始的时候执行一次
//    public void setupTest(JavaSamplerContext arg0) {
//        configpath = arg0.getParameter("configpath");
//        kms_siwei = new KMS_SIWEI(configpath);
//    }
//
//    public Arguments getDefaultParameters() {
//        Arguments params = new Arguments();
//        params.addArgument("configpath", "E://swsds.ini");
//        params.addArgument("username", "fota");
//        params.addArgument("password", "Siwei1234.");
//        params.addArgument("name", "0703-1");
//        params.addArgument("certpath", "E://test.cer");
//        return params;
//    }
//
//    @Override
//    //开始测试，从arg0参数可以获得参数值；
//    public SampleResult runTest(JavaSamplerContext arg0) {
//
//        username = arg0.getParameter("username");
//        password = arg0.getParameter("password");
//        name = arg0.getParameter("name");
//        certpath = arg0.getParameter("certpath");
//
//        SampleResult sr = new SampleResult();
//        sr.setSampleLabel( "Java请求哦");
//        try {
//            sr.sampleStart();// jmeter 开始统计响应时间标记
//
//            byte[] bytes = null;
//            Result symmKey = null;
//            if (StringUtils.isNotBlank(certpath)) {
//                try {
//                    bytes = Util.readFromFile(certpath);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(new String(bytes));
//                symmKey = kms_siwei.getSymmKey(username, password, name, new String(bytes));
//            } else {
//                symmKey = kms_siwei.getSymmKey(username, password, name, null);
//            }
//            if(symmKey.getCode()==0){
//                sr.setSuccessful(true);
//            }else{
//                sr.setSuccessful(false);
//            }
//        } catch (Throwable e) {
//            sr.setSuccessful(false);
//            e.printStackTrace();
//        } finally {
//            sr.sampleEnd();// jmeter 结束统计响应时间标记
//        }
//        return sr;
//    }
//    //测试结束时调用；
//    public void teardownTest(JavaSamplerContext arg0) {
//        super.teardownTest(arg0);
//    }
//
//}
