package ncu.im3069.demo.app;

import org.json.*;

import java.security.Timestamp;
import java.util.Calendar;

// TODO: Auto-generated Javadoc
/**
 * The Class Appointment
 * Appointment類別（class）具有預約所需要之屬性與方法，並且儲存與預約相關之商業判斷邏輯
 */

public class Appointment {

    private int Seq;

    private int DoctorId;

    private String UserId;

    private Timestamp ReserveTime;

    private int AppointmentNumber;

    private User user;

    private Doctor doctor;

    /** ah，AppointmentHelper之物件與Appointment相關之資料庫方法（Sigleton） */
    private AppointmentHelper aph = AppointmentHelper.getHelper();

    /** uh，UserHelper之物件與User相關之資料庫方法（Sigleton） */
    private UserHelper uh = UserHelper.getHelper();

    /** dh，DoctorHelper之物件與Doctor相關之資料庫方法（Sigleton） */
    private DoctorHelper dh = DoctorHelper.getHelper();

    /**
     * 實例化（Instantiates）一個新的（new）Appointment物件
     */
    public Appointment(int Seq) {

    }

    /**
     * 實例化（Instantiates）一個新的（new）Appointment物件
     */
    public Appointment(int Seq, int DoctorId, String UserId) {

    }

    /**
     * 取得預約流水號
     *
     * @return the id 回傳預約流水號
     */
    public int getSeq() {
        return this.Seq;
    }

    public int getDoctorID() {

    }

    public String getUserID() {

    }

    public Timestamp getRserveTime() {

    }

    public int getAppointmentNumber() {

    }

    /**
     * 更新預約資料
     * 
     * @return the JSON object 回傳SQL更新之結果與相關封裝之資料
     */
    public JSONObject update() {

    }

    /**
     * 取得預約資料
     * 
     * @return the data 取得該預約資料並封裝於JSONObject物件內
     */
    public JSONObject getData() {

    }

    /**
     * 計算預約流水號
     */
    private void setSeq() {

    }

    private void setAppointmentNubmer(String UserId, int DoctorId, Timestamp ReserveTime) {

    }

    private void appoint(String UserId, int DoctorId, Timestamp ReserveTime) {

    }

    private void cancel(String UserId, int DoctorId, Timestamp ReserveTime) {

    }
}
