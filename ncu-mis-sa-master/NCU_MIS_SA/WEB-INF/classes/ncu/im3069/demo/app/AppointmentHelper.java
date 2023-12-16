package ncu.im3069.demo.app;

import java.sql.*;
import java.time.LocalDateTime;
import org.json.*;

import ncu.im3069.demo.util.DBMgr;

// TODO: Auto-generated Javadoc
/**
 * <p>
 * The Class AppointmentHelper<br>
 * AppointmentHelper類別（class）主要管理所有與Appointment相關與資料庫之方法（method）
 * </p>
 * 
 * @author IPLab
 * @version 1.0.0
 * @since 1.0.0
 */

public class AppointmentHelper {

    /**
     * 實例化（Instantiates）一個新的（new）AppointmentHelper物件<br>
     * 採用Singleton不需要透過new
     */
    private AppointmentHelper() {

    }

    /** 靜態變數，儲存AppointmentHelper物件 */
    private static AppointmentHelper aph;

    private UserHelper uh;

    /** 儲存JDBC資料庫連線 */
    private Connection conn = null;

    /** 儲存JDBC預準備之SQL指令 */
    private PreparedStatement pres = null;

    /**
     * 靜態方法<br>
     * 實作Singleton（單例模式），僅允許建立一個AppointmentHelper物件
     * 
     * @return the helper 回傳AppointmentHelper物件
     */
    public static AppointmentHelper getHelper() {
        /** Singleton檢查是否已經有AppointmentHelper物件，若無則new一個，若有則直接回傳 */
        if (aph == null)
            aph = new AppointmentHelper();

        return aph;
    }

    /**
     * 透過身分證字號編號（ID）刪除預約資料
     * 
     * @return the JSONObject 回傳SQL執行結果
     */
    public JSONObject deleteByID(String id) {

    }

    /**
     * 取回所有預約資料
     * 
     * @return the JSONObject 回傳SQL執行結果與自資料庫取回之所有資料
     */
    public JSONObject getAll() {

    }

    /**
     * 透過身分證字號（ID）取得預約資料
     * 
     * @return the JSON object 回傳SQL執行結果與該身分證字號之預約資料
     */
    public JSONObject getByID(String id) {

    }

    /**
     * 建立預約資料至資料庫
     * 
     * @return the JSON object 回傳SQL指令執行之結果
     */
    public JSONObject create(Appointment ap) {

    }

    /**
     * 更新預約資料
     * 
     * @return the JSONObject 回傳SQL指令執行結果與執行之資料
     */
    public JSONObject update(Appointment ap) {

    }

}
