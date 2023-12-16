package ncu.im3069.demo.app;

import java.sql.*;
import java.time.LocalDateTime;
import org.json.*;

import ncu.im3069.demo.util.DBMgr;

// TODO: Auto-generated Javadoc
/**
 * <p>
 * The Class ClinicHelper
 * ClinicHelper類別（class）主要管理所有與Clinic相關與資料庫之方法（method）
 * </p>
 * 
 * @author IPLab
 * @version 1.0.0
 * @since 1.0.0
 */

public class ClinicHelper {

    /**
     * 實例化（Instantiates）一個新的（new）ClinicHelper物件
     * 採用Singleton不需要透過new
     */
    private ClinicHelper() {

    }

    /** 靜態變數，儲存ClinicHelper物件 */
    private static ClinicHelper ch;

    /** 儲存JDBC資料庫連線 */
    private Connection conn = null;

    /** 儲存JDBC預準備之SQL指令 */
    private PreparedStatement pres = null;

    /**
     * 靜態方法
     * 實作Singleton（單例模式），僅允許建立一個ClinicHelper物件
     * 
     * @return the helper 回傳ClinicHelper物件
     */
    public static ClinicHelper getHelper() {
        /** Singleton檢查是否已經有ClinicHelper物件，若無則new一個，若有則直接回傳 */
        if (ch == null)
            ch = new ClinicHelper();

        return ch;
    }

    /**
     * 透過門診編號（ID）刪除門診
     * 
     * @return the JSONObject 回傳SQL執行結果
     */
    public JSONObject deleteByID(int id) {

    }

    /**
     * 取回所有門診料
     * 
     * @return the JSONObject 回傳SQL執行結果與自資料庫取回之所有資料
     */
    public JSONObject getAll() {

    }

    /**
     * 透過門診編號（ID）取得門診資料
     * 
     * @return the JSON object 回傳SQL執行結果與該門診編號之門診資料
     */
    public JSONObject getByID(String id) {

    }

    /**
     * 檢查該門診是否存在
     * 
     * @return boolean 若存在回傳False，若不存在則回傳True
     */
    public boolean checkDuplicate(Administrator a) {

    }

    /**
     * 建立該門診至資料庫
     * 
     * @return the JSON object 回傳SQL指令執行之結果
     */
    public JSONObject create(Administrator a) {

    }

    /**
     * 更新一名門診資料
     * 
     * @return the JSONObject 回傳SQL指令執行結果與執行之資料
     */
    public JSONObject update(Administrator a) {

    }

}
