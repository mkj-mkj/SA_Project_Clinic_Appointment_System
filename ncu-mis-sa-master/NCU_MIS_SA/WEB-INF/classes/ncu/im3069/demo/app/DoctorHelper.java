package ncu.im3069.demo.app;

import java.sql.*;
import java.time.LocalDateTime;
import org.json.*;

import ncu.im3069.demo.util.DBMgr;

// TODO: Auto-generated Javadoc
/**
 * <p>
 * The Class DoctorHelper<br>
 * DoctorHelper類別（class）主要管理所有與Doctor相關與資料庫之方法（method）
 * </p>
 * 
 * @author IPLab
 * @version 1.0.0
 * @since 1.0.0
 */

public class DoctorHelper {

    /**
     * 實例化（Instantiates）一個新的（new）Helper物件
     * 採用Singleton不需要透過new
     */
    private DoctorHelper() {

    }

    /** 靜態變數，儲存DoctorHelper物件 */
    private static DoctorHelper dh;

    /** 儲存JDBC資料庫連線 */
    private Connection conn = null;

    /** 儲存JDBC預準備之SQL指令 */
    private PreparedStatement pres = null;

    /**
     * 靜態方法
     * 實作Singleton（單例模式），僅允許建立一個DoctorHelper物件
     * 
     * @return the helper 回傳DoctorHelper物件
     */
    public static DoctorHelper getHelper() {
        /** Singleton檢查是否已經有DoctorHelper物件，若無則new一個，若有則直接回傳 */
        if (dh == null)
            dh = new DoctorHelper();

        return dh;
    }

    /**
     * 取回所有醫生資料
     * 
     * @return the JSONObject 回傳SQL執行結果與自資料庫取回之所有資料
     */
    public JSONObject getAll() {

    }

    /**
     * 透過醫生編號（ID）取得醫生資料
     * 
     * @return the JSON object 回傳SQL執行結果與該編號之醫生資料
     */
    public JSONObject getByID(int id) {

    }

}
