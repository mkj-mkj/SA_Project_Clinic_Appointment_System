package ncu.im3069.demo.app;

import org.json.*;

import java.sql.Timestamp;
import java.util.Calendar;

/**
 * The Class Appointment
 * Appointment類別（class）具有預約所需要之屬性與方法，並且儲存與預約相關之商業判斷邏輯
 */

public class Appointment {

    private int Seq;

    private int DoctorId;

    private String UserId;

    private String ReserveTime;

    private int AppointmentNumber;
    
    private String DeptName;
    
    private String DoctorName;

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
        this.Seq = Seq;
    }

    /**
     * 實例化（Instantiates）一個新的（new）Appointment物件
     */
    public Appointment(int Seq, int DoctorId, String UserId) {
        this.Seq = Seq;
        this.DoctorId = DoctorId;
        this.UserId = UserId;
    }

    /**
     * 實例化（Instantiates）一個新的（new）Appointment物件
     */
    public Appointment(int DoctorId, String UserId, String ReserveTime) {
        this.DoctorId = DoctorId;
        this.UserId = UserId;
        this.ReserveTime = ReserveTime;
    }

    /**
     * 實例化（Instantiates）一個新的（new）Appointment物件
     */
    public Appointment(int Seq, int DoctorId, String UserId, String ReserveTime) {
        this.Seq = Seq;
        this.DoctorId = DoctorId;
        this.UserId = UserId;
        this.ReserveTime = ReserveTime;
    }

    /**
     * 實例化（Instantiates）一個新的（new）Appointment物件
     */
    public Appointment(int DoctorId, String UserId, String ReserveTime, int AppointmentNumber) {
        this.DoctorId = DoctorId;
        this.UserId = UserId;
        this.ReserveTime = ReserveTime;
        this.AppointmentNumber = AppointmentNumber;
    }

    /**
     * 實例化（Instantiates）一個新的（new）Appointment物件
     */
    public Appointment(int Seq, int DoctorId, String UserId, String ReserveTime, int AppointmentNumber) {
        this.Seq = Seq;
        this.DoctorId = DoctorId;
        this.UserId = UserId;
        this.ReserveTime = ReserveTime;
        this.AppointmentNumber = AppointmentNumber;
    }
    
    /**
     * 實例化（Instantiates）一個新的（new）Appointment物件
     */
    public Appointment(int Seq, int DoctorId, String UserId, String ReserveTime, int AppointmentNumber, String DeptName, String DoctorName) {
        this.Seq = Seq;
        this.DoctorId = DoctorId;
        this.UserId = UserId;
        this.ReserveTime = ReserveTime;
        this.AppointmentNumber = AppointmentNumber;
        this.DeptName = DeptName;
        this.DoctorName = DoctorName;
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
        return this.DoctorId;
    }

    public String getUserID() {
        return this.UserId;
    }

    public String getReserveTime() {
        return this.ReserveTime;
    }

    public int getAppointmentNumber() {
        return this.AppointmentNumber;
    }
    
    public String getDeptName() {
    	return this.DeptName;
    }
    
    public String getDoctorName() {
    	return this.DoctorName;
    }

    /**
     * 更新預約資料
     * 
     * @return the JSON object 回傳SQL更新之結果與相關封裝之資料
     */
    public JSONObject update() {
        /** 新建一個JSONObject用以儲存更新後之資料 */
        JSONObject data = new JSONObject();

        /** 檢查該預約資料是否已經在資料庫 */
        if (this.Seq != 0) {
            /** 透過AppointmentHelper物件，更新目前之預約資料置資料庫中 */
            data = aph.update(this);
        }
        return data;
    }

    /**
     * 取得預約資料
     * 
     * @return the data 取得該預約資料並封裝於JSONObject物件內
     */
    public JSONObject getData() {
        /** 透過JSONObject將該預約資料所需之資料全部進行封裝 */
        JSONObject jso = new JSONObject();
        jso.put("seq", getSeq());
        jso.put("doctor_id", getDoctorID());
        jso.put("user_id", getUserID());
        jso.put("reserve_time", getReserveTime());
        jso.put("appointment_number", getAppointmentNumber());
        jso.put("dept_name", getDeptName());
        jso.put("doctor_name", getDoctorName());

        return jso;
    }

    /**
     * 改成從資料庫實作
     * /**
     * 計算預約流水號
     * 
     * private void setSeq() {
     * 
     * }
     * 
     * private void setAppointmentNubmer(String UserId, int DoctorId, Timestamp
     * ReserveTime) {
     * 
     * }
     */

    /**
     * 用AppointmentHelper的creat() deleteById()實作
     * private void appoint(String UserId, int DoctorId, Timestamp ReserveTime) {
     * 
     * }
     * 
     * private void cancel(String UserId, int DoctorId, Timestamp ReserveTime) {
     * 
     * }
     */
}
