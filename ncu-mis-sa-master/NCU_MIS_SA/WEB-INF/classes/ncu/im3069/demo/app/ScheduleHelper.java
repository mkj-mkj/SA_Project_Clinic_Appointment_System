package ncu.im3069.demo.app;

import java.sql.*;
import java.time.LocalDateTime;
import org.json.*;

import ncu.im3069.demo.util.DBMgr;

// TODO: Auto-generated Javadoc
/**
 * <p>
 * The Class ScheduleHelper<br>
 * ScheduleHelper類別（class）主要管理所有與Schedule相關與資料庫之方法（method）
 * </p>
 * 
 * @author IPLab
 * @version 1.0.0
 * @since 1.0.0
 */

public class ScheduleHelper {

    /**
     * 實例化（Instantiates）一個新的（new）ScheduleHelper物件<br>
     * 採用Singleton不需要透過new
     */
    private ScheduleHelper() {

    }

    /** 靜態變數，儲存ScheduleHelper物件 */
    private static ScheduleHelper sh;

    /** 儲存JDBC資料庫連線 */
    private Connection conn = null;

    /** 儲存JDBC預準備之SQL指令 */
    private PreparedStatement pres = null;

    /**
     * 靜態方法<br>
     * 實作Singleton（單例模式），僅允許建立一個ScheduleHelper物件
     * 
     * @return the helper 回傳ScheduleHelper物件
     */
    public static ScheduleHelper getHelper() {
        /** Singleton檢查是否已經有ScheduleHelper物件，若無則new一個，若有則直接回傳 */
        if (sh == null)
            sh = new ScheduleHelper();

        return sh;
    }

    /**
     * 透過班表流水號（Seq）刪除班表
     * 
     * @return the JSONObject 回傳SQL執行結果
     */
    public JSONObject deleteBySeq(int Seq) {

    }

    /**
     * 取回所有班表資料
     * 
     * @return the JSONObject 回傳SQL執行結果與自資料庫取回之所有資料
     */
    public JSONObject getAll() {

    }

    /**
     * 透過班表流水號（Seq）取得班表資料
     * 
     * @return the JSON object 回傳SQL執行結果與該班表流水號之班表資料
     */
    public JSONObject getBySeq(int Seq) {

    }

    /**
     * 建立該班表至資料庫
     * 
     * @return the JSON object 回傳SQL指令執行之結果
     */
    public JSONObject create(Schedule s) {

    }

    /**
     * 更新班表資料
     * 
     * @return the JSONObject 回傳SQL指令執行結果與執行之資料
     */
    public JSONObject update(Schedule s) {

    }

}
