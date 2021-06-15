/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinic_management;
import com.teknikindustries.bulksms.SMS;
/**
 *
 * @author MIS.Hardware
 */
public class sms_testing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       SMS send = new SMS();
       send.SendSMS("customer890", "dummy*()890", "Test java sms with bulksms sms gateway from Jaymar abrea", "+639088854210", "https://bulksms.vsms.net/eapi/submission/send_sms/2/2.0");
    }
    
}
