package ncu.im3069.demo.app;

import org.json.*;

import java.security.Timestamp;
import java.util.Calendar;

// TODO: Auto-generated Javadoc
/**
 * The Class Schedule
 * Schedule類別（class）具有班表所需要之屬性與方法，並且儲存與班表相關之商業判斷邏輯
 */

public class Schedule {

    private int Seq;

    private Timestamp DateTime;

    private int ClinicId;

    private int DoctorId;

    private int MaxCapacity;

    private int CurrentRegistrations;

    private Clinic clinic;

    private Doctor doctor;

    /** ch，ClinicHelper之物件與Clinic相關之資料庫方法（Sigleton） */
    private ClinicHelper ch = ClinicHelper.getHelper();

    /** dh，DoctorHelper之物件與Doctor相關之資料庫方法（Sigleton） */
    private DoctorHelper dh = DoctorHelper.getHelper();

    /** sh，ScheduleHelper之物件與Schedule相關之資料庫方法（Sigleton） */
    private ScheduleHelper sh = ScheduleHelper.getHelper();

    /**
     * 實例化（Instantiates）一個新的（new）Schedule物件
     */
    public Schedule(int Seq) {

    }

    /**
     * 實例化（Instantiates）一個新的（new）Schedule物件
     */
    public Schedule(int Seq, Timestamp DateTime, int ClinicId) {

    }

    /**
     * 實例化（Instantiates）一個新的（new）Schedule物件
     */
    public Schedule(int Seq, Timestamp DateTime, int ClinicId, int DoctorId) {

    }

    /**
     * 實例化（Instantiates）一個新的（new）Schedule物件
     */
    public Schedule(int Seq, Timestamp DateTime, int ClinicId, int DoctorId, int MaxCapacity) {

    }

    /**
     * 取得班表流水號
     *
     * @return the id 回傳班表流水號
     */
    public int getSeq() {
        return this.Seq;
    }

    public Timestamp getDateTime() {

    }

    public int getClinicID() {

    }

    public int getDoctorID() {

    }

    public int getMaxCapacity() {

    }

    public int getCurrentRegistrations() {

    }

    /**
     * 更新班表資料
     * 
     * @return the JSON object 回傳SQL更新之結果與相關封裝之資料
     */
    public JSONObject update() {

    }

    /**
     * 取得該班表所有資料
     * 
     * @return the data 取得該班表之所有資料並封裝於JSONObject物件內
     */
    public JSONObject getData() {

    }

    /**
     * 計算新班表流水號
     */
    private void setSeq() {

    }
}
